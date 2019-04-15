
public class C4P13_BoxOfProduce {
	
	private String bundle1;
	private String bundle2;
	private String bundle3;
	
	public C4P13_BoxOfProduce()
	{
		bundle1 = "No produce";
		bundle2 = "No produce";
		bundle3 = "No produce";
	}
	public C4P13_BoxOfProduce(String bundle1, String bundle2, String bundle3)
	{
		this.bundle1 = bundle1;
		this.bundle2 = bundle2;
		this.bundle3 = bundle3;
	}
	
	public String getBundle1()
	{
		return bundle1;
	}
	public String getBundle2()
	{
		return bundle2;
	}
	public String getBundle3()
	{
		return bundle3;
	}
	
	public void setBundle1(String newBundle1)
	{
		bundle1 = newBundle1;
	}
	public void setBundle2(String newBundle2)
	{
		bundle2 = newBundle2;
	}
	public void setBundle3(String newBundle3)
	{
		bundle3 = newBundle3;
	}
	public void setBox(String newBundle1, String newBundle2, String newBundle3)
	{
		bundle1 = newBundle1;
		bundle2 = newBundle2;
		bundle3 = newBundle3;
	}
	
	public String toString()
	{
		return ("bundle1: " + bundle1 + "\nbundle2: " + bundle2 + "\nbundle3: " + bundle3);
	}
	
}
