package textbook.ProjectsChapter7;

public class Fraction {

	private int numerator;
	private int denominator;

	public Fraction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

	/**
	 * @param numerator
	 * @param denominator
	 */
	public Fraction(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * @return the numerator of the fraction
	 */
	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public String toString() {
		return "Fraction [numerator=" + numerator + ", denominator=" + denominator + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result + numerator;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}

}
