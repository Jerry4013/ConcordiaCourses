import java.util.Scanner;
public class C3P7_ArmstrongNumber {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String answer = null;
		do
		{
			System.out.print("Please enter the start and end numbers: ");
			int start = kb.nextInt();
			int end = kb.nextInt(); 
			
			for (int number = start; number<=end; number++)
			{
				String numberString = String.valueOf(number);
				int digitNumber = numberString.length();
				int[] digit = new int[digitNumber];
				int remainder = number;
				int sum = 0;
				for (int i=0; i<digitNumber; i++)
				{
					digit[i] = (int) (remainder/Math.pow(10, digitNumber-i-1));
					sum += Math.pow(digit[i], digitNumber);
					remainder = (int) (remainder % Math.pow(10, digitNumber-i-1));
				}
				if(sum==number)
					System.out.println(number + " is an Armstrong Number.");
			}
			System.out.print("\nDo you want to try again?(Y/N) ");
			answer = kb.next();
		}while(answer.equalsIgnoreCase("Y"));
		System.out.println("\nBye bye!");
		kb.close();

	}

}
