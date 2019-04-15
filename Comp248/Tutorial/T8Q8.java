import java.util.Scanner;
public class T8Q8 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the size of the 2-D array: ");
		int size = kb.nextInt();
		int[][] myArray = new int[size][size];
		for(int i=0; i<size; i++)
		{
			System.out.println("Please enter the "+(i+1)+"th line: ");
			for (int j=0; j<size; j++)
				myArray[i][j] = kb.nextInt();
		}
		int sum = 0;
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				if(i==j)
					sum += myArray[i][j];
				else if (i+j+1==size)
					sum += myArray[i][j];
		System.out.println(sum);
		kb.close();
	}

}
