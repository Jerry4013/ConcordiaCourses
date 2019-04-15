
public class C4P12_PizzaOrder {
	private C4P11_Pizza pizza1;
	private C4P11_Pizza pizza2;
	private C4P11_Pizza pizza3;
	private int numPizzas;
	
	public C4P12_PizzaOrder()
	{
		pizza1 = new C4P11_Pizza();
		pizza2 = new C4P11_Pizza();
		pizza3 = new C4P11_Pizza();
		numPizzas = 0;
	}
	public C4P12_PizzaOrder(int numPizzas)
	{
		if(numPizzas == 1)
			pizza1 = new C4P11_Pizza();
		else if (numPizzas == 2)
		{
			pizza1 = new C4P11_Pizza();
			pizza2 = new C4P11_Pizza();
		}
		else if (numPizzas == 3)
		{
			pizza1 = new C4P11_Pizza();
			pizza2 = new C4P11_Pizza();
			pizza3 = new C4P11_Pizza();
		}
		else
		{
			System.out.print("Invalid number.");
			System.exit(0);
		}
	}
	
	public void setNumPizzas(int numPizzas)
	{
		if(numPizzas>=1 && numPizzas<=3)
			this.numPizzas = numPizzas;
		else 
		{
			System.out.println("Invalid number!");
			System.exit(0);
		}
	}
	
	public void setPizza1(C4P11_Pizza pizza1)
	{
		this.pizza1 = pizza1;
	}
	
	public void setPizza2(C4P11_Pizza pizza2)
	{
		this.pizza2 = pizza2;
	}
	
	public void setPizza3(C4P11_Pizza pizza3)
	{
		this.pizza3 = pizza3;
	}
	
	public double calcTotal()
	{
		double total = 0;
		if (numPizzas==1)
			total = pizza1.calcCost();
		else if (numPizzas==2)
			total = pizza1.calcCost() + pizza2.calcCost();
		else if (numPizzas==3)
			total = pizza1.calcCost() + pizza2.calcCost() + pizza3.calcCost();
		return total;
	}
	
	public String toString()
	{
		return ("You ordered " + numPizzas + "pizza" );
	}
	
	
	
}
