import java.util.Scanner;
public class C5P2_FractionDemo {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		C5P2_Fraction fraction1 = new C5P2_Fraction(1,3);
		fraction1.display();
		System.out.println("Enter the numerator: ");
		int numerator = keyIn.nextInt();
		System.out.println("Enter the denominator: ");
		int denominator = keyIn.nextInt();
		
		C5P2_Fraction targetFraction = new C5P2_Fraction(numerator, denominator);
		System.out.print(targetFraction.equals(fraction1));
		keyIn.close();
	}

}
