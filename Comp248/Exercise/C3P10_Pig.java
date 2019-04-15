import java.util.Random;
import java.util.Scanner;
public class C3P10_Pig {

	public static void main(String[] args) {
		Random dice = new Random();
		Scanner keyIn = new Scanner(System.in);
		String answer = "";
		int results, humanScore=0, computerScore=0, tempScore=0;
		
		System.out.println("\n----------------------------------------------");
		System.out.println("   Welcome to Jingchao's Game Of Pig Program!");
		System.out.println("----------------------------------------------");
		
		do
		{
			System.out.println("Press \"r\" to start rolling.");
			answer = keyIn.next();
			tempScore = 0;
			while(answer.equals("r"))
			{
				results = dice.nextInt(6) + 1;
				if (results != 1)
				{
					tempScore += results;
					System.out.println("The result is: " + results + ". Your Score now is: " + (humanScore+tempScore));
					System.out.println("Do you want to hold or roll again?[h/r]");
					answer = keyIn.next();	
				}
				else
				{
					System.out.println("The result is 1. No new point! Your Score now is: " + humanScore +"\nThe computer's turn.");
					System.out.println();
					tempScore = 0;
					break;
				}
			}
			if(answer.equals("h"))
			{
				humanScore += tempScore;
				System.out.println("Your score now is: " + humanScore);
				if (humanScore>=100)
				{
					System.out.println("You win! Bye bye!");
					System.exit(0);
				}
				else
					System.out.println("It's the computer's turn now.");
				System.out.println();
			}
			System.out.println("Computer's turn: ");
			tempScore = 0;
			do
			{
				results = dice.nextInt(6) + 1;
				tempScore += results;
				if (results != 1)
					System.out.println("The result is: " + results + ". Computer's Score now is: " + (computerScore + tempScore));	
			}while (results != 1 && tempScore<20);
			if (results != 1)
			{
				computerScore += tempScore;
				if (computerScore>=100)
				{
					System.out.println("Computer win! Bye bye!");
					System.exit(0);
				}
				else
				{
					System.out.println("The score of computer now is: " + computerScore);
					System.out.println("It's your turn now!");
				}
			}
			else
			{
				System.out.println("The result is 1. No score! The computer's score is: "+ computerScore +"\nIt's your turn now!");
				System.out.println();
			}
		}while(computerScore<100 && humanScore<100);
		
		keyIn.close();
	}

}
