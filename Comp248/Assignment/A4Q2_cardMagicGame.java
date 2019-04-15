// -------------------------------------------------------
// Assignment 4 Question 2
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Nov 5, 2017
// Purpose: Implementing a card magic game which accurately predicts a user’s card from a randomly generated 4x4 card matrix.
// --------------------------------------------------------

import java.util.Random;
import java.util.Scanner;

public class A4Q2_cardMagicGame {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		String[] cardNumbers = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] cardTypes = {"Diamonds", "Hearts", "Clubs", "Spades"};
		String answer;
		
		//Welcome banner.
		System.out.println("\n------------------------------------------");
		System.out.println("  Welcome to Jingchao's Card Magic 101");
		System.out.println("------------------------------------------");
		
		do
		{
			//We need to generate a random card matrix, so I write a method named randomizeArray, which contains two parameters
			//to get an array containing 4 elements in a random order from an existing array.
			String[] randomNumbers = randomizeArray(cardNumbers,4);
			String[] randomTypes = randomizeArray(cardTypes, 4);
			String[][] cards = new String[4][4];
			//Assign the values from the two random array into the card matrix.
			//Display the card matrix
			for (int i=0; i<4; i++)
			{
				for (int j=0; j<4; j++)
				{
					cards[i][j] = randomNumbers[j] + " of " + randomTypes[i];
					System.out.printf("%-22s",cards[i][j]);
				}
				System.out.println();
			}
		
			System.out.println("Please pick a card and enter the column number (1-4) where it appears");
			int column = keyIn.nextInt();
			while(column<1||column>4)//Check validity
			{
				System.out.println("Please enter an integer value between 1 and 4");
				column = keyIn.nextInt();
			}
			//Display the transposed matrix
			for (int i=0; i<4; i++)
			{
				for (int j=0; j<4; j++)
					System.out.printf("%-22s",cards[j][i]);
				System.out.println();
			}
			
			System.out.println("Please indicate which column number (1-4) it is in now");
			int column2 = keyIn.nextInt();
			while(column2<1||column2>4)//Check validity
			{
				System.out.println("Please enter an integer value between 1 and 4");
				column2 = keyIn.nextInt();
			}
			//The index of the matrix is one less than the real column number or row number
			System.out.println("Your card is " + cards[column2-1][column-1]);
			System.out.println("Do you want to try one more time? y or n");
			answer = keyIn.next();
		}while(answer.equalsIgnoreCase("y"));
		System.out.println("Thank you for using the JAVA Magic 101 Program");
		keyIn.close();
	}
	
	//The first parameter is the source array, we select elements from it.
	//The second parameter refers to how many element do we want in the new array.
	public static String[] randomizeArray(String[] anArray, int number)
	{
		boolean hasBeenSelected;
		Random randomGenerator = new Random();
		String[] newArray = new String[number];
		for (int i=0; i<number; i++)//use i to control the index of the new array.
		{
			do
			{
				hasBeenSelected = false;
				newArray[i] = anArray[randomGenerator.nextInt(anArray.length)];
				//Check whether it is equal to the numbers we have already selected.
				for (int j=0; j<i; j++)
					if(newArray[i] == newArray[j])
						hasBeenSelected = true;
			}while(hasBeenSelected);
		}
		return newArray;
	}

}
