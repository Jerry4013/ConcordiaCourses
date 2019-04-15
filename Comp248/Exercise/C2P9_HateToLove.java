import java.util.Scanner;
public class C2P9_HateToLove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a line of text.");
		String text = keyboard.nextLine();
		int positionOfHate = text.indexOf("hate");
		String changedtext = text.substring(0, positionOfHate) + "love" + text.substring(positionOfHate+4);
		
		System.out.println("I have rephrased that line to read:");
		System.out.println(changedtext);
		
		
		keyboard.close();
	}

}
