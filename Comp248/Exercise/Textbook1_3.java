
public class Textbook1_3 {
	
	public static final int ANSWER = 42;
	public static void main(String[] args) {

		String myString = "  Hello world! ";
		System.out.println(myString);
		
		String myTrimString = myString.trim();
		System.out.println(myTrimString);
		
		System.out.println("Time's up!");
		char singleQuote = '\'';
		System.out.println(singleQuote);
		
		String lenthTest = "I hate text processing! I want to test the index of the last letter.";
		int lenthOfThisSentence = lenthTest.length();
		System.out.println(lenthOfThisSentence);
		int indexOfLetter = lenthTest.indexOf("letter");
		System.out.println(indexOfLetter);
		
		String verbPhrase = "is money";
		System.out.println("Time" + verbPhrase);
		
		char mychar = '\n';
		System.out.println(mychar);
		System.out.println("Test: Where is the cursor?");
		
		int aVar;
		aVar = 10/4;
		System.out.println(aVar);
		
		byte aByte;
		int anInt=75;
		aByte= (byte)anInt;
		System.out.println(aByte);
		
		byte b1 = 1, b2 = 'a';
		int b3;
		b3 = b1 + b2;
		System.out.println(b3);
		
		b3 = 1 + b2;
		b3 = (byte)1 + b2;
		
		String myString1 = "ataasdf";
		int lengthOf1 = myString1.length();
		System.out.println(myString1.substring(lengthOf1-1));
		String myString2 = "Att";
		int stringCompare = myString1.compareTo(myString2);
		System.out.println(stringCompare);
		
		
		
		
	}

}
