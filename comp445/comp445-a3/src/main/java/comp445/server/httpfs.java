package comp445.server;

public class httpfs {

    public static void main(String[] args){
        UDPServer server = new UDPServer();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-v":
                    server.setDebugging(true);
                    System.out.println("Prints debugging messages.");
                    break;
                case "-p":
                    int port = Integer.parseInt(args[++i]);
                    server.setPort(port);
                    System.out.println("Port is set: " + port);
                    break;
                case "-d":
                    server.setPath(args[++i]);
                    break;
                default:
                    System.out.println("Cannot resolve the command.");
            }
        }

        try {
            server.startServer();
        } catch (Exception ex){
            System.out.println("Server failed to open...");
        }
    }
}
