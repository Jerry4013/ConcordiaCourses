import java.util.Scanner;
public class C2P7_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter price of item:");
		System.out.println("(from 25 cents to a dollar, in 5-cent increments):");
		int cost = keyboard.nextInt();
		int change = 100 - cost;
		int quarters = change / 25;
		int dimes = change % 25 /10;
		int nickles = change % 25 % 10 / 5;
		
		
		System.out.println("\nYou bought an item for " + cost + " cents and gave me a dollar,");
		System.out.println("So your change is ");
		System.out.println(quarters + " quarters,");
		System.out.println(dimes + " dimes, and");
		System.out.println(nickles + " nickles.");
		
		keyboard.close();
	}

}
