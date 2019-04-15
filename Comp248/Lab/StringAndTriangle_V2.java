import java.util.Scanner;
public class StringAndTriangle_V2 {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String word = keyIn.next();
		System.out.println();
		
		for(int i=1; i<=word.length(); i++)
		{
			for (int j=i-1; j>=0; j--)
				System.out.print(word.charAt(j)+"\t");
			System.out.println();
		}	
		
		for(int i=1; i<=word.length()-1; i++)
		{
			for (int j=1; j<=word.length()-i; j++)
				System.out.print(word.charAt(word.length()-j-i)+"\t");
			System.out.println();
		}	
		keyIn.close();
	}

}
