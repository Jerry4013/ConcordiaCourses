
public class C4P10_Pet
{
    private String name;
    private int age;//in years
    private double weight;//in pounds
    private String type;
    // toString method
    public String toString( )
    {
        return ("Type: " + type + "  Name: " + name + " Age: " + age + " years"
                       + "\nWeight: " + weight + " pounds");
    }

    // constructor
    public C4P10_Pet(String initialType, String initialName, int initialAge, double initialWeight)
    {
    	set(initialType, initialName, initialAge, initialWeight);
    }

    // Mutator for all attributes
    public void set(String newType, String newName, int newAge, double newWeight)
    {
    	type = newType;
        name = newName;
        if ((newAge < 0) || (newWeight < 0))
        {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
        else
        {
            age = newAge;
            weight = newWeight;
        }
    }
    
    public void setType(String newType)
    {
       if (newType.equalsIgnoreCase("dog")|| newType.equalsIgnoreCase("cat"))
    	   type = newType; 
       else
       {
    	   System.out.println("Invalid type!");
    	   System.exit(0);
       }
    }
    
    // another constructor
    public C4P10_Pet(String initialName)
    {
        type = "Unknown";
    	name = initialName;
        age = 0;
        weight = 0;
    } 

    // mutator for the name attribute
    public void setName(String newName)
    {
        name = newName; 
    }
    
    // another constructor
    public C4P10_Pet(int initialAge)
    {
    	type = "Unknown";
        name = "No name yet.";
        weight = 0;
        setAge(initialAge);
    }

     // mutator for the age attribute
    public void setAge(int newAge)
    {
        if (newAge < 0)
        {
            System.out.println("Error: Negative age.");
            System.exit(0);
        }
        else
            age = newAge;
    }

    // another constructor
    public C4P10_Pet(double initialWeight)
    {
    	type = "Unknown";
        name = "No name yet";
        age = 0;
        setWeight(initialWeight);
    }

    // mutator for the weight attribute
    public void setWeight(double newWeight)
    {
        if (newWeight < 0)
        {
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }
        else
            weight = newWeight;
    }

    // another constructor
    public C4P10_Pet( )
    {
    	type = "Unknown";
        name = "No name yet.";
        age = 0;
        weight = 0; 
    }

    public String getType( )
    {
        return type;
    }
    
    // accessor for the name attribute
    public String getName( )
    {
        return name;
    }

     // accessor for the age attribute
    public int getAge( )
    {
        return age;
    }

    // accessor for the weight attribute
    public double getWeight( )
    {
        return weight;
    }
    
    public double acepromazine()
    {
    	double dosage = 0;
    	if (type.equalsIgnoreCase("dog"))
    		dosage = (weight / 2.2) * (0.03 / 10);
    	else if (type.equalsIgnoreCase("cat"))
    		dosage = (weight / 2.2) * (0.002 / 10);
    	return dosage;
    }
    
    public double carprofen()
    {
    	double dosage = 0;
    	if (type.equalsIgnoreCase("dog"))
    		dosage = (weight / 2.2) * (0.5 / 12);
    	else if (type.equalsIgnoreCase("cat"))
    		dosage = (weight / 2.2) * (0.25 / 12);
    	return dosage;
    }
    
}
