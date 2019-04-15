/*	COPYRIGHT OF CONCORDIA UNIVERSITY
DEPARTMENT OF ENGINEERING AND COMPUTER SCIENCE

	COMP248	LAB72	Fall 2018
	PROF: Nancy Acemian
	AUTHOR: 
	STUDENT ID: 
	
	
	Topic: Simple Class	 
*/

// class Lab72
public class Lab72 {
	// ------------------------
	// CODE TO COMPLETE
	// -------------------------
	// Declare class variables
	private String name;
	private int seats;
	private int speakers;
	private int wheels;
	
	// Implement default constructor
	public Lab72()
	{
		name = "The Cube Car";
		seats = 2;
		speakers = 4;
		wheels = 4;
	}
	
	// Implement Get/Set methods
	public String getName()
	{
		return name;
	}
	public int getSeats()
	{
		return seats;
	}
	public int getSpeakers()
	{
		return speakers;
	}
	public int getWheels()
	{
		return wheels;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	public void setSeats(int newSeats)
	{
		seats = newSeats;
	}
	public void setSpeakers(int newSpeakers)
	{
		speakers = newSpeakers;
	}
	public void setWheels(int newWheels)
	{
		wheels = newWheels;
	}
	
	//-----------------------------------------------------------------
	// DO NOT CHANGE CODE FROM HERE ON
	// main method
	public static void main(String[] args) {
		Lab72 defaultCar = new Lab72();
		
		System.out.println("Car name: " + defaultCar.getName());
		System.out.println("Seats: " + defaultCar.getSeats());
		System.out.println("Speakers: " + defaultCar.getSpeakers());
		System.out.println("Wheels: " + defaultCar.getWheels() + "\n");
		
		System.out.println("Applying changes...\n");
		defaultCar.setName("Circle Car");
		defaultCar.setSeats(8);
		defaultCar.setSpeakers(12);
		defaultCar.setWheels(8);
		
		System.out.println("Car name: " + defaultCar.getName());
		System.out.println("Seats: " + defaultCar.getSeats());
		System.out.println("Speakers: " + defaultCar.getSpeakers());
		System.out.print("Wheels: " + defaultCar.getWheels());
	}
}
