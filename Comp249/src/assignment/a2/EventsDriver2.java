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

package assignment.a2;

import assignment.a2.four.Fair2;
import assignment.a2.one.Event2;
import assignment.a2.three.SportCompetition2;
import assignment.a2.two.Culturalfiesta2;
import assignment.a2.two.Festival2;
import assignment.a2.two.Musicfiesta2;

public class EventsDriver2 {
	
	public static Event2[] copyFestival(Event2[] events) {
		Event2[] newEvents = new Event2[events.length];
		for(int i=0; i<events.length; i++)
			newEvents[i] = new Event2(events[i]);
		for(int i=0; i<newEvents.length; i++)
			System.out.println(newEvents[i]);
		return newEvents;
	}
	
	public static void main(String[] args) {
		//Creating 12 events
		Event2[] events = createEvents();

		//Create an array of the same length and copy all Events from the passed array to a new array then return it
		copyFestival(events);
		
		System.out.println();
		System.out.println("This copy is NOT correct, because we used copy constructors of each object, " + 
		"\nbut we used Event copy constructor all the time. We've never overridden a copy constructor, so this is not a polymorphysm.");
		System.out.println("Thank you! Bye bye!");
	}
		
	/**
	 * Creating 10 events of different classes
	 * @return an array of events
	 */
	public static Event2[] createEvents(){
		Event2 e1 = new Event2(2018, 7, 2);
		System.out.println(e1);
		Event2 e2 = new Event2(2020, 7, 3);
		System.out.println(e2);
		Festival2 f1 = new Festival2(2018, 6, 5, "Comedy", 19.8, 5);
		System.out.println(f1);
		Festival2 f2 = new Festival2(2019, 6, 5, "Comedy", 19.8, 5);
		System.out.println(f2);
		Culturalfiesta2 c1 = new Culturalfiesta2(2018, 7, 2, "arts", 39.75, 7, 2);
		System.out.println(c1);
		Culturalfiesta2 c2 = new Culturalfiesta2(2019, 7, 3, "arts", 39.75, 7, 2);
		System.out.println(c2);
		Musicfiesta2 m1 = new Musicfiesta2(2018, 3, 2, "music", 29.75, 3, 10);
		System.out.println(m1);
		SportCompetition2 s1 = new SportCompetition2(2018, 7, 12, 15);
		System.out.println(s1);
		SportCompetition2 s2 = new SportCompetition2(2018, 7, 12, 15);
		System.out.println(s2);
		Fair2 fair1 = new Fair2(2018, 3, 10, 20);
		System.out.println(fair1);
		Fair2 fair2 = new Fair2(2019, 4, 10, 15);
		System.out.println(fair2);
		Fair2 fair3 = new Fair2(2020, 4, 10, 15);
		System.out.println(fair3);
		System.out.println();
		Event2[] events = new Event2[12];
		events[0] = e1;
		events[1] = e2;
		events[2] = f1;
		events[3] = f2;
		events[4] = c1;
		events[5] = c2;
		events[6] = m1;
		events[7] = s1;
		events[8] = s2;
		events[9] = fair1;
		events[10] = fair2;
		events[11] = fair3;
		return events;
	}
	
	/**
	 * Find the object that has the least/most number of cities
	 * @param events find object from this events array 
	 */
	public static void leastAndMostNumberOfCities(Event2[] events) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < events.length; i++) {
			if (events[i].getNumberOfCities() < min) {
				min = events[i].getNumberOfCities();
			}
			if (events[i].getNumberOfCities() > max) {
				max = events[i].getNumberOfCities();
			}
		}
		System.out.println("The least number of cities is: " + min);
		for(int i = 0; i < events.length; i++) {
			if (events[i].getNumberOfCities() == min)
				System.out.println("Index[" + i + "]: " + events[i]);
		}
		System.out.println("The most number of cities is: " + max);
		for(int i = 0; i < events.length; i++) {
			if (events[i].getNumberOfCities() == max)
				System.out.println("Index[" + i + "]: " + events[i]);
		}
		System.out.println();
	}
	
	/**
	 * Test the equality of some to the created objects using the equals() method.
	 * @param events the events array for test
	 */
	public static void equalityTesting(Event2[] events){
		System.out.println(events[0].equals(events[1]));
		System.out.println(events[2].equals(events[3]));
		System.out.println(events[5].equals(events[4]));
		System.out.println(events[8].equals(events[7]));
		System.out.println();
	}
	
	/**
	 * Find the events that are happening on the same year
	 * @param events the events array for tracking
	 */
	public static void happenOnTheSameYear(Event2[] events){
		boolean[] counted = new boolean[events.length];
		int counter = 1;
		for (int i = 0; i < events.length - 1; i++) {
			counter = 1;
			if (counted[i] == false) {
				counted[i] = true;
				for (int j = i + 1; j < events.length; j++)
					if (events[i].getYear() == events[j].getYear()) {
						counter++;
						counted[j] = true;
					}
				if (counter > 1) {
					System.out.println("In year " + events[i].getYear() + ": ");
					for (int j = i; j < events.length; j++)
						if (events[i].getYear() == events[j].getYear())
							System.out.println("Index[" + j + "]: " + events[j]);
				}
			}
		}
		System.out.println();
	}
	
}
