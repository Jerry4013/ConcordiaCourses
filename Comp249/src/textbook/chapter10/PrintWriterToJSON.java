package textbook.chapter10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriterToJSON {

	public static void main(String[] args) {
		PrintWriter fileOut = null;
			try{
				fileOut = new PrintWriter(new FileOutputStream("sdf54.json"));
				fileOut.println("sdfawetfgasd");
				fileOut.close();
			}catch(FileNotFoundException e){
				System.out.println(e.getMessage());
			}
	}

}
