import java.util.Scanner;
public class T6Q2_Shapes {

	public static void main(String[] args) {
		System.out.println("Please enter the line number(odd): ");
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		//shape 1
//		for (int i=1; i<=5; i++)
//		{
//			for (int j=1; j<=i; j++)
//				System.out.print("*");
//			System.out.println();
//		}
//		System.out.println();
//		
		//shape 2
//		for (int i=1; i<=3; i++)
//		{
//			for (int j=1; j<=3-i; j++)
//				System.out.print(" ");
//			for (int j=1; j<=2*i-1; j++)
//				System.out.print("*");
//			System.out.println();
//		}
//		for (int i=1; i<=2; i++)
//		{
//			for (int j=1; j<=i; j++)
//				System.out.print(" ");
//			for (int j=1; j<=5-2*i; j++)
//				System.out.print("*");
//			System.out.println();
//		}
		
		//shape 2 v2
		for (int i=1; i<=n; i++)
		{
			int numberOfStars = (-2)* (Math.abs(i-(n+1)/2)) + n;
			int numberOfSpace = (n - numberOfStars)/2;
			for (int j=1; j<=numberOfSpace; j++)
				System.out.print(" ");
			for (int j=1; j<=numberOfStars; j++)
				System.out.print("*");
			System.out.println();
		}
		kb.close();
	}

}
