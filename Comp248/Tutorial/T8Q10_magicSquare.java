
public class T8Q10_magicSquare {

	public static void main(String[] args) {
		int[][] matrix = {{2,7,6}, {9,5,1}, {4,3,8}};
		int size = 3;
		int[] sum = new int[2*size+2];
		boolean test = true;
		
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				sum[i] += matrix[i][j];
		for (int j=0; j<size; j++)
			for (int i=0; i<size; i++)
				sum[size+j] += matrix[i][j];
		for (int j=0; j<size; j++)
			for (int i=0; i<size; i++)
				if (i==j)
					sum[size*2] += matrix[i][j];
		for (int j=0; j<size; j++)
			for (int i=0; i<size; i++)
				if (i+j+1==size)
					sum[size*2+1] += matrix[i][j];
		
		for(int i=0; i<2*size+2; i++)
			System.out.println(sum[i]);
		for(int i=0; i<2*size+2; i++)
			if (sum[i]!=sum[0])
				test = false;
		System.out.println(test);
		
	}

}
