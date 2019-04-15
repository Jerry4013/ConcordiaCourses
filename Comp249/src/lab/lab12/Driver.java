package lab.lab12;

public class Driver {

	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();
		Book b1 = new Book(2000, "b1");
		Book b2 = new Book(1000, "b2");
		Book b3 = new Book(500, "b3");
		Book b4 = new Book(5000, "b4");
	
		list.insert(b1);
		System.out.println(list);
		list.insert(b2);
		System.out.println(list);
		list.insert(b3);
		System.out.println(list);
		list.insert(b4);
		System.out.println(list);
	}

}
