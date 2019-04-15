package lab;

public class ErrModifException extends Exception{
	
	private int badValue;
	private static final long serialVersionUID = 1L;

	public ErrModifException(){
		super("Fail to modify this natural number. Natural cannot less than zero.");
	}
	
	public ErrModifException(String m){
		super(m);
	}
	
	public ErrModifException(int value){
		badValue = value;
	}
	
	public String getMessage(){
		return "Fail to modify this natural number, because " + badValue +" change the number to be less than zero.";
	}
}
