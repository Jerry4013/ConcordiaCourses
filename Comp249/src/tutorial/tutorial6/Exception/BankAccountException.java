package tutorial.tutorial6.Exception;

public class BankAccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BankAccountException(){
		super ("  ");
	}
	
	public BankAccountException(String message){
		super(message);
	}
	
}
