import java.util.Random;
public class T11Q5_Histogram {
	
	private int[] marks = new int[20];
	
	public T11Q5_Histogram()
	{
		Random randomInteger = new Random();
		for (int i=0; i<marks.length; i++)
			marks[i] = randomInteger.nextInt(10);
	}
	
	public void display()
	{
		int[] frequency = new int[10];
		for (int i=0; i<20; i++)
			frequency[marks[i]]++;
		for (int i=0; i<10; i++)
		{
			System.out.print(i + ": ");
			for(int j=0; j<frequency[i]; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	public int[] getMarks()
	{
		return marks;
	}
	
}
