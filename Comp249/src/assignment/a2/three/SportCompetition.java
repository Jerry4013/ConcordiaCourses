package assignment.a2.three;

import assignment.a2.one.Event;

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

public class SportCompetition extends Event {
	private int numberOfActivities;

	public static enum SeasonName {
		SUMMER, FALL, WINTER, SPRING
	};

	/**
	 * Default constructor
	 */
	public SportCompetition() {
		super();
		numberOfActivities = 0;
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
	 * @param numberOfActivities
	 *            the number of activities
	 */
	public SportCompetition(int year, int month, int numberOfCities, int numberOfActivities) {
		super(year, month, numberOfCities);
		checkConsistent(numberOfActivities);
		this.numberOfActivities = numberOfActivities;
	}

	/**
	 * Copy constructor
	 * 
	 * @param otherSportCompetition
	 *            another Festival for copying
	 */
	public SportCompetition(SportCompetition otherSportCompetition) {
		super(otherSportCompetition);
		checkConsistent(otherSportCompetition.numberOfActivities);
		numberOfActivities = otherSportCompetition.numberOfActivities;
	}

	public void checkConsistent(int numberOfActivities) {
		if (numberOfActivities < 0) {
			System.out.println("Number of activities is positive. Aborting!");
			System.exit(0);
		}
	}

	public int getNumberOfActivitie() {
		return numberOfActivities;
	}

	public void setNumberOfActivitie(int numberOfActivities) {
		checkConsistent(numberOfActivities);
		this.numberOfActivities = numberOfActivities;
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
		SportCompetition other = (SportCompetition) obj;
		if (numberOfActivities != other.numberOfActivities)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "This Sport competition will be held in "+ year + ", " + month + " in " + numberOfCities + 
				" cities, and has " + numberOfActivities + " activities.";
	}

}
