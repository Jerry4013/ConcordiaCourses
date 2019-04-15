
// -------------------------------------------------------
// Assignment 2 Question 3
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Oct 9, 2017
// Purpose: The purpose of this program is to help a customer decide which subscription is best for them 
// based on the number of food orders they make per month
// --------------------------------------------------------

import java.util.Scanner;
import java.text.NumberFormat;
public class A2Q3_FoodieDelivery_V2 {

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
		NumberFormat money = NumberFormat.getCurrencyInstance();
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the number of times a month you use food delivery services: ");
		int number = kb.nextInt();
		double payPerDelivery = 0.0, occassionalFoodie = 15.0, montrealFoodie = 30.0;//initializing by their lowest possible prices.
		
		//Calculate the cost of the three programs
		//The cost will be updated if the order number exceed their threshold values.
		payPerDelivery = 3.0 * number;
		if (number > 12)
		{
			occassionalFoodie = 15.0 + (number - 6) * 2.0;
			montrealFoodie = 30.0 + (number - 12) * 1.5;
		}
		else if (number > 6)
			occassionalFoodie = 15.0 + (number - 6) * 2.0;

		//Find the minimum and print out the result in different cases.
		System.out.println("\nThe cost of Pay per delivery would be: " + money.format(payPerDelivery) + "/month");
		if (payPerDelivery < occassionalFoodie)
			if (payPerDelivery < montrealFoodie)
				System.out.println("\n**We recommend getting the Pay per delivery.**");
			else
				System.out.println("The cost of the OccasionalFoodie subscription would be: " + money.format(occassionalFoodie) + "/month\n"+ 
						"Based on your food ordering, the cost of the MontrealFoodie subscription would be:\n" + 
						money.format(montrealFoodie) + "/month\n\n"+
						"**We recommend getting the MontrealFoodie subscription.**\n" +
						"You would save "+ money.format(payPerDelivery-montrealFoodie) + " from payPerDelivery and "
						+ money.format(occassionalFoodie - montrealFoodie) +" from occassionalFoodie.");
		else if (occassionalFoodie < montrealFoodie)	
			System.out.println("Based on your food deliveries, the cost of the OccasionalFoodie subscription would be: \n" + 
					money.format(occassionalFoodie) + "/month"+"\n**We recommend getting the OccasionalFoodie subscription.**\n" +
					"You would save "+ money.format(payPerDelivery - occassionalFoodie) +" from payPerDelivery.");
		else 
			System.out.println("The cost of the OccasionalFoodie subscription would be: " + money.format(occassionalFoodie) + "/month"+ 
					"\nBased on your food ordering, the cost of the MontrealFoodie subscription would be:\n" + 
					money.format(montrealFoodie) + "/month\n\n"+
					"**We recommend getting the MontrealFoodie subscription.**\n" +
					"You would save "+ money.format(payPerDelivery-montrealFoodie) + " from payPerDelivery and "
					+ money.format(occassionalFoodie - montrealFoodie) +" from occassionalFoodie.");

		System.out.println("\nThank you for using FoodieDelivery Subscription Calculator. Good Eats :-)!");
		kb.close();
		
	}

}
