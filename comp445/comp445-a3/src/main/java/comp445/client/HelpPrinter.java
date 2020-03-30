package comp445.client;

import java.util.Formatter;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/10/02
 **/
public class HelpPrinter {

    public static void printHelp() {
        Formatter formatter = new Formatter(System.out);
        System.out.println("\nhttpc is a curl-like application but supports HTTP protocol only.\n\n" +
                "Usage:\n" +
                "\thttpc command [arguments]\n\n" +
                "The commands are:");
        formatter.format("\t%-10s %-200s\n", "get", "executes a HTTP GET request and prints the " +
                "response.");
        formatter.format("\t%-10s %-200s\n", "post", "executes a HTTP POST request and prints the " +
                "response.");
        formatter.format("\t%-10s %-200s\n", "help", "prints this screen.\n");
        System.out.println("Use \"httpc help [command]\" for more information about a command.\n");
    }

    public static void printHelpGet() {
        Formatter formatter = new Formatter(System.out);
        System.out.println(
                "\nUsage: httpc get [-v] [-h key:value] URL\n\n" +
                        "Get executes a HTTP GET request for a given URL.\n");
        formatter.format("\t%-20s %-200s\n", "-v", "Prints the detail of the response such as " +
                "protocol, status, and headers.");
        formatter.format("\t%-20s %-200s\n", "-h key:value", "Associates headers to HTTP Request " +
                "with the format 'key:value'.");
    }

    public static void printHelpPost() {
        Formatter formatter = new Formatter(System.out);
        System.out.println(
                "usage: httpc post [-v] [-h key:value] [-d inline-data] [-f file] URL\n\n" +
                        "Post executes a HTTP POST request for a given URL with inline data or " +
                        "from file.\n");
        formatter.format("\t%-20s %-200s\n", "-v", "Prints the detail of the response such as " +
                "protocol, status, and headers.");
        formatter.format("\t%-20s %-200s\n", "-h key:value", "Associates headers to HTTP Request " +
                "with the format 'key:value'.");
        formatter.format("\t%-20s %-200s\n", "-d string", "Associates an inline data to the body " +
                "HTTP POST request.");
        formatter.format("\t%-20s %-200s\n", "-f file", "Associates the content of a file to the " +
                "fileBody HTTP POST request.");
        System.out.println("Either [-d] or [-f] can be used but not both.");
    }
}
