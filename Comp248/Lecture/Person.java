

/**
 Class for a person with a name and dates for birth and death.
 Class invariant: A Person always has a date of birth, and if the Person 
 has a date of death, then the date of death is equal to or later than the
 date of birth.
*/
public class Person
{
    private String name;
    private Date1 born;
    private Date1 died;//null indicates still alive.

    public Person(String initialName, Date1 birthDate, Date1 deathDate)
    {
        if (consistent(birthDate, deathDate))
        {
            name = initialName;
            born = new Date1(birthDate);
            if (deathDate == null)
                died = null;
            else
                died = new Date1(deathDate);
         }
         else
         {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
         }
    }

    public Person(Person original)
    {
        if (original == null)
        {
            System.out.println("Fatal error.");
            System.exit(0);
        }

        name = original.name;
        born = new Date1(original.born);

        if (original.died == null)
            died = null;
        else
            died = new Date1(original.died);
    }

    public void set(String newName, Date1 birthDate, Date1 deathDate)
    {
        if (consistent(birthDate, deathDate))
        {
                name = newName;
                born = new Date1(birthDate);
                if (deathDate == null)
                    died = null;
                else
                    died = new Date1(deathDate);
         }
         else
         {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
         }
}

    public String toString( )
    {
        String diedString;
        if (died == null)
            diedString = ""; //Empty string
        else
            diedString = died.toString( );

        return (name + ", " + born + "-" + diedString);
    }

    public boolean equals(Person otherPerson)
    {
        if (otherPerson == null) 
            return false;
        else
            return (name.equals(otherPerson.name)
                    && born.equals(otherPerson.born)
                    && datesMatch(died, otherPerson.died) );
    }

    /**
     To match date1 and date2 must either be the same date or both be null.
    */
    private static boolean datesMatch(Date1 date1, Date1 date2)
    {
        if (date1 == null) 
            return (date2 == null);
        else if (date2 == null) //&& date1 != null
            return false;
        else // both dates are not null.
            return(date1.equals(date2));
    }

    /**
     Precondition: newDate is a consistent date of birth.
     Postcondition: Date of birth of the calling object is newDate.
    */
    public void setBirthDate(Date1 newDate)
    {
        if (consistent(newDate, died))
            born = new Date1(newDate);
        else
        {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
        }
    }

    /**
     Precondition: newDate is a consistent date of death.
     Postcondition: Date of death of the calling object is newDate.
    */
    public void setDeathDate(Date1 newDate)
    {
    
        if (!consistent(born, newDate))
        {
            System.out.println("Inconsistent dates. Aborting.");
            System.exit(0);
        }

        if (newDate == null)
            died = null;
        else
            died = new Date1(newDate);
    }

    public void setName(String newName)
    {
        name = newName;
    }

     /**
     Precondition: The date of birth has been set, and changing the year
     part of the date of birth will give a consistent date of birth.
     Postcondition: The year of birth is (changed to) newYear.
    */
    public void setBirthYear(int newYear)
    {
        if (born == null) //Precondition is violated
        {
             System.out.println("Fata; Error. Aborting.");
             System.exit(0);
        }
        born.setYear(newYear);
        if (!consistent(born, died))
        {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
        }
    }
 
    /**
     Precondition: The date of death has been set, and changing the year
     part of the date of death will give a consistent date of death.
     Postcondition: The year of death is (changed to) newYear.
    */
    public void setDeathYear(int newYear)
    {
        if (died == null) //Precondition is violated
        {
             System.out.println("Fata; Error. Aborting.");
             System.exit(0);
        }
        died.setYear(newYear);
        if (!consistent(born, died))
        {
             System.out.println("Inconsistent dates. Aborting.");
             System.exit(0);
        }
    }

    public String getName( )
    {
        return name;
    }

    public Date1 getBirthDate( )
    {
        return new Date1(born);
    }

    public Date1 getDeathDate( )
    {
        if (died == null)
            return null;
        else
            return new Date1(died);
     }

    /**
     To be consistent, birthDate must not be null. If there is no date of
     death (deathDate == null), that is consistent with any birthDate.
     Otherwise, the birthDate must come before or be equal to the deathDate.
    */

    private static boolean consistent(Date1 birthDate, Date1 deathDate)
    {
        if (birthDate == null)
            return false;
        else if (deathDate == null)
            return true;
        else 
            return (birthDate.precedes(deathDate ) || birthDate.equals(deathDate ));
    }
}