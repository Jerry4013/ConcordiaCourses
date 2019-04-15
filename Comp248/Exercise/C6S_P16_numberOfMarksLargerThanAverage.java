import java.util.Scanner;
public class C6S_P16_numberOfMarksLargerThanAverage {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("How many students: ");
		int numberOfStudents = kb.nextInt();
		double[] marks = new double[numberOfStudents];
		double sum = 0, average = 0;
		int count = 0;
		
		System.out.println("Please enter the marks: ");
		for (int i=0; i<numberOfStudents; i++)
		{
			marks[i] = kb.nextDouble();
			sum = sum + marks[i];
		}
		
		average = sum / numberOfStudents;
		System.out.println("The average is: " + average);
		
		for (int i = 0; i<numberOfStudents; i++)
		{
			if (marks[i]>average)
				count++;
		}
		System.out.println("\n"+count + " students have a mark higher than the average.");
		
		
		kb.close();
	}

}
