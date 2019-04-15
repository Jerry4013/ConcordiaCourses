import java.util.Scanner;
public class C6T_P381_ArrayOfScores {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		double[] score = new double[5];
		int index = 0;
		double max = 0;
		
		System.out.println("Enter 5 scores: ");
		for (index=0; index<5; index++)
		{
			score[index] = kb.nextDouble();
			if (score[index]>max)
				max = score[index];
		}
		
		System.out.println("The highest score is "+ max);
		System.out.println("The scores are: ");
		for (index=0; index<5; index++)
			System.out.printf( "%.1f differs from max by %.1f\n", score[index] , (max-score[index]));
		
		
		kb.close();
	}

}
