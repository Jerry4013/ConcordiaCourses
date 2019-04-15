// -------------------------------------------------------
// Assignment 3 Question 2
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Oct 21, 2017
// Purpose: To compute the total price of some items including taxes (Tax1 & Tax2).
// --------------------------------------------------------
import java.util.Scanner;
import java.text.DecimalFormat;
public class A3Q2_Cashier {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		DecimalFormat decimal = new DecimalFormat("0.00");
		int numberOfItems, errorCounter=0;
		double price=0, subtotal=0, taxRate1, taxRate2, tax1, tax2, total=0;
		final int min_numberOfItems = 1;
		final int max_numberOfItems = 10;
		final double min_price = 1;
		final double max_price = 1000;
		final double min_taxRate = 0;
		final double max_taxRate = 100;
		
		//Welcome banner.
		System.out.println("-$-$-$----------------------------------------------$-$-$-");
		System.out.println("    Welcome to Jingchao's Cashier Calculator Program!");
		System.out.println("-$-$-$----------------------------------------------$-$-$-\n");
		
		do//number of items.
		{
			System.out.print("Please enter the number of items bought [1...10]: ");
			numberOfItems = keyIn.nextInt();
			if (numberOfItems<min_numberOfItems||numberOfItems>max_numberOfItems)
				errorCounter++;
		}while(numberOfItems<min_numberOfItems||numberOfItems>max_numberOfItems);//Check limits
		System.out.println();
		
		//input the price of each item.
		for (int i=1; i<=numberOfItems; i++)//Using i to control which item
		{
			do
			{
				System.out.print("Please enter the price of items " + i + " [1...1000]: ");
				price = keyIn.nextDouble();
				if (price<min_price||price>max_price)
					errorCounter++;
				else
					subtotal+=price;
			}while(price<min_price||price>max_price);
			System.out.println();
		}
		
		//Tax1 rate input
		do 
		{
			System.out.print("Please enter the tax rate of Tax1 [0...100]: ");
			taxRate1 = keyIn.nextDouble();
			if (taxRate1<min_taxRate||taxRate1>max_taxRate)//error counting
				errorCounter++;
		}while(taxRate1<min_taxRate||taxRate1>max_taxRate);//error check
		System.out.println();
		
		//Tax2 rate input
		do 
		{
			System.out.print("Please enter the tax rate of Tax2 [0...100]: ");
			taxRate2 = keyIn.nextDouble();
			if (taxRate2<min_taxRate||taxRate2>max_taxRate)//error counting
				errorCounter++;
		}while(taxRate2<min_taxRate||taxRate2>max_taxRate);//error check
		System.out.println();
		
		//Compute the results
		tax1 = subtotal * (taxRate1/100);
		tax2 = (subtotal + tax1) * (taxRate2/100);
		total = subtotal + tax1 + tax2;
		
		System.out.println("Here are your results\n---------------------");
		if (errorCounter!=0)
			System.out.println("You have entered " + errorCounter + " invalid inputs.");
		System.out.println("Subtotal: $ " + decimal.format(subtotal));
		System.out.println("Tax 1: $ " + decimal.format(tax1));
		System.out.println("Tax 2: $ " + decimal.format(tax2));
		System.out.println("TOTAL: $ " + decimal.format(total));
		System.out.println("\nHope you shopping trip was an enjoyable one!");		
		
		keyIn.close();
	}

}
