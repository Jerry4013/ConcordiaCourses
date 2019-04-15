import java.util.Scanner;
public class A3Q3_PrimeNumber {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int i = 0 ,value = 0, n;
		String string = "";
		System.out.println("Enter the value of n:");
		n = scanner.nextInt();
		for (i = 1; i <= n; i++)
		{
			int counter=0;
			for(value = 1; value <= i; value++)
				if(i%value==0)
					counter = counter + 1;
			if (counter == 2)
				string = string + i + " ";
		}
		System.out.println("Output is :");
		System.out.println(string);
		scanner.close();
		
	}

}
