
public class T12Q4_Transpose {

	public static void main(String[] args) {
		int[][] twod = { { 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		final int LIM = twod.length;
		for (int j = 0; j < LIM; j++)
			for (int k = 0; k < LIM; k++)
				if ( j > k ) {
					int x = twod[j][k];
					twod[j][k] = twod[k][j];
					twod[k][j] = x;
				}
	}

}
