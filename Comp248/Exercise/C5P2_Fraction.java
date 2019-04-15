
public class C5P2_Fraction {
	private int numerator;
	private int denominator;
	
	public C5P2_Fraction(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public void display()
	{
		System.out.println(numerator + "/" + denominator);
	}
	
	public boolean equals(C5P2_Fraction anotherFraction)
	{
		return numerator/(double)denominator == 
				anotherFraction.numerator/(double)anotherFraction.denominator;
	}
}
