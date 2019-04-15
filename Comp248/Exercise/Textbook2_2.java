
import java.util.Scanner;
public class Textbook2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		Scanner keyboard = new Scanner(System.in);
//		System.out.println("Enter the number of pods:");
//		
//		System.out.println("the number of peas in a pod:");		
//		double numberOfPods = keyboard.nextDouble();
//		int peasPerPod = keyboard.nextInt();
//		double totalNumberOfPeas = numberOfPods * peasPerPod;
//		System.out.print(numberOfPods + " pods and ");
//		System.out.println(peasPerPod + " peas per pod.");
//		System.out.println("The total number of peas = " + totalNumberOfPeas);
//		keyboard.close();
//		
//		String myString = "ias";
//		String mySubstring = myString.substring(0, 1);
//		System.out.println("test " + mySubstring + " test");
		Scanner scannerObject = new Scanner(System.in);
		
		System.out.println("Next enter two words:");
		String word1 = scannerObject.next();
		String word2 = scannerObject.next();
		System.out.println("You entered \"" + word1 + "\" and \"" + word2 + "\"\n");
		scannerObject.nextLine(); //To get rid of '\n'
		System.out.println("Next enter a line of text:");
		String line = scannerObject.nextLine();
		System.out.println("You entered: \"" + line + "\"");
		
		scannerObject.close();
//		Scanner frank = new Scanner(System.in);
//		String w = frank.next();
		
//		frank.close();
	}

}
