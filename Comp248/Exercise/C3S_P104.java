import java.util.Scanner;
public class C3S_P104 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the line number: ");
		int line = kb.nextInt();
		int i,j;
		
		for (i=1; i<=line; i++)
		{
			for (j=i; j<=line; j++)
				System.out.print(j+"\t");
			System.out.println();
		}
		kb.close();
	}

}
