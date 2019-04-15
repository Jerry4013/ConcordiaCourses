package textbook.chapter15;

public class StockItem implements PubliclyCloneable{
	
	private String name;
	private int number;
	
	public StockItem(){
		name = null;
		number = 0;
	}
	
	public StockItem(String nameData, int numberData){
		name = nameData;
		number = numberData;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String toString(){
		return (name + " " + number);
	}
	
	public Object clone(){
		try{
			return super.clone();
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	
	public boolean equals(Object otherObject){
		if (otherObject == null)
			return false;
		if (getClass() !=otherObject.getClass())
			return false;
		StockItem other = (StockItem) otherObject;
		return name.equalsIgnoreCase(other.name) && number == other.number;
	}

}







