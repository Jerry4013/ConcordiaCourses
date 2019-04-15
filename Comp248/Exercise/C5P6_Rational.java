
public class C5P6_Rational {
	private int numerator;
	private int denominator;
	
	public C5P6_Rational(int numerator, int denominator)
	{
		if(denominator==0)
		{
			System.out.println("Denominator cannot be zero!");
			System.exit(0);
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public C5P6_Rational(int wholeNumber)
	{
		numerator = wholeNumber;
		denominator = 1;
	}
	
	public C5P6_Rational()
	{
		numerator = 0;
		denominator = 1;
	}
	
	public static C5P6_Rational add(C5P6_Rational r1, C5P6_Rational r2)
	{
		int n = r1.numerator * r2.denominator + r2.numerator * r1.denominator;
		int d = r1.denominator * r2.denominator;
		C5P6_Rational addition = new C5P6_Rational (n, d);
		return addition;
	}
	
	public String toString()
	{
		return numerator + "/" + denominator;
	}
}
