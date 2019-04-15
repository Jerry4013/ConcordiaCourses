package tutorial.tutorial8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCharacters {

	public static void main(String[] args) {
		try{
			BufferedReader bf = new BufferedReader(new FileReader("G:\\workspace\\Comp 249\\IOfiles\\tutorial\\tut8\\chars.txt"));
			int c = bf.read();
			while(c!=-1){
				System.out.print(c + " ");
				c = bf.read();
			}
			bf.close();
		}catch(FileNotFoundException e){
			System.out.println("No such file.");
		}catch(IOException e){
			System.out.println("Error reading from \"chars.txt\"");
		}
	}

}
