import java.util.StringTokenizer;
public class C4P5_WordCount {
	
	private static int count;
	
	public static int wordCount(String sentence)
	{
		StringTokenizer st = new StringTokenizer(sentence);
		while(st.hasMoreTokens())
		{
			String word = st.nextToken();
			if(word.charAt(0)=='A'||word.charAt(0)=='a')
				decrement();
			else
				increment();
		}
		return count;
	}
	
	public static int getCount()
	{
		return count;
	}
	
	public static void printCount()
	{
		System.out.println(count);
	}
	
	public static void setCount()
	{
		count = 0;
	}
	
	public static void increment()
	{
		count++;
	}
	
	public static void decrement()
	{
		if(count>0)
			count--;
	}
}
