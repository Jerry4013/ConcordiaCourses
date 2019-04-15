/*	COPYRIGHT OF CONCORDIA UNIVERSITY
DEPARTMENT OF ENGINEERING AND COMPUTER SCIENCE

	COMP248	LAB82	Fall 2018
	PROF: Nancy Acemian
	AUTHOR: 
	
	Topic: Full Basic Class	 
*/

// class Lab82
import java.util.Scanner;
public class Lab82 {
	// class variables
	String name;
	int seats, speakers, wheels;
	//==>
	double cost;
	
	// Constructors
	//==============
		
	// default constructor
	public Lab82() {
		// initialize object variables
		this.name = "The Cube Car";
		this.seats = 4;
		this.speakers = 2;
		this.wheels = 5;
		this.cost = 95;
	}
	//---------------------------------------------------------------
	//SECTION TO COMPLETE
	//------------------------
	// ==> other constructor
	public Lab82(String name, int seats, int speakers, int wheels, double cost)
	{
		this.name = name; 
		this.seats = seats;
		this.speakers = speakers;
		this.wheels = wheels;
		this.cost = cost;
	}
	
	// ==>toString() method
	public String toString()
	{
		return (name + " has " + seats + " seats, " + speakers + " speakers, and " + wheels + " wheels.");
	}
	
	// =>equals() method
	public boolean equals(Lab82 anotherCar)
	{
		return (name.equalsIgnoreCase(anotherCar.name)&& seats==anotherCar.seats);
	}
	
	// ==>calculateCost() method
	public double calculateCost()
	{
		return (cost * speakers);
	}
	
	//---------------------------------------------------------------
	
	// Get/Set methods
	//================
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSeats() {
		return this.seats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public int getSpeakers() {
		return this.speakers;
	}
	
	public void setSpeakers(int speakers) {
		this.speakers = speakers;
	}
	
	public int getWheels() {
		return this.wheels;
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
//---------------------------------------------------------------	
//==> get/set methods for cost - TO COMPLETE
	public double getCost(){
		return this.cost;
	}
	
	public void setCost(double cost)
	{
		this.cost = cost;
	}
//---------------------------------------------------------------


//-------
// MAIN
//-------	
	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		Lab82 car1 = new Lab82();
		System.out.print("How many seats and speakers does your car have? ");
		int seats = keyIn.nextInt();
		int speakers = keyIn.nextInt();
		Lab82 car2 = new Lab82("Nancy's Car", seats, speakers, 5, 45.3);
		
		System.out.println("car1: " + car1.toString());
		System.out.println("car2: " +car2.toString());
		System.out.println("car1 == car2: " + car1.equals(car2) + "\n");
		 
		System.out.println("Applying changes...\n");
		car2.setName("The Cube Car");
		
		//-------------------------------------------------------------------------------
		//SECTION TO COMPLETE
		//------------------------
		//==> Set the number of seats of car2 object to be the same as car1 object
		car2.setSeats(car1.seats);
		//==> increase the number of speakers of car1 object by 1
		car1.speakers++;
		//==> increase the number of wheels of car1 object by 2
		car1.wheels += 2;
		//==> set the cost of car1 to be 1.4 times wat it currently is
		car1.cost = 1.4 * car1.cost;
		// END OF SECTION TO COMPLETE
		//--------------------------------------------------------------------------------
;
		
		System.out.println("car1: " + car1.toString());
		System.out.println("car2: " + car2.toString());
		System.out.println("car2 == car1: " + car2.equals(car1) + "\n");
		
		System.out.println("Processing cost for Cube car...\n");
		System.out.println("Cost per unit: " + car1.getCost());
		System.out.print("Total cost of speakers: " + car1.calculateCost());
		keyIn.close();
	}
}
