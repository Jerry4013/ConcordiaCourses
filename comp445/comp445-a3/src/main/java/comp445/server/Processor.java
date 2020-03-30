package comp445.server;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import javax.activation.MimetypesFileTypeMap;

public class Processor {

    private String path;
    private Request request;
    private Response response;

    public Processor(Request request, String path){
        response = new Response();
        this.request = request;
        if (path.equals("/")) {
            this.path = System.getProperty("user.dir");
        } else {
            this.path = path;
        }
    }

    public Response getResponse(){
        if(!request.getVersion().equals("HTTP/1.0") && !request.getVersion().equals("HTTP/1.1")){
            response.setState("505 HTTP Version Not Supported");
            return response;
        }
        if(request.getMethod().equals("GET")) {
            processGet();
        } else {
            processPost();
        }
        return response;
    }

    private void processPost(){
        path += request.getFilePath();
        try {
            boolean overwrite = false;
            String parameters = request.getParameters();
            if (parameters != null) {
                String[] splitParameters = parameters.split("&");
                for (String splitParameter : splitParameters) {
                    String[] entry = splitParameter.split("=");
                    if (entry[0].equals("overwrite")) {
                        if (entry[1].equals("true")) {
                            overwrite = true;
                        }
                    }
                }
            }
            FileWriter fileWriter = new FileWriter(path, !overwrite);
            fileWriter.write(request.getBody());
            fileWriter.close();
            response.setState("200 OK");

            StringBuilder body = new StringBuilder();
            Scanner inputStream = new Scanner(new FileInputStream(path));
            while (inputStream.hasNextLine( )) {
                body.append(inputStream.nextLine()).append("\n");
            }
            response.setBody(body.toString());
        } catch (IOException ex) {
            response.setState("403 Forbidden");
        }
    }

    private void processGet(){
        path += request.getFilePath();
        response.setState("200 OK");
        if(request.getFilePath().equals("/")){
            displayFiles();
            return;
        }

        try {
            readFile();
        } catch (FileNotFoundException ex ){
            response.setState("404 Not Found");
        } catch (IOException ex){
            response.setState("400 Bad Request");
        }
    }

    private void displayFiles(){
        File file = new File(path);
        File[] filesList = file.listFiles();
        StringBuilder body = new StringBuilder();
        if (filesList == null || filesList.length == 0) {
            return;
        }
        String acceptType = getAcceptType();
        if (acceptType == null
                || acceptType.equalsIgnoreCase("text/plain")
                || acceptType.equals("*/*")) {
            response.setHeader("Content-Type: text/plain");
            for (File files : filesList){
                if(files.isDirectory())
                    body.append(files.getName()).append("/").append("\n");
                else
                    body.append(files.getName()).append("\n");
            }
        } else if (acceptType.equalsIgnoreCase("text/html")) {
            response.setHeader("Content-Type: text/html");
            displayHTML(body, filesList);
        } else if (acceptType.equalsIgnoreCase("application/json")) {
            response.setHeader("Content-Type: application/json");
            body.append("[");
            for (int i = 0; i < filesList.length; i++) {
                if(filesList[i].isDirectory())
                    body.append("\"").append(filesList[i].getName()).append("/").append("\"");
                else
                    body.append("\"").append(filesList[i].getName()).append("\"");
                if (i != filesList.length - 1) {
                    body.append(",");
                }
            }
            body.append("]");
        }

        response.setBody(body.toString());
    }

    private String getAcceptType() {
        List<String> headers = request.getHeaders();
        for (String header : headers) {
            String headerKey = header.substring(0, header.indexOf(":")).trim();
            if (headerKey.equalsIgnoreCase("Accept")) {
                int end = header.contains(",") ? header.indexOf(",") : header.length();
                return header.substring(header.indexOf(":") + 1, end).trim();
            }
        }
        return null;
    }

    private StringBuilder displayHTML(StringBuilder body, File[] filesList) {
        body.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Display Files</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<ul>\n");
        for (File files : filesList){
            body.append("<li>");
            if(files.isDirectory())
                body.append(files.getName()).append("/");
            else
                body.append(files.getName());
            body.append("</li>\n");
        }
        body.append("</ul>\n" +
                "</body>\n" +
                "</html>");
        return body;
    }

    private void readFile() throws IOException {
        File file = new File(path);
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = bReader.readLine()) != null) {
            sb.append(line).append("\r\n");
        }
        bReader.close();
        response.setBody(sb.toString());
        response.setHeader("Content-Type : " + new MimetypesFileTypeMap().getContentType(file));
        if (file.getName().endsWith("txt")) {
            response.setHeader("Content-Disposition : attachment");
        } else if(file.getName().endsWith("html")){
            response.setHeader("Content-Disposition : inline");
        }
    }
}
