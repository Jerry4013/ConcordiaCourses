
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/10/01
 **/

enum Method {
    GET, POST, PUT, DELETE
}

public class Request {
    private Method method;
    private String URL;
    private List<String> header = new ArrayList<>();
    private String body;
    private String protocol = " HTTP/1.0\r\n";
    private String host;
    private int port;
    private String path;
    private boolean verbose;
    private boolean needRedirection = false;
    private String writeToFile;


    public void send() {
        try {
            Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

            InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader in = new BufferedReader(inputStreamReader);

            String request = assembleRequest();
            out.println(request);
            out.flush();

            PrintWriter fileOut = null;
            if (writeToFile != null) {
                fileOut = new PrintWriter(new FileOutputStream(writeToFile, true));
                fileOut.println("\n" + new Date().toString() + "\n");
            }
            receiveAndPrintData(in, fileOut);
            if (fileOut != null) {
                fileOut.close();
            }

            in.close();
            out.close();
            clientSocket.close();
            if (needRedirection) {
                needRedirection = false;
                redirect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void redirect() {
        if (method.equals(Method.GET)) {
            // According to Redirection specifications, a user agent can redirect automatically when
            // the request method is GET
            send();
        } else if (method.equals(Method.POST)) {
            System.out.println("This page has moved to " + host + path);
            System.out.println("Do you want to sent the POST request again? (Y/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Y")) {
                if (host.equals("httpbin.org")) {
                    path = "/post";
                }
                send();
            }
            scanner.close();
        }
    }

    private void receiveAndPrintData(BufferedReader in, PrintWriter fileOut) throws IOException {
        readFirstLine(in, fileOut); // Read the first line to check response status code

        // Then read from the second line
        String line;
        while((line = in.readLine()) != null) {
            if (line.equals("")) {
                verbose = true;
            }
            if (needRedirection && (line.startsWith("location:") || line.startsWith("Location:"))) {
                String[] locationAndNewURL = line.split(":");
                String newURL = locationAndNewURL[1].trim();
                updateURL(newURL);
            }
            if (verbose) {
                if (writeToFile != null) {
                    fileOut.println(line);
                } else {
                    System.out.println(line);
                }
            }
        }
    }

    private void readFirstLine(BufferedReader in, PrintWriter fileOut) throws IOException {
        String line = in.readLine();
        String[] firstLineWords = line.split(" ");
        if (firstLineWords[1].equals("301") || firstLineWords[1].equals("302")) {
            needRedirection = true;
        }
        if (verbose) {
            if (writeToFile != null) {
                fileOut.println(line);
            } else {
                System.out.println(line);
            }
        }
    }

    private void updateURL(String newURL) throws IOException {
        if (newURL.startsWith("/")) {
            path = newURL;
        } else {
            URL = newURL;
            java.net.URL url = new URL(URL);
            host = url.getHost();
            port = url.getPort();
            path = url.getPath();
        }
    }

    private String assembleRequest() {
        StringBuilder sb = new StringBuilder();
        sb.append(method.toString()).append(" ").append(path).append(protocol);
        sb.append("Host: ").append(host).append("\r\n");
        for (String headerLine : header) {
            sb.append(headerLine).append("\r\n");
        }
        if (method.equals(Method.POST)) {
            int length = body != null ? body.length() : 0;
            sb.append("Content-Length: ").append(length).append("\r\n");
        }
        sb.append("\r\n");
        if (method.equals(Method.POST)) {
            sb.append(body);
        }
        return sb.toString();
    }

    public boolean isNeedRedirection() {
        return needRedirection;
    }

    public void setNeedRedirection(boolean needRedirection) {
        this.needRedirection = needRedirection;
    }

    public String getWriteToFile() {
        return writeToFile;
    }

    public void setWriteToFile(String writeToFile) {
        this.writeToFile = writeToFile;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public Request() {
        port = 80;
        header.add("User-Agent:Concordia-HTTP/1.0");
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

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
