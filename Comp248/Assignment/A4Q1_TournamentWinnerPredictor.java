// -------------------------------------------------------
// Assignment 4 Question 1
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Nov 5, 2017
// Purpose: To ask a user for names of 8 soccer teams and to output a possible road map of 4 quarter finals, 
//          2 semifinals, 1 final and the final winner of a tournament.
// --------------------------------------------------------
import java.util.Scanner;
import java.util.Random;
public class A4Q1_TournamentWinnerPredictor {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
	
		//There are different numbers of teams in the three stages, in which I need to generate random winners,
		//so I created three different arrays of type String.
		String[] participatingTeams = new String[8];
		String[] groupedQuarterFinalTeams = new String[8];//shuffled teams
		String[] semiFinalTeams = new String[4];
		String[] groupedSemiFinalTeams = new String[4];//shuffled teams
		String[] FinalTeams = new String[2];//Only two teams in the final, do not need to shuffle.
		String finalWinner;
		int[] quarterFinalTeamNumber = new int[8];
		int[] semiFinalTeamNumber = new int[4];
		String answer;
		//Algorithm: 
		//For each round, quarter-Final, semi-Final, Final
		//1. Get the teams in this round and store them into an array.
		//2. Shuffle them and store the result in a new array.
		//3. Select a winner between two teams of each group randomly, and print out the result.
		//4. In the final, we do not need to shuffle or to assign it into a new array. Just pick one between two teams.
		
		//Welcome banner.
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println("    Welcome to Jingchao's Tournament Outcome Predictor program!");
		System.out.println("------------------------------------------------------------------------");
		
		//To store the 8 teams' name that a user inputs in the array "participatingTeams";
		System.out.println("Please enter a name for the soccer tournament");
		String tournamentName = keyIn.nextLine();
		System.out.println("\nPlease enter the 8 participating teams");
		for(int i=0; i<8; i++)
			participatingTeams[i] = keyIn.nextLine();
		do//Allow the use to repeat the whole predicting program if he is not satisfied with the predicted result.
		{
			System.out.println("\n      ----- " + tournamentName + " Outcome Predictions -----\n");
			
			//First, I want to combine the 8 teams randomly. So I need a random sequence from 0-7 used for the index of this array
			//I need to use it in the second round as well, so I write a method named "randomSequence" to avoid repeat.
			quarterFinalTeamNumber = randomSequence(8);
			//Assign each number of the array that we just generated to a corresponding array of String.
			for (int i=0; i<8; i++)
				groupedQuarterFinalTeams[i] = participatingTeams[quarterFinalTeamNumber[i]];
			
			//Quarter-Final round: select 4 teams and output the result.
			for (int i=0; i<4; i++)
			{
				semiFinalTeams[i] = selectBetweenTwoTeams(groupedQuarterFinalTeams[i*2],groupedQuarterFinalTeams[i*2+1]);
				System.out.println("Quater Final " + (i+1) + ": " + groupedQuarterFinalTeams[i*2] + " Vs " +
						groupedQuarterFinalTeams[i*2+1]);
				System.out.println(semiFinalTeams[i] + " Wins !!!\n");
			}
			semiFinalTeamNumber = randomSequence(4);
			//Assign each number of the array that we just generated to a corresponding array of String.
			for (int i=0; i<4; i++)
				groupedSemiFinalTeams[i] = semiFinalTeams[semiFinalTeamNumber[i]];
			//semi-Final round: select two teams and output the result.
			for (int i=0; i<2; i++)
			{
				FinalTeams[i] = selectBetweenTwoTeams(groupedSemiFinalTeams[i*2],groupedSemiFinalTeams[i*2+1]);
				System.out.println("Semi-Final " + (i+1) + ": " + groupedSemiFinalTeams[i*2] + " Vs " + 
						groupedSemiFinalTeams[i*2+1]);
				System.out.println(FinalTeams[i] + " Wins !!!\n");
			}
			//Final	round
			for (int i=0; i<1; i++)
			{
				finalWinner = selectBetweenTwoTeams(FinalTeams[i*2], FinalTeams[i*2+1]);
				System.out.println("Final: " + FinalTeams[i*2] + " Vs " + FinalTeams[i*2+1]);
				System.out.println(finalWinner + " Wins !!!\n");
			}
			System.out.println("Do you want a different outcome? y or n");
			answer = keyIn.next();
		}while(answer.equalsIgnoreCase("y"));
		System.out.println("Thank you for using the JAVA Tournament Winner Predictor Program");
		keyIn.close();
	}
	
	//This method return an array of type integer containing a sequence from 0 to number, the parameter, in a random order
	//Each number has to be distinct. For example, if we input 8 as a parameter, we may get {2, 6, 4, 3, 5, 1, 0, 7}
	private static int[] randomSequence(int number)
	{
		boolean hasBeenSelected;
		int[] teamNumber = new int[number];
		Random randomGenerator = new Random();
		for (int i=0; i<number; i++)//use i to control the index of this array.
		{
			//Check whether it is equal to the numbers we have already selected.
			//If the new choice equals anyone of the previous selected numbers, change hasBeenSelected to true, and try again.
			do
			{
				hasBeenSelected = false;
				teamNumber[i] = randomGenerator.nextInt(number);
				for (int j=0; j<i; j++)
					if(teamNumber[i] == teamNumber[j])
						hasBeenSelected = true;
			}while(hasBeenSelected);
		}
		return teamNumber;
	}
	
	//Every round we need to select a winner between two teams. So I write a static method to avoid repeat.
	private static String selectBetweenTwoTeams(String team1, String team2)
	{
		Random randomGenerator = new Random();
		int r = randomGenerator.nextInt(2);
		if(r==0)
			return team1;
		else
			return team2;
	}

}
