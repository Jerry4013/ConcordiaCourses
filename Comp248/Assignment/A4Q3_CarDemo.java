// -------------------------------------------------------
// Assignment 4 Question 3
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Nov 6, 2017
// Purpose: This is a driving program to test the class, Car, we defined.
// --------------------------------------------------------

public class A4Q3_CarDemo {

	public static void main(String[] args) {
		
		//Declaring 4 car objects using 4 different constructors and outputs the description of the 4 cars by toString() method.
		A4Q3_Car C1 = new A4Q3_Car();
		A4Q3_Car C2 = new A4Q3_Car(32000);
		A4Q3_Car C3 = new A4Q3_Car(4, 18000);
		A4Q3_Car C4 = new A4Q3_Car(2, 36000, "SUV");
		System.out.println("Car C1: " + C1);
		System.out.println("Car C2: " + C2);
		System.out.println("Car C3: " + C3);
		System.out.println("Car C4: " + C4);
		System.out.println();
		
		//Testing accessor methods.
		System.out.println("Accessor Method: The cartype for car C4 is " + C4.getType() + ", its age is " + C4.getAge() + 
				", and it costs $" + C4.getCost());
		System.out.println();
		
		//Testing the estimatePrice() method
		System.out.println("The estimated price of car C3 is $" + C3.estimatePrice());
		System.out.println("The estimated price of car C4 is $" + C4.estimatePrice());
		
		//Testing the mutator methods, and toString() method
		C3.setAge(5);
		System.out.println("Mutator Method: The new age for car C3 is " + C3.getAge());
		C3.setType("SUV");
		System.out.println("Mutator Method: The new cartype for car C3 is " + C3.getType());
		C3.setCost(14000);
		System.out.println("Mutator Method: The new cost for car C3 is " + C3.getCost());
		C3.setAgeAndCost(9, 9000);
		System.out.println("Mutator Method: The new car age is " + C3.getAge() + " and its new cost is " + C3.getCost());
		C3.setCar(14, 5000, "Sedan");
		System.out.println("Mutator Method: The new cartype for car C3 is " + C3.getType() + ", its new age is " + 
				C3.getAge() + " and its cost is " + C3.getCost());
		System.out.println("toString: " + C3);
		System.out.println();
		
		//Testing the equals(), isLessThan() and isGreaterThan() methods
		System.out.println("Cars C1 and C2 are equal is " + C1.equals(C2));
		System.out.println("Cars C1 and C4 are equal is " + C1.equals(C4));
		System.out.println("Car C4 is less than C3 is " + C4.isLessThan(C3));
		System.out.println("Car C1 is greater than C3 is " + C1.isGreaterThan(C3));
	}

}
