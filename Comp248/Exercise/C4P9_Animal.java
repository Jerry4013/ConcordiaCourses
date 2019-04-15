import java.text.DecimalFormat;
public class C4P9_Animal {
	private String name;
	private double population;
	private double rate;
	
	public C4P9_Animal()
	{
		name = "No name";
		population = 0;
		rate = 0;
	}
	
	public C4P9_Animal(String name, double population)
	{
		setName(name);
		setPopulation(population);
		rate = 0;
	}
	
	public C4P9_Animal(String name, double population, double rate)
	{
		setSpecies(name, population, rate);
	}
	
	public void setSpecies(String name, double population, double rate)
	{
		setName(name);
		setPopulation(population);
		setRate(rate);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPopulation(double population)
	{
		if(population>0)
			this.population = population;
		else
		{
			System.out.println("Invalid population!");
			System.exit(0);
		}
	}
	
	public void setRate(double rate)
	{
		this.rate = rate / 100.0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPopulation()
	{
		return (Math.round(population * 100.0) / 100.0);
	}
	
	public double getRate()
	{
		return rate;
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		DecimalFormat percent = new DecimalFormat("0.00%");
		return ("Name: " + name + "\nPopulation: " + df.format(population) + "\nGrowth rate: " + percent.format(rate));
	}
	
	public boolean equals(C4P9_Animal anotherAnimal)
	{
		return (name.equalsIgnoreCase(anotherAnimal.name));
	}
	
	public boolean endangered()
	{
		return (rate<0);
	}
}
