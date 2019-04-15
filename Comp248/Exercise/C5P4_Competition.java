
public class C5P4_Competition {
	private String name, nameOfWinner, nameOfRunnerUp;
	private int year;
	
	public C5P4_Competition(String name, String nameOfWinner, String nameOfRunnerUp, int year)
	{
		this.name = name;
		this.nameOfWinner = nameOfWinner;
		this.nameOfRunnerUp = nameOfRunnerUp;
		if(year<1900||year>2018)
		{
			System.out.println("Fatal error!");
			System.exit(0);
		}
		this.year = year;
	}
	
	public C5P4_Competition(C5P4_Competition anotherCompetition)
	{
		name = anotherCompetition.name;
		nameOfWinner = anotherCompetition.nameOfWinner;
		nameOfRunnerUp = anotherCompetition.nameOfRunnerUp;
		year = anotherCompetition.year;
	}
	
	public String toString()
	{
		return ("Competition " + name + " in " + year + ": \nWinner: " + nameOfWinner + "\nRunner Up: " + nameOfRunnerUp);
	}
	
}
