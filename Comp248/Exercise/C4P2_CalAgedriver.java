
public class C4P2_CalAgedriver {

	public static void main(String[] args) {
		C4P2_CalAge newCal = new C4P2_CalAge();
		int age = newCal.calculateAge();
		System.out.println("Your age is: " + age);
		double age2 = newCal.calculateAgeWithDecimal();
		System.out.printf("Your age is: %.1f", age2);
		
	}

}
