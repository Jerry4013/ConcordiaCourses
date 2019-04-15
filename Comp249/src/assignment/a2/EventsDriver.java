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

package assignment.a2;

import assignment.a2.four.Fair;
import assignment.a2.one.Event;
import assignment.a2.three.SportCompetition;
import assignment.a2.two.Culturalfiesta;
import assignment.a2.two.Festival;
import assignment.a2.two.Musicfiesta;

public class EventsDriver {
	
	public static Event[] copyFestival(Event[] events) {
		Event[] newEvents = new Event[events.length];
		for(int i=0; i<events.length; i++)
			newEvents[i] = new Event(events[i]);
		for(int i=0; i<newEvents.length; i++)
			System.out.println(newEvents[i]);
		return newEvents;
	}
	
	public static void main(String[] args) {
		//Creating 10 events
		Event[] events = createEvents();
		//Testing equality
		equalityTesting(events);
		//Find the object that has the least/most number of cities
		leastAndMostNumberOfCities(events);
		//Are happening on the same year
		happenOnTheSameYear(events);
		//Create an array of the same length and copy all Events from the passed array to a new array then return it
		copyFestival(events);
		System.out.println("Thank you! Bye bye!");
	}
		
	/**
	 * Creating 10 events of different classes
	 * @return an array of events
	 */
	public static Event[] createEvents(){
		Event e1 = new Event(2018, 7, 3);
		System.out.println(e1);
		Event e2 = new Event(2020, 7, 3);
		System.out.println(e2);
		Festival f1 = new Festival(2018, 6, 5, "Comedy", 19.8, 5);
		System.out.println(f1);
		Festival f2 = new Festival(2019, 6, 5, "Comedy", 19.8, 5);
		System.out.println(f2);
		Culturalfiesta c1 = new Culturalfiesta(2018, 7, 2, "arts", 39.75, 7, 2);
		System.out.println(c1);
		Culturalfiesta c2 = new Culturalfiesta(2019, 7, 3, "arts", 39.75, 7, 2);
		System.out.println(c2);
		Musicfiesta m1 = new Musicfiesta(2018, 3, 2, "music", 29.75, 3, 10);
		System.out.println(m1);
		SportCompetition s1 = new SportCompetition(2018, 7, 12, 15);
		System.out.println(s1);
		SportCompetition s2 = new SportCompetition(2018, 7, 12, 15);
		System.out.println(s2);
		Fair fair = new Fair(2018, 3, 10, 20);
		System.out.println(fair);
		System.out.println();
		Event[] events = new Event[10];
		events[0] = e1;
		events[1] = e2;
		events[2] = f1;
		events[3] = f2;
		events[4] = c1;
		events[5] = c2;
		events[6] = m1;
		events[7] = s1;
		events[8] = s2;
		events[9] = fair;
		return events;
	}
	
	/**
	 * Find the object that has the least/most number of cities
	 * @param events find object from this events array 
	 */
	public static void leastAndMostNumberOfCities(Event[] events) {
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
	public static void equalityTesting(Event[] events){
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
	public static void happenOnTheSameYear(Event[] events){
		boolean[] counted = new boolean[10];
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
