package textbook.chapter10.SelfTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Joe {

	public static void main(String[] args)  {
		BufferedReader fileIn = null;
		String a = null;
		try
		{
			fileIn = new BufferedReader(new FileReader("joe"));
			a = fileIn.readLine();
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		System.out.println(a);
		
	}

}
