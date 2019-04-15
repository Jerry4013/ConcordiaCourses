//********************************************************************
// Author: W. Savitch (modified by L. Kosseim)
//
//  This program demonstrates how to use the "Bill" class (int Bill.java)
//  This file is the driver because it contains the "main" method
//********************************************************************

public class BillingDialog
{
   public static void main(String[] args)
   {
        System.out.println("Welcome to the law offices of");
        System.out.println("Dewey, Cheatham, and Howe.");
        
        // create a new Bill object
        Bill yourBill = new Bill( );
        
        // call a few (public) methods of the Bill class
        yourBill.inputTimeWorked( );
        yourBill.updateFee( );
        yourBill.outputBill( );
        
        System.out.println("We have placed a lien on your house.");
        System.out.println("It has been our pleasure to serve you.");
     }
}
