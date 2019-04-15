import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Textbook2_3 {

	public static void main(String[] args) {
		
		Scanner fileIn = null;
		try
		{
			fileIn = new Scanner(new FileInputStream("G:\\workspace\\exercise\\src\\player.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
			System.exit(0);
		}
		int highscore;
		String name;
		System.out.println("Text left to read? " + fileIn.hasNextLine());
		highscore = fileIn.nextInt();
		fileIn.nextLine();
		name = fileIn.nextLine();
		
		System.out.println("Name: " + name);
		System.out.println("High score: " + highscore);
		System.out.println("Text left to read? " + fileIn.hasNextLine());
		
		
		fileIn.close();
	}

}
