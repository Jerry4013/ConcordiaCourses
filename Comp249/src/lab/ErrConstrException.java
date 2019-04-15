package lab;

public class ErrConstrException extends Exception{
	
	private static final long serialVersionUID = 1L;

	private int badValue;
	
	public ErrConstrException(){
		super("Fail to creat new natural number. Natural cannot less than zero.");
	}
	
	public ErrConstrException(String message){
		super(message);
	}
	
	public ErrConstrException(int value){
		badValue = value;
	}
	
	public String getMessage(){
		return "Fail to creat new natural number which is " + badValue +". Natural cannot less than zero.";
	}
}
