
public class Test {
	public static void main(String[] args) {
		Server server = new Server();
		Client client = new Client(server);
		System.out.println(client.testConnection());
		
//		Human sebastian = new Human();
//		Bladerunner deckard = new Bladerunner();
//		System.out.println(sebastian.reason());
//		System.out.println(deckard.reason());
		
//		BStack myStack = new BStack(2);
//		myStack.push("base");
//		myStack.push("your");
//		myStack.push("all");
//		System.out.println(myStack.pop());
//		System.out.println(myStack.pop());
//		System.out.println(myStack.pop());
//		System.out.println(myStack.top());
	}
}
