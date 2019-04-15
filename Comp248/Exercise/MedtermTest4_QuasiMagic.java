import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class MedtermTest4_QuasiMagic {
	public static void main (String[] args)
	{
		Scanner myKeyboard = new Scanner(System.in);
		System.out.println("Enter the dimension of the matrix (N)");
		int N = myKeyboard.nextInt();
		int[] array = new int[N*N];
		int[][] matrix = new int[N][N];

		Integer[] arr = new Integer[N*N];
	    for (int i = 0; i < arr.length; i++)
	        arr[i] = i;
	    Collections.shuffle(Arrays.asList(arr));
	    for (int i = 0; i < arr.length; i++)
	    	array[i] = arr[i];
	    
	    for(int i=0; i<N; i++)
	    {
	    	for (int j=0; j<N; j++){
	    		matrix[i][j] = array[j+N*i];
	    		System.out.print(matrix[i][j]+"\t");
	    	}
	    	System.out.println();
	    }
	    
	    int[] counter = new int[N*N];
	    for (int i=0; i<N*N; i++)
	    	for(int j=0; j<N; j++)
	    		for (int k=0; k<N; k++)
	    			if(matrix[j][k]==i)
	    				counter[i]++;
	    boolean checkResult = true;
	    for(int i=0; i<N*N; i++)
	    	if(counter[i]>1)
	    		checkResult = false;
	    if(checkResult==false)
			System.out.println("It is not a quasi-magic");
	    else
	    	System.out.println("It is a quasi-magic");
	    
	    int[] sum = new int[N];
	    for(int i=0; i<N; i++)
	    	for (int j=0; j<N; j++)
	    		sum[i]+=matrix[i][j];
	    boolean check = true;
	    for(int i=0; i<N-1; i++)
	    	if(sum[i]!=sum[i+1])
	    		check = false;
	    if(check==false)
			System.out.println("It is not a quasi-magic");
	    else
	    	System.out.println("It is a quasi-magic");
	   
		myKeyboard.close();
	}
}
