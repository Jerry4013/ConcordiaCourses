package tutorial.tutorial8;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Q3 {

	public static void main(String[] args) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		try{
			int counter =0;
			ObjectInputStream binIn = new ObjectInputStream(new FileInputStream("IOfiles/tutorial/tut8/question11.dat"));
			try{
				
				while(true){
					int n = binIn.readInt();
					counter++;
					if(n>max)
						max = n;
					if(n<min)
						min = n;
				}
			}catch(EOFException e){
			}
			binIn.close();
			if(counter==0)
				System.out.println("No element in this file.");
			else{
				System.out.println("Max: " + max);
				System.out.println("Min: " + min);
			}
		}catch(FileNotFoundException e){
			System.out.println("Cannot find file.");
		}catch(IOException e){
			System.out.println(e.getMessage());
			System.out.println("Problem with file reading.");
		}
	}

}
