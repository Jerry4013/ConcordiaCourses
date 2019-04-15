import java.util.Scanner;
public class C6P2_GameOfIdenticalNumbers {
	private int numberOfRows;
	private int numberOfColomns;
	private C6P2_Cards[][] cards;
	private Scanner kb;
	
	public C6P2_GameOfIdenticalNumbers()
	{
		setNewGame();
	}
	
	public void setNewGame()
	{
		setNumberOfRows();
		setNumberOfColomns();
		cards = new C6P2_Cards[numberOfRows][numberOfColomns];
		setCards();
		System.out.println();
	}
	
	public void play()
	{
		displayCurrent();
		while(!gameEnd())
			selectTwoCards();
	}
	
	private void setNumberOfRows()
	{
		kb = new Scanner(System.in);
		System.out.print("Enter the number of rows of your game: ");
		int rowNumber = kb.nextInt();
		while (rowNumber<2)
		{
			System.out.println("Please enter a positive integer larger than 1!");
			System.out.print("Enter the number of rows of your game: ");
			rowNumber = kb.nextInt();
		}
		numberOfRows = rowNumber;
	}
	
	private void setNumberOfColomns()
	{
		kb = new Scanner(System.in);
		System.out.print("Enter the number of columns of your game: ");
		int columnNumber = kb.nextInt();
		while (columnNumber<2)
		{
			System.out.println("Please enter a positive integer larger than 1!");
			System.out.print("Enter the number of columns of your game: ");
			columnNumber = kb.nextInt();
		}
		while (numberOfRows%2==1&&columnNumber%2==1)
		{
			System.out.println("At least one of the rows number or colomn number must be even.");
			System.out.print("Enter the number of columns of your game: ");
			columnNumber = kb.nextInt();
		}
		numberOfColomns = columnNumber;
	}
	
	public void setCards()
	{
		int numberOfCards = numberOfRows * numberOfColomns;
		int[] index = new int[numberOfCards];
		int[] temp = new int[numberOfCards];
		for(int i=0; i<numberOfCards; i++)
		{
			if (i<numberOfCards/2)
				temp[i] = i;
			else
				temp[i] = i - numberOfCards/2;
		}
		int[] randomIndex = RandomSequence.generateRandomSequence(numberOfCards);
		for (int i=0; i<numberOfCards; i++)
			 index[i] = temp[randomIndex[i]];
			
		int counter = 0;
		for (int i=0; i<numberOfRows; i++)
			for (int j=0; j<numberOfColomns; j++)
			{
				cards[i][j] = new C6P2_Cards(index[counter]+1);
				counter++;
			}
	}
	
	public void displayCurrent()
	{
		for (int i=0; i<numberOfColomns; i++)
			System.out.print("\t" + (i+1));
		System.out.print("\n    ");
		for (int i=0; i<numberOfColomns; i++)
			System.out.print("--------");
		System.out.println();
		for (int i=0; i<numberOfRows; i++)
		{
			System.out.printf("%-3d|\t",(i+1));
			for (int j=0; j<numberOfColomns; j++)
				System.out.print(cards[i][j]+"\t");
			System.out.println();
			System.out.printf("%-3s|\n","");
		}
	}
	
	public void displayAll()
	{
		for (int i=0; i<numberOfColomns; i++)
			System.out.print("\t" + (i+1));
		System.out.print("\n    ");
		for (int i=0; i<numberOfColomns; i++)
			System.out.print("--------");
		System.out.println();
		for (int i=0; i<numberOfRows; i++)
		{
			System.out.printf("%-3d|\t",(i+1));
			for (int j=0; j<numberOfColomns; j++)
			{
				cards[i][j].changeFaceToUp();
				System.out.print(cards[i][j]+"\t");
			}
			System.out.println();
			System.out.printf("%-3s|\n","");
		}
	}
	
	private boolean gameEnd()
	{
		boolean isEnd = true;
		for (int i=0; i<numberOfRows; i++)
			for (int j=0; j<numberOfColomns; j++)
				if(cards[i][j].getFace().equals("down"))
					isEnd = false;
		return isEnd;
	}
	
	private void selectTwoCards()
	{
		kb = new Scanner(System.in);
		int row1, column1, row2, column2;
		boolean selected = false;
		System.out.println("Select two cards to turn over:");
		do
		{
			selected = false;
			System.out.println("First card (Enter the row and the column): ");
			row1 = kb.nextInt();
			column1 = kb.nextInt();	
			if(cards[row1-1][column1-1].getFace().equals("up"))
			{
				System.out.println("This card is already displayed, choose another one.");
				selected = true;
			}
		}
		while(selected);
		cards[row1-1][column1-1].changeFaceToUp();
		
		do
		{
			selected = false;
			System.out.println("Second card (Enter the row and the column): ");
			row2 = kb.nextInt();
			column2 = kb.nextInt();	
			if(cards[row2-1][column2-1].getFace().equals("up"))
			{
				System.out.println("This card is already displayed, choose another one.");
				selected = true;
			}
		}
		while(selected);
		cards[row2-1][column2-1].changeFaceToUp();
		System.out.println();
		displayCurrent();
		
		if(cards[row1-1][column1-1].getValue()!=cards[row2-1][column2-1].getValue())
		{
			cards[row1-1][column1-1].changeFace();
			cards[row2-1][column2-1].changeFace();
			System.out.println("\nUnmatched cards will be rechange to * in 5 seconds...");
			timer5Seconds();
			for(int i=0;i<400;i++)
				System.out.println();
			displayCurrent();
			for(int i=0;i<3;i++)
				System.out.println();
		}
	}
	
	public void timer5Seconds()
	{
		 try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
	}
	
}
