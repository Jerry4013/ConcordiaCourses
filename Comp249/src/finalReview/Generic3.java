package finalReview;

//*******************************************************************
//Generic5.java By: Aiman Hanna (C) 1993 - 2018
//This program illustrates generic method. A generic method can
//be created within a generic or a non-generic class. 
//
//Key Points:
//1) Generic Methods.
//*******************************************************************


import java.util.Scanner;

class Cls1
{
	public Cls1()
	{
		// Nothing for now
	}
	
	// A generic method that takes an array of some type and a value (actually an object) of that type. 
	// The method searches the array for that value and returns that passed value if found. 
	// The method returns null if the value is not found. 
	
	public  <T> T searchArr(T[] A, T val)
	{
		int i;
		for(i = 0; i < A.length; i++)
		{
			if (A[i].equals(val))
				return val;
		}
		return null;
	}
}


//Car Class 
class Car  {

	// Attributes
	private int numOfDoors;
	private double price;
	private int numOfSeats;
	
	// Constructors
	public Car()	// default constructor 
	{
		numOfDoors = 4;
		price = 10000;
		numOfSeats = 5;
	}
	
	public Car(int nd, double pr, int ns)	
	{
		numOfDoors = nd;
		price = pr;
		numOfSeats = ns;
	}
	
	public Car(Car c)	
	{
		numOfDoors = c.numOfDoors;
		price = c.price;
		numOfSeats = c.numOfSeats;
	}
	
	public int getNumOfDoors()
	{
		return numOfDoors;
	}
	
	public void setNumOfDoors(int nd)
	{
		numOfDoors = nd;
	}
	

	public int getNumOfSeats()
	{
		return numOfSeats;
	}
	
	public void setNumOfSeats(int ns)
	{
		numOfSeats = ns;;
	}
	
	public void setPrice(double pr)
	{
		price = pr;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String toString()
	{
		return getNumOfDoors() + " doors, " + getPrice() +
		"$, and " + numOfSeats + " seats."; 
	}
	
	public boolean equals(Car c)
	{
		return (price == c.price && numOfDoors == c.numOfDoors && numOfSeats == c.numOfSeats);	
	}
}   // end of Car class


public class Generic3{
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		Integer i1, x;
		Integer[] Arr1 = new Integer[10];
		Arr1[0] = 3; Arr1[1] = 8; Arr1[2] = 3; Arr1[3] = 10; Arr1[4] = 2; 
		Arr1[5] = 32; Arr1[6] = 18; Arr1[7] = 44; Arr1[8] = 65; Arr1[9] = 22; 
		
		String[] Arr2 = new String[8];
		Arr2[0] = "Hello"; Arr2[1] = "This"; Arr2[2] = "is"; Arr2[3] = "just"; Arr2[4] = " a simple"; 
		Arr2[5] = "test"; Arr2[6] = "for"; Arr2[7] = "Generic Methods";
		@SuppressWarnings("unused")
		String s1, s2;
		
		@SuppressWarnings("unused")
		Car c1 = new Car(4, 12000, 5), c2 = new Car(2, 23000, 2), c3 = new Car(2, 28000, 4), c4 = new Car(), 
	    c5 = new Car(2, 8000, 5), c6 = new Car(4, 17000, 2), c7 = new Car(5, 26000, 6), c8 = new Car(2, 36000, 5);
		Car c;
		
		Car[] carArr1 = new Car[5];
		carArr1[0] = c1; carArr1[1] = c2; carArr1[2] = c3; carArr1[3] = c4; 
		carArr1[4] = c5; 
		
		Cls1 cl1 = new Cls1();
		
		System.out.print("Please enter an integer value to search for: ");
		i1 = kb.nextInt();
		
		x = cl1.<Integer>searchArr(Arr1, i1); // Notice that the following is also okay: x = c1.searchArr(Arr1, i1);
		if(x != null)
		{
			System.out.println("At least one occurrence of " + x + " was found in the array.");
		}
		else
			System.out.println("No matches of " + i1 + " was found in the array.");
		
		
		System.out.print("\nPlease enter an String search for: ");
		s1 = kb.next();
		
		s2 = cl1.<String>searchArr(Arr2, s1);	// Notice that the following is also okay: s2 = c1.searchArr(Arr2, s1);
		if(x != null)
		{
			System.out.println("\nAt least one occurrence of \"" + s1 + "\" was found in the array.");
		}
		else
			System.out.println("\nNo matches of \"" + s1 + "\" was found in the array.");
		
		System.out.println("\nWill start search for Car C3 in the array.... ");
		c = cl1.<Car>searchArr(carArr1, c3); // Notice that the following is also okay: c = c1.searchArr(carArr, c3);
		
		if(c != null)
		{
			System.out.println("At least one occurrence of car c1: \"" + c1 + "\" was found in the array.");
		}
		else
			System.out.println("No matches of car c1: \"" + c1 + "\" was found in the array.");
		
		
		System.out.println("\nWill start search for Car C7 in the array.... ");
		c = cl1.searchArr(carArr1, c7);	// Notice the difference in this call from the above one. Both are okay
		
		if(c != null)
		{
			System.out.println("At least one occurrence of car c7: \"" + c7 + "\" was found in the array.");
		}
		else
			System.out.println("No matches of car c7: \"" + c7 + "\" was found in the array.");
	
	}
}

/* The Output 
Please enter an integer value to search for: 32
At least one occurrence of 32 was found in the array.

Please enter an String search for: just

At least one occurrence of "just" was found in the array.

Will start search for Car C3 in the array.... 
At least one occurrence of car c1: "4 doors, 12000.0$, and 5 seats." was found in the array.

Will start search for Car C7 in the array.... 
No matches of car c7: "5 doors, 26000.0$, and 6 seats." was found in the array.

*/