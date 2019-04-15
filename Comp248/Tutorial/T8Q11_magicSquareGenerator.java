import java.util.Scanner;
public class T8Q11_magicSquareGenerator {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter the size (positive odd interger): ");
		int size = kb.nextInt();
		int[][] matrix = new int[size][size];
		int i = 1;
		int m = size;
		int n = (size + 1)/2;
		matrix[m-1][n-1] = i;
		for (i=2; i<=size*size; i++)
		{
			int tempm = m;
			int tempn = n;
			m = m + 1;
			n = n + 1;
			if (m>size)
				m = 1;
			if (n>size)
				n = 1;
			if(matrix[m-1][n-1]==0)
				matrix[m-1][n-1] = i;
			else
			{
				m = tempm - 1 ;
				n = tempn;
				if (m>size)
					m = 1;
				matrix[m-1][n-1] = i;
			}
		}
		
		for (i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
				System.out.print(matrix[i][j]+"\t");
			System.out.println();
		}	
		T8Q10_MagicSquareTest.MagicSquareTest(matrix);
		
		kb.close();
	}

}
