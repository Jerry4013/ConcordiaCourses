import java.util.Scanner;
import java.text.NumberFormat;


public class T4Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
		
		System.out.println("Please enter the cost of your purchase: ");
		double cost = kb.nextDouble();
		double total = 0;
		
		double shippingCost = 0;
		if (cost<=20)
			shippingCost = 5.99;
		else if (cost<=65)
			shippingCost = 10.99;
		else
			shippingCost = 15.99;
		total = cost + shippingCost;
				
		System.out.println("\nYour purchase is " + moneyFormatter.format(cost));
		System.out.println("And your shipping cost is: " + moneyFormatter.format(shippingCost)); 
		System.out.println("\nYour total cost is : " + moneyFormatter.format(total));
		
		
		kb.close();
	}

}
