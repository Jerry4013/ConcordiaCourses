
public class T5Q3d {

	public static void main(String[] args) {
		int a = 30;
		int b = 3;
		while (a >= b)
		{
			System.out.println("while " + a + " " + b);
			if ((a%b) == 0)
			{
				a = a/b;
				b++;
			}
			else
			{
				a = a-1;
				b = b-1;
			}
		}
		System.out.println("the end " + a + " " + b);
	}

}
