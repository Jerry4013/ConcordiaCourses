import java.util.HashMap;
import java.util.Random;

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

	int numberOfPhilosophers;

	boolean someoneHasLeft;  //task5

	boolean[] isChopstickInUsed;

	boolean[] isPhilosopherInRoom;

	boolean[] isPepperInUsed = new boolean[2];

	enum status {THINKING, EATING, HUNGRY, WAITING, TALKING, SLEEPING}

	status[] state;

	boolean isSomeoneTalking;

	int numberOfSleeping;

	int[] age;

	long talkingStartTime;

	HashMap<Integer, Integer> hashMap = new HashMap<>(); //task 6

	long TIME_LIMIT = 2000;

	Integer priority[];



	/**
	 * Constructor
	 */
	public Monitor(int numberOfPhilosophers)
	{
		// TODO: set appropriate number of chopsticks based on the # of philosophers
		this.numberOfPhilosophers = numberOfPhilosophers;
		this.numberOfChopsticks = numberOfPhilosophers;
		isChopstickInUsed = new boolean[numberOfChopsticks];
		age = new int[numberOfChopsticks];
		philosophersComeIn();
		isSomeoneTalking = false;
		initializeStates();
		initializePriorities(); //task3
	}

	//task 5
	public  Monitor(int numberOfPhilosophers, int numberOfChopsticks){
		this.numberOfPhilosophers = numberOfPhilosophers;
		this.numberOfChopsticks = numberOfChopsticks;
		isChopstickInUsed = new boolean[numberOfChopsticks];
		isPhilosopherInRoom = new boolean[numberOfPhilosophers];
		age = new int[numberOfChopsticks];
		philosophersComeIn();
		isSomeoneTalking = false;
		initializeStates();
		initializePriorities(); //task3
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */

	//task 2
	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID) throws InterruptedException {
		int index = piTID - 1;
		state[index] = status.HUNGRY;
		while(true){
			if (tooOld(piTID) &&
				!isChopstickInUsed[index] &&
				!isChopstickInUsed[(index+1)%numberOfChopsticks]){

				clearAge(piTID);
				isChopstickInUsed[index] = true;
				isChopstickInUsed[(index+1) % numberOfChopsticks] = true;
				state[index] = status.EATING;
				break;
			}
			if(( !shouldNeighborEat(index) && 	//task3
				 !isChopstickInUsed[index] &&
				 !isChopstickInUsed[(index+1)%numberOfChopsticks])){

				clearAge(piTID);
				isChopstickInUsed[index] = true;
				isChopstickInUsed[(index+1) % numberOfChopsticks] = true;
				state[index] = status.EATING;
				break;
			} else {
				increaseAge(piTID);
				wait();
			}
		}
	}

	//task 2
	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
		int index = piTID - 1;
		state[index] = status.THINKING;
		isChopstickInUsed[index] = false;
		isChopstickInUsed[(index+1) % numberOfChopsticks] = false;
		notifyAll();
	}

	//task 2
	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk(final int piTID) throws InterruptedException
	{
		while(true){
			int index = piTID - 1;
			state[index] = status.WAITING;
			long talkingTime = System.currentTimeMillis( ) - talkingStartTime;
			if(numberOfSleeping == 0 && (!isSomeoneTalking || talkingTime > TIME_LIMIT)){
				state[index] = status.TALKING;
				talkingStartTime = System.currentTimeMillis( );
				isSomeoneTalking = true;
				break;
			} else {
				wait();
			}
		}
	}

	//task 2
	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk(final int piTID)
	{
		isSomeoneTalking = false;
		state[(piTID-1)] = status.THINKING;
		notifyAll();
	}

	//task 2
	public synchronized void requestSleep(final int piTID) throws InterruptedException{
		while (true) {
			if (isSomeoneTalking){
				wait();
			} else{
				numberOfSleeping++;
				state[(piTID-1)] = status.SLEEPING;
				break;
			}
		}
	}

	//task 2
	public synchronized void endSleep(final int piTID) throws InterruptedException {
		state[(piTID-1)] = status.THINKING;
		numberOfSleeping--;
	}

	//task2
	private void initializeStates(){
		state = new status[numberOfChopsticks];
		for (int i = 0; i < numberOfChopsticks; i++) {
			state[i] = status.THINKING;
		}
	}

	//task2
	private void philosophersComeIn(){
		isPhilosopherInRoom = new boolean[numberOfChopsticks];
		for (int i = 0; i < numberOfPhilosophers; i++) {
			isPhilosopherInRoom[i] = true;
		}
	}

	//task 2
	private boolean shouldNeighborEat(int index){
		int left = (index+1) % numberOfChopsticks;
		int right = (index + numberOfChopsticks - 1) % numberOfChopsticks;
		return (isPhilosopherInRoom[left] && state[left] == status.HUNGRY && priority[left] < priority[index]) ||
			   (isPhilosopherInRoom[right] && state[right] == status.HUNGRY && priority[right] < priority[index] );
	}

	//task 3
	private void initializePriorities(){
		priority = new Integer[numberOfChopsticks];
		Random random = new Random();
		for (int i = 0; i < numberOfChopsticks; i++) {
			priority[i] = i + 1;
		}
		for (int i=0; i<numberOfChopsticks; i++) {
			int randomPosition = random.nextInt(numberOfChopsticks);
			int temp = priority[i];
			priority[i] = priority[randomPosition];
			priority[randomPosition] = temp;
		}
	}

	//task 5
	public void newPhilosopherComeIn(){
		for (int i = 0; i < isPhilosopherInRoom.length; i++) {
			if (!isPhilosopherInRoom[i]){
				isPhilosopherInRoom[i] = true;
				return;
			}
		}
	}

	//task 5
	public synchronized void leave(final int piTID){
		someoneHasLeft = true;
		isPhilosopherInRoom[piTID-1] = false;
	}

	//task 5
	public synchronized boolean isSomeoneHasLeft(){
		return someoneHasLeft;
	}

	//task 6
	public synchronized void requestPepper(final int piTID) throws InterruptedException
	{
		while(true){
			int index = piTID - 1;
			if(state[index] == status.EATING && (!isPepperInUsed[0] || !isPepperInUsed[1])){
				if (!isPepperInUsed[0]){
					isPepperInUsed[0] = true;
					hashMap.put(piTID, 0); //Philosopher piTID is using pepper 0
				}else {
					isPepperInUsed[1] = true;
					hashMap.put(piTID, 1); //Philosopher piTID is using pepper 1
				}
				break;
			} else {
				wait();
			}
		}
	}

	//task 6
	public synchronized void putDownPepper(final int piTID)throws InterruptedException{
		int pepperIndex = hashMap.get(piTID);
		isPepperInUsed[pepperIndex] = false;
		hashMap.remove(piTID);
		notifyAll();
	}

	public synchronized void increaseAge(final int piTID) {
		int index = piTID - 1;
		age[index]++;
	}

	public synchronized void clearAge(final int piTID){
		int index = piTID - 1;
		age[index] = 0;
	}

	private synchronized boolean tooOld(final int piTID){
		int index = piTID - 1;
		return age[index] > 10;
	}

}

// EOF
