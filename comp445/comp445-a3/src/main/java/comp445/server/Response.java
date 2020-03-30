package comp445.server;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private final String version = "HTTP/1.1";
    private String state = "";
    private List<String> headers;
    private String body;

    public Response() {
        headers = new ArrayList<>();
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVersion() {
        return version;
    }

    public String getState() {
        return state;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeader(String header) {
        this.headers.add(header);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String makeResponse(){
        StringBuilder response = new StringBuilder(version + " " + state + "\r\n");
        if (headers == null || headers.size() == 0) {
            setHeader("Content-Type: text/html");
        }

        int length = body == null ? 0 :  body.getBytes().length;
        setHeader("Content-Length: " + length);
        for (String header : headers) {
            response.append(header).append("\r\n");
        }
        response.append("\r\n");
        if (!state.equals("200 OK")) {
            setErrorPageBody();
        }
        if(body != null) {
            response.append(body);
        }
        return response.toString();
    }

    private void setErrorPageBody() {
        StringBuilder body = new StringBuilder();
        body.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>" +
                state +
                "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>" +
                state +
                "</h2>\n" +
                "</body>\n" +
                "</html>");
        this.body = body.toString();
    }

}
