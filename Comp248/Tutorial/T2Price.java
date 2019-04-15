/* Purpose: This program calculates the final price of a purchase including a 15% sales tax */
import java.util.Scanner;
public class T2Price
{
	public static final double TAX_RATE = 0.15;
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		int quantity;
		double subtotal, tax, totalCost, unitPrice;
		System.out.print ("Enter the quantity: ");
		quantity = keyboard.nextInt();
		System.out.print ("Enter the unit price: ");
		unitPrice = keyboard.nextDouble();
		subtotal = quantity * unitPrice;
		tax = subtotal * TAX_RATE;
		totalCost = subtotal + tax;
		// Print output */
		System.out.printf("Subtotal: %.2f%n", subtotal);
		System.out.printf("Tax: %.2f%n", tax);
		System.out.printf("Total: %.2f",totalCost);
		keyboard.close();
		
	}
}