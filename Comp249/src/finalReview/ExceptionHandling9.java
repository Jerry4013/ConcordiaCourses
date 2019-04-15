package finalReview;
//*******************************************************************
//ExceptionHandling9.java By: Aiman Hanna (C) 1993 - 2018
//This program illustrates the subject of re-throwing exceptions. 
//You should notice that this is merely a toy program to illustrate 
//the idea. 
//
//Key Points:
//1) Re-throwing an Exception. 
//*******************************************************************

import java.util.Scanner;

//Define a new exception class that targets all errors in relation to 
//division by zero
class DivisionByZeroException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor 
	public DivisionByZeroException()
	{
		// Since this class is particular for this type of errors; that is, 
		// division by zero, a message to that effect can be coded to that effect
		super("Error ... Division by zero detected. Cannot perform division operation.");
	}
	
	// A constructor that takes a String parameter
	public DivisionByZeroException(String s)
	{
		// Allows the possibility to display any other desired exception message
		super(s);
	}
	
	public String getMessage()
	{
		return super.getMessage();
	}
}


//Define a new exception class that targets trivial division cases where the divisor 
//is always zero 

class ResultIsAlwaysZeroException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor 
	public ResultIsAlwaysZeroException()
	{
		super("Trivial Division ... Result is Always 0.");
	}
	
	// A constructor that takes a String parameter
	public ResultIsAlwaysZeroException(String s)
	{
		// Allows the possibility to display any other desired exception message
		super(s);
	}
	
	public String getMessage()
	{
		return super.getMessage();
	}
}


class ExhaustedNumberOfAttemptsException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MAXIMUM_ALLOWED_ATTEMPTS = 3;
	private int numOfAttempts;
	// Constructor 
	public ExhaustedNumberOfAttemptsException()
	{
		numOfAttempts = 0;
	}
	
	// A constructor that takes a String parameter
	public ExhaustedNumberOfAttemptsException(String s)
	{
		// Allows the possibility to display any other desired exception message
		super(s);
		numOfAttempts = 0;
	}
	
	public String getMessage()
	{
		return super.getMessage();
	}
	
	public int getNumOfAttempts()
	{
		return numOfAttempts;
	}
	
	public void incNumOfAttempts()
	{
		
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		double d1, d2;
		
		numOfAttempts++;
		if (numOfAttempts >= MAXIMUM_ALLOWED_ATTEMPTS)
		{
			System.out.print("You have entered bad value " + MAXIMUM_ALLOWED_ATTEMPTS + " times.");
			System.out.print("\nNo more attempts will be allowed. Program will terminate immediately.");
			System.exit(0);
		}
		else
		{
			System.out.print("Just exhausted attempt # " + numOfAttempts + "........\nPlease enter two new values to perform a division: ");
			d1 = kb.nextDouble();
			d2 = kb.nextDouble();
			try
			{
				ExceptionHandling9.divide(d1, d2);
			}
			catch(DivisionByZeroException e)
			{
				String s = e.getMessage();
				System.out.println(s);
				try
				{
					// Throw, or possibly re-throw, myself. 
					// Why not: throw new ExhaustedNumberOfAttemptsException();?
					throw (this); 
				}
				catch(ExhaustedNumberOfAttemptsException e2)
				{
					e2.incNumOfAttempts();
				}
				
			}
			catch(ResultIsAlwaysZeroException e)
			{
				String s = e.getMessage();
				System.out.println(s);
			}
		}
			
		
	}
	
}

public class ExceptionHandling9{


	// A method that takes two double value and return the result of their division 
	// This method throws an exception in case division by zero is detected 
	// The method also targets the special trivial case when the result is always 
	// going to be zero 
	public static double divide(double x, double y) throws DivisionByZeroException, ResultIsAlwaysZeroException
	{
		double result;
		System.out.println("\nExecuting divide() ...");
		if (y == 0)
				throw new DivisionByZeroException("Error: Division by Zero Detected; Cannot Perform Division.");
		else if (x == 0)
				throw new ResultIsAlwaysZeroException("Trivial Division; Result is Always 0.");
		else
		{
			result = x/y;
			System.out.println("The result of dividing " + x + " by " + y + " is: " + result);
			return result;
		}

	}

	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		double d1, d2;
		
		System.out.print("Please enter two values to perform a division: ");
		d1 = kb.nextDouble();
		d2 = kb.nextDouble();
		
		try
		{
			// Call divide() to perform the division 
			divide(d1, d2);
		}
		catch(DivisionByZeroException e)
		{
			String s = e.getMessage();
			System.out.println(s);
			// Re-throw another exception that will handle number of failed attempts
			try
			{
				throw new ExhaustedNumberOfAttemptsException();
			}
			catch(ExhaustedNumberOfAttemptsException e2) 
			{
				e2.incNumOfAttempts();
			}
		}
		catch(ResultIsAlwaysZeroException e)
		{
			String s = e.getMessage();
			System.out.println(s);
		}
		finally
		{
			System.out.print("Program reached last statement.");
		}
		
	}

}

/* The Output 
Please enter two values to perform a division: 9 0

Executing divide() ...
Error: Division by Zero Detected; Cannot Perform Division.
Just exhausted attempt # 1........
Please enter two new values to perform a division: 3 0

Executing divide() ...
Error: Division by Zero Detected; Cannot Perform Division.
Just exhausted attempt # 2........
Please enter two new values to perform a division: 5 0

Executing divide() ...
Error: Division by Zero Detected; Cannot Perform Division.
You have entered bad value 3 times.
No more attempts will be allowed. Program will terminate immediately.
*/


/* Run Again
Please enter two values to perform a division: 9 0

Executing divide() ...
Error: Division by Zero Detected; Cannot Perform Division.
Just exhausted attempt # 1........
Please enter two new values to perform a division: 8 4

Executing divide() ...
The result of dividing 8.0 by 4.0 is: 2.0
Program reached last statement.
*/


/* Run Again
Please enter two values to perform a division: 9 0

Executing divide() ...
Error: Division by Zero Detected; Cannot Perform Division.
Just exhausted attempt # 1........
Please enter two new values to perform a division: 5 0

Executing divide() ...
Error: Division by Zero Detected; Cannot Perform Division.
Just exhausted attempt # 2........
Please enter two new values to perform a division: 6 3

Executing divide() ...
The result of dividing 6.0 by 3.0 is: 2.0
Program reached last statement.
*/

/* Run Again
Please enter two values to perform a division: 9 0

Executing divide() ...
Error: Division by Zero Detected; Cannot Perform Division.
Just exhausted attempt # 1........
Please enter two new values to perform a division: 8 0

Executing divide() ...
Error: Division by Zero Detected; Cannot Perform Division.
Just exhausted attempt # 2........
Please enter two new values to perform a division: 0 5

Executing divide() ...
Trivial Division; Result is Always 0.
Program reached last statement.
*/
