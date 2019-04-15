import java.util.Scanner;

public class T4Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please enter your weight:");
		double weight = kb.nextDouble();
		
		if (weight<116)
			System.out.println("Eat 5 banana splits!");
		else if (weight<=130)
			System.out.println("Eat a banana split!");
		else if (weight<=200)
			System.out.println("Perfect!");
		else
			System.out.println("Plenty of banana splits have been consumed!");
		
		kb.close();
		
	}

}
