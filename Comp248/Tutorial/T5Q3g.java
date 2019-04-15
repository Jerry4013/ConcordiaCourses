
public class T5Q3g {

	public static void main(String[] args) {
		int sum = 0;
		for (int k = 0; k < 7; k++)
		{
		for (int j = 7; j > 2*k; j-=2)
		{
		System.out.print(" " + (j-k) + "+");
		sum += (j-k);
		}
		System.out.println();
		}
		System.out.println(" = " + sum);
	}

}
