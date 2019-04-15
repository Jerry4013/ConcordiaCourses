/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */
	int numberOfChopsticks;


	enum states {THINKING, EATING, HUNGRY, WAITING, TALKING}

	/**
	 * An array of chopsticks
	 * If the value is 1 the chopstick is in use.
	 * If the value is 0 the chopstick is available.
	 * When initialized, all chopsticks are available (value is 0)
	 */
	int[] chopstick;

	/**
	 * Holds the piTID of last philosopher to eat
	 * Ensures that people don't starve by not getting a turn
	 */
	int lastEater;

	/**
	 * Array containing the states of all the philosophers
	 * 
	 */
	states[] philosopherState;
	
	/**
	 * true if a philosopher is currently talking, false otherwise
	 */
	boolean isTalking;

	/**
	 * Constructor
	 */
	public Monitor(int piNumberOfPhilosophers)
	{

		//Number of chopsticks is equal to the number of philosophers
		numberOfChopsticks = piNumberOfPhilosophers;

		//Initialize chopstick array
		chopstick = new int[numberOfChopsticks];

		//philosopher states array
		philosopherState = new states[piNumberOfPhilosophers];
		
		//initialize all the states to thinking
		for(states state : philosopherState){
			state = states.THINKING;
		}
		//no last eater
		lastEater = -1;
		
		//no one is talking
		isTalking = false;
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */

	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 * @throws InterruptedException 
	 */
	public synchronized void pickUp(final int piTID) throws InterruptedException
	{
		/*
		 * Philo X can pick up chopsticks[X-1] (to the left) and chopsticks[X] (to the right)
		 */
		int idx = piTID - 1;
		while(true){
			//testing if chopsticks are used
			if((chopstick[idx] == 0 && chopstick[(idx+1) % numberOfChopsticks] == 0)){

				//EAT WITH CHOPSTICKS

				//Changes the availibility of the chopsticks
				chopstick[idx] = 1;
				chopstick[(idx+1) % numberOfChopsticks] = 1;

				//System.out.println("Philosopher "+ piTID + " picks up chopsticks " + idx +", " + ((idx+1)% numberOfChopsticks));
				philosopherState[idx] = states.EATING;

				lastEater = piTID;
				
				break;
				
				
			} else {
				//System.out.println("Philosopher " + piTID + " is waiting for the chopsticks " + idx +", " + ((idx+1)% numberOfChopsticks) );
				philosopherState[idx] = states.HUNGRY;
				wait();
			}
		}

	}

	/**
	 * When a given philosopher's done eating, they put the chopsticks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
		int idx = piTID - 1;
		if(chopstick[idx] == 1 && chopstick[(idx+1) % numberOfChopsticks] == 1){

			//PUT DOWN CHOPSTICKS
			chopstick[idx] = 0;
			chopstick[(idx+1) % numberOfChopsticks] = 0;
			
			//System.out.println("Philosopher "+ piTID + " put down chopsticks " + idx +", " + ((idx+1)% numberOfChopsticks));
			
			philosopherState[idx] = states.THINKING;
			notifyAll();

		} else {
			//Something went wrong if this is called. edit: commented out because it wont be called. 
			System.err.println("Chopsticks are already put down " + idx + ", " + ((idx+1)% numberOfChopsticks));
		}

	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 * @throws InterruptedException 
	 */
	public synchronized void requestTalk(final int piTID) throws InterruptedException
	{
		while(true){
			if(!isTalking && philosopherState[(piTID-1)] != states.EATING){
				philosopherState[(piTID-1)] = states.TALKING;
				isTalking = true;
				break;
			} else {
				philosopherState[(piTID-1)] = states.WAITING;
				wait();
			}
		}
	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk(final int piTID)
	{
		isTalking = false;
		philosopherState[(piTID-1)] = states.THINKING;
		notifyAll();
	}
}

// EOF
