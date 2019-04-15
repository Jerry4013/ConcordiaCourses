// -------------------------------------------------------
// Assignment 4 Question 3
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Nov 6, 2017
// Purpose: Define a class named Car that stores information about a car.
// --------------------------------------------------------

import java.text.DecimalFormat;
public class A4Q3_Car {
	//Instance variables;
	private int age;
	private String type;
	private double cost;
	
	//Defining 4 constructors
	public A4Q3_Car()
	{
		age = 0;
		type = "Sedan";
		cost = 32000;
	}
	
	public A4Q3_Car(double initialCost)
	{
		setCost(initialCost);
		this.age = 0;
		this.type = "Sedan";
	}
	
	public A4Q3_Car(int initialAge, double initialCost)
	{
		setAge(initialAge);
		setCost(initialCost);
		this.type = "Sedan";
	}
	
	public A4Q3_Car(int initialAge, double initialCost, String initialType)
	{
		setCar(initialAge, initialCost, initialType);
	}
	
	//Defining 3 accessor methods
	public int getAge()
	{
		return age;
	}
	
	public double getCost()
	{
		return cost;
	}
	
	public String getType()
	{
		return type;
	}
	
	//5 Mutator methods. Adding some conditions to the input.
	public void setAge(int newAge)
	{
		if(newAge>=0)
			age = newAge;
		else
		{
			System.out.println("Error");
			System.exit(0);
		}
	}
	
	public void setType(String newType)
	{
		if (newType.equalsIgnoreCase("Sedan")||newType.equalsIgnoreCase("SUV"))
			type = newType;
		else
		{
			System.out.print("Invalid type.");
			System.exit(0);
		}
	}
	
	public void setCost(double newCost)
	{
		if(newCost>=0)
			cost = newCost;
		else
		{
			System.out.println("Error");
			System.exit(0);
		}
	}
	
	public void setCar(int newAge, double newCost, String newType)
	{
		setAge(newAge);
		setCost(newCost);
		setType(newType);
	}
	
	public void setAgeAndCost(int newAge, double newCost)
	{
		setAge(newAge);
		setCost(newCost);
	}
	
	//estimatePrice() method. Computing the price after depreciation in each case.
	public double estimatePrice()
	{
		double price = 0;
		if (type.equalsIgnoreCase("Sedan"))
			if (age<=5)
				price = 32000 * (1 - age * 0.1);
			else if (age<=15)//If age is greater than 15, the cost would be less than 0, which we need to transfer to 0
				price = 32000 * (1 - 5 * 0.1 - (age-5) * 0.05);
			else//age>15
				price = 0;//price cannot be negative
		else if (type.equalsIgnoreCase("SUV"))
			if (age<=5)
				price = 45000 * (1 - age * 0.08);
			else if (age<=20)//If age is greater than 20, the cost would be less than 0, which we need to transfer to 0.
				price = 45000 * (1 - 5 * 0.08 - (age-5) * 0.04);
			else//age>20
				price = 0;//price cannot be negative
		return price;
	}
	
	public String toString()
	{
		DecimalFormat decimal = new DecimalFormat("0.0");
		return ("This car is type " + type + ". Its age is " + age + " and costs $" + decimal.format(cost));
	}
	
	public boolean equals(A4Q3_Car anotherCar)
	{
		return (age == anotherCar.age && type.equalsIgnoreCase(anotherCar.type));
	}
	
	public boolean isLessThan(A4Q3_Car anotherCar)
	{
		return cost < anotherCar.cost;
	}
	
	public boolean isGreaterThan(A4Q3_Car otherCar)
	{
		return cost > otherCar.cost;
	}
		
}
