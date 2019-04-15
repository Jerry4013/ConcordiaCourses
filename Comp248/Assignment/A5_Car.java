// -------------------------------------------------------
// Assignment 5 Question 3
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Nov 19, 2017
// Purpose: define a class Car, with some instance variables and some methods. 
// --------------------------------------------------------

public class A5_Car {
	private String model;
	private int location;
	private int currentSpeed;
	private boolean movingForward;
	private int maxSpeed;
	private boolean crashed;
	private boolean Arrived;
	
	public A5_Car()//default constructor
	{	}
	
	public A5_Car(A5_Car anotherCar)//Copy constructor
	{
		if (anotherCar==null)
		{
			System.out.println("Fatal error.");
			System.exit(0);	
		}
		model = anotherCar.model;
		location = anotherCar.location;
		currentSpeed = anotherCar.currentSpeed;
		movingForward = anotherCar.movingForward;
		maxSpeed = anotherCar.maxSpeed;
		crashed = anotherCar.crashed;
		Arrived = anotherCar.Arrived;
	}
	//Constructor
	public A5_Car(String initialModel, int initialMaxSpeed, int initialLocation)
	{
		model = initialModel;
		
		if (initialMaxSpeed >= 0)
			maxSpeed = initialMaxSpeed;
		else
		{
			System.out.println("Max speed cannot be less than 0. Aborting.");
			System.exit(0);
		}
		
		if(initialLocation>=0)
			location = initialLocation;
		else
		{
			System.out.println("Location cannot be less than 0. Aborting.");
			System.exit(0);
		}
		movingForward = true;
		currentSpeed = 0;
	}
	
	//part 2, create a new constructor
	public A5_Car(String initialModel, int initialMaxSpeed)
	{
		model = initialModel;
		if (initialMaxSpeed >= 0)
			maxSpeed = initialMaxSpeed;
		else
		{
			System.out.println("Max speed cannot be less than 0. Aborting.");
			System.exit(0);
		}
		location = 0;
		movingForward = true;
		currentSpeed = 0;
	}
	//some accessor methods
	public String getModel()
	{
		return model;
	}
	
	public boolean getDirection()
	{
		return movingForward;
	}
	
	public int getLocation()
	{
		return location;
	}
	
	public boolean getStatusOfCrash()
	{
		return crashed;
	}
	
	public boolean getStatusOfArriving()
	{
		return Arrived;
	}
	
	//Some controlling methods of a Car
	public void arrive()
	{
		Arrived = true;
	}
	
	public void go()
	{
		currentSpeed = maxSpeed;
	}
	
	public void stop()
	{
		currentSpeed = 0;
	}
	
	public void turnAround()
	{
		movingForward = !movingForward;
	}
	
	public void move()
	{
		if(movingForward)
			location += currentSpeed;
		else
			location -= currentSpeed;
	}
	
	public void accelerate()
	{
		if (currentSpeed < maxSpeed)
			currentSpeed++;
	}
	
	public void brake()
	{
		if(currentSpeed > 0)
			currentSpeed--;
	}
	
	public void crash()
	{
		crashed = true;
	}
	
	//toString
	public String toString()
	{
		String direction, speedString;
		if (movingForward)
			direction = "forward";
		else
			direction = "backwards";
		if (currentSpeed > 0)
			speedString = " and moving at " + currentSpeed + " speed.";
		else
			speedString = ", not moving";
		return (model + ": Located at " + location + ", facing " + direction + speedString);
	}
	//equals
	public boolean equals(A5_Car anotherCar)
	{
		return(model.equals(anotherCar.model) && maxSpeed == anotherCar.maxSpeed);
	}
}
