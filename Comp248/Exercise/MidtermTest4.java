public class MidtermTest4
{
	
	public static void main(String[] args)
	{
		
		char[] setA = {'a', 'b', 'd', 'e', 'f'};
		char[] setB = {'d', 'a', 'c'};
		boolean mystery = false;
		for (int i = 0; i < setA.length; i++)
		{
		mystery = false;
		for (int j = 0; (j < setB.length && !mystery); j++)
		if (setA[i] == setB[j])
		mystery = true;
		if (!mystery)
		System.out.print(setA[i] + " ");
		}
	}
	
}