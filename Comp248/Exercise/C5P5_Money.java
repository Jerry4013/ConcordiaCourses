
public class C5P5_Money {
	private int dollars;
	private int cents;
	
	public C5P5_Money(int dollars, int cents)
	{
		if(dollars<0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		this.dollars = dollars;
		
		if(cents<0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		this.cents = cents;
	}
	
	public C5P5_Money(int dollars)
	{
		if(dollars<0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		this.dollars = dollars;
		this.cents = 0;
	}
	
	public C5P5_Money()
	{	}
	
	public C5P5_Money(C5P5_Money anotherMoney)
	{
		if (anotherMoney==null)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		
		if(anotherMoney.dollars<0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		dollars = anotherMoney.dollars;
		
		if(anotherMoney.cents<0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		cents = anotherMoney.cents;
	}
	
	public static C5P5_Money add(C5P5_Money Money1, C5P5_Money Money2)
	{
		C5P5_Money newMoney = new C5P5_Money(Money1.dollars + Money2.dollars, Money1.cents + Money2.cents);
		return newMoney;
	}
	
	public static C5P5_Money minus(C5P5_Money Money1, C5P5_Money Money2)
	{
		int centsDifference = 0, dollarsDifference = 0;
		C5P5_Money difference = null;
		if(Money1.dollars>=Money2.dollars && Money1.cents>=Money2.cents)
		{
			centsDifference = Money1.cents - Money2.cents;
			dollarsDifference = Money1.dollars - Money2.dollars;
			difference = new C5P5_Money(dollarsDifference, centsDifference);
		}
		else if (Money1.dollars>Money2.dollars && Money1.cents<Money2.cents)
		{
			centsDifference = Money1.cents + 100 - Money2.cents;
			dollarsDifference = Money1.dollars - 1 - Money2.dollars;
			difference = new C5P5_Money(dollarsDifference, centsDifference);
		}
		return difference;
	}
	
	public C5P5_Money add(C5P5_Money Money)
	{
		C5P5_Money newMoney = new C5P5_Money(dollars + Money.dollars, cents + Money.cents);
		return newMoney;
	}
	
	
	public String toString()
	{
		return "$" + dollars + "." + cents;
	}
}
