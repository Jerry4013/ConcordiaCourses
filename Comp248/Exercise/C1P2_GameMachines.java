//Author: Jingchao Zhang
//Date: Oct 1, 2017

import java.util.Scanner;
public class C1P2_GameMachines {
	public static void main(String[] args){
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the number of your coupons:");
		int coupons = keyboard.nextInt();
		int candy = coupons / 10;
		coupons = coupons % 10;
		int gumballs = coupons / 3;
		
		System.out.println("You can redeem " + candy + " candy bars and " + gumballs + " gumballs in total.");
		
		keyboard.close();
		
	}
}
