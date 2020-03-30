package comp445.client;

import java.util.*;

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
    private String host = "localhost";
    private int port;
    private String path;

    public String assembleRequest() {
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

    public Request() {
        port = 8080;
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
