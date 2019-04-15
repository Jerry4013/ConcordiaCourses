//********************************************************************
// Author: W. Savitch (modified by L. Kosseim)
//
//  This class represents a "bill".  The driver program is BillingDialog.java
//********************************************************************

import java.util.Scanner;

public class Bill
{
    // constants and variables of the class
    public static double RATE = 150.00; //Dollars per quarter hour

    private int hours; // the nb of hours worked
    private int minutes; // the nb of minutes worked
    private double fee; // the fee to charge

    // method inputTimeWorked
    // result: none (void)
    // arguments: none
    // description: askes the user for the time worked and sets the variables accordingly
    public void inputTimeWorked( )
    {
        System.out.println("Enter number of full hours worked");
        System.out.println("followed by number of minutes:");
        Scanner keyboard = new Scanner(System.in);
        hours = keyboard.nextInt( );
        minutes = keyboard.nextInt( );
        keyboard.close();
    }

    // method outputBill
    // result: double: the fee to charge
    // arguments: 2 integers: the time worked - hours and minutes
    // description: computes the fee to charge 
    public double computeFee(int hoursWorked, int minutesWorked)
    {
        minutesWorked = hoursWorked*60 + minutesWorked;
        int quarterHours = minutesWorked/15; //Any remaining fraction of a
                                         // quarter hour is not charged for.
        return quarterHours*RATE;
    }

    // method outputBill
    // result: none (void)
    // arguments: none
    // description: changes the value the variable fee according to the time worked
     public void updateFee( )
    {
        fee = computeFee(hours, minutes);
    }
    
    // method outputBill
    // result: none (void)
    // arguments: none
    // description: displays the various variables of the class
    public void outputBill( )
    {
        System.out.println("Time worked: ");
        System.out.println(hours + " hours and " + minutes + " minutes");
        System.out.println("Rate: $" + RATE + " per quarter hour.");
        System.out.println("Amount due: $" + fee);
    }
}
