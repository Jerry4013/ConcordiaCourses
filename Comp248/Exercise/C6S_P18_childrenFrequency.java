import java.util.Scanner;
public class C6S_P18_childrenFrequency {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int age;
		int[] count = new int[11];
		System.out.println("Enter the age of the 10 children (from 0 to 10): ");
		
		for (int i = 0; i < 10; i++)
		{
			age = kb.nextInt();
			count[age]++;
		}
		for (int i = 0; i<11; i++)
			System.out.println(count[i]+ " students are " + i + " years old");

		kb.close();
	}

}
