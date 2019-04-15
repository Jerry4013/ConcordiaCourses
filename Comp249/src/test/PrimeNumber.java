package test;

public class PrimeNumber {

	public static void main(String[] args) {
		System.out.println(isPrimeNumber(113));
	}

	public static boolean isPrimeNumber(int n){
		if (n<=1)
			return false;
		if (n==2)
			return true;
		for(int j=2; j<=Math.sqrt(n); j++)
			if(n%j==0)
				return false;
		return true;
	}
}
