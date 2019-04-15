import java.util.Scanner;
import java.text.DecimalFormat;
public class C2P11_ExerciseGrade {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int i = 1, j = 0, score = 0, possible = 0, totalScore = 0, totalPossible = 0;
		String[] item = new String[3];
		String exerciseName = null;
		DecimalFormat percent = new DecimalFormat("##0.00%");
		
		while (i<4)
		{
			System.out.println("Name of exercise " + i + ":");
			exerciseName = kb.nextLine();
			System.out.println("Score received for exercise " + i + ":");
			score = kb.nextInt();
			System.out.println("Total points possible for exercise " + i + ":");
			possible = kb.nextInt();
			
			totalScore = totalScore + score;
			totalPossible = totalPossible + possible;
			item[i-1] = String.format("%-20s%-10d%-10d", exerciseName, score, possible);
			kb.nextLine();
			System.out.println();
			i++;
		}
		
		System.out.printf("%-20s%-10s%-15s%n%n", "Exercise", "Score", "Total Possible");
		while (j<3)
		{
			System.out.println(item[j]);
			j++;
		}
		System.out.printf("%-20s%-10d%-15d%n%n", "Total", totalScore, totalPossible);
		System.out.println("Your total is " + totalScore + " out of " + totalPossible + ", or " 
		+ percent.format((double)totalScore/totalPossible) + ".");
	
		kb.close();

	}

}
