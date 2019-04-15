
public class SwapTest2 {
	public static int i;
	public static int j;
	
	public static void swap(int number1, int number2)
	{
		int temp = number1;
		number1 = number2;
		number2 = temp;
		i = number1;
		j = number2;
	}
	
}
