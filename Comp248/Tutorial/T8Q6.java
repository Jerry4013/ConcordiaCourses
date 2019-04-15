import java.util.Scanner;
public class T8Q6 {

	public static void main(String[] args) {
		//A
		int[] myArray = new int[10];
		for (int i=0; i<10; i++)
			myArray[i] = -10;
		
		//B
		int[] values = new int[20];
		for (int i=0; i<20; i++)
			values[i] = values[i]+1;
		
		//C
		Scanner keyboard = new Scanner(System.in);
		float[] dailyTemperatures = new float[7];
		for(int i=0; i<7; i++)
			dailyTemperatures[i] = keyboard.nextFloat();
		keyboard.close();
		
		//D
		int[] bestScores = new int[5];
		for (int i=0; i<5; i++)
			System.out.println(bestScores[i]);
	}

}
