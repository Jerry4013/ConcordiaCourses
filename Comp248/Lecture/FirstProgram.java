//********************************************************************
// Author: W. Savitvh (modified by L. Kosseim)
//
//  A first Java program that displays messages on the screen 
// and does a simple addition.
//********************************************************************

public class FirstProgram
{
    public static void main(String[] args)
    {
        // display messages (strings) on the screen
        System.out.println("Hello reader.");
        System.out.println("Welcome to Java.");

        System.out.println("Let's demonstrate a simple calculation.");
        int answer;  // answer is a variable
        answer = 2 + 2; // we assign to the variable the value of 2+2 (ie... 4 :-)
        System.out.println("2 plus 2 is " + answer); // we display the value of the variable on the screen
    }
}
