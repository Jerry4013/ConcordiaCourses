package textbook.chapter13.selftest;

//********************************************************************
// Author: W. Savitch (modified by L. Kosseim)
//
//  The Date class represents a date.
//********************************************************************
import java.util.Scanner;

public class Date implements Cloneable{
    // the attributes that represents a data
    private String month;  
    private int day;       
    private int year; //a four digit number.

    // the constructor with no argument
    public Date( )
    {
        month = "January";
        day = 1;
        year = 1000;
    }

    // the constructor with 3 arguments (the initial values of the attributes)
    // here the month is indicated by an integer (1-12)
    public Date(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    // the constructor with 3 arguments (the initial values of the attributes)
    // here the month is indicated by a string
    public Date(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

    // the constructor with only 1 argument (the year)
    public Date(int year)
    {
        setDate(1, 1, year);
    }
    
    // the copy constructor with 1 argument (another Date object) 
    public Date(Date aDate)
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

    // method setDate
    // result: none (void)
    // arguments: 3 int: the values to set for each attribute
    // description: checks that the given values are in the correct range for each attribute.  
    //              if so, sets the attributes to these values.  
    //              otherwise, just quit the program
    public void setDate(int monthInt, int day, int year)
    {
        if (dateOK(monthInt, day, year))
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    // method setDate
    // result: none (void)
    // arguments: 1 string (the month) and 2 int: the values to set for each attribute
    // description: checks that the given values are in the correct range for each attribute.  
    //              if so, sets the attributes to these values.  
    //              otherwise, just quit the program
    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    // method setDate
    // result: none (void)
    // arguments: 1 int: the year to set
    // description: sets the year to the given value and sets the day and the month to 1 (jan. 1)
    public void setDate(int year)
    {
        setDate(1, 1, year);
    }

    // method setYear
    // result: none (void)
    // arguments: 1 int: the year to set
    // description: checks that the given value is valid, then sets the year attribute to this value
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

    // method setMonth
    // result: none (void)
    // arguments: 1 int: the month to set
    // description: checks that the given value is valid, then sets the month attribute to this value
    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    // method setDay
    // result: none (void)
    // arguments: 1 int: the day to set
    // description: checks that the given value is valid, then sets the day attribute to this value
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

    // method setDay
    // result: int (the rank of the month)
    // arguments: none
    // description: returns the rank of the month attribute
    public int getMonth( )
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

    // method getDay
    // result: int (the day)
    // arguments: none
    // description: returns the value of the day attribute
    public int getDay( )
    {
        return day;
    }

 
    // method getYear
    // result: int (the yeat)
    // arguments: none
    // description: returns the value of the year attribute
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
    public boolean equals(Date otherDate)
    {
        return ( (month.equals(otherDate.month))
                  && (day == otherDate.day) && (year == otherDate.year) );
    }

    // method precedes
    // result: boolean 
    // arguments: a Date object
    // description: returns true if the the receiving object precedes the argument
    public boolean precedes(Date otherDate)
    {
        return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                         && day < otherDate.day) );
    }

    // method readInput
    // result: void 
    // arguments: none
    // description: asks the user to input a date and set the receiving object to these values
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

    // method dateOK
    // result: boolean 
    // arguments: 3 int (the values of the month, day and year)
    // description: returns true if the 3 arguments represent a valid date
    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    // method dateOK
    // result: boolean 
    // arguments: 1 string & 2 int (the values of the month, day and year)
    // description: returns true if the 3 arguments represent a valid date
    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    // method monthOK
    // result: boolean 
    // arguments: 1 string (the month)
    // description: returns true if the argument represents a valid month
    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    // method monthString
    // result: String 
    // arguments: 1 int (the month)
    // description: returns the name (as a string) corresponding to the rank of the month (the argument)
    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
            System.out.println("Fatal Error");
            System.exit(0);
            return "Error"; //to keep the compiler happy
        }
    }
    
    public Object clone(){
    	try{
    		return super.clone();
    	}catch(CloneNotSupportedException e){
    		return null;
    	}
    }
}
