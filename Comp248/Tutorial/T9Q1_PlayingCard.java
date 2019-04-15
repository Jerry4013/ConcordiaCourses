
public class T9Q1_PlayingCard {
	
	private int value; // ex. 1 (ace) to 13 (king)
	private String color; // ex: "heart" "diamond" "club" "spade"
	public void writeOutput() //error1: private to public
	{
		System.out.println(value + " of " + color);
	}
	public void randomCard()
	{
		value = (int)(Math.random()*13)+1;// a random integer between [1..13] 
		switch ((int)(Math.random()*4)+1) // a random integer between [1..4]
		{
		case 1: color = "heart"; 
		break; 
		case 2: color = "diamond"; 
		break; 
		case 3: color = "spade"; 
		break; 
		case 4: color = "club";
		break;
		}
	
	}
	public boolean isAFace()
	{
	// is the value a jack (11), a queen (12) or a king (13)? 
		return (value == 11 || value == 12 || value == 13);
	}
	public boolean isAnAce()
	{
		return (value == 1);
	}
	
	public String toString()
	{
		return (value + " of " + color);
	}
	
	
}
