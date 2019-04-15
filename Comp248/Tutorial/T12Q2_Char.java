
public class T12Q2_Char {

	public static void main(String[] args) {
		char ch = 'A';
		char[][] ary = new char[5][];
		for (int k = 0; k < ary.length; k++) {
			ary[k] = new char[k+1];
			for (int j = 0; j < ary[k].length; j++)
				ary[k][j] = ch++;
		}
		
		for (int i=0; i<ary.length; i++){
			for (int j=0; j<ary[i].length; j++){
				System.out.print(ary[i][j]+" ");
			}
			System.out.println();
		}
			
	}

}
