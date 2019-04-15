import java.util.Scanner;

public class C4P8_Date
{

    private int month;  
    private int day;       
    private int year; 
    
    public C4P8_Date( )
    {
        month = 1;
        day = 1;
        year = 1000;
    }

    public C4P8_Date(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    public C4P8_Date(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

    public C4P8_Date(int year)
    {
        setDate(1, 1, year);
    }

    public C4P8_Date(C4P8_Date aDate)
    {
        if (aDate == null)//Not a real date.
        {
             System.out.println("Fatal Error.");
             System.exit(0); // quit the program now!
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }

    public void setDate(int monthInt, int day, int year)
    {
        if (dateOK(monthInt, day, year))
        {
            this.month = monthInt;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthNumber(monthString);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(int year)
    {
        setDate(1, 1, year);
    }

    public void setYear(int year)
    {
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.year = year;
    }

    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            month = monthNumber;
    }

    public void setDay(int day)
    {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.day = day;
    }

    public int getMonth( )
    {
        return month;
    }
   

    public int getDay( )
    {
        return day;
    }

    public int getYear( )
    {
        return year;
    }

    // method toString
    // result: string 
    // arguments: none
    // description: returns a string containing the values of the attributes in a nice format
    public String toString( )
    {
        return (month + " " + day + ", " + year);
    }

    // method equals
    // result: boolean 
    // arguments: a Date object
    // description: returns true if the argument represents the same date as the receiving object
    public boolean equals(C4P8_Date otherDate)
    {
        return ( (month == otherDate.month)
                  && (day == otherDate.day) && (year == otherDate.year) );
    }

    // method precedes
    // result: boolean 
    // arguments: a Date object
    // description: returns true if the the receiving object precedes the argument
    public boolean precedes(C4P8_Date otherDate)
    {
        return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month == otherDate.month && day < otherDate.day) );
    }

    public void readInput( )
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
              System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
         }
        keyboard.close();
    }

    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    private int monthNumber(String monthString)
    {
        if (monthString.equals("January"))
            return 1;
        else if (monthString.equals("February"))
            return 2;
        else if (monthString.equalsIgnoreCase("March"))
            return 3;
        else if (monthString.equalsIgnoreCase("April"))
            return 4;
        else if (monthString.equalsIgnoreCase("May"))
            return 5;
        else if (monthString.equals("June"))
            return 6;
        else if (monthString.equalsIgnoreCase("July"))
            return 7;
        else if (monthString.equalsIgnoreCase("August"))
            return 8;
        else if (monthString.equalsIgnoreCase("September"))
            return 9;
        else if (monthString.equalsIgnoreCase("October"))
            return 10;
        else if (monthString.equals("November"))
            return 11;
        else if (monthString.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }
    
}
