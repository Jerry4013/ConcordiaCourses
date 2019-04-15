import java.util.Arrays;

public class C6ST11_halfArray {
	public static double[] halfArray(double[] a)
	{
		double[] newArray = new double[a.length];
		for (int i=0; i<a.length; i++)
			newArray[i] = a[i] / 2.0;
		return newArray;
	}
	
	public static void main(String[] args){
		double[] abc = {1,2,3};
		
		System.out.print(Arrays.toString(C6ST11_halfArray.halfArray(abc)));
	}
}
