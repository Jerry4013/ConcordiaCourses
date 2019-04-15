
public class T9Q1_CardDriver {

	public static void main(String[] args) {
		
		T9Q1_PlayingCard mySecondCard = new T9Q1_PlayingCard();
		mySecondCard.randomCard();
		
		do
		{
			mySecondCard.randomCard(); 
			System.out.println(mySecondCard.isAFace());
			mySecondCard.writeOutput();
		}
		while (mySecondCard.isAFace());
		
	}

}
