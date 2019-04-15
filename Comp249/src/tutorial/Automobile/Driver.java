package tutorial.Automobile;

public class Driver {

	public static void main(String[] args) {
		Car c1 = new Car(5.21);
		Car c2 = new Car(4.4);
		Car c3 = new Car(5.21);
		String s1 = new String("1234");
		
		System.out.println(c1.equals(c1));
		System.out.println(c2.equals(c1));
		System.out.println(c3.equals(c1));
		System.out.println(c1.equals(s1));
	}

}
