
public class C6P3_Student {
	private String name;
	private String id;
	private int[] arrMarks = new int[5];
	private int arrUsed = 5;
	
	public C6P3_Student(String initialName, String initialID, int[] marks)
	{
		name = initialName;
		if (initialID.length()>8)
		{
			System.out.println("invalidate ID! Aborting!");
			System.exit(0);
		}
		id = initialID;
		for(int i=0; i<5; i++)
			arrMarks[i] = marks[i];
	}
	
	public void validateMarks()
	{
		for(int i=0; i<5; i++)
			if(arrMarks[i]<0||arrMarks[i]>100)
			{
				for(int j=i+1; j<5; j++)
					arrMarks[j-1] = arrMarks[j];
				arrUsed--;
			}
	}
	
	public String toString()
	{
		String markString="";
		for(int i=0; i<arrUsed; i++)
			markString +=  arrMarks[i] + "  ";
		return("Name: " + name + "   id: " + id + "   Marks: " + markString);
	}
	
	
}
