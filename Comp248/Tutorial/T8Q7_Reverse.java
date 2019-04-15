import java.util.Arrays;
import java.util.Scanner;
public class T8Q7_Reverse {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("How many numbers are there in the array? ");
		int length = kb.nextInt();
		int[] myArray = new int[length];
		System.out.print("Please enter your array: ");
		for (int i=0; i<length; i++)
			myArray[i] = kb.nextInt();

		for (int i=0; i<length/2;i++)
		{
			int temp  = myArray[i];
			myArray[i] = myArray[length-1-i];
			myArray[length-1-i] = temp;
		}
		
		System.out.print("\nThe reversed array is: " + Arrays.toString(myArray));
		kb.close();
	}

}
