
public class MidtermTest3 {

	public static void main(String[] args) {
		final int MIN = 1;
		final int MAX = 7;
		int i;
		int j;
		i=MIN;
		while(i<=MAX)
		{
			j=MIN;
			while (j<=MAX)
			{
				if((i==j&&i!=(MIN+MAX)/2)||i!=j&&i+j==(MIN+MAX))
					System.out.print("*");
				else if (i==j&&i==(MIN+MAX)/2)
					System.out.print("O");
				else
					System.out.print(" ");
				j++;
			}
			System.out.println();
			i++;
		}
		
		String word = "Test3";
		char c = 'm';
		if (c > 'd' || word.charAt(1) == 'e')
		if (c < 'g')
		System.out.println("red");
		else
		System.out.println("blue");
		System.out.println("green");
		
		int price = 0;
		boolean isFree = (price == 0);
		if (isFree)
		{
			price = 10;
			if (isFree)
				System.out.println("one");
			else
				System.out.println("two");
		}
		else
			System.out.println("three");
		
//		int prevprev = 2;
//		int prev = 2;
//		int sum = 0;
//		for (int i = 1; i < 4; i++)
//		{
//		sum = prevprev + prev;
//		System.out.println(prevprev + " " + prev + " " + sum);
//		prevprev = prev;
//		prev = sum;
//		}
	}

}
