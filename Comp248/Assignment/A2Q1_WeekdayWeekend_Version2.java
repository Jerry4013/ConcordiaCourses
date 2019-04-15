
// -------------------------------------------------------
// Assignment 2 Question 1 Version 2
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Oct 3, 2017
// Purpose: To determine which day the user entered is and whether the day is a weekday or a weekend.
// --------------------------------------------------------

import java.util.Scanner;
public class A2Q1_WeekdayWeekend_Version2 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
				
		//Welcome banner
		System.out.println("\n-----------------------------------------------");
		System.out.println("Welcome to Jingchao's \"WeekdayWeekend\" program.");
		System.out.println("-----------------------------------------------\n");
		
		//The input is an integer number entered by the user, so we need to create a variable of type integer, 
		//and store the number that the user entered in this variable later.
		int daynumber = 0;
		System.out.print("Please enter the day of the week as a number (1-7):");
		daynumber = keyboard.nextInt();
		
		//We need to print out different output depending on what the user entered.
		//So I discuss all the seven cases with switch statements
		switch (daynumber)
		{
			case 1:
				System.out.println("It's Monday! It's the weekday!");
				break;
			case 2:
				System.out.println("It's Tuesday! It's the weekday!");
				break;
			case 3:
				System.out.println("It's Wednesday! It's the weekday!");
				break;
			case 4:
				System.out.println("It's Thursday! It's the weekday!");
				break;
			case 5:
				System.out.println("It's Friday! It's the weekday!");
				break;
			case 6:
				System.out.println("It's Saturday! It's the weekend!");
				break;
			case 7:
				System.out.println("It's Sunday! It's the weekend!");
				break;
			default: 
				System.out.println("That's not a valid day!");
				break;
		}
		
		//Prompt the user this is the end of this program
		System.out.println("\nThank you for using the program!");
		
		keyboard.close();
		

	}

}
