//********************************************************************
// Author: W. Savitch (modified by L. Kosseim)
//
//  This program demonstrates how to read various types of token with
//  the Scanner class
//********************************************************************

import java.util.Scanner;

public class ScannerDemo2
{
    public static void main(String[] args)
    {
        // let's try to read integers
        int n1, n2; // let's declare 2 variables for our tests
        Scanner scannerObject = new Scanner(System.in);  // let's declare our scanner object

        System.out.println("Enter two whole numbers");
        System.out.println("separated by one or more spaces:");

        n1 = scannerObject.nextInt( );  // we read 1 integer and assign it to n1
        n2 = scannerObject.nextInt( );  // we read another integer and assign it to n2
        System.out.println("You entered " + n1 + " and " + n2);

        System.out.println("Next enter two numbers.");
        System.out.println("Decimal points are allowed.");

        // let's try to read doubles now
        double d1, d2;
        d1 = scannerObject.nextDouble( );
        d2 = scannerObject.nextDouble( );
        System.out.println("You entered " + d1 + " and " + d2);

        // let's try to read 2 "words" now
        System.out.println("Next enter two words:");

        String word1 = scannerObject.next( );
        String word2 = scannerObject.next( );
        System.out.println("You entered \"" + 
                                word1 + "\" and \"" + word2 + "\"");

        String line = scannerObject.nextLine( ); //To get rid of '\n'

        // let's try to read an entire line
        System.out.println("Next enter a line of text:");
        line = scannerObject.nextLine( );
        System.out.println("You entered: \"" + line + "\"");
        scannerObject.close();
    }
}

