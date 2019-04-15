import java.util.Scanner;

public class C6ST15_GolfScores
{
    public static final int MAX_NUMBER_SCORES = 10;
    private static double[] score = new double[MAX_NUMBER_SCORES];
    private static int numberUsed=0;
    /**
     Shows differences between each of a list of golf scores and their average.
    */
    public static void main(String[] args) 
    {
        System.out.println("This program reads golf scores and shows");
        System.out.println("how much each differs from the average.");

        System.out.println("Enter golf scores:");
        fillArray();
        showDifference();
    }

    /**
     Reads values into the array a. Returns the number of values placed in the array a.
    */
    public static void fillArray() 
    {
        System.out.println("Enter up to " + score.length + " nonnegative numbers.");
        System.out.println("Mark the end of the list with a negative number.");
        Scanner keyboard = new Scanner(System.in);

        double next;
        int index = 0;
        next = keyboard.nextDouble();
        while ((next >= 0) && (index < score.length))
        {
            score[index] = next;
            index++;
            next = keyboard.nextDouble( );
           //index is the number of array indexed variables used so far.
        }
       //index is the total number of array indexed variables used.

        if (next >= 0)
             System.out.println("Could only read in " + score.length + " input values.");
        keyboard.close();
        numberUsed = index;  
    } 

    /**
     Precondition: numberUsed <= a.length.
                   a[0] through a[numberUsed-1] have values.
     Returns the average of numbers a[0] through a[numberUsed-1].
    */
   
    public static double computeAverage()
    {
        double total = 0;
        for (int index = 0; index < numberUsed; index++)
            total = total + score[index];
        if (numberUsed > 0)
        {
            return (total/numberUsed);
        }
        else
        {
            System.out.println("ERROR: Trying to average 0 numbers.");
            System.out.println("computeAverage returns 0.");
            return 0;
        }
    }
 
    /**
     Precondition: numberUsed <= a.length.
                   The first numberUsed indexed variables of a have values.
      Postcondition: Gives screen output showing how much each of the first
      numberUsed elements of the array a differ from their average.
    */
    public static void showDifference()
    {
        double average = computeAverage();
        System.out.println("Average of the " + numberUsed + " scores = " + average);
        System.out.println("The scores are:");
        for (int index = 0; index < numberUsed; index++)
        	System.out.println(score[index] + " differs from average by " + (score[index] - average));
    }
}