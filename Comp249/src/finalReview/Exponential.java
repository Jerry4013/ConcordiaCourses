package finalReview;

public class Exponential {
	public static double calculate(double base, int exp){
		double result = 0;
		if(exp==1)
			result = base;
		else
			result = base * calculate(base, exp-1);
		
		return result;
	}
}
