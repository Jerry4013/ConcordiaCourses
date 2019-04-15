import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class C3P13_palindrome {

	public static void main(String[] args) {
		Scanner fileIn = null;
		String word;
		try
		{
			fileIn = new Scanner(new FileInputStream("G:\\workspace\\Exercise\\src\\ng.txt"));
		}	
		catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
			System.exit(0);
		}
		String longestWord=null; 
		int length=0;
		while (fileIn.hasNextLine())
		{
			word = fileIn.next().trim();
			if(word.length()>1)
			{
				int left=0, right = word.length()-1;
				while (word.charAt(left)==word.charAt(right) && left<right)
				{
					left++;
					right--;
				}	
				if (left>=right)
				{
					if(word.length()>length)
					{
						length = word.length();
						longestWord = word;
					}
				}
			}
		}
		System.out.println("The longest word that is a palindrome is: " + longestWord);
		
		fileIn.close();
	}

}
