
public class T8Q10_MagicSquareTest {
	
	public static void MagicSquareTest(int[][] testMatrix)
	{
		int size = testMatrix.length;
		int[] sum = new int[2*size+2];
		boolean test = true;
		
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
				sum[i] += testMatrix[i][j];
			System.out.println("The sum of the "+ (i+1) +"th row is: " + sum[i]);
		}
		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
				sum[size+i] += testMatrix[j][i];
			System.out.println("The sum of the "+ (i+1) +"th column is: " + sum[size+i]);
		}
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				if (i==j)
					sum[size*2] += testMatrix[i][j];
		System.out.println("The sum of the first diagonal is: " + sum[size*2]);
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				if (i+j+1==size)
					sum[size*2+1] += testMatrix[i][j];
		System.out.println("The sum of the second diagonal is: " + sum[size*2]);
		
		for(int i=0; i<2*size+1; i++)
			if (sum[i]!=sum[i+1])
				test = false;
		System.out.print(test);
	}
}
