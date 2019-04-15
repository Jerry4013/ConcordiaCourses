
public class T5Q3c {

	public static void main(String[] args) {
		int i; int j;
		boolean again = true;
		
		for (i = 1; i < 5; i++)
		{
			again = !again;
			for (j = 1; j < 5; j+=2)
			{
				System.out.print( i + " " + j);
				if (again)
					System.out.print("-") ;
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}

}
