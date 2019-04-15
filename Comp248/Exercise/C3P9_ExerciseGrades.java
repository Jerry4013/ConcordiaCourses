import java.util.Scanner;
import java.text.DecimalFormat;
public class C3P9_ExerciseGrades {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		DecimalFormat percent = new DecimalFormat("0.00%");
		System.out.print("How many exercises to input? ");
		int numberOfExercise = kb.nextInt();
		int score=0, totalPoints=0;
		for (int i = 1; i<=numberOfExercise; i++)
		{
			System.out.println("Score received for exercise " + i + ":");
			score+=kb.nextInt();
			System.out.println("Total points possible for exercise " + i +":");
			totalPoints+=kb.nextInt();
			System.out.println();
		}
		
		System.out.println("Your total is " + score + " out of " + totalPoints + ", or "+ 
				percent.format((double)score/totalPoints)+".");
		
		
		kb.close();
	}

}
