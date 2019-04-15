package textbook.chapter10.SelfTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sally {

	public static void main(String[] args) {
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new FileInputStream("sally.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		String a = fileIn.next();
		System.out.println(a);

	}

}
