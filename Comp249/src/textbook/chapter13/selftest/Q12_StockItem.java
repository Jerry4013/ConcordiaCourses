package textbook.chapter13.selftest;

public class Q12_StockItem implements Cloneable{
	private int number;
	private String name;
	public void setNumber(int newNumber)
	{
		number = newNumber;
	}
	
	public Object clone(){
		try{
			return super.clone();
		}catch(CloneNotSupportedException e){
			return null;
		}
	}

	@Override
	public String toString() {
		return "Q12_StockItem [number=" + number + ", name=" + name + "]";
	}
	
}
