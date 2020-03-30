package comp445.server;

import comp445.share.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static java.nio.charset.StandardCharsets.UTF_8;

public class UDPServer {

    private static final Logger logger = LoggerFactory.getLogger(UDPServer.class);

    private static final int TIMEOUT = 3000;
    private int port;
    private String path;
    private Boolean debugging = false;
    private TreeMap<Long, String> buffer;
    private final int WINDOW_SIZE = 51200;
    private long lastSeqNum = -1;
    private Packet packet;
    private SocketAddress router;
    private StringBuilder sb;

    public UDPServer() {
        port = 8080;
        path = "/";
        buffer = new TreeMap<>();
        sb = new StringBuilder();
    }

    public void startServer() throws IOException {

        try (DatagramChannel channel = DatagramChannel.open()) {
            channel.configureBlocking(false); // NIO
            channel.socket().bind(new InetSocketAddress(port));
            logger.info("Server is listening at {}", channel.getLocalAddress());
            if (debugging) {
                System.out.println("Server start successfully!");
            }

            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_READ);

            for (; ; ) {
                if(selector.select(TIMEOUT) == 0) {
                    continue;
                }
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();

                    if (selectionKey.isReadable()){
                        if (debugging) {
                            System.out.println("New client connected.\n");
                        }
                        readHandler(selectionKey);
                    }
                }
                iterator.remove();
            }
        }
    }

    private boolean checkReady() {
        if (lastSeqNum == -1) {
            return false;
        }
        long checkSequenceNumber = lastSeqNum;
        while (checkSequenceNumber != 0) {
            if (!this.buffer.containsKey(checkSequenceNumber)) {
                return false;
            }
            checkSequenceNumber -= 1013;
        }
        return true;
    }

    private void readHandler(SelectionKey selectionKey) throws IOException {
        DatagramChannel channel = (DatagramChannel) selectionKey.channel();

        ByteBuffer buffer = ByteBuffer.allocate(Packet.MAX_LEN).order(ByteOrder.BIG_ENDIAN);
        buffer.clear();
        SocketAddress router = channel.receive(buffer); // read the data from the change and write it to the buffer.
        buffer.flip(); // change the buffer to read mode
        Packet packet = Packet.fromBuffer(buffer);
        buffer.clear(); // change the buffer to write mode
        if (this.packet == null) {
            this.packet = packet;
        }
        if (this.router == null) {
            this.router = router;
        }
        if (packet.getType() == 1) {
            sendACK(packet, channel, router); // Use this channel to send this packet to this router
            return;
        }
        String payload = new String(packet.getPayload(), UTF_8);
        this.buffer.put(packet.getSequenceNumber(), payload);
        logger.info("Packet: {}", packet);
        logger.info("Payload: {}", payload);
        logger.info("Router: {}", router);
        if (packet.getType() == 4) {
            lastSeqNum = packet.getSequenceNumber();
        }
        if (checkReady()) {
            for (Map.Entry<Long, String> entry : this.buffer.entrySet()) {
                sb.append(entry.getValue());
            }
            sendResponse(sb.toString(), channel, router, this.packet);
            return;
        }
        Packet resp = packet.toBuilder()
                .setType(5)
                .create();
        channel.send(resp.toBuffer(), router);
    }

    private void sendResponse(String completeRequestString, DatagramChannel channel,
                              SocketAddress router, Packet packet) throws IOException {
        try {
            Request request = new Request(completeRequestString);
            Processor processor = new Processor(request, path);
            String response = processor.getResponse().makeResponse();
            if(debugging){
                System.out.println(response);
            }
            Packet resp = packet.toBuilder()
                    .setType(0)
                    .setPayload(response.getBytes())
                    .create();
            channel.send(resp.toBuffer(), router);
        } catch (InvalidRequestException e) {
            if(debugging) {
                e.printStackTrace();
                System.out.println("HTTP/1.0 400 Bad Request");
            }
            Packet resp = packet.toBuilder().setPayload("HTTP/1.0 400 Bad Request".getBytes()).create();
            channel.send(resp.toBuffer(), router);
        }
    }

    private void sendACK(Packet packet, DatagramChannel channel, SocketAddress router) throws IOException {
        Packet ack = packet.toBuilder()
                .setType(2)
                .create();
        channel.send(ack.toBuffer(), router);
    }

    public void setDebugging(Boolean debugging){
        this.debugging = debugging;
    }

    public void setPort(int port){
        this.port = port;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

}
