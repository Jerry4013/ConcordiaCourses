package lab;

public class Bicycle extends Vehicle{
	public Bicycle(){}
	public Bicycle(int seats, int year){
		super(seats, year);
	}
	
	public String toString(){
		return "I have no engine.";
	}
	
	public void greeting(){
		System.out.println("I am a bicycle manufactured in year " + getYear() + 
				"\nI carry " + getSeats() + " persons and I have no engine!");
	}
}
