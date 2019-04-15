
public class C6P2_Cards {
	private int value;
	private String face;
	
	public C6P2_Cards(int value)
	{
		if (value<=0)
		{
			System.out.println("We only play with positive integer.");
			System.exit(0);
		}
		this.value = value;
		face = "down";
	}
	
	public String getFace()
	{
		return face;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void changeFace()
	{
		if (face.equals("up"))
			face = "down";
		else
			face = "up";
	}
	
	public boolean equals(C6P2_Cards anotherCard)
	{
		return(this.value == anotherCard.value);
	}
	
	public String toString()
	{
		if (face.equals("up"))
			return (Integer.toString(value));
		else
			return "*";
	}
	
	public void changeFaceToUp()
	{
		face = "up";
	}
	
	
}
