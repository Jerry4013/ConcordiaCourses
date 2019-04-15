
public class C3P5_loan {

	public static final double RATE = 0.015;
	public static final double MONTHLY_PAYMENT = 50;
	public static void main(String[] args) {
		
		double cost = 1000;
		double interest, remainingDebt = cost;
		int months = 0;
		
		while (remainingDebt > 0)
		{
			interest = remainingDebt * RATE;
			remainingDebt = (remainingDebt - (MONTHLY_PAYMENT - interest))>0?(remainingDebt - (MONTHLY_PAYMENT - interest)):0;
			months = months + 1;
			System.out.printf("Your interest this month is: $%.2f%n", interest);
			System.out.printf("Your remaining debt is: $%.2f%n%n", remainingDebt);
		}
		System.out.println("You need " + months + " months to pay off the loan.");
	}

}
