import java.util.Scanner;
public class T5Q4 {

	public static void main(String[] args) {
		int age, k = 0;
		int low;
		int up;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter lower bound and upper bound:");
		low = keyboard.nextInt();
		up = keyboard.nextInt();
		
		//for (age = low ; age <= up ; age += 5)
		age = low;
		if (age <= up)
		{
			do 
			{
				switch (age)
				{
					case 25:
						System.out.print("one");
						break;
					case 35: case 20:
						k++;
						System.out.print("two");
						break;
					default:
						System.out.println(age);
				}
				age = age + 10;
			} while (age <= up);
		}
		System.out.print(k);
		keyboard.close();
	}

}
