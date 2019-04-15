package textbook;

public class Test {

	public static void main(String[] args) {
		HourlyEmployee object1 = new HourlyEmployee();
		Employee object2 = new HourlyEmployee();
		if (object1.getClass( ) == object2.getClass( ))
			System.out.println("Same class.");
		else
			System.out.println("Not the same class.");
	}

}
