package assignment.a2.two;
/**
 * Name(s) and ID(s): Jingchao Zhang 40049474 <br>
 * COMP249 <br>
 * Assignment # 2 <br>
 * Due Date: Feb 21, 2018 <br>
 * Purpose: Helping the office manage the year around events
 */

// -----------------------------------------------------
// Assignment 2
// Question: Part 2
// Written by: Jingchao Zhang 40049474
// -----------------------------------------------------

public class Musicfiesta2 extends Festival2 {

	private int numberOfBands;

	/**
	 * Default constructor
	 */
	public Musicfiesta2() {
		super();
		numberOfBands = 0;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param year
	 *            the year of this event
	 * @param month
	 *            the month of this event
	 * @param numberOfCities
	 *            the number of cities where it will be held.
	 * @param name
	 *            the name of this festival, such as Arts, Beer, Comedy, Film,
	 *            Fire, Folk…etc
	 * @param ticketPrice
	 *            ticket price
	 * @param duration
	 *            number of days.
	 * @param numberOfBands
	 *            number of bands in this music fiesta
	 */
	public Musicfiesta2(int year, int month, int numberOfCities, String name, double ticketPrice, int duration,
			int numberOfBands) {
		super(year, month, numberOfCities, name, ticketPrice, duration);
		checkConsistent(numberOfBands);
		this.numberOfBands = numberOfBands;
	}

	/**
	 * Copy constructor
	 * 
	 * @param otherMusicfiesta
	 *            another object for copying
	 */
	public Musicfiesta2(Musicfiesta2 otherMusicfiesta) {
		super(otherMusicfiesta);
		checkConsistent(otherMusicfiesta.numberOfBands);
		numberOfBands = otherMusicfiesta.numberOfBands;
	}

	/**
	 * overloading, check the validity of number of bands
	 * 
	 * @param numberOfBands
	 *            positive number
	 */
	public void checkConsistent(int numberOfBands) {
		if (numberOfBands < 0) {
			System.out.println("Number of bands cannot be negative. Aborting!");
			System.exit(0);
		}
	}

	public int getNumberOfBands() {
		return numberOfBands;
	}

	public void setNumberOfBands(int numberOfBands) {
		checkConsistent(numberOfBands);
		this.numberOfBands = numberOfBands;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)//same address, equals for sure.
			return true;
		if (obj == null)//comparing with a null object, not equal.
			return false;
		if (!super.equals(obj))//comparing the attributes in its base class.
			return false;
		if (getClass() != obj.getClass())//different classes, not equal.
			return false;
		Musicfiesta2 other = (Musicfiesta2) obj;
		if (numberOfBands != other.numberOfBands)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "This " + getName() + " Musicfiesta will be held in "+ getYear() + ", " + getMonth() + " in " + getNumberOfCities() + 
				" cities, for " + getDuration() + " days, the ticket will cost " + getTicketPrice() + "$, and has " + 
				numberOfBands + " bands.";
	}
	
	
	
}
