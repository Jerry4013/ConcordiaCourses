package comp445.server;

import java.util.ArrayList;
import java.util.List;

public class Request {

    private String method;
    private String filePath;
    private List<String> headers = new ArrayList<>();
    private String body;
    private String requestText;
    private String version;
    private String parameters;

    public Request(String requestText) throws InvalidRequestException {
        this.requestText = requestText;
        parse();
    }

    private void parse() throws InvalidRequestException {
        String[] headerAndBody = requestText.split("\r\n\r\n");
        if (headerAndBody.length > 2) {
            throw new InvalidRequestException();
        } else if (headerAndBody.length == 2){
            body = headerAndBody[1];
        }

        String[] requestLineAndHeaders = headerAndBody[0].split("\r\n");
        String requestLine = requestLineAndHeaders[0];
        String[] requestLineWords = requestLine.split(" ");
        if(requestLineWords.length != 3){
            throw new InvalidRequestException();
        }

        if (requestLineWords[0].equals("GET")) {
            method = "GET";
        } else if (requestLineWords[0].equals("POST")){
            method = "POST";
        } else {
            throw new InvalidRequestException();
        }

        filePath = requestLineWords[1];
        if (filePath.contains("?")) {
            parameters = filePath.substring(filePath.indexOf("?") + 1);
            filePath = filePath.substring(0, filePath.indexOf("?"));
        }
        version = requestLineWords[2];

        if (requestLineAndHeaders.length > 1) {
            for (int i = 1; i < requestLineAndHeaders.length; i++) {
                headers.add(requestLineAndHeaders[i]);
            }
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
}
