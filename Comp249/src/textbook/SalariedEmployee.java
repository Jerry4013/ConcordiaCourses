package textbook;
public class SalariedEmployee extends Employee{

	private double salary;

	public SalariedEmployee(){}

	public SalariedEmployee(String theName, Date theDate, double theSalary)
	{
		super(theName, theDate);
		if (theSalary >= 0)
			salary = theSalary;
		else
		{
			System.out.println("Fatal Error: Negative salary.");
			System.exit(0);
		}
	}

	public SalariedEmployee(SalariedEmployee originalObject)
	{
		super(originalObject);
		salary = originalObject.salary;
	}

	public double getSalary()
	{
		return salary;
	}

	public double getPay()
	{
		return salary/12;
	}

	public void setSalary(double newSalary)
	{
		if (newSalary >= 0)
			salary = newSalary;
		else
		{
			System.out.println("Fatal Error: Negative salary.");
			System.exit(0);
		}
	}
	
	public String toString()
	{
		return (super.toString() + "\n$" + salary + " per year");
	}

	public boolean equals(SalariedEmployee anotherSalariedEmployee){
		return (super.equals(anotherSalariedEmployee) && salary == anotherSalariedEmployee.salary);
	}
	

}