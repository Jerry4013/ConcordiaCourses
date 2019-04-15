package textbook.chapter13.test;


public class CallFromOutside {

	public static void main(String[] args) {
		SomeClass1 c = new SomeClass1();
		c.display();
		System.out.println(c);
		c.fun1();
	}

}
