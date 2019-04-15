import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class C3P14_ConsecutiveVowels {

	public static void main(String[] args) {
		Scanner fileIn = null; 
		String word, longestWord=null;
		try
		{
			fileIn = new Scanner(new FileInputStream("G:\\workspace\\Exercise\\src\\ng.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
			System.exit(0);
		}
		int counter=0, length = 0;
		while (fileIn.hasNextLine())
		{
			word = fileIn.next();
			if (word.charAt(word.length()-1)==',')
				word = word.substring(0, word.length()-1);
			for (int i=0; i<word.length(); i++)
			{
				while (word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u')
				{
					counter++;
					if (i!=word.length()-1)
						i++;
					else
						break;
				}
				if (counter>length)
				{
					length = counter;
					longestWord = word;
				}
				counter = 0;
			}
		}
		System.out.println("The word that has the most consecutive vowels is: " + longestWord);
				
		fileIn.close();
	}

}
