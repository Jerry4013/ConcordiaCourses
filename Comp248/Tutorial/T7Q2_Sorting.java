import java.util.Scanner;
public class T7Q2_Sorting {
	
	public static void swap(int i, int j, int[] givenArray){
		int temp = givenArray[j];
		givenArray[j] = givenArray[i];
		givenArray[i] = temp;
	}
	
	public static void main(String[] args) {
		int[] givenArray = {1,2,3,4,5,6,7,8,9};
		
		Scanner keyIn = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int k = keyIn.nextInt();
		for (int i = givenArray.length-1; i>=0; i--)
		{
			for (int j=0; j<i; j++)
			{
				if (givenArray[j+1]>givenArray[j])
				{
					swap(j+1, j, givenArray);
				}
			}
		}
		System.out.print(givenArray[k-1]);
		
		keyIn.close();
	}

}
