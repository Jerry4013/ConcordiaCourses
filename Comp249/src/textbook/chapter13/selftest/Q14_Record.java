package textbook.chapter13.selftest;

public class Q14_Record implements Cloneable{
	private Q12_StockItem item1;
	private Q12_StockItem item2;
	private String description;
	
	public Object clone(){
		try{
			Q14_Record copy = (Q14_Record) super.clone();
			copy.item1 = (Q12_StockItem) item1.clone();
			copy.item2 = (Q12_StockItem) item2.clone();
			return copy;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}

	@Override
	public String toString() {
		return "Q14_Record [item1=" + item1 + ", item2=" + item2 + ", description=" + description + "]";
	}
	
	
}
