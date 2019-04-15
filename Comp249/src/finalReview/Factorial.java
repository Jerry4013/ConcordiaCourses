package finalReview;

public class Factorial {
	public static int calculate(int n){
		if(n==1)
			return n;
		else 
			return n * calculate(n-1);
	}
}
