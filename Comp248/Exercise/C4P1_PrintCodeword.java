import java.util.Scanner;
public class C4P1_PrintCodeword {
	private char initialLetter;
	private int initialDigit;
	
	public C4P1_PrintCodeword(){}
	
	public C4P1_PrintCodeword(String letterString, int digit)
	{
		setCode (letterString, digit);
	}
	
	public void inputCode()
	{
		Scanner kb = new Scanner(System.in);
		boolean tryagain = true;
		while (tryagain)
		{
			System.out.println("Please enter the starting letter and starting digit, seperated by space: ");
			String startingLetterString = kb.next();
			int startingDigit = kb.nextInt();
			if (codeOK(startingLetterString, startingDigit))
			{
				setCode(startingLetterString, startingDigit);
				tryagain = false;
			}
			else
				System.out.println("Invalid input! Please enter again: ");
		}
		kb.close();
	}
	
	public void setCode (String letterString, int digit)
	{
		if(codeOK(letterString, digit))
		{
			this.initialLetter = letterString.charAt(0);
			this.initialDigit = digit;
		}
		else
		{
			System.out.println("Invalid input!");
			System.exit(0);
		}
	}
	
	private boolean codeOK(String startingLetterString, int startingDigit)
	{
		char startingLetter = startingLetterString.charAt(0);
		return (startingLetter>='A' && startingLetter<='Z' && startingDigit>=0 && startingDigit<=9);
	}
	
	public void printCodeword()
	{
		char printLetter = initialLetter;
		int printdigit = initialDigit;
		for (int i=1; i<=26; i++)
		{
			System.out.println(printLetter + "" +printdigit);
			if(printLetter!='Z')
				printLetter++;
			else
				printLetter = 'A';
			
			if (printdigit!=9)
				printdigit++;
			else
				printdigit = 0;
		}
	}
	
}







