//Author: Jingchao Zhang
//date: Oct 2, 2017

import java.util.Scanner;

public class C2P1_SquareRoot {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a number:");
		double number = keyboard.nextInt();
		double guess = number / 2;
		double r = number / guess;
		
		int i = 0;
		while (i<10)
		{
			r = number / guess;
			guess = (guess + r) / 2;
			System.out.println(guess);
			i++;
		}
//		while (Math.abs(guess - Math.sqrt(number)) > 0.0000000000000001)
//		{
//			r = number / guess;
//			guess = (guess + r) / 2;
//			System.out.println(guess);
//		}
		System.out.println("\nThe square root of " + number + " is: " + Math.sqrt(number) + " calculated by computer");
		System.out.println("The result we got is: " + guess);
		keyboard.close();

	}

}
