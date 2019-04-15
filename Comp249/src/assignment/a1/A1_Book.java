package assignment.a1;
/**
 * Name(s) and ID(s): Jingchao Zhang 40049474 <br>
 * COMP249 <br>
 * Assignment # 1 <br>
 * Due Date: Jan 31, 2018 <br>
 * Purpose: Defining the Book class
 */

// -----------------------------------------------------
// Assignment 1
// Question: Part 1
// Written by: Jingchao Zhang 40049474
// -----------------------------------------------------

public class A1_Book {
	private String title;
	private String author;
	private long ISBN;
	private double price;
	private static int createdBookCounter;

	public A1_Book()
	{	
		title = "No title";
		author = "No author";
		ISBN = 0;
		price = 0;
		createdBookCounter++;
	}

	/**
	 * 
	 * @param theTitle The title of the new book
	 * @param theAuthor the author of the new book
	 * @param theISBN the ISBN of the new book, a 10 digits or 13 digits long number
	 * @param thePrice the price of the new book, larger than or equal to 0
	 */
	public A1_Book(String theTitle, String theAuthor, long theISBN, double thePrice)
	{
		title = theTitle;
		author = theAuthor;
		if(validISBN(theISBN))
			ISBN = theISBN;
		else
		{
			System.out.println("ISBN must be 10 digits long or 13 digits long. Please update your ISBN asap!");
			ISBN = theISBN;
		}
			
		if(thePrice>=0)
			price = thePrice;
		else 
		{
			System.out.println(":( Fatal Error! Price cannot be negative. System terminated.");
			System.exit(0);
		}
		createdBookCounter++;
	}

	/**
	 * 
	 * @param anotherBook another Book object, the same as the book we want to create
	 */
	public A1_Book(A1_Book anotherBook)
	{
		if(anotherBook == null)
		{
			System.out.println(":( Fatal error. This book does not exist. System terminated.");
			System.exit(0);
		}
		title = anotherBook.title;
		author = anotherBook.author;
		ISBN = anotherBook.ISBN;
		price = anotherBook.price;
		createdBookCounter++;
	}
	
	/**
	 * Accessor method
	 * @return The title of this book.
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Accessor method
	 * @return The author of this book.
	 */
	public String getAuthor()
	{
		return author;
	}
	
	/**
	 * Accessor method
	 * @return The ISBN of this book.
	 */
	public long getISBN()
	{
		return ISBN;
	}

	/**
	 * Accessor method
	 * @return The price of this book.
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * Mutator method
	 * @param newTitle The new title of this book.
	 */
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}

	/**
	 * Mutator method
	 * @param newAuthor The new Author of this book.
	 */
	public void setAuthor(String newAuthor)
	{
		author = newAuthor;
	}

	/**
	 * Mutator method
	 * @param newISBN The new ISBN of this book.
	 */
	public void setISBN(long newISBN)
	{
		if(validISBN(newISBN))
			ISBN = newISBN;
		else
			System.out.println("Error! ISBN must be 10 digits long or 13 digits long. The ISBN is still: " + ISBN);
	}

	/**
	 * Mutator method
	 * @param newPrice The new price of this book.
	 */
	public void setPrice(double newPrice)
	{
		if(newPrice>=0)
			price = newPrice;
		else 
			System.out.println("Error! Price cannot be negative. The price is still: " + price);
	}

	/**
	 *  To display the information of this book.
	 */
	public String toString()
	{
		return "Author: "+author+"\nTitle: "+title+"\nISBN: "+ISBN+"\nPrice: $"+price+"\n";
	}

	/**
	 * 
	 * @return the number of books has been created
	 */
	public static int findNumberOfCreatedBooks()
	{
		return createdBookCounter;
	}

	/**
	 * 
	 * @param inventory An array of Books
	 * @param authorName the author's name to be searched in the array of books.
	 * @return An array containing the indices of inventory that have the same author's name
	 */
	public static int[] findBooksBy(A1_Book[] inventory, String authorName)
	{
		int counter = 0;
		int[] bookNumber = null;
		for(int i=0; i<inventory.length; i++)
			if(inventory[i]!=null && inventory[i].author.equals(authorName))
				counter++;
		if(counter == 0)
			System.out.println("There is no book in this inventory is wriiten by this author!");
		else
		{
			bookNumber = new int[counter];
			for(int i=0,j=0; i<inventory.length; i++)
				if(inventory[i]!=null && inventory[i].author.equals(authorName))
				{
					bookNumber[j] = i;
					j++;
				}
		}
		return bookNumber;
	}

	/**
	 * Find all the books cheaper than a given price.
	 * @param inventory An array of Books
	 * @param price Return all the books with the price below this value
	 * @return An array containing the indices of inventory that have the price below this value
	 */
	public static int[] findCheaperThan(A1_Book[] inventory, double price)
	{
		int counter = 0;
		int[] bookNumber = null;
		for(int i=0; i<inventory.length; i++)
			if(inventory[i]!=null && inventory[i].price<price)
				counter++;
		if(counter == 0)
			System.out.println("There is no book in this inventory is under this price!");
		else
		{
			bookNumber = new int[counter];
			for(int i=0,j=0; i<inventory.length; i++)
				if(inventory[i]!=null && inventory[i].price<price)
				{
					bookNumber[j] = i;
					j++;
				}
		}
		return bookNumber;
	}

	/**
	 * Two Book objects are considered equal if they have the same ISBN and price.
	 */
	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else 
		{
			A1_Book otherBook = (A1_Book)otherObject;
			return (ISBN==otherBook.ISBN && price==otherBook.price);
		}
	}

	/**
	 * @param theISBN ISBN must be 10 digits long or 13 digits long
	 * @return return true if the input ISBN is a valid number.
	 */
	private boolean validISBN(long theISBN)
	{
		final long min1 = 1000000000L;
		final long max1 = 9999999999L;
		final long min2 = 1000000000000L;
		final long max2 = 9999999999999L;
		return ( (theISBN>=min1 && theISBN<=max1) || (theISBN>=min2 && theISBN<=max2) );
	}

}
