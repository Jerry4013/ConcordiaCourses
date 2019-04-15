
// -------------------------------------------------------
// Assignment 1  Question 2
// Written by: Jingchao Zhang   40049474
// For COMP 248 Section R – Fall 2017
// Date: Sep 25, 2017
// The purpose of this program is to help a student write the text to an email 
// explaining to their professor why their assignment is late.
// --------------------------------------------------------

import java.util.Scanner;
public class A1Q2_LateAssignment {

	public static void main(String[] args) {
		
		//Welcome Banner
		System.out.println("---------------------------------------------");
		System.out.println("Welcome to Jingchao\'s \"Late Assignment Assistant\" program!");
		System.out.println("You may use this program to write an email to your professor when your assignment is late.");
		System.out.println("---------------------------------------------");
		System.out.println();	
		
		//Prompt the user to enter the needed information.
		//Each variable in this part is created to store the information that the user entered, 
		//and substitute the words in the text later.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("(Hint: Please enter your answer with one single word.)");		
		System.out.print("What is your teacher's first or last name? ");
		String instructorName = keyboard.next();
		System.out.print("What is your name? ");
		String yourName = keyboard.next();
		System.out.print("Enter a food: ");
		String food = keyboard.next();
		System.out.print("Enter the amount of fever (between 37.0 and 40.0): ");
		double degreesOfFever = keyboard.nextDouble();
		System.out.print("Enter an animal: ");
		String animal = keyboard.next();
		System.out.print("Enter an adjective that will describe your pet: ");
		String discriptionOfYourAnimal = keyboard.next();
		System.out.print("Enter an colour: ");
		String colour = keyboard.next();
		System.out.println("\nHere is a sample email for you:\n");
		
		//Display the email (output)
		System.out.println("Dear professor " + instructorName +",\n\n" + 
				"I am sorry that I am unable to turn in my computer assignment at this time. \n" + 
				"First, I ate a rotten " + food +
				", which made me turn " + colour + " and extremely ill. " + 
				"I came down with a fever of " + degreesOfFever + ". \n" + 
				"Next my " + discriptionOfYourAnimal + " pet " + animal + 
				" must have smelled the remains of the " + food + " on my USB key \n" + 
				"(which is where my program was stored) because he ate it. \n" + 
				"I am currently rewriting my programs and hope you will accept my assignment late.\n\n" + 
				"Sincerely,\n" + yourName);
		
		//Ending message
		System.out.println("\n---------------------------------------------");
		System.out.println("Thank you for using this program!");
		System.out.println("---------------------------------------------");
		keyboard.close();
	}

}
