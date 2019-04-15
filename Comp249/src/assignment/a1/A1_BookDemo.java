package assignment.a1;
import java.util.Scanner;

/**
 * Name(s) and ID(s): Jingchao Zhang 40049474 <br>
 * COMP249 <br>
 * Assignment # 1 Part 2 <br>
 * Due Date: Jan 31, 2018 <br>
 * Purpose: To help the store owner in keeping track of the books at the store.
 * 
 */

// -----------------------------------------------------
// Assignment 1
// Question: Part 2
// Written by: Jingchao Zhang 40049474
// -----------------------------------------------------

public class A1_BookDemo {

	final static String password = "password";

	public static void main(String[] args) {

		Scanner keyIn = new Scanner(System.in);

		// Welcome banner.
		System.out.println("\n----------------------------------------------------");
		System.out.println("    Welcome to Books Management System!");
		System.out.println("----------------------------------------------------");

		int maxBooks = inputMaxBooks(keyIn);
		A1_Book[] inventory = new A1_Book[maxBooks];
		int[] passwordAttempts = { 0 };// Incorrect password counter for main
										// menu, total repeat times.
		int remainingSpace = maxBooks;
		boolean goToMainMenu = true; // If true, go back to main menu after each
										// repetition.

		// Using while loop to control the main menu. Go back to main menu with
		// "continue",
		// quit system with "break" or change goToMainMenu to false.
		while (goToMainMenu) {
			System.out.println("What do you want to do?\n" + "   1. Enter new books (password required)\n"
					+ "   2. Change information of a book (password required)\n"
					+ "   3. Display all books by a specific author\n"
					+ "   4. Display all books under a certain a price.\n" + "   5. Quit\n"
					+ "Please enter your choice > ");
			int choice = chooseAndCheck(keyIn, 1, 5);

			// Discussing choice 1 to 5, respectively
			if (choice == 1) {
				// Calculating the remaining space
				int bookNumber = 0;// The bookNumber is the index in the array
									// inventory
				for (bookNumber = 0; bookNumber < maxBooks; bookNumber++)
					if (inventory[bookNumber] == null) {
						remainingSpace = maxBooks - bookNumber;
						break;
					}
				if (remainingSpace == 0) {
					System.out.println("Cannot add new book. No space.");
					continue;// go back to the main menu.
				}
				// Checking password
				if (!checkPassword(keyIn, passwordAttempts, true))
					continue;
				System.out.println(":) Your password is correct!");
				// bookNumber is the first null index in inventory.
				createNewbooks(keyIn, inventory, bookNumber, remainingSpace);
				continue;
			}

			else if (choice == 2) {
				if (!checkPassword(keyIn, passwordAttempts, false))
					continue;
				System.out.println(":) Your password is correct!");

				// Update information of a book.
				updateBook(keyIn, inventory);
			}

			else if (choice == 3) {
				System.out.print("Enter the author's full name here: ");
				keyIn.nextLine();
				String author = keyIn.nextLine();
				int[] bookNumber = A1_Book.findBooksBy(inventory, author);
				if (bookNumber != null)
					for (int i = 0; i < bookNumber.length; i++)
						System.out.println(inventory[bookNumber[i]]);
			}

			else if (choice == 4) {
				System.out.print("Enter the price here: ");
				double price = keyIn.nextDouble();
				int[] bookNumber = A1_Book.findCheaperThan(inventory, price);
				if (bookNumber != null)
					for (int i = 0; i < bookNumber.length; i++)
						System.out.println(inventory[bookNumber[i]]);
			}

			else if (choice == 5)
				goToMainMenu = false;
		}
		System.out.println("\n------------------------------------------------------------");
		System.out.println("    Thank you for using Books Management System! Bye Bye!");
		System.out.println("------------------------------------------------------------");
		keyIn.close();
	}

	/**
	 * prompt the user to input the maximum number of books the bookstore can
	 * contain
	 * 
	 * @param keyIn
	 *            The scanner created in the main method
	 * @return the maximum number of books the bookstore can contain
	 */
	public static int inputMaxBooks(Scanner keyIn) {
		System.out.println("Please enter the maximum number of books your bookstore can contain: ");
		int maxBooks = keyIn.nextInt();
		// Invalid maximum number of books
		while (maxBooks <= 0) {
			System.out.println("Please enter a number larger than 0. Try again: ");
			maxBooks = keyIn.nextInt();
		}
		return maxBooks;
	}

	/**
	 * After prompting the user input his/her choice, use this method to receive
	 * the choice, and check if the choice is valid. If not, prompt the user to
	 * try again, until (s)he input a valid integer.
	 * 
	 * @param keyIn
	 *            The scanner created in the main method
	 * @param upBound
	 *            The maximum value of user's input
	 * @param downBound
	 *            The minimum value of user's input
	 * @return A valid user's choice
	 */
	public static int chooseAndCheck(Scanner keyIn, int downBound, int upBound) {
		int choice = keyIn.nextInt();
		// Invalid choice number
		while (choice < downBound || choice > upBound) {
			System.out.println(
					"Please enter a number between " + downBound + " and " + upBound + " inclusive. Try again: ");
			choice = keyIn.nextInt();
		}
		return choice;
	}

	/**
	 * Prompt the user input information and create several new books.
	 * 
	 * @param keyIn
	 *            The scanner created in the main method
	 * @param ArrayOfBooks
	 *            The Books array where need to create new books.
	 * @param startIndex
	 *            The first null object in the Books array
	 * @param remainingSpace
	 *            The remaining space in the book array.
	 */
	public static void createNewbooks(Scanner keyIn, A1_Book[] ArrayOfBooks, int startIndex, int remainingSpace) {
		int numberOfNewBooks;// The number of new books we want to add.

		do {
			System.out.println("How many books do you want to enter?");
			numberOfNewBooks = keyIn.nextInt();
			if (numberOfNewBooks <= 0)
				System.out.println("Please enter a positive integer.");
			if (numberOfNewBooks > remainingSpace)
				System.out.println("You can only add at most " + remainingSpace + " books in your store.");
		} while (numberOfNewBooks > remainingSpace || numberOfNewBooks <= 0);
		for (int i = 0; i < numberOfNewBooks; startIndex++, i++) {
			System.out.print("Input the information of book " + (i + 1) + ":\nTitle: ");
			keyIn.nextLine();
			String title = keyIn.nextLine();
			System.out.print("Author: ");
			String author = keyIn.nextLine();
			System.out.print("ISBN: ");
			long ISBN = keyIn.nextLong();
			System.out.print("Price: ");
			double price = keyIn.nextDouble();
			ArrayOfBooks[startIndex] = new A1_Book(title, author, ISBN, price);
		}
		System.out.println("The new books have been recorded.\n");
	}

	/**
	 * Update the author of a book in the array.
	 * 
	 * @param keyIn
	 *            The scanner created in the main method
	 * @param ArrayOfBooks
	 *            The Books array where need to update the author.
	 * @param bookNumber
	 *            The index of the book to be updated in the array.
	 */
	public static void updateAuthor(Scanner keyIn, A1_Book[] ArrayOfBooks, int bookNumber) {
		System.out.print("Enter new author here: ");
		keyIn.nextLine();
		String newAuthor = keyIn.nextLine();
		ArrayOfBooks[bookNumber].setAuthor(newAuthor);
	}

	/**
	 * Update the title of a book in the array.
	 * 
	 * @param keyIn
	 *            The scanner created in the main method
	 * @param ArrayOfBooks
	 *            The Books array where need to update the title.
	 * @param bookNumber
	 *            The index of the book to be updated in the array.
	 */
	public static void updateTitle(Scanner keyIn, A1_Book[] ArrayOfBooks, int bookNumber) {
		System.out.print("Enter new title here: ");
		keyIn.nextLine();
		String newTitle = keyIn.nextLine();
		ArrayOfBooks[bookNumber].setTitle(newTitle);
	}

	/**
	 * Update the ISBN of a book in the array.
	 * 
	 * @param keyIn
	 *            The scanner created in the main method
	 * @param ArrayOfBooks
	 *            The Books array where need to update the ISBN.
	 * @param bookNumber
	 *            The index of the book to be updated in the array.
	 */
	public static void updateISBN(Scanner keyIn, A1_Book[] ArrayOfBooks, int bookNumber) {
		System.out.print("Enter new ISBN here: ");
		long newISBN = keyIn.nextLong();
		ArrayOfBooks[bookNumber].setISBN(newISBN);
	}

	/**
	 * Update the price of a book in the array.
	 * 
	 * @param keyIn
	 *            The scanner created in the main method
	 * @param ArrayOfBooks
	 *            The Books array where need to update the price.
	 * @param bookNumber
	 *            The index of the book to be updated in the array.
	 */
	public static void updatePrice(Scanner keyIn, A1_Book[] ArrayOfBooks, int bookNumber) {
		System.out.print("Enter new price here: ");
		double newPrice = keyIn.nextDouble();
		ArrayOfBooks[bookNumber].setPrice(newPrice);
	}

	/**
	 * Prompt the user to input a password, and then check if it is correct.
	 * 
	 * @param keyIn
	 *            The scanner created in the main method
	 * @param totalAttemptNumber
	 *            The attempt number of the outer loop
	 * @param isForCreatingNewBook
	 *            if it is true, every time users input incorrectly three times,
	 *            the total attempt number add 1
	 * @return true If the password is correct
	 */
	public static boolean checkPassword(Scanner keyIn, int[] totalAttemptNumber, boolean isForCreatingNewBook) {
		System.out.println("Enter your password: ");
		String enteredPassword = keyIn.next();
		int passwordAttempts = 1;
		while (!enteredPassword.equals(password) && passwordAttempts < 3) {
			System.out.println("Incorrect password! Try again: ");
			enteredPassword = keyIn.next();
			passwordAttempts++;
		}
		if (!enteredPassword.equals(password)) {
			System.out.println("Incorrect password!");
			if (isForCreatingNewBook)
				totalAttemptNumber[0]++;
			if (totalAttemptNumber[0] >= 4) {
				System.out.println("Program detected suspicous activities and will terminate immediately!");
				System.exit(0);
			}
			return false;
		}
		return true;
	}

	/**
	 * update information of a book in the array
	 * 
	 * @param keyIn
	 *            The scanner created in the main method
	 * @param inventory
	 *            The book array to be updated
	 */
	public static void updateBook(Scanner keyIn, A1_Book[] inventory) {
		boolean ReEnter = true;
		while (ReEnter) {
			System.out.println("Which book do you wish to update?");
			int bookNumber = chooseAndCheck(keyIn, 1, inventory.length);

			// Invalid index
			if (inventory[bookNumber - 1] == null) {
				System.out.println("There is no Book at index " + bookNumber + " location");
				System.out.println("What do you want to do?\n" + "   1. Re-enter another book\n"
						+ "   2. Quit this operation and go back to the main menu.\n" + "Please enter your choice > ");
				int choice2 = chooseAndCheck(keyIn, 1, 2);
				// If Choice2 == 1, do nothing, repeat from "ReEnter" while loop
				if (choice2 == 2)
					ReEnter = false;// Get out of the "ReEnter" while loop. Go
									// to main menu
			} else {// Update the book.
				System.out.println("Book #" + bookNumber);
				System.out.println(inventory[bookNumber - 1]);
				int choice = 0;// The user's choice of what information will be
								// changed
				while (choice != 5) {// Keep changing until he/she quit
					System.out
							.println("What information would you like to change?\n" + "   1. author\n" + "   2. title\n"
									+ "   3. ISBN\n" + "   4. price\n" + "   5. Quit\n" + "Enter your choice > ");
					choice = chooseAndCheck(keyIn, 1, 5);
					if (choice == 1)
						updateAuthor(keyIn, inventory, bookNumber - 1);
					else if (choice == 2)
						updateTitle(keyIn, inventory, bookNumber - 1);
					else if (choice == 3)
						updateISBN(keyIn, inventory, bookNumber - 1);
					else if (choice == 4)
						updatePrice(keyIn, inventory, bookNumber - 1);
					else if (choice == 5) {
						ReEnter = false;
						break;
					}
					System.out.println("Now, book #" + bookNumber);
					System.out.println(inventory[bookNumber - 1]);
				}
			}
		}
	}

}
