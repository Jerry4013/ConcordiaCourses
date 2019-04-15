// *******************************************************************
// Inherit1.java By: Aiman Hanna (C) 1993 - 2018
// This program illustrates the subject of inheritance. In particular,
// the program illustrate how objects are being created when inheritance 
// is used. 
//
// Key Points: 
// 	1) Inheritance 
// 	2) Base & derived classes
//  3) The keyword "extends"
//  4) Default constructors
// *******************************************************************

// Vehicle Class
class Vehicle {

	// Attributes
	private int numOfDoors;
	private double price;
	
	// Constructors
	public Vehicle()	// default constructor 
	{
		System.out.println("Creating a vehicle object using default constructor ....");
		
		numOfDoors = 4;
		price = 10000;
	}
	
	public Vehicle(int nd, double pr)	
	{
		System.out.println("Creating a vehicle object using parameterized constructor ....");
		
		numOfDoors = nd;
		price = pr;
	}
	
	
	public Vehicle(Vehicle vec)	// copy constructor 
	{
		System.out.println("Creating a vehicle object using copy constructor ....");
		
		numOfDoors = vec.numOfDoors;
		price = vec.price;
	}
	
	public int getNumOfDoors()
	{
		return numOfDoors;
	}
	
	public void setNumOfDoors(int nd)
	{
		numOfDoors = nd;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double pr)
	{
		price = pr;
	}
	
	public String toString()
	{
		return "This Vehicle has " + numOfDoors + 
		"doors and it price is " + price + "$.";
	}
} // end of Vehicle class




// Bus Class - This is a derived class from the Vehicle Class; that is it 
// inherits the Vehicle class 
class Bus extends Vehicle{

	// Attributes
	private int passengerCapacity;
	
	// Constructors
	public Bus()	// default constructor 
	{
		System.out.println("Creating a bus object using default constructor ....\n");
		
		passengerCapacity = 10;
	}
	
	public Bus(int pc)	
	{
		System.out.println("Creating a bus object using parameterized constructor ....\n");
		
		passengerCapacity = pc;
	}
	
	public Bus(Bus b)	
	{
		System.out.println("Creating a bus object using copy constructor ....\n");
		
		passengerCapacity = b.passengerCapacity;
	}
	
	public int getPassangerCapacity()
	{
		return passengerCapacity;
	}
	
	public void setPassengerCapacity(int pc)
	{
		passengerCapacity = pc;;
	}
	
	public String toString()
	{
		return "This Bus has a passenger capacity of " + passengerCapacity + "."; 
	}
}   // end of Bus class
	


public class Inherit1 {

	
	public static void main(String[] args) {
		System.out.println("Will create two Vehicle objects");

		Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 5000);
		
		System.out.println();
		System.out.println("Will create three Bus objects");

		Bus b1 = new Bus(), b2 = new Bus(55), b3 = new Bus(b1);
		
		System.out.println("Here is the information of the first bus:\n" + b1 + "\n");
		System.out.println("Here is the information of the second bus:\n" + b2 + "\n");
		System.out.println("Here is the information of the third bus:\n" + b3 + "\n");
		System.out.println(v1);
		System.out.println(v2);
	}

}

/* The Output 
Will create two Vehicle objects
Creating a vehicle object using default constructor ....
Creating a vehicle object using parameterized constructor ....

Will create three Bus objects
Creating a vehicle object using default constructor ....
Creating a bus object using default constructor ....

Creating a vehicle object using default constructor ....
Creating a bus object using parameterized constructor ....

Creating a vehicle object using default constructor ....
Creating a bus object using copy constructor ....

Here is the information of the first bus:
This Bus has a passenger capacity of 10.

Here is the information of the second bus:
This Bus has a passenger capacity of 55.

Here is the information of the third bus:
This Bus has a passenger capacity of 10.

 */
	