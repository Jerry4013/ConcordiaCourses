package lab;

public class Car extends Vehicle {
	private double enginePower;

	public Car() {
	}

	public Car(int seats, int year, double enginePower) {
		super(seats, year);
		if (enginePower < 0) {
			System.out.println("Fail to creat a car.");
			System.exit(0);
		}
		this.enginePower = enginePower;
	}
	
	public String toString(){
		return super.toString() + "\nEngine power: " + enginePower;
	}
	
	public void greeting(){
		System.out.println("I am a car manufactured in year " + getYear() + 
				"\nI carry " + getSeats() + " persons with power " + enginePower);
	}
	
}
