package lab;

public class DiscountedItem extends Item{
	
	
	public DiscountedItem(){}
	public DiscountedItem(String name, double price) {
		super(name,price);
	}
	
	public DiscountedItem(DiscountedItem discountedItem) {
		// TODO Auto-generated constructor stub
		super(discountedItem);
	}
	
	public boolean canBeReturned(){
		return false;
	}
	
	public DiscountedItem clone() {
		return new DiscountedItem(this);
	} 
	
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		DiscountedItem other = (DiscountedItem)obj;
		return super.equals(other);
	}
	
	
}
