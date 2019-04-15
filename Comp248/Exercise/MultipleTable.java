import java.util.Scanner;
public class MultipleTable {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the largest number of this multiple table: ");
		int size = kb.nextInt();
		for (int i=1; i<=size; i++)
		{
			for (int j=1; j<=i; j++)
				System.out.print(j+ " * "+i+" = "+(i*j)+"\t");
			System.out.println();
		}
		
		kb.close();
	}

}
