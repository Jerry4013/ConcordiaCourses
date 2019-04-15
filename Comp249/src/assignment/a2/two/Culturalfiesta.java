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
// Question: Part 1
// Written by: Jingchao Zhang 40049474
// -----------------------------------------------------

public class Culturalfiesta extends Festival {

	private int numberOfSpokenLanguages;

	/**
	 * default constructor
	 */
	public Culturalfiesta() {
		super();
		numberOfSpokenLanguages = 0;
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
	 * @param numberOfSpokenLanguages
	 *            indicates the maximum languages spoken in this kind of
	 *            festival
	 */
	public Culturalfiesta(int year, int month, int numberOfCities, String name, double ticketPrice, int duration,
			int numberOfSpokenLanguages) {
		super(year, month, numberOfCities, name, ticketPrice, duration);
		checkConsistent(numberOfSpokenLanguages);
		this.numberOfSpokenLanguages = numberOfSpokenLanguages;
	}

	/**
	 * Copy constructor
	 * 
	 * @param otherCulturalfiesta
	 *            another Culturalfiesta object for copying
	 */
	public Culturalfiesta(Culturalfiesta otherCulturalfiesta) {
		super(otherCulturalfiesta);
		checkConsistent(otherCulturalfiesta.numberOfSpokenLanguages);
		numberOfSpokenLanguages = otherCulturalfiesta.numberOfSpokenLanguages;
	}

	/**
	 * Overloading
	 * 
	 * @param numberOfSpokenLanguages
	 *            number of spoken languages is positive
	 */
	public void checkConsistent(int numberOfSpokenLanguages) {
		if (numberOfSpokenLanguages < 0) {
			System.out.println("Number of spoken languages cannot be negative. Aborting!");
			System.exit(0);
		}
	}

	public int getNumberOfSpokenLanguages() {
		return numberOfSpokenLanguages;
	}

	public void setNumberOfSpokenLanguages(int numberOfSpokenLanguages) {
		checkConsistent(numberOfSpokenLanguages);
		this.numberOfSpokenLanguages = numberOfSpokenLanguages;
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
		Culturalfiesta other = (Culturalfiesta) obj;
		if (numberOfSpokenLanguages != other.numberOfSpokenLanguages)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "This " + name + " Culturalfiesta will be held in "+ year + ", " + month + " in " + numberOfCities + 
				" cities, for " + duration + " days, the ticket will cost " + ticketPrice + "$, and has " + 
				numberOfSpokenLanguages + " spoken language.";
	}
}
