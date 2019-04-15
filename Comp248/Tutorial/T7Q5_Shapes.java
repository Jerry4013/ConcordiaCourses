
public class T7Q5_Shapes {

	public static void main(String[] args) {
		boolean a = false;
		if (a)
		{
			for (int i=1; i<=5; i++)
			{
				for (int j=1; j<=i; j++)
					System.out.print("*");
				System.out.println();
			}
		}
		else
		{
			for (int i=1; i<=6; i++)
			{
				for (int j=1; j<=6-i; j++)
					System.out.print(" ");
				for (int j=1; j<=2*i-1; j++)
					System.out.print("*");
				System.out.println();
			}
		}
		
	}

}
