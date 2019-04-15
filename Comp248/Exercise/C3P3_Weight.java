import java.util.Scanner;
public class C3P3_Weight {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String choice = null, choice2 = null;
		double mass, weight;
		
		do
		{
			System.out.print("Please enter the mass of the car in kilograms: ");
			mass = kb.nextDouble();
			System.out.print("Do you want to calculate the car's weight on Earth or on the Moon? Type in E/M: ");
			choice = kb.next();
			if (choice.equalsIgnoreCase("E"))
			{
				weight = mass * 9.81;
				System.out.printf("%nThe car's weight on Earth is: %.2f N.%n%n", weight);
			}
			else if (choice.equalsIgnoreCase("M"))
			{
				weight = mass * 9.81 / 6;
				System.out.printf("%nThe car's weight on the Moon is: %.2f N.%n%n", weight);
			}
			else 
				System.out.println("Please enter E/M");
			System.out.print("Would you like to try again? Enter Y/YES to continue, others to exit: ");
			choice2 = kb.next();
		}while (choice2.equalsIgnoreCase("Y")||choice2.equalsIgnoreCase("YES"));
		
		System.out.println("\nThank you for using Jingchao's Weight Calculator!");
				
		kb.close();
				
	}

}
