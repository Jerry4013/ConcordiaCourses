package textbook.chapter11.test;

public class Test {
	public static void main(String[] args) {
		System.out.println(display(5));
	}
	
	public static String display(int n){
		if(n<=0){
			System.out.println("Error!");
			System.exit(0);
		}
		if(n==1)
			return String.valueOf(1);
		return display(n-1) + " " + n;
	}
}
