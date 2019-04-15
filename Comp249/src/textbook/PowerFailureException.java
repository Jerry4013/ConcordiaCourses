package textbook;

public class PowerFailureException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PowerFailureException(){
		super("Power Failure!");
	}
	
	public PowerFailureException(String message){
		super(message);
	}
}
