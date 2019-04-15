// -------------------------------------------------------
// Assignment 5 Question 3
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Nov 20, 2017
// Purpose: Simulating two cars driven in different direction, and crash to each other.
// --------------------------------------------------------
import java.util.Scanner;
public class A5_RaceLane1 {

	public static void main(String[] args) {
		
		int location1, location2, speed1, speed2;
		String model1, model2;
		boolean car1IsOnTheRight = false;
		 
		//Reading information of the first car.
		Scanner keyIn = new Scanner(System.in);
		System.out.println("Please enter the model of the first car");
		model1 = keyIn.nextLine();
		System.out.println("Please enter the location of the first car");
		location1 = keyIn.nextInt();
		System.out.println("Please enter the speed of the first car");
		speed1 = keyIn.nextInt();
		A5_Car car1 = new A5_Car(model1, speed1, location1);
		//Reading information of the second car.
		keyIn.nextLine();
		System.out.println("Please enter the model of the second car");
		model2 = keyIn.nextLine();
		System.out.println("Please enter the location of the second car");
		location2 = keyIn.nextInt();
		//These two cars cannot at the same location.
		while(location2 == location1)
		{
			System.out.println("Two cars cannot at the same location on the same lane.");
			System.out.println("Please enter a different location for the second car: ");
			location2 = keyIn.nextInt();
		}
		System.out.println("Please enter the speed of the second car");
		speed2 = keyIn.nextInt();
		A5_Car car2 = new A5_Car(model2, speed2, location2);
		//Print out the initial cars.
		System.out.println(car1);
		System.out.println(car2);
		
		//Determine which car is on the right, and turn the car on the right.
		if(car1.getLocation() < car2.getLocation())
		{
			car1IsOnTheRight = false;
			car2.turnAround();
		}
		else if (car1.getLocation() > car2.getLocation())
		{
			car1IsOnTheRight = true;
			car1.turnAround();
		}
		//Print out the cars after turn around
		System.out.println(car1);
		System.out.println(car2);
		//start with the max speed
		car1.go();
		car2.go();
		System.out.println(car1);
		System.out.println(car2);
		
		//continue moving with their current speeds, until they crash
		while(car1IsOnTheRight && car1.getLocation() > car2.getLocation() ||
			  !car1IsOnTheRight && car1.getLocation() < car2.getLocation())
		{
			car1.move();
			car2.move();
			System.out.println(car1);
			System.out.println(car2);
		}
		System.out.println("Boom!!");
		
		keyIn.close();
	}

}
