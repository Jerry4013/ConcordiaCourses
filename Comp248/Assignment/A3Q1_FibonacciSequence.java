// -------------------------------------------------------
// Assignment 3 Question 1
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Oct 21, 2017
// Purpose: Output a Fibonacci Sequence, containing as many terms as the user want.
// --------------------------------------------------------
import java.util.Scanner;
public class A3Q1_FibonacciSequence {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		String answer;
		int count=0;
		
		//Welcome banner.
		System.out.println("\n--------------------------------------------------------");
		System.out.println("    Welcome to Jingchao's sequences program!");
		System.out.println("--------------------------------------------------------");
		
		do
		{
			int i=1, j=1, k=1; 
			//i stands for the sequence number of the changing terms in the for loop later. 
			//While j and k are the values of last term and the term before last term, respectively.
			
			System.out.println("\nPlease enter the number of sequences");
			int n = keyIn.nextInt();
			int output = 0;
			if(n<0)//In case the user entered a negative number.
				n=1;
			//This loop is used for controlling the number of terms. 
			for (i=1; i<=n; i++)
			{
				//The first two terms are always 1 and 1. So we use a if-else statement to control it.
				if(i==1)
					System.out.print("\nThe results is: \n" + j);
				else if (i==2)
					System.out.print("," + k);
				else
				{
					output =  j + k;//The current term is the sum of the last two terms.
					System.out.print("," + output);
					k = j;
					j = output;//update the terms
				}
			}
			System.out.println("\n\nDo you want to repeat? (Yes/No)");
			answer = keyIn.next();
			count++;
		}while(answer.equalsIgnoreCase("Yes"));
		System.out.println("\nYou have played " + count + " times.");
		System.out.println("Thank you for choosing our program, have a nice day! ");
			
		keyIn.close();
		
	}

}
