
public class C5P3_Container {
	private double maximum;
	private double quantity;
	
	public C5P3_Container(double maximum)
	{
		if(maximum<=0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		this.maximum = maximum;
		quantity = 0;
	}
	
	public void full()
	{
		quantity = maximum;
	}
	
	public void empty()
	{
		quantity = 0;
	}
	
	public void transfer(C5P3_Container anotherContainer)
	{
		if(anotherContainer.leftover()>=quantity)
		{
			anotherContainer.setQuantity(anotherContainer.getQuantity()+quantity);
			quantity = 0;
		}
		else
		{
			quantity = quantity - anotherContainer.leftover();
			anotherContainer.full();
		}
	}
	
	public double getQuantity()
	{
		return quantity;
	}
	
	public double getMaximum()
	{
		return maximum;
	}
	
	public void setQuantity(double newQuantity)
	{
		if(newQuantity>maximum || newQuantity<0)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		quantity = newQuantity;
	}
	
	public double leftover()
	{
		if(maximum<quantity)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		return maximum-quantity;
	}
	
	public void displayQuantity()
	{
		if(quantity<1 && quantity>0)
			System.out.println("The current quantity of liquid in this container is: " 
					+ quantity*1000 + " milliliters");
		else if (quantity>=1 && quantity<1000)
			System.out.println("The current quantity of liquid in this container is: " 
					+ quantity + " liters");
		else if (quantity==0)
			System.out.println("The container is empty.");
		else if (quantity>=1000)
			System.out.println("The current quantity of liquid in this container is: " 
					+ quantity/1000 + " kiloliters");
	}
	
}
