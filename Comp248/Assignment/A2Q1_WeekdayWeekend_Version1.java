// -------------------------------------------------------
// Assignment 2 Question 1 Version 1
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Oct 3, 2017
// Purpose: To determine which day the user entered is and whether the day is a weekday or a weekend.
// --------------------------------------------------------

import java.util.Scanner;
public class A2Q1_WeekdayWeekend_Version1 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//Welcome banner
		System.out.println("\n-----------------------------------------------");
		System.out.println("Welcome to Jingchao's \"WeekdayWeekend\" program.");
		System.out.println("-----------------------------------------------");
		
		//The input is an integer number entered by the user, so we need to create a variable of type integer, 
		//and store the number that the user entered in this variable later.
		int daynumber = 0;
		
		//We need to print out different output depending on what the user entered.
		//So I discuss all the seven cases with some if/else statements
		//If the user entered a invalid number, I want him enter it again, so I use a do/while loop 
		//This program will be executed at least once, so I use do/while rather than while loop
		do 
		{
			System.out.print("\nPlease enter the day of the week as a number (1-7): ");
			daynumber = keyboard.nextInt();
			if (daynumber == 1)
				System.out.println("It's Monday! It's the weekday!");
			else if (daynumber == 2)
				System.out.println("It's Tuesday! It's the weekday!");
			else if (daynumber == 3)
				System.out.println("It's Wednesday! It's the weekday!");
			else if (daynumber == 4)
				System.out.println("It's Thursday! It's the weekday!");
			else if (daynumber == 5)
				System.out.println("It's Friday! It's the weekday!");
			else if (daynumber == 6)
				System.out.println("It's Saturday! It's the weekend!");
			else if (daynumber == 7)
				System.out.println("It's Sunday! It's the weekend!");
			else 
				System.out.println("That's not a valid day!");
		}
		while (daynumber>7 || daynumber<1);
		
		//Prompt the user this is the end of this program
		System.out.println("\nThank you for using this program!");
		
		keyboard.close();
				
	}

}
