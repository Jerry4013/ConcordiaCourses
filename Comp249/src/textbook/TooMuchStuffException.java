package textbook;

public class TooMuchStuffException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TooMuchStuffException(){
		super("Too much stuff!");
	}
	
	public TooMuchStuffException(String message){
		super(message);
	}
}
