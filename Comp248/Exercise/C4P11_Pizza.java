import java.util.Scanner;
public class C4P11_Pizza {
	private String size;
	private int cheese;
	private int pepperoni;
	private int ham;
	
	public C4P11_Pizza()
	{
		size = "medium";
		cheese = 0;
		pepperoni = 0; 
		ham = 0;
	}
	public C4P11_Pizza(String size, int cheese, int pepperoni, int ham)
	{
		setPizza(size, cheese, pepperoni, ham);
	}
	
	public void setPizza(String size, int cheese, int pepperoni, int ham)
	{
		setSize(size);
		if (cheese>=0 && cheese<=10 && pepperoni>=0 && pepperoni<=10 && ham>=0 && ham<=10)
		{
			this.cheese = cheese;
			this.pepperoni = pepperoni;
			this.ham = ham;
		}	
		else
		{
			System.out.println("Invalid topping number!");
			System.exit(0);
		}
	}
	
	public void setPizzaByUser()
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Please input the size of pizza 1: ");
		String size = kb.next();
		System.out.println("Please input the number of cheese toppings of pizza 1: ");
		int cheese = kb.nextInt();
		System.out.println("Please input the number of pepperoni toppings of pizza 1: ");
		int pepperoni = kb.nextInt();
		System.out.println("Please input the number of ham toppings of pizza 1: ");
		int ham = kb.nextInt();
		setPizza(size, cheese, pepperoni, ham);
		kb.close();
	}
	
	public void setSize(String size)
	{
		if (size.equalsIgnoreCase("small"))
			this.size = "small"; 
		else if (size.equalsIgnoreCase("medium"))
			this.size = "medium";
		else if (size.equalsIgnoreCase("large"))
			this.size = "large";
		else
		{
			System.out.println("Invalid size");
			System.exit(0);
		}
	}
	
	public void setCheese(int cheese)
	{
		if (cheese>=0 && cheese<=10)
		{
			this.cheese = cheese;
		}	
		else
		{
			System.out.println("Invalid topping number!");
			System.exit(0);
		}
	}
	
	public void setPepperoni(int pepperoni)
	{
		if (pepperoni>=0 && pepperoni<=10)
		{
			this.pepperoni = pepperoni;
		}	
		else
		{
			System.out.println("Invalid topping number!");
			System.exit(0);
		}
	}
	
	public void setHam(int ham)
	{
		if (ham>=0 && ham<=10)
		{
			this.ham = ham;
		}	
		else
		{
			System.out.println("Invalid topping number!");
			System.exit(0);
		}
	}
	
	public String getSize()
	{
		return size;
	}

	public int getCheese()
	{
		return cheese;
	}
	
	public int getPepperoni()
	{
		return pepperoni;
	}
	
	public int getHam()
	{
		return ham;
	}
	
	public double calcCost()
	{
		double cost = 0;
		int toppings = 0;
		toppings = cheese + pepperoni + ham;
		if (size.equalsIgnoreCase("small"))
			cost = 10.0 + 2.0 * toppings;
		else if (size.equalsIgnoreCase("medium"))
			cost = 12.0 + 2.0 * toppings;
		else if (size.equalsIgnoreCase("large"))
			cost = 14.0 + 2.0 * toppings;
		return cost;
	}
	
	public String getDescription()
	{
		return ("\nSize: " + size + "\nCheese toppings: " + cheese + "    Pepperoni toppings: " + pepperoni + "    Ham toppings: " + ham + 
				"\nCost: " + calcCost());
	}
	
	public String toString()
	{
		return ("\nSize: " + size + "\nCheese toppings: " + cheese + "    Pepperoni toppings: " + pepperoni + "    Ham toppings: " + ham + 
				"\nCost: " + calcCost());
	}
}
