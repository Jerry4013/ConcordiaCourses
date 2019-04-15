package assignment.a2.two;

import assignment.a2.one.Event2;

/**
 * Name(s) and ID(s): Jingchao Zhang 40049474 <br>
 * COMP249 <br>
 * Assignment # 2 <br>
 * Due Date: Feb 21, 2018 <br>
 * Purpose:Helping the office manage the year around events
 */

// -----------------------------------------------------
// Assignment 2
// Question: Part 2
// Written by: Jingchao Zhang 40049474
// -----------------------------------------------------

public class Festival2 extends Event2 {

	//We use private in Part 2
	//All the derived classes have to use getter methods to access the attributes in the base class.
	//It is more safe.
	private String name;
	private double ticketPrice;
	private int duration;

	/**
	 * default constructor
	 */
	public Festival2() {
		super();
		name = "No name";
		ticketPrice = 0;
		duration = 0;
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
	 */
	public Festival2(int year, int month, int numberOfCities, String name, double ticketPrice, int duration) {
		super(year, month, numberOfCities);
		checkConsistent(ticketPrice, duration);
		this.name = name;
		this.ticketPrice = ticketPrice;
		this.duration = duration;
	}

	/**
	 * Copy constructor
	 * 
	 * @param otherFestival
	 *            another Festival for copying
	 */
	public Festival2(Festival2 otherFestival) {
		super(otherFestival);
		checkConsistent(otherFestival.ticketPrice, otherFestival.duration);
		name = otherFestival.name;
		ticketPrice = otherFestival.ticketPrice;
		duration = otherFestival.duration;
	}

	/**
	 * Overloading
	 * 
	 * @param ticketPrice
	 *            price is positive
	 * @param duration
	 *            number of days is positive
	 */
	public void checkConsistent(double ticketPrice, int duration) {
		if (ticketPrice < 0 || duration < 0) {
			System.out.println("Inconsistent ticket price or duration. Aborting!");
			System.exit(0);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		if (ticketPrice < 0) {
			System.out.println("Ticket price is positive. Aborting!");
			System.exit(0);
		}
		this.ticketPrice = ticketPrice;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		if (duration < 0) {
			System.out.println("Negative number of days! Aborting!");
			System.exit(0);
		}
		this.duration = duration;
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
		Festival2 other = (Festival2) obj;
		if (duration != other.duration)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(ticketPrice) != Double.doubleToLongBits(other.ticketPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "This " + name + " festival will be held in "+ getYear() + ", " + getMonth() + " in " + getNumberOfCities() + 
				" cities, for " + duration + " days, the ticket will cost " + ticketPrice + "$.";
	}

}
