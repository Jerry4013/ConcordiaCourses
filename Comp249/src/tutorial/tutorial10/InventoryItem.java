package tutorial.tutorial10;

public class InventoryItem implements Comparable<InventoryItem>{
	private String name;
	private int itemID;
	
	public InventoryItem(){}
	/**
	 * @param name
	 * @param itemID
	 */
	public InventoryItem(String name, int itemID) {
		super();
		this.name = name;
		this.itemID = itemID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	@Override
	public int compareTo(InventoryItem o) {
			
		
		return 0;
	}
	
	
}
