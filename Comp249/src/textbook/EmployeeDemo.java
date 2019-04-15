package textbook;

public class EmployeeDemo {

	public static void main(String[] args) {
		HourlyEmployee joe = new HourlyEmployee("Joe Worker",
				new Date("January", 1, 2015),
				50.50, 160);
		System.out.println("joe's longer name is " +
				joe.getName());
		System.out.println("Changing joe's name to Josephine.");
		joe.setName("Josephine");
		System.out.println("joe's record is as follows:");
		System.out.println(joe);
		
		SalariedEmployee Hanny = new SalariedEmployee("Hanny", new Date("January", 1, 2018), 50000);
		System.out.println(Hanny);
	}

}
