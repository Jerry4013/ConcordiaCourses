import java.util.Scanner;
public class Lab4_StringValidation {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int length;
		String word;
				
		System.out.print("Enter a string: ");
		
		do{
			word = kb.next();
			length = word.length();
			if(word.indexOf("e")==-1||!word.substring(length-2, length).equals("99")||length<5)
				System.out.print("Invalid string, try again: ");
		}while(word.indexOf("e")==-1||!word.substring(length-2, length).equals("99")||length<5);
		
		System.out.println();
		System.out.println("Output:");
		for (int i=length-1; i>=0; i--)
			System.out.println(word.charAt(i));
		
		kb.close();
	}

}
