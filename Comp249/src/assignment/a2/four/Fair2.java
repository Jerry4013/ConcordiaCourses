package assignment.a2.four;

import assignment.a2.one.Event2;

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

public class Fair2 extends Event2 {
	private int numberOfExhibitors;

	public static enum Type {
		CAREER, SCIENCE, TRADE, TRAVEL
	}

	/**
	 * Default constructor
	 */
	public Fair2() {
		super();
		numberOfExhibitors = 0;
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
	 * @param numberOfExhibitors
	 *            the number of exhibitors.
	 */
	public Fair2(int year, int month, int numberOfCities, int numberOfExhibitors) {
		super(year, month, numberOfCities);
		checkConsistent(numberOfExhibitors);
		this.numberOfExhibitors = numberOfExhibitors;
	}

	/**
	 * Copy constructor
	 * 
	 * @param otherFair
	 *            another Fair for copying
	 */
	public Fair2(Fair2 otherFair) {
		super(otherFair);
		checkConsistent(otherFair.numberOfExhibitors);
		numberOfExhibitors = otherFair.numberOfExhibitors;
	}

	public void checkConsistent(int numberOfExhibitors) {
		if (numberOfExhibitors < 0) {
			System.out.println("Number of exhibitors cannot be negative. Aborting!");
			System.exit(0);
		}
	}

	public int getNumberOfExhibitors() {
		return numberOfExhibitors;
	}

	public void setNumberOfExhibitors(int numberOfExhibitors) {
		checkConsistent(numberOfExhibitors);
		this.numberOfExhibitors = numberOfExhibitors;
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
		Fair2 other = (Fair2) obj;
		if (numberOfExhibitors != other.numberOfExhibitors)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "This fair will be held in "+ getYear() + ", " + getMonth() + " in " + getNumberOfCities() + 
				" cities, and has " + numberOfExhibitors + " exhibitors.";
	}

}
