package lab.lab9;
import java.util.Random;
public class Calculator {

	public static void main(String[] args) {
		Random randomGenerator = new Random();
		int r1 = randomGenerator.nextInt(6) + 5;
		int result1 = multiplyOrSum(r1);
		System.out.println("The random number is: " + r1 + ", and the result is: " + result1);
		int r2 = randomGenerator.nextInt(6) + 5;
		int result2 = multiplyOrSum(r2);
		System.out.println("The random number is: " + r2 + ", and the result is: " + result2);
		System.out.println("The two values are: " + result1 + " and " + result2 + ". Their greatest Common Divisor is: "
		+ greatestCommonDivisor(result1, result2));
	}
	
	public static int multiplyOrSum(int n){
		if(n<=0){
			System.out.println("Cannot calculate a nonpositive number. Aborting!");
			System.exit(0);
		}
		if(n%2==1&&n==1)
			return 1;
		if(n%2==1)
			return multiplyOrSum(n-2) * n;
		if(n%2==0&&n==2)
			return 2;
		if(n%2==0)
			return multiplyOrSum(n-2) + n;
		return -1;
	}
	
	public static int greatestCommonDivisor(int x, int y){
		if(x>y&&y!=0)
			return greatestCommonDivisor(y, x%y);
		if(x>y&&y==0)
			return x;
		if(x<y&&x!=0)
			return greatestCommonDivisor(x, y%x);
		if(x<y&&x==0)
			return y;
		if(x==y)
			return x;
		return -1;
	}
	
	
}
