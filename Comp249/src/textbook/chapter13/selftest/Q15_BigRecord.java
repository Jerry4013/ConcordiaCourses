package textbook.chapter13.selftest;

public class Q15_BigRecord extends Q14_Record implements Cloneable{
	private Q12_StockItem item3;
	
	public Object clone(){
		Q15_BigRecord copy = (Q15_BigRecord)super.clone();
		copy.item3 = (Q12_StockItem)item3.clone();
		return copy;
	}
}
