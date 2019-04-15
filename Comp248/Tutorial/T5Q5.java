import java.util.Scanner;
public class T5Q5 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a line of text: ");
		String text = kb.nextLine();
		text = text.replace('a','*');
		text = text.replace('e','*');
		text = text.replace('i','*');
		
//		int length = text.length();
//		int i=0;
//		for (i=0; i<length; i++)
//		{
//			char letter=text.charAt(i);
//			if (letter == 'a'||letter == 'e'||letter == 'i')
//				text = text.substring(0,i) + "*" + text.substring(i+1); 
//		}
		
		System.out.println(text);
		kb.close();
		
	}

}
