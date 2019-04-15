import java.util.Scanner;

public class MidtermTestF15 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter three integers: ");
		int[] x = new int[3];
		x[0] = kb.nextInt();
		x[1] = kb.nextInt();
		x[2] = kb.nextInt();
		
		for (int i=1; i<3; i++)
			for (int j=0; j<2; j++)
				if (x[j]>x[j+1])
				{
					int temp = x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
		
		for (int i=0; i<3; i++)
			System.out.print(x[i]+" ");
		
		
		kb.close();
	}

}
