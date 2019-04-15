import java.util.Scanner;
public class MidtermTest2 {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		int value1, value2, value3;
		String suit1, suit2, suit3;
		
		System.out.print("Enter the value and suit of card 1: ");
		value1 = keyIn.nextInt();
		suit1 = keyIn.next();
		System.out.print("Enter the value and suit of card 2: ");
		value2 = keyIn.nextInt();
		suit2 = keyIn.next();
		System.out.print("Enter the value and suit of card 3: ");
		value3 = keyIn.nextInt();
		suit3 = keyIn.next();
		
		if(value1<1||value1>13||value2<1||value2>13||value3<1||value3>13)
		{
			System.out.println("Invalid value - bye bye ");
			System.exit(0);
		}
		
		switch (value1)
		{
			case 1:
				System.out.println("\nYour first card is: ace of "+suit1);
				break;
			case 11:
				System.out.println("\nYour first card is: jack of "+suit1);
				break;
			case 12:
				System.out.println("\nYour first card is: queen of "+suit1);
				break;
			case 13:
				System.out.println("\nYour first card is king of "+suit1);
				break;
			default:
				System.out.println("\nYour first card is: "+ value1 + " of " + suit1);	
		}
		
		System.out.print("Your hand type is: ");
		if (value1==value2&&value2==value3)
			System.out.println("TRIO");
		else if(value1==value2||value2==value3||value3==value1)
			System.out.println("PAIR");
		else if (suit1.equals(suit2)&&suit2.equals(suit3)&&value2==(value1+1)&&value3==(value2+1))
			System.out.println("STRAIGHT FLUSH");
		else if (suit1.equals(suit2)&&suit2.equals(suit3))
			System.out.println("FLUSH");
		else if (value2==(value1+1)&&value3==(value2+1))
			System.out.println("STRIGHT");
		else 
			System.out.println("NOTHING");
		keyIn.close();
	}

}
