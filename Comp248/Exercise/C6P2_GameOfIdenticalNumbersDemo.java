
public class C6P2_GameOfIdenticalNumbersDemo {

	public static void main(String[] args) {
		System.out.println("\n---------------------------------------------");
		System.out.println("  Welcome to Jingchao's Memory Matching Game");
		System.out.println("---------------------------------------------");
		System.out.println("\n***********  Find identical numbers  ***********\n");
		C6P2_GameOfIdenticalNumbers newGame = new C6P2_GameOfIdenticalNumbers();
		newGame.play();
		
		System.out.println("\nCongratulations! Thank you for using Jingchao's Memory Matching Game Program!");
		for(int i=0;i<3;i++)
			System.out.println();
		
	}

}
