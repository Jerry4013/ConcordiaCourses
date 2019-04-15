package textbook.chapter11.selftest;

public class SelfTest15 {

	public static void main(String[] args) {
		System.out.println(squares(3));
	}
	
	
	public static int squares(int n){
		if(n>1){
			return squares(n-1) + n * n;
		}
		else if (n==1)
			return 1;
		else 
			return -1;
		
		
		
	}
}

