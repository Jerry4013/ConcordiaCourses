
/**
 Class for basic pet records: name, age, and weight.
*/
public class Pet
{
    private String name;
    private int age;//in years
    private double weight;//in pounds

    // toString method
    public String toString( )
    {
        return ("Name: " + name + " Age: " + age + " years"
                       + "\nWeight: " + weight + " pounds");
    }

    // constructor
    public Pet(String initialName, int initialAge, double initialWeight)
    {
        name = initialName;
        if ((initialAge < 0) || (initialWeight < 0))
        {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
        else
        {
            age = initialAge;
            weight = initialWeight;
        }
    }

    // Mutator for all attributes
    public void set(String newName, int newAge, double newWeight)
    {
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

    // another constructor
    public Pet(String initialName)
    {
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
    public Pet(int initialAge)
    {
        name = "No name yet.";
        weight = 0;
        if (initialAge < 0)
        {
            System.out.println("Error: Negative age.");
            System.exit(0);
        }
        else
            age = initialAge;
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
    public Pet(double initialWeight)
    {
        name = "No name yet";
        age = 0;
        if (initialWeight < 0)
        {
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }
        else
            weight = initialWeight;
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
    public Pet( )
    {
        name = "No name yet.";
        age = 0;
        weight = 0; 
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
}
