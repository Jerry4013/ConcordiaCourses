import java.util.Scanner;
public class A1Q2 {
	/* WHAT DOES THIS PROGRAM DO?
	 * ---------------------------
	 * This program helps you write the text to an email explaining to your professor why their assignment is late.
	 */
	public static void main(String[] args) {
		// -----------------------------------------------------
		// Assignment 1
		// One Possible Solution to Question 2
		// File name: A1Q2.java
		// Written by: Nancy Acemian
		// For Comp 248/ Fall 2017
		// -----------------------------------------------------

		// Variable  Declarations
		// ----------------------
		Scanner keyIn = new Scanner(System.in);			// Keyboard input variable
		String profName, studentName, food;				// User input
		double fever;									// User input
		String anAdj, colour, animal;					// user input


		// Display Welcome Message
		//-------------------------
		System.out.println( "----------------------------------------\n"
				+ "   Welcome to Nancy's Mad Lib Program\n"
				+ "----------------------------------------\n");

		// Prompt the user for the data to incorporate in text
		// ---------------------------------------------------
		System.out.print("What is your teacher's first or last name? ");
		profName = keyIn.next();
		System.out.print("What is your name? ");
		studentName = keyIn.next();
		System.out.print("Enter a food: ");
		food = keyIn.next();
		System.out.print("Enter the amount of fever (between 37.0 and 40.0): ");
		fever = keyIn.nextDouble();
		System.out.print("Enter an animal: ");
		animal = keyIn.next();
		System.out.print("Enter an adjective that will describe your pet: ");
		anAdj = keyIn.next();
		System.out.print("Enter a colour: ");
		colour = keyIn.next();

		// Display the resulting email to your prof using a single System.out.println().
		// -----------------------------------------------------------------------------
		System.out.println("\n\nDear professor " + profName + ",\n\n"
				+"I am sorry that I am unable to turn in my computer assignment at this time. First,\n"
				+"I ate a rotten " + food + ", which made me turn " + colour + " and  extremely ill. "
				+"I came down\nwith a fever of " + fever + ". Next my " + anAdj + " pet " + animal
				+ " must have smelled\nthe remains of the " + food + " on my USB key (which is where my program was stored)\n"
				+"because he ate it.\nI am currently rewriting my programs and hope you will accept my assignment late.\n\n"
				+"Sincerely,\n" + studentName);
		
		keyIn.close();         // close the scanner object
	}

}
