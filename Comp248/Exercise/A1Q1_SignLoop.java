import java.util.Scanner;
public class A1Q1_SignLoop {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the size of this sign: ");
		int size = kb.nextInt();
		int i = 0, j = 0;
		
		for (i=1; i<=size; i++)
		{
			for (j=1; j<=size-i; j++)
				System.out.print(" ");
			for (j=1; j<=i; j++)
				System.out.print("\\");
			for (j=1; j<=i; j++)
				System.out.print("/");
			System.out.println( );
		}		
		for (i=1; i<=size; i++)
		{
			for (j=1; j<=i-1; j++)
				System.out.print(" ");
			for (j=0; j<=size-i; j++)
				System.out.print("/");
			for (j=0; j<=size-i; j++)
				System.out.print("\\");
			System.out.println();
		}
		
		System.out.println("\nAll done!");
		kb.close();
		
	}

}
