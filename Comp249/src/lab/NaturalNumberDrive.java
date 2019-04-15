package lab;

import java.util.Scanner;

public class NaturalNumberDrive {

	public static void main(String[] args) {
		NaturalNumber[] nn = new NaturalNumber[10];
		Scanner keyIn = new Scanner(System.in);
		int number = 0;
		System.out.println("Please input 10 numbers.");
		for (int i = 0; i < nn.length; i++) {
			number = keyIn.nextInt();
			try{
				nn[i] = new NaturalNumber(number);
				
			} catch (ErrConstrException e) {
				System.out.println(e.getMessage());
			} 
		}
		try{
			System.out.println("Please input a number add to this 10 numbers.");
			number = keyIn.nextInt();
			NaturalNumber x = new NaturalNumber(number);
			for(int i=0; i< nn.length; i++){
				nn[i].minus(x);
			}
		}catch (ErrConstrException e) {
			System.out.println(e.getMessage());
		}catch (ErrModifException e) {
			System.out.println(e.getMessage());
		}
		keyIn.close();
	} 
}


