
public class C6S_P31 {

	public static void main(String[] args) {
		int[][] table = new int[5][10];
		for (int row=0; row < table.length; row++)
		{
			for (int col=0; col < table[row].length; col++)
			{
				table[row][col] = row * 10 + col;
				System.out.print (table[row][col] + "\t");
			}
			System.out.println();
		}		
		
		System.out.println();
		
		for(int i=0; i<5; i++)
		{
			for (int j=0; j<10; j++)
				System.out.print(i*10+j+"\t");
			System.out.println();
		}
		
	}

}
