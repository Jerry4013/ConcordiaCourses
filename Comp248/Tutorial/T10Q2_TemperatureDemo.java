
public class T10Q2_TemperatureDemo {

	public static void main(String[] args) {
		T10Q2_Temperature t1 = new T10Q2_Temperature(30, 'F');
		T10Q2_Temperature t2 = new T10Q2_Temperature(15, 'C');
		if(t1.isHotter(t2))
			System.out.println("t1 is hotter than t2");
		else
			System.out.println("t2 is hotter than t1");
		
		System.out.println(t1.getTempInCelsius());
		
		System.out.println(t1.add(t2));
	}

}
