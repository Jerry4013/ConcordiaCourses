
public class C4P7_TemperatureDemo {

	public static void main(String[] args) {
		C4P7_Temperature t1 = new C4P7_Temperature(-6);
		System.out.println("t1: " + t1);
		C4P7_Temperature t2 = new C4P7_Temperature('F');
		System.out.println("t2: " + t2);
		C4P7_Temperature t3 = new C4P7_Temperature(4, 'F');
		System.out.println("t3: " + t3);
		C4P7_Temperature t4 = new C4P7_Temperature();
		System.out.println("t4: " + t4);
		
		System.out.println(t3.getTemperatureInCelsius());
		System.out.println(t1.getTemperatureInFahrenheit());
		t1.setBoth(0, 'C');
		t2.setBoth(32, 'F');
		System.out.println(t1.equals(t2));
		t3.setBoth(-40, 'C');
		t4.setBoth(-40, 'F');
		System.out.println(t3.equals(t4));
		t1.setBoth(100, 'C');
		t2.setBoth(212, 'F');
		System.out.println(t1.equals(t2));
		
	}

}
