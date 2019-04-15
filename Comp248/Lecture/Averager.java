//********************************************************************
// Author: W. Savitch (modified by L. Kosseim)
//
//  This program computes the average of marks.  The last mark will be
// indicated by a negative number (not to be averaged)
//********************************************************************

import java.util.Scanner; // to read form the console

public class Averager
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a list of nonnegative scores.");
        System.out.println("Mark the end with a negative number.");
        System.out.println("I will compute their average.");

        double next, sum = 0; // the next mark and the cummulative sum
        int count = 0; // the number of marks read so far

        // let's read a first mark
        next = keyboard.nextDouble( );
        while(next >= 0) // while the mark is not negative
        {
            sum = sum + next; // we add it to the cummulative sum
            count++;          // we count one more mark
            next = keyboard.nextDouble( ); // we read the next mark
        }

        if (count == 0) // if the user types in no mark
            System.out.println("No scores entered."); // display a message
        else            // otherwise
        {
            double average = sum/count; // computer average
            System.out.println(count + " scores read."); // display how many marks were read
            System.out.println("The average is " + average); // display the average
        }
        keyboard.close();
    }
}

 
