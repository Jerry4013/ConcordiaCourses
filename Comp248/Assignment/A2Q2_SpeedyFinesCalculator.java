// -------------------------------------------------------
// Assignment 2 Question 2
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Oct 6, 2017
// Purpose: To determine the penalty for a driver who is speeding and 
// to determine if the driver should lose their license and
// Output how many demerit points the driver has after the current infraction.
// --------------------------------------------------------
import java.util.Scanner;
public class A2Q2_SpeedyFinesCalculator {

	public static final int LIMIT = 100; //This speed limit will not change in this program. 
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		//Welcome banner
		System.out.println("\n-----------------------------------------------");
		System.out.println("Welcome to Jingchao's \"SpeedyFines Calculator\".");
		System.out.println("-----------------------------------------------\n");
		
		//We need to store the speed and calculate the total demerit points and determine whether he lose his license.
		int speed = 0, demeritPoints = 0, originalDemeritPoint = 0, totalPoints = 0;
		System.out.print("How fast was the driver going? (Please enter a whole number) ");
		speed = keyboard.nextInt();
		
		//First we need to determine whether the driver is over the speed limit,
		//if not, we don't need to do anything, except tell the user the driver was not speeding. That's all. 
		if (speed > LIMIT)
		{
			//In the second layer, we need to determine which category the driver belongs to, and 
			//print out different text depends on different speed. 
			//Meanwhile, because we need to calculate the demerit points later, 
			//we change the variable demeritPoints in each cases. 
			if (speed-LIMIT<10) 
				System.out.println("The fine is $65.");
			else if (speed-LIMIT<20)
			{
				System.out.println("The fine is $120 and the driver gets 2 demerit points!");
				demeritPoints = 2;
			}
			else if (speed-LIMIT<40)
			{
				System.out.println("The fine is $240 and the driver gets 5 demerit points!");
				demeritPoints = 5;
			}
			else if (speed-LIMIT<60)
			{
				System.out.println("The fine is $360 and the driver gets 7 demerit points!");
				demeritPoints = 7;
			}
			else 
				System.out.println("The fine is $520 and the driver loses his license.");
			
			//If the driver did not get demeritPoints this time, we do not need to discuss about his points at all.
			if (demeritPoints!=0)
			{
				//determine whether the driver will lose his license by calculating his total points.
				System.out.print("How many demerit points did the driver have prior to being stopped? ");
				originalDemeritPoint = keyboard.nextInt();
				totalPoints = originalDemeritPoint + demeritPoints;
				if (totalPoints>=12)
					System.out.println("The driver has " + totalPoints + " demerit points and loses his license.");
				else
					System.out.println("The driver now has " + totalPoints + " demerit points.");
			}
		}
		else
			System.out.println("The driver was not speeding.");
		
		//Ending message
		System.out.println("\n----------------------------------------------------------");
		System.out.println("Thank you for using Jingchao's \"SpeedyFines Calculator\"!");

		keyboard.close();
	}

}
