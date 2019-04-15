
public class T12Q1_StandardDev {

	public static void main(String[] args) {
		double[] ex1 = {1.5, 1.5, 1.5};
		double[] ex2 = {0.0, 1.0, 2.0, 3.0};
		double[] ex3 = {3.4, 5.6, 123.4, 684.93, 3.4};
		System.out.println(standardDev(ex1, ex1.length));
		System.out.println(standardDev(ex2, ex2.length));
		System.out.println(standardDev(ex3, ex3.length));
		
	}
	
	public static double standardDev(double[] data, int length)
	{
		double average = 0, standardDev = 0;
		for (int i=0; i<length; i++)
			average += data[i];
		average = average / length;
		for (int i=0; i<length; i++)
			standardDev += (data[i] - average) * (data[i] - average);
		standardDev = Math.sqrt(standardDev / length);
		return standardDev;
	}

}
