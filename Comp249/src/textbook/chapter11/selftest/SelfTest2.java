package textbook.chapter11.selftest;

public class SelfTest2 {

	public static void main(String[] args) {
		printAsterisks(5);
	}
	
	public static void printAsterisks(int n) {
		if(n>0){
			System.out.print("*");
			printAsterisks(n-1);
		}
	}

}
