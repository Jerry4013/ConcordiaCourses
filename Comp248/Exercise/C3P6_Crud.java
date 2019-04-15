import java.util.Scanner;
public class C3P6_Crud {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String repeat = null;
	
		do
		{
			int days = 0,i;
			double initial = 0, lastPopulation1 = 0, lastPopulation2 = 0, population = 0;
			System.out.print("Please enter the initial size of a green crud population (in pounds): ");
			initial = kb.nextDouble();
			System.out.print("Please enter the number of days: ");
			days = kb.nextInt();
			lastPopulation1 = initial;
			for(i=0; i<=days-5; i=i+5)
			{
				population = lastPopulation1 + lastPopulation2;
				lastPopulation2 = lastPopulation1;
				lastPopulation1 = population;
			}
			System.out.println("\nThe number of pounds of green crud after "+ days +" days is " + population + " pounds.");
			System.out.print("\nEnter C to continue, others to exit: ");
			repeat = kb.next();
		}
		while(repeat.equalsIgnoreCase("C"));
		
		kb.close();
	}

}
