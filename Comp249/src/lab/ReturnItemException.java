package lab;

public class ReturnItemException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReturnItemException(){
		super("Item cannot be returned");
	}
	public ReturnItemException(String message){
		super(message);
	}
	
	public String getMessage(){
		return "Item cannot be returned";
	}
	
}
