import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/10/03
 **/
public class ArgsParser {

    private static final String HELP = "help";
    private static final String GET = "get";
    private static final String POST = "post";
    private static Request request = new Request();
    private static boolean bodyExists;

    public static Request parse(String[] args) throws InvalidCommandException, IOException {
        if (args.length == 0) {
            HelpPrinter.printHelp();
            return null;
        }

        switch (args[0]) {

            case HELP:
                if (args.length == 1) {
                    HelpPrinter.printHelp();
                } else if (args.length == 2 && args[1].equals(GET)) {
                    HelpPrinter.printHelpGet();
                } else if (args.length == 2 && args[1].equals(POST)) {
                    HelpPrinter.printHelpPost();
                }
                return null;

            case GET:
                request.setMethod(Method.GET);
                processGetOrPost(args);
                break;

            case POST:
                request.setMethod(Method.POST);

                processGetOrPost(args);
                break;

            default:
                throw new InvalidCommandException();
        }
        return request;
    }

    private static void processGetOrPost(String[] args) throws InvalidCommandException, IOException {
        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("-h")) {
                i++;
                request.getHeader().add(args[i]);
            } else if (args[i].equals("-v")) {
                request.setVerbose(true);
            } else if (args[i].equals("-d") || args[i].equals("-f")) {
                if (args[0].equals(GET) || bodyExists) {
                    throw new InvalidCommandException();
                }
                bodyExists = true;
                i++;
                if (args[i-1].equals("-d")) {
                    request.setBody(args[i]);
                } else { // -f
                    request.getHeader().add("Content-Type: application/json");
                    request.setBody(readFile(args[i]));
                }
            } else if (args[i].equals("-o")) {
                i++;
                request.setWriteToFile(args[i]);
            } else {
                parseURL(args[i]);
            }
        }
    }

    private static String readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String data;
        while ((data = bReader.readLine()) != null) {
            sb.append(data);
        }
        bReader.close();
        return sb.toString();
    }

    private static void parseURL(String URL) {
        if (URL.startsWith("\'") || URL.startsWith("\"")) {
            URL = URL.substring(1, URL.length() - 1);
        }
        if (URL.startsWith("http://")) {
            URL = URL.substring(7);
        }
        int firstSlash = URL.indexOf("/");
        String hostAndPort;
        if (firstSlash < 0){
            hostAndPort = URL;
        } else {
            hostAndPort = URL.substring(0, firstSlash);
        }
        if (hostAndPort.contains(":")) {
            String[] split = hostAndPort.split(":");
            request.setHost(split[0]);
            request.setPort(Integer.parseInt(split[1]));
        } else {
            request.setHost(hostAndPort);
        }
        request.setPath(URL.substring(firstSlash));
    }

}
