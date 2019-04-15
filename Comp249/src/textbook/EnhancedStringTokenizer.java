package textbook;
import java.util.StringTokenizer;
public class EnhancedStringTokenizer extends StringTokenizer{
	private String[] a;
	private int count;
	
	public EnhancedStringTokenizer(String theString)
	{
		super (theString);
		a = new String[countTokens()];
		count = 0;
	}

	public EnhancedStringTokenizer(String theString, String delimiters)
	{
		super (theString, delimiters);
		a = new String[countTokens()];
		count = 0;
	}
	
	public String nextToken()
	{
		String token = super.nextToken();
		a[count] = token;
		count++;
		return token;
	}
	
	public String nextToken(String delimiters)
	{
		String token = super.nextToken(delimiters);
		a[count] = token;
		count++;
		return token;
	}
	
	public String[] tokensSoFar()
	{
		String[] arrayToReturn = new String[count];
		for (int i = 0; i < count; i++)
			arrayToReturn[i] = a[i];
		return arrayToReturn;
	}

}
