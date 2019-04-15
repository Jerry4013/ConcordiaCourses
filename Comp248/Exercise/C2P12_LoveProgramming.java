import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class C2P12_LoveProgramming {

	public static void main(String[] args) {
		Scanner fileIn = null;
		try
		{
			fileIn = new Scanner(new FileInputStream("C:\\Users\\z_jingc\\Desktop\\program.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
			System.exit(0);
		}
		
		String sentence;
	
		sentence = fileIn.nextLine();
		int position = sentence.indexOf("hate");
		String newsentence = sentence.substring(0, position) + "love" +sentence.substring(position + 4);
		
		System.out.println("The original sentence is: \n\"" + sentence + "\"\n");
		System.out.println("The new sentence is: \n\"" + newsentence + "\"");
	
		
		fileIn.close();
		
		
	}

}
