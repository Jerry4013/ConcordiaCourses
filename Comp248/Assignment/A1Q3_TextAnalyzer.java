
// -------------------------------------------------------
// Assignment 1  Question 3
// Written by: Jingchao Zhang   40049474
// For COMP 248 Section R – Fall 2017
// Date: Sep 25, 2017
// The purpose of this program is to analyze the two words that the user input
// and to create two new words by interchanging the first characters of the two words 
// and the last characters of them, respectively.
// --------------------------------------------------------

import java.util.Scanner;
public class A1Q3_TextAnalyzer {

	public static void main(String[] args) {
		
		//Welcome Banner
		System.out.println("---------------------------------------------");
		System.out.println("   Welcome to Jingchao\'s Text Analyzer");
		System.out.println("---------------------------------------------\n");
		
		//Prompt the user to enter two words and store them in the variables word1, word2
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter 2 words on one line seperated by at least one space " + 
		"(no white space allowed IN each word):");
		String word1 = keyboard.next();
		String word2 = keyboard.next();
		System.out.println();
		
		//Compute the length of these two words, their first and last characters and their middle parts(excluding their first and last characters).
		int lengthOfWord1 = word1.length();
		int lengthOfWord2 = word2.length();
		char firstCharacterOfWord1 = word1.charAt(0);
		char firstCharacterOfWord2 = word2.charAt(0);
		char lastCharacterOfWord1 = word1.charAt(lengthOfWord1-1);
		char lastCharacterOfWord2 = word2.charAt(lengthOfWord2-1);
		String middleWord1 = word1.substring(1, lengthOfWord1-1);
		String middleWord2 = word2.substring(1, lengthOfWord2-1);
		
		//display the result of the text analyzing
		System.out.println("First word you entered is <" + word1 + "> which is " +
				 lengthOfWord1 + " characters long.");
		System.out.println("It starts with the character \'" + firstCharacterOfWord1 + 
				"\' and ends with the character \'" + lastCharacterOfWord1 + "\'\n");
		
		System.out.println("Second word you entered is <" + word2 + "> which is " +
				 lengthOfWord2 + " characters long.");
		System.out.println("It starts with the character \'" + firstCharacterOfWord2 + 
				"\' and ends with the character \'" + lastCharacterOfWord2 + "\'\n");
		
		System.out.println("New words: " + firstCharacterOfWord2 + middleWord1 + lastCharacterOfWord2 + 
				" " + firstCharacterOfWord1 + middleWord2 + lastCharacterOfWord1 + "\n");
		
		//ending message
		System.out.println("Thank you for using Jingchao\'s Text Analyzer!");
		
		keyboard.close();
	}

}
