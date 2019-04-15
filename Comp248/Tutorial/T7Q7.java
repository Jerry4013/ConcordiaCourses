import java.util.Scanner;
public class T7Q7 {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		System.out.print("Which question do you want to check? ");
		String answer = keyIn.next();
		switch(answer)
		{
			case "a":
				for (int i = 1; ++i < 4; )
					System.out.print(i);
				break;
			case "b":
				for (int i = 1; i < 4; i++)
					System.out.print(i);
				break;
			case "c":
				for (int i = 1; i++ < 4; )
					System.out.print(i);
				break;
			case "d":
				for (int i = 1; i < 4; ++i)
					System.out.print(i);
		}
		keyIn.close();
	}

}
