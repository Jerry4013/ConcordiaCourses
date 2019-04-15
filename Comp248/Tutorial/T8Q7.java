import java.util.Scanner;
import java.util.Arrays;
public class T8Q7 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("How many numbers do you want to enter? ");
		int number = kb.nextInt();
		int[] myArray = new int[number];
		System.out.println("Please enter your array here: ");
		for (int i=0; i<number; i++)
			myArray[i] = kb.nextInt();
		
		reverse(myArray);
		System.out.println(Arrays.toString(myArray));
		kb.close();	
	}
	
	public static int[] reverse(int[] myArray)
	{
		for (int i=0; i<myArray.length/2; i++)
		{
			int temp = myArray[i];
			myArray[i] = myArray[myArray.length-i-1];
			myArray[myArray.length-i-1] = temp;
		}
		return myArray;
	}
}
