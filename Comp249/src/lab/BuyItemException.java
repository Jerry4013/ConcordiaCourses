package lab;

public class BuyItemException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BuyItemException() {
		super ("Item cannot be bought");
	}
	public BuyItemException(String message) {
		super(message);
	}
	
	public String getMessage(){
		return "Item cannot be bought";
	}
	
	
}
