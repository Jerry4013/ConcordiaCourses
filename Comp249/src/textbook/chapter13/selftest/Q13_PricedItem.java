package textbook.chapter13.selftest;

public class Q13_PricedItem extends Q12_StockItem implements Cloneable{
	private double price;
	
	public Object clone(){
		return super.clone();
	}

	@Override
	public String toString() {
		return "Q13_PricedItem [price=" + price + "]";
	}
	
	
}
