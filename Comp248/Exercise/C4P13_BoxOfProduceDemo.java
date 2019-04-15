import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class C4P13_BoxOfProduceDemo {

	public static void main(String[] args) {
		Scanner fileIn = null;
		Scanner keyIn = new Scanner(System.in);
		String[] item = new String[5];
		int numberToSubstitute;
		try
		{
			fileIn = new Scanner(new FileInputStream("G:\\workspace\\Exercise\\src\\produce.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
			System.exit(0);
		}
		
		for (int i=0; i<5; i++)
		{
			item[i] = fileIn.next();
		}
		C4P13_BoxOfProduce box = new C4P13_BoxOfProduce();
		box.setBundle1(item[(int)(Math.random()*5)]);
		box.setBundle2(item[(int)(Math.random()*5)]);
		box.setBundle3(item[(int)(Math.random()*5)]);
		
		System.out.println("The contents of the box to be delivered are: \n"+box);
		System.out.println();
		
		System.out.print("Do you want to substitute one of them? ");
		String answer = keyIn.next();
		if(answer.equalsIgnoreCase("Y"))
		{
			System.out.print("Which bundle do you want to substitute? ");
			numberToSubstitute = keyIn.nextInt();
			System.out.print("What item do you want to change to? ");
			String newItem = keyIn.next();
			switch(numberToSubstitute)
			{
			case 1: 
				box.setBundle1(newItem);
				break;
			case 2:
				box.setBundle2(newItem);
				break;
			case 3:
				box.setBundle3(newItem);
				break;
			}
		}

		System.out.println("\nThe final contents of the box to be delivered are: \n" + box);
		
		fileIn.close();
		keyIn.close();
	}

}
