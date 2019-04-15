package textbook.chapter15;

public class Entry implements PubliclyCloneable{
	private String item;
	private int count;
	/**
	 * @param item
	 * @param count
	 */
	public Entry(String item, int count) {
		this.item = item;
		this.count = count;
	}
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String toString(){
		return (item + " " + count);
	}
	
	public boolean equals(Object otherObject){
		if(otherObject == null)
			return false;
		else if(getClass() != otherObject.getClass())
			return false;
		else{
		Entry otherEntry = (Entry) otherObject;
		return (item.equals(otherEntry.item) && (count == otherEntry.count));
		}
	}
	
	public Object clone(){
		try{
			return super.clone();
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
}
