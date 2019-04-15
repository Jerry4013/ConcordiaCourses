package lab;

public class Item {
	protected String name;
	protected double price;
	
	/**
	 * Default constructor
	 */
	public Item(){}
	
	/**
	 * @param name
	 * @param price
	 */
	public Item(String name, double price) {
		if(price<0){
			System.out.println("Price cannot be negative. Aborting!");
			System.exit(0);
		}
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Copy constructor
	 * @param otherItem the Item object for copying
	 */
	public Item(Item otherItem) {
		if(otherItem.price<0){
			System.out.println("Price cannot be negative. Aborting!");
			System.exit(0);
		}
		name = otherItem.name;
		price = otherItem.price;
			
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean canBeReturned(){
		return true;
	}
	
	public Item clone() {
		return new Item(this);
	} 
	
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) 
			if (other.name != null)
				return false;
			else
				return price == other.price;
		else
			return name.equals(other.name) && price == other.price;
	}

	
	
	
}
