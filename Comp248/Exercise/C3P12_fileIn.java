import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class C3P12_fileIn {

	public static void main(String[] args) {
		Scanner fileIn = null;
		int feet, inch, idealWeight;
		try 
		{
			fileIn = new Scanner(new FileInputStream("G:\\workspace\\Exercise\\src\\weight.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
			System.exit(0);
		}
		
		while (fileIn.hasNextLine())
		{
			
			System.out.println(fileIn.nextLine());
			feet = fileIn.nextInt();
			inch = fileIn.nextInt();
			System.out.println("Height: " + feet + " feets and " + inch + " inches.");
			idealWeight = feet<5 ? 110 : (110 + ((feet-5) * 12 + inch) * 5); 
			System.out.println("Ideal weight is: " + idealWeight);
			System.out.println();
			if (fileIn.hasNextLine())
				fileIn.nextLine();
		}
		fileIn.close();
	}

}
