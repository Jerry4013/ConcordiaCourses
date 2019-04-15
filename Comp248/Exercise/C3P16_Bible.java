import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class C3P16_Bible {

	public static void main(String[] args) {
		Scanner fileIn = null;
		Scanner keyIn = new Scanner(System.in);
		String word = null;
		String letter;
		boolean valid = true;
		try
		{
			fileIn = new Scanner(new FileInputStream("G:\\workspace\\Exercise\\src\\Bible.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
			System.exit(0);
		}
		System.out.print("Please enter the vowel you want to check: ");
		do
		{
			valid = true;
			letter = keyIn.next();
			if (!letter.equals("a")&&!letter.equals("e")&&!letter.equals("i")&&!letter.equals("o")&&!letter.equals("u"))
			{
				valid = false;
				System.out.print("Invalid input! Please input a vowel: ");
			}
		}while(!valid);
		
		System.out.println();
		while (fileIn.hasNext())
		{
			word = fileIn.next();
			if (word.substring(0,1).equalsIgnoreCase(letter))
				System.out.println(word);
		}
		fileIn.close();
		keyIn.close();
	}

}
