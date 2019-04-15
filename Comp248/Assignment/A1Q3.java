import java.util.Scanner;
public class A1Q3 {

	// WHAT DOES THIS PROGRAM DO?
	// ---------------------------
	// This program prompts the user for 2 words, displays information regarding length of each word entered
	// as well as the starting and ending characters of each words. It then creates 2 new words by swapping the 1st characters
	// of the two words and the last characters of the two words and displays the new words.
	
	public static void main(String[] args) {
		// -----------------------------------------------------
		// Assignment 1
		// One Possible Solution to Question 3
		// File name: A1Q3.java
		// Written by: Nancy Acemian
		// For Comp 248/ Fall 2017
		// -----------------------------------------------------

		// Variable  Declarations
		// ----------------------
		Scanner keyIn = new Scanner(System.in);			// Keyboard input variable
		String word1, word2;							// Words as entered by user
		String newWord1, newWord2;						// New words created with original words entered by user.

		// Welcome message
		// ---------------
		System.out.println( "------------------------------\n" +
							"     Nancy's Text Analyzer\n" +
							"------------------------------\n");

		// Prompt user for 2 words
		//-------------------------
		System.out.println("Enter 2 words on one line seperated by at least one space (no white space allowed IN each word): ");
		word1 = keyIn.next();
		word2 = keyIn.next();

		// Analyze the two words entered by user
		//--------------------------------------
		System.out.println("\nFirst word you entered is <" + word1
				+ "> which is " + word1.length() + " characters long.\nIt starts with the character '"
				+ word1.substring(0, 1) + "' and ends with the character '" + word1.substring(word1.length() - 1, word1.length())
				+ "'\n");

		System.out.println("Second word you entered is <" + word2
				+ "> which is " + word2.length() + " characters long.\nIt starts with the character '"
				+ word2.substring(0, 1) + "' and ends with the character '" + word2.substring(word2.length() - 1, word2.length())
				+ "'\n" );

		// Create 2 new words such that the first word starts and ends with the 1st and last characters of the second word
		// and the second word starts and ends with the 1st and last character of the first word. Display the new words.
		// -------------------------------------------------------------------------------------------------------------
		newWord1 = word2.substring(0, 1) + word1.substring(1, word1.length() - 1) + word2.substring(word2.length() - 1, word2.length());
		newWord2 = word1.substring(0, 1) + word2.substring(1, word2.length() - 1) + word1.substring(word1.length() - 1, word1.length());
		System.out.println("New words: " + newWord1 + ' ' + newWord2);

		// Closing message
		//-----------------
		System.out.println("\nThank you for using Nancy's Text Analyzer!\n\n");
		keyIn.close();
	}
}


