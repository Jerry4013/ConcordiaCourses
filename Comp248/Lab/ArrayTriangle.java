import java.util.Scanner;
public class ArrayTriangle {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		int[] array = new int[5];
		int number;
		
		System.out.println("Input below:");
		for(int i=0; i<5; i++)
		{
			do
			{
				number = keyIn.nextInt();
			}while(number>0 && (number%4==0));
			array[i] = number*(-2);
		}
		System.out.println();
		for(int i=0; i<5; i++)
		{
			for (int j=0; j<i; j++)
				System.out.print("\t");
			for (int j=i; j<5; j++)
				System.out.print(array[j] + "\t");
			System.out.println();
		}
		keyIn.close();
	}
}
