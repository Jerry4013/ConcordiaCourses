package textbook.chapter10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadBinaryFileDemo {

	public static void main(String[] args) {
		double i = 0;
		String s = null;
		try{
			ObjectInputStream inputThing = new ObjectInputStream(new FileInputStream("someStuff.dat"));
			i = inputThing.readDouble();
			System.out.println(i);
			i = inputThing.readDouble();
			System.out.println(i);
			s = inputThing.readUTF();
			System.out.println(s);
			
			i = inputThing.readDouble();
			System.out.println(i);
			inputThing.close();
		}catch (IOException e)
		{
			System.out.println(e);
			System.exit(0);
		}
		
	}

}
