
// -------------------------------------------------------
// Assignment 2 Question 3
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Oct 7, 2017
// Purpose: The purpose of this program is to help a customer decide which subscription is best for them 
// based on the number of food orders they make per month
// --------------------------------------------------------

import java.util.Scanner;
import java.text.NumberFormat;
public class A2Q3_FoodieDelivery {

	public static void main(String[] args) {
		// Algorithm:
		// Step 1: Ask the user to enter the number of food orders per month.
		// Step 2: Calculate the cost of the three programs by the given rules.
		// Step 3: Find the minimum of them and output the result.
				
		//Welcome banner
		System.out.println("\n----------------------------------------------------------------");
		System.out.println("Welcome to Jingchao's \"FoodieDelivery Subscription Calculator\".");
		System.out.println("----------------------------------------------------------------\n");
		
		//Prompt the user to enter the number of food orders
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the number of times a month you use food delivery services: ");
		int number = kb.nextInt();
		double payPerDelivery, occassionalFoodie, montrealFoodie;
		
		//Calculate the cost of the three programs
		payPerDelivery = 3.0 * number;
		if (number<=6)
			occassionalFoodie = 15.0;
		else 
			occassionalFoodie = 15.0 + (number - 6) * 2.0;
		if (number<=12)
			montrealFoodie = 30.0;
		else
			montrealFoodie = 30.0 + (number - 12) * 1.5;
		
		NumberFormat money = NumberFormat.getCurrencyInstance();
		System.out.println("\nThe cost of Pay per delivery would be: " + money.format(payPerDelivery) + "/month");
		System.out.println("The cost of the OccasionalFoodie subscription would be: " + money.format(occassionalFoodie) + "/month");
		System.out.println("The cost of the MontrealFoodie subscription would be: " + money.format(montrealFoodie) + "/month\n");
		
		//Find the minimum: first, find the minimum between number1 and number2, if number1 is less than number2, 
		//then check number1 and number3
		//if not, then check number2 and number3.
		if (payPerDelivery < occassionalFoodie)
			if (payPerDelivery < montrealFoodie)
				System.out.println("**We recommend getting the Pay per delivery.**\n" + 
						"You would save "+ money.format(occassionalFoodie - payPerDelivery) +
						" from occassionalFoodie and " + money.format(montrealFoodie - payPerDelivery) + " from MontrealFoodie.");
			else
				System.out.println("**We recommend getting the MontrealFoodie subscription.**\n" +
						"You would save "+ money.format(payPerDelivery-montrealFoodie) + " from payPerDelivery and "
						+ money.format(occassionalFoodie - montrealFoodie) +" from occassionalFoodie.");
		else if (occassionalFoodie < montrealFoodie)
			System.out.println("**We recommend getting the OccasionalFoodie subscription.**\n" +
				"You would save "+ money.format(payPerDelivery - occassionalFoodie) +" from payPerDelivery and "
				+ money.format(montrealFoodie-occassionalFoodie) + " from montrealFoodie.");
		else
			System.out.println("**We recommend getting the MontrealFoodie subscription.**\n" +
			    "You would save "+ money.format(payPerDelivery - montrealFoodie) +" from payPerDelivery and " +
				money.format(occassionalFoodie - montrealFoodie) + " from occassionalFoodie.");
		
		System.out.println("\nThank you for using FoodieDelivery Subscription Calculator. Good Eats :-)!");
		kb.close();
		
	}

}
