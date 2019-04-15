
public class C3T_SelfTest3_1 {

	public static void main(String[] args) {
				
		//Q1
		int score = 106;
		if (score>100)
			System.out.println("High");
		else
			System.out.println("Low");
		
		//Q2
		double savings = 64.3;
		double expenses = 45.1;
		if (savings > expenses)
		{
			System.out.println("Solvent");
			savings = savings - expenses;
			expenses = 0;
		}
		else
			System.out.println("Bankrupt");
		
		//Q3
		int number = 0;
		if(number>0)
			System.out.println("Positive");
		else
			System.out.println("Not positive");
				
		//Q4
		double salary = 1564.8;
		double deductions = 515.1;
		double net;
		if(salary<deductions)
			System.out.println("Crazy");
		else
		{
			System.out.println("OK");
			net = salary - deductions;
			System.out.printf("Net: %.2f%n", net);
		}
		
		//Q5: large
		//Q6: small
		//Q7: medium
		//Q8
		int n = 24;
		if (n<0)
			System.out.println("n is negative.");
		else if (n<100)
			System.out.println("n is larger than or equal to 0 and less than 100.");
		else 
			System.out.println("n is larger than or equal to 100");
		
		int number2 = 1;
		switch(number2)
		{
			case 2:
				System.out.println("This is not number2.");
				break;
			case 1:
				System.out.println("This is number2.");
				break;
			default:
				System.out.println("guess again.");
				break;
		}
		
		//Q13
		int n1 = 124, n2 = 234;
		if(n1 >= n2)
			System.out.println("n1 is greater or equal to n2.");
		else
			System.out.println("n1 is less than n2.");
		
		//Q16
		String nextWord = "weruhi";
		if (nextWord.compareToIgnoreCase("N")<0)
			System.out.println("First half of the alphabet");
		else 
			System.out.println("Second half of the alphabet");
		
		
		
		
		
		
	}

}
