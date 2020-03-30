package comp445.client;

import comp445.share.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.nio.channels.SelectionKey.OP_READ;


/**
 * @author: Jingchao Zhang
 * @createDate: 2019/11/24
 **/
public class UDPClient {
    private String host = "localhost";
    private int port = 8080;
    private int routerPort = 3000;
    private InetSocketAddress serverAddress;
    private SocketAddress routerAddress;
    private long nextSequenceNumber = -1;
    private boolean needRedirection = false;
    private boolean verbose;
    private String writeToFilePath;
    private static final int TIMEOUT = 3000;
    private int sendBase = 0;
    private final int WINDOW_SIZE = 51200;
    private TreeMap<Long, Long> sentPacketSeqNum;

    private static final Logger logger = LoggerFactory.getLogger(Request.class);

    public UDPClient() {
        serverAddress = new InetSocketAddress(host, port);
        routerAddress = new InetSocketAddress(host, routerPort);
        sentPacketSeqNum = new TreeMap<>();
    }

    public DatagramChannel handShaking() {
        DatagramChannel channel;
        try {
            channel = DatagramChannel.open();
            sendSYN(channel, false);
            receiveACK(channel);
            return channel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sendSYN(DatagramChannel channel, boolean isResending) throws IOException {
        Packet p = new Packet.Builder()
                .setType(1) // SYN
                .setSequenceNumber(nextSequenceNumber)
                .setPortNumber(serverAddress.getPort())
                .setPeerAddress(serverAddress.getAddress())
                .setPayload("".getBytes())
                .create();
        if (!isResending) {
            nextSequenceNumber++;
        }
        channel.send(p.toBuffer(), routerAddress);
    }

    private void receiveACK(DatagramChannel channel) throws IOException {
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.register(selector, OP_READ);
        while (selector.select(TIMEOUT) == 0) {
            logger.error("Time out. Resending SYN...");
            sendSYN(channel, true);
        }
        Set<SelectionKey> keys = selector.selectedKeys();
        ByteBuffer buffer = ByteBuffer.allocate(Packet.MAX_LEN);
        channel.receive(buffer);
        buffer.flip();
        Packet resp = Packet.fromBuffer(buffer);
        if (resp.getType() != 2) {
            selector.close();
            keys.clear();
            sendSYN(channel, true);
            receiveACK(channel);
        }
        keys.clear();
    }

    public void sendRequest(Request request, DatagramChannel channel) throws IOException {
        String requestString = request.assembleRequest();
        sendPackets(requestString, channel);

        String response = receivePackets(channel, requestString);

        handleResponse(response, request, channel);

        channel.close();
    }

    private void sendPackets(String requestString, DatagramChannel channel) throws IOException {
        byte[] bytes = requestString.getBytes();
        int from = 0;
        while (bytes.length - from >= 1013) {
            if (bytes.length - from == 1013) {
                from = sendSinglePacket(bytes, from, from + 1013, channel, 4);
            } else {
                from = sendSinglePacket(bytes, from, from + 1013, channel, 0);
            }
        }
        if (bytes.length > from) {
            sendSinglePacket(bytes, from, bytes.length, channel, 4);
        }
    }

    private int sendSinglePacket(byte[] bytes, int from, int to, DatagramChannel channel, int type) throws IOException {
        byte[] subBytes = Arrays.copyOfRange(bytes, from, to);
        Packet p = new Packet.Builder()
                .setType(type)
                .setSequenceNumber(nextSequenceNumber)
                .setPortNumber(port)
                .setPeerAddress(serverAddress.getAddress())
                .setPayload(subBytes)
                .create();
        channel.send(p.toBuffer(), routerAddress);
        sentPacketSeqNum.put(nextSequenceNumber, (long) to);
        nextSequenceNumber += subBytes.length;
        return from + 1013;
    }

    private String receivePackets(DatagramChannel channel, String requestString) throws IOException {
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.register(selector, OP_READ);
        logger.info("Waiting for the response");
        StringBuilder stringBuilder = new StringBuilder();

        while (sentPacketSeqNum.size() > 0) {
            selector.select(TIMEOUT);
            Set<SelectionKey> keys = selector.selectedKeys();
            if(keys.isEmpty()){
                byte[] bytes = requestString.getBytes();
                logger.info("Time out. Resending packet...");
                resendPacket(bytes, sentPacketSeqNum.firstKey().intValue(),
                        sentPacketSeqNum.firstEntry().getValue().intValue(), channel);
                continue;
            }
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                ByteBuffer buffer = ByteBuffer.allocate(Packet.MAX_LEN);
                DatagramChannel channel1 = (DatagramChannel) selectionKey.channel();
                channel1.receive(buffer);
                buffer.flip();
                Packet resp = Packet.fromBuffer(buffer);
                String payload = new String(resp.getPayload(), StandardCharsets.UTF_8);
                if (resp.getType() == 5) {
                    sentPacketSeqNum.remove(resp.getSequenceNumber());
                }
                if (resp.getType() == 0) {
                    stringBuilder.append(payload);
                    sentPacketSeqNum.remove(resp.getSequenceNumber());
                }
            }
            keys.clear();
        }
        return stringBuilder.toString();
    }

    private void resendPacket(byte[] bytes, int from, int to, DatagramChannel channel) throws IOException {
        byte[] subBytes = Arrays.copyOfRange(bytes, from, to);
        Packet p = new Packet.Builder()
                .setType(0)
                .setSequenceNumber(from)
                .setPortNumber(port)
                .setPeerAddress(serverAddress.getAddress())
                .setPayload(subBytes)
                .create();
        channel.send(p.toBuffer(), routerAddress);
    }

    private void handleResponse(String response, Request request, DatagramChannel channel)
            throws IOException {
        PrintWriter fileOut = null;
        if (writeToFilePath != null) {
            fileOut = new PrintWriter(new FileOutputStream(writeToFilePath, true));
            fileOut.println("\n" + new Date().toString() + "\n");
        }

        receiveAndPrintData(response, fileOut, request);

        if (fileOut != null) {
            fileOut.close();
        }

        if (needRedirection) {
            needRedirection = false;
            redirect(request, channel);
        }
    }

    private void redirect(Request request, DatagramChannel channel) throws IOException {
        if (request.getMethod().equals(Method.GET)) {
            // According to Redirection specifications, a user agent can redirect automatically when
            // the request method is GET
            sendRequest(request, channel);
        } else if (request.getMethod().equals(Method.POST)) {
            System.out.println("This page has moved to " + host + request.getPath());
            System.out.println("Do you want to sent the POST request again? (Y/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Y")) {
                if (host.equals("httpbin.org")) {
                    request.setPath("/post");
                }
                sendRequest(request, channel);
            }
            scanner.close();
        }
    }

    private void receiveAndPrintData(String response, PrintWriter fileOut, Request request) throws IOException {
        String[] split1 = response.split("\r\n\r\n");
        String statusLineAndHeaders = split1[0];
        String responseBody = split1[1];
        String[] split2 = statusLineAndHeaders.split("\r\n");
        String statusLine = split2[0];
        readStatusLine(statusLine, fileOut); // Read the first line to check response status code

        for (int i = 1; i < split2.length; i++) {
            if (needRedirection && (split2[i].startsWith("location:") || split2[i].startsWith("Location:"))) {
                String[] locationAndNewURL = split2[i].split(":");
                String newURL = locationAndNewURL[1].trim();
                updateURL(request, newURL);
            }
            if (verbose) {
                if (writeToFilePath != null) {
                    fileOut.println(split2[i]);
                }
                System.out.println(split2[i]);
            }
        }
        System.out.println(responseBody);
    }

    private void readStatusLine(String statusLine, PrintWriter fileOut) throws IOException {
        String[] firstLineWords = statusLine.split(" ");
        if (firstLineWords[1].equals("301") || firstLineWords[1].equals("302")) {
            needRedirection = true;
        }
        if (verbose) {
            if (writeToFilePath != null) {
                fileOut.println(statusLine);
            }
            System.out.println(statusLine);
        }
    }

    private void updateURL(Request request, String newURL) throws IOException {
        if (newURL.startsWith("/")) {
            request.setPath(newURL);
        } else {
            request.setURL(newURL);
            java.net.URL url = new URL(request.getURL());
            request.setHost(url.getHost());
            request.setPort(url.getPort());
            request.setPath(url.getPath());
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InetSocketAddress getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(InetSocketAddress serverAddress) {
        this.serverAddress = serverAddress;
    }

    public SocketAddress getRouterAddress() {
        return routerAddress;
    }

    public void setRouterAddress(SocketAddress routerAddress) {
        this.routerAddress = routerAddress;
    }

    public long getNextSequenceNumber() {
        return nextSequenceNumber;
    }

    public void setNextSequenceNumber(long nextSequenceNumber) {
        this.nextSequenceNumber = nextSequenceNumber;
    }

    public boolean isNeedRedirection() {
        return needRedirection;
    }

    public void setNeedRedirection(boolean needRedirection) {
        this.needRedirection = needRedirection;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public String getWriteToFilePath() {
        return writeToFilePath;
    }

    public void setWriteToFilePath(String writeToFilePath) {
        this.writeToFilePath = writeToFilePath;
    }
}
