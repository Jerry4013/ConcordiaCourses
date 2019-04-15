package textbook.chapter10.SelfTest;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class Sam {

	public static void main(String[] args) {
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(new FileOutputStream("sam.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file sam.txt");
			System.exit(0);
		}
		outStream.println("Sam and");
		outStream.close();
	}

}
