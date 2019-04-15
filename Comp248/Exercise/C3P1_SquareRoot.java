import java.util.Scanner;
public class C3P1_SquareRoot {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter an arbitrary positive number: ");
		double number = kb.nextDouble();
		double guess, lastGuess, r; 
		guess = number/2.0;
		do
		{
			r = number / guess;
			lastGuess = guess;
			guess = ( guess + r )/2;
			System.out.println(guess);
		}
		while(Math.abs(guess-lastGuess)>=(lastGuess*0.000001));
		
		System.out.printf("The result is: %.2f", guess);
		kb.close();
	}

}
