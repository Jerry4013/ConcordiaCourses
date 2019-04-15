
public class T2_Question {
	/**
	* Question.java
	*/
	public static final String sentence = "I hate programming.";
	public static void main (String[] args)
	{
	int position = sentence.indexOf("hate");
	String firstPart = sentence.substring(0, position);
	String afterHate = sentence.substring(position + 4);
	String newString = firstPart + "love" + afterHate;
	System.out.println("The line of text to be hanged is: ");
	System.out.println(sentence);
	System.out.println("I have rephrased the line to read:");
	System.out.println(newString);
	}// end of main ()
	// Question
}
