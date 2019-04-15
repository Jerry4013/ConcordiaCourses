package assignment.a2.one;
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

public class Event {
	protected int year;
	protected int month;
	protected int numberOfCities;

	/**
	 * Default constructor
	 */
	public Event() {
		year = 1000;
		month = 1;
		numberOfCities = 0;
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
	 */
	public Event(int year, int month, int numberOfCities) {
		checkConsistent(year, month, numberOfCities);
		this.year = year;
		this.month = month;
		this.numberOfCities = numberOfCities;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param otherEvent
	 */
	public Event(Event otherEvent) {
		if (otherEvent == null) {
			System.out.println("Fail to copy an event.");
			System.exit(0);
		}
		checkConsistent(otherEvent.year, otherEvent.month, otherEvent.numberOfCities);
		year = otherEvent.year;
		month = otherEvent.month;
		numberOfCities = otherEvent.numberOfCities;
	}

	public void checkConsistent(int year, int month, int numberOfCities) {
		if (year < 1000 || month < 1 || month > 12 || numberOfCities < 0) {
			System.out.println("Inconsistent date or number of cities. Aborting!");
			System.exit(0);
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year < 1000) {
			System.out.println("Invalid year. Aborting!");
			System.exit(0);
		}
		this.year = year;
	}

	public int getMonth() {
		return month;
	}
	
	public String getMonthString() {
		return month<10 ? ("0"+month) : new Integer(month).toString();
	}

	public void setMonth(int month) {
		if (month < 1 || month > 12) {
			System.out.println("Invalid month. Aborting!");
			System.exit(0);
		}
		this.month = month;
	}

	public int getNumberOfCities() {
		return numberOfCities;
	}

	public void setNumberOfCities(int numberOfCities) {
		if (numberOfCities < 0) {
			System.out.println("Invalid number of cities. Aborting!");
			System.exit(0);
		}
		this.numberOfCities = numberOfCities;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)//same address, equals for sure.
			return true;
		if (obj == null)//comparing with a null object, not equal.
			return false;
		if (getClass() != obj.getClass())//different classes, not equal.
			return false;
		Event other = (Event) obj;
		if (month != other.month)
			return false;
		if (numberOfCities != other.numberOfCities)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "This event will be held in "+ year + ", " + month + " in " + numberOfCities + " cities.";
	}

}
