import java.util.Scanner;
public class C3P4_budget {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int year = 0, i = 0;
		double cost = 0, inflation = 0;
		
		System.out.print("Please enter the cost of the item: ");
		cost = kb.nextDouble();
		System.out.print("Please enter the number of years from now that the item will be purchased: ");
		year = kb.nextInt();
		System.out.print("Please enter the rate of inflation: ");
		inflation = kb.nextDouble();
		
		for (i=1; i<=year; i++)
			cost = cost * (1+inflation/100.0);
		System.out.printf("The price after %d years is $%.2f", year, cost);
		kb.close();
	}

}
