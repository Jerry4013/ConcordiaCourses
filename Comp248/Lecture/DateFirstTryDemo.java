//********************************************************************
// Author: W. Savitch (modified by L. Kosseim)
//
//  The driver program to test the DateFirstTry class
//********************************************************************

public class DateFirstTryDemo
{
   public static void main(String[] args)
   {
        // let's create 2 objects of the class DateFirstTry
        DateFirstTry date1, date2;
        date1 = new DateFirstTry( );
        date2 = new DateFirstTry( );
        
        // let's change the values of the object's attributes
        date1.month = "December";
        date1.day = 31;
        date1.year = 2007;
        System.out.println("date1:");
        date1.writeOutput( );

        date2.month = "July";
        date2.day = 4;
        date2.year = 1776;
        System.out.println("date2:");
        date2.writeOutput( );
    }
}



