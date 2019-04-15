import java.util.Scanner;
public class C3S_P93 {
	public static final int PER_LINE = 5;
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a positive value:  ");
		int value = kb.nextInt();
		System.out.print("Enter an upper limit:  ");
		int limit = kb.nextInt();
		int i;
		System.out.println("Multiples of " +value+" between "+value+" and "+limit+": \n");
		for (i=1; i*value<=limit; i++)
		{
			int newValue = value * i;
			System.out.print(newValue + " ");
			if(i % PER_LINE == 0)
				System.out.println();
		}
		
		kb.close();
		
	}

}
