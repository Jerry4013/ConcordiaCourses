import java.util.Scanner;
public class T6Q3_HourGlass {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please enter an integer larger than 2 (the size of the shape): ");
		int integer = kb.nextInt();
		
		int line=0, upline=0;
		if(integer%2==0)
			line = integer -1;
		else
			line = integer;
		upline = (line+1)/2;
		
		if(integer <= 2 )
		{
			System.out.println("Error.");
			System.exit(0);
		}
		else
		{
			int i;
			for (i=1; i<=upline; i++)
			{
				for (int j=0; j<i-1; j++)
					System.out.print(" ");
				for (int j=0; j<integer-2*i+2; j++)
					System.out.print("*");
				System.out.println();
			}
			for (i=upline-1; i>0; i--)
			{
				for (int j=0; j<i-1; j++)
					System.out.print(" ");
				for (int j=0; j<integer-2*i+2; j++)
					System.out.print("*");
				System.out.println();
					
			}
		}
			
		
		
		
		kb.close();
	}

}
