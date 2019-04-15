package textbook.chapter10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinaryFileDemo {

	public static void main(String[] args) {
		try{
			double v1 = 209.1;
			double v2 = 6584.1;
			ObjectOutputStream outputThisWay = new ObjectOutputStream(new FileOutputStream("someStuff.dat"));
			outputThisWay.writeDouble(v1);
			outputThisWay.writeDouble(v2);
			outputThisWay.writeUTF("Hello");
			outputThisWay.close();
		}catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
	}

}
