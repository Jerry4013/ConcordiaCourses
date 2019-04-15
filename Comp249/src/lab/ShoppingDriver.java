package lab;

public class ShoppingDriver {

	public static void main(String[] args) {
		ShoppingBag sb = new ShoppingBag(1);
		Item i1 = new Item("meat", 6.5);
		Item i2 = new Item("apple", 3.5);
		DiscountedItem d1 = new DiscountedItem("banana", 2.1);
		DiscountedItem d2 = new DiscountedItem("pasta", 2.6);
		try {
			sb.BuyItem(i1);
			sb.BuyItem(i2);
			sb.BuyItem(d1);
			sb.BuyItem(d2);
			
		}catch (BuyItemException e) {
			System.out.println(e.getMessage());
		}
		try{
			sb.ReturnItem(i2);
			sb.ReturnItem(d1);
		}catch(ReturnItemException e){
			System.out.println(e.getMessage());
		}finally{
			System.out.println(sb.getTotalAmount());
		}
	}

}
