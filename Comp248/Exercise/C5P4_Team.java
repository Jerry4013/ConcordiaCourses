
public class C5P4_Team {
	private String teamName;
	private String name1, name2, name3, name4;
	private C5P4_Competition competition1, competition2;
	
	public C5P4_Team(String teamName, String name1, String name2, String name3, String name4, 
			C5P4_Competition competition1, C5P4_Competition competition2)
	{
		
	}
	
	public C5P4_Team(C5P4_Team anotherTeam)
	{
		if(anotherTeam==null)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		teamName = anotherTeam.teamName;
		name1 = anotherTeam.name1;
		name2 = anotherTeam.name2;
		name3 = anotherTeam.name3;
		name4 = anotherTeam.name4;
		if(anotherTeam.competition1==null)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		competition1 = new C5P4_Competition(anotherTeam.competition1);
		if(anotherTeam.competition2==null)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		competition2 = new C5P4_Competition(anotherTeam.competition2);
	}
	
	public void display()
	{
		System.out.println("Team name: " + teamName + "\nTeam members: " + name1 + ", " + name2 + ", " + name3 + ", " + name4);
		System.out.println(competition1);
		System.out.println(competition2);
	}
}
