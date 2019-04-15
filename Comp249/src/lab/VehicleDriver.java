package lab;

public class VehicleDriver {

	public static void main(String[] args) {
		Vehicle[] v = new Vehicle[2];
		v[0] = new Car(5, 2015, 200);
		v[1] = new Bicycle(2, 2016);
		for(int i=0; i<v.length; i++){
			v[i].greeting();
			System.out.println();
		}
		
	}

}
