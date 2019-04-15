//********************************************************************
// Author: W. Savitch (modified by L. Kosseim)
//
//  This program demonstrates how to read tokens from
//  the console with the Scanner class
//********************************************************************

import java.util.Scanner; // we need to import this class

public class ScannerDemo
{
   public static void main(String[] args)
   {
      // let's declare our scanner
      Scanner keyboard = new Scanner(System.in);

      // let's ask the user for some input
      System.out.println("Enter the number of pods followed by");
      System.out.println("the number of peas in a pod:");
      
      // let's read the user input (2 integers that we assign to 2 variables)
      int numberOfPods = keyboard.nextInt( );
      int peasPerPod = keyboard.nextInt( );

      int totalNumberOfPeas = numberOfPods*peasPerPod;

      // let's display some output
      System.out.print(numberOfPods + " pods and ");
      System.out.println(peasPerPod + " peas per pod.");
      System.out.println("The total number of peas = " 
                                          + totalNumberOfPeas);
      keyboard.close();
   }
}
