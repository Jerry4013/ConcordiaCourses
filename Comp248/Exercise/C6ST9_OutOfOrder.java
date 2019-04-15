
public class C6ST9_OutOfOrder {

	public static int outOfOrder(double[] a)
	{
		for (int i=0; i<a.length-1; i++)
			if(a[i]>a[i+1])
				return(i+1);
		return(-1);
	}
	
	public static void main(String[] args) {
		double[] a = {1.2, 2.1, 3.3, 2.5, 4.5, 7.9, 5.4, 8.7, 9.9, 1.0};
		System.out.print(outOfOrder(a));
	}

}
