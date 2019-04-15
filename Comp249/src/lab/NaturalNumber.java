package lab;

public class NaturalNumber {
	private int value;
	
	public NaturalNumber(){
		value = 0;
	}
	
	public NaturalNumber(int value) throws ErrConstrException{
		if(value<0)
			throw new ErrConstrException(value);
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int value) throws ErrModifException{
		if(value<0)
			throw new ErrModifException(value);
		this.value = value;
	}
	
	public void add(NaturalNumber x){
		value += x.value;
	}
	
	public void minus (NaturalNumber x) throws ErrModifException{
		if(value<x.value)
			throw new ErrModifException(value);
		value -= x.value;
	}
	
	public String toString(){
		return "This natural number is: " + value;
	}
	
	
	
}
