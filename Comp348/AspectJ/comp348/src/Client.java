
public class Client {
	Server server;
	public Client(Server server) {
		this.server = server;
	}
	
	public String testConnection() {
		System.out.println("About to call server.ping()");
		String str = server.ping();
		System.out.println("Just called server.ping()");
		return str;
	}
}
