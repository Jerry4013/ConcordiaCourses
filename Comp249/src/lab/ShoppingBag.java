package lab;

public class ShoppingBag {
	private int ID;
	private double totalAmount = 0;
	private Item[] items = new Item[3];
	
	public ShoppingBag(int ID){
		this.ID = ID; 
	}
	
	
	public ShoppingBag(ShoppingBag shoppingBag) {
		ID = shoppingBag.ID;
		totalAmount = shoppingBag.totalAmount;
		for (int i=0; i<shoppingBag.items.length; i++) {
			items[i] = new Item(shoppingBag.items[i]);
		}
	}

	public double getTotalAmount() {
		return totalAmount;
	}
	
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public Item[] getItems() {
		return items;
	}


	public void setItems(Item[] items) {
		this.items = items;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public ShoppingBag clone() {
		return new ShoppingBag(this);
	}
	
	public void BuyItem(Item item) throws BuyItemException{
		if(items[2]!=null)
			throw new BuyItemException();
		else{
			for(int i=0; i<items.length; i++){
				if(items[i]==null){
					items[i] = item.clone();
					break;
				}
			}
			totalAmount += item.getPrice();
		}
	}
	
	public void ReturnItem(Item item) throws ReturnItemException {
		if(!item.canBeReturned())
			throw new ReturnItemException();
		else{
			for(int i=0; i<items.length;i++)
				if(items[i].equals(item)){
					items[i] = null;
					totalAmount -= item.getPrice();
				}
		}
	}
	
	
	
}
