package tutorial.tutorial8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		System.out.println("Enter integers, enter\"e\" to end.");
		String number = keyIn.next();
		try{
			ObjectOutputStream binOut = new ObjectOutputStream(new FileOutputStream("IOfiles/tutorial/tut8/question11.dat"));
			while(!number.equals("e")){
				try{
					int n = Integer.parseInt(number);
					binOut.writeInt(n);
					number = keyIn.next();
				}catch(NumberFormatException e){
					System.out.println("Please enter an integer.");
					number = keyIn.next();
				}
			}
			binOut.close();
		}catch(FileNotFoundException e){
			System.out.println("Cannot find file.");
		}catch(IOException e){
			System.out.println("Problem with file output.");
		}
		System.out.println("Done!");
		keyIn.close();
	}
}
