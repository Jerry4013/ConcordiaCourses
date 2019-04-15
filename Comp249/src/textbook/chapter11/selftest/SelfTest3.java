package textbook.chapter11.selftest;

public class SelfTest3 {

	public static void main(String[] args) {
		printAsterisks(65491324);
	}
	
	public static void printAsterisks(int n) {
		if(n!=0){
			System.out.print(n%10);
			printAsterisks(n/10);
		}
	}
}
