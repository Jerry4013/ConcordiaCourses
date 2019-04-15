package finalReview;

import java.io.Serializable;

public class MyClass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;
	private char letter;
	
	public MyClass(){
		
	}
	/**
	 * @param number
	 * @param letter
	 */
	public MyClass(int number, char letter) {
		super();
		this.number = number;
		this.letter = letter;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	@Override
	public String toString() {
		return "MyClass [number=" + number + ", letter=" + letter + "]";
	}
	
	
}
