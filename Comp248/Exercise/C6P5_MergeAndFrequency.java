import java.util.Scanner;

public class C6P5_MergeAndFrequency {

	public static void main(String[] args) {
		int[] array1 = new int[15];
		int[] array2 = new int[15];
		int[] array = new int[30];
		Scanner keyIn = new Scanner(System.in);
		System.out.println("Please enter your first array: ");
		for(int i=0; i<15; i++)
			array1[i] = keyIn.nextInt();
		System.out.println("Please enter your second array: ");
		for(int i=0; i<15; i++)
			array2[i] = keyIn.nextInt();
		for(int i=0; i<30; i++)
		{
			if(i<15)
				array[i] = array1[i];
			else
				array[i] = array2[i-15];
		}
		for(int i=0; i<29; i++)
			for(int j=0; j<29-i; j++)
			{
				int temp;
				if(array[j]>array[j+1])
				{
					temp = array[j];
					array[j] = array[j+1];
					array[j+1]= temp;
				}
			}
		boolean[] occurrence = new boolean[30];
		int counter = 0;
		System.out.println("N\tCount");
		for(int i=0; i<30; i++)
		{
			counter=0;
			if(occurrence[i]==false)
			{
				for(int j=i; j<30; j++)
					if(array[i]==array[j])
					{
						counter++;
						occurrence[j] = true;
					}
				System.out.println(array[i]+"\t"+counter);
			}
		}
		keyIn.close();
	}

}
