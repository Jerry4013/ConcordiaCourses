import common.BaseThread;



/**
 * Class Philosopher.
 * Outlines main subrutines of our virtual philosopher.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Philosopher extends BaseThread
{
	/**
	 * Max time an action can take (in milliseconds)
	 */
	public static final long TIME_TO_WASTE = 1000;

	/**
	 * The act of eating.
	 * - Print the fact that a given phil (their TID) has started eating.
	 * - yield
	 * - Then sleep() for a random interval.
	 * - yield
	 * - The print that they are done eating.
	 */
	public void eat()
	{
		try
		{
			System.out.println("Philosopher "+ this.iTID +" has started EATING.");

			// task 6 -----------------------------------------------------------
			if (Math.random() <= 0.5) {
				DiningPhilosophers.soMonitor.requestPepper(getTID());
				System.out.println("Philosopher "+ this.iTID +" is putting PEPPER.");
				DiningPhilosophers.soMonitor.putDownPepper(getTID());
			}
			// task 6 -----------------------------------------------------------

			yield();
			sleep((long)(Math.random() * TIME_TO_WASTE));
			yield();
			System.out.println("Philosopher "+ this.iTID +" has finished EATING.");
		}
		catch(InterruptedException e)
		{
			System.err.println("Philosopher.eat():");
			DiningPhilosophers.reportException(e);
			System.exit(1);
		}
	}

	/**
	 * The act of thinking.
	 * - Print the fact that a given phil (their TID) has started thinking.
	 * - yield
	 * - Then sleep() for a random interval.
	 * - yield
	 * - The print that they are done thinking.
	 */
	public void think()
	{
		try {
			System.out.println("Philosopher "+ this.iTID +" has started THINKING.");
			yield();
			sleep((long)(Math.random() * TIME_TO_WASTE));
			yield();
			System.out.println("Philosopher "+ this.iTID +" has finished THINKING.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The act of talking.
	 * - Print the fact that a given phil (their TID) has started talking.
	 * - yield
	 * - Say something brilliant at random
	 * - yield
	 * - The print that they are done talking.
	 */
	public void talk()
	{
		System.out.println("Philosopher "+ this.iTID +" has started TALKING.");
		yield();
		saySomething();
		for (int i = 0; i < 9999999; i++) {
			double random = Math.random();
			double k = i / random;
		}
		yield();
		System.out.println("Philosopher "+ this.iTID +" has finished TALKING.");
	}

	public void p_sleep(){
		try {
			System.out.println("Philosopher " + this.iTID + " has started SLEEPING.");
			yield();
			sleep((long) (Math.random() * TIME_TO_WASTE)); // define variable TIME_TO_WASTE
			yield();
			System.out.println("Philosopher " + this.iTID + " has finished SLEEPING.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * No, this is not the act of running, just the overridden Thread.run()
	 */
	public void run()
	{
		for(int i = 0; i < DiningPhilosophers.DINING_STEPS; i++)
		{
			try {
				DiningPhilosophers.soMonitor.pickUp(getTID());

				eat();

				DiningPhilosophers.soMonitor.putDown(getTID());

				think();

				//task 5
				if (i > 3 && !DiningPhilosophers.soMonitor.isSomeoneHasLeft() && Math.random() <= 0.1) {
					System.out.println("Philosopher "+ this.iTID +" left the table------------------------");
					DiningPhilosophers.soMonitor.leave(getTID());
					return;
				}

				/*
				 * TODO:
				 * A decision is made at random whether this particular
				 * philosopher is about to say something terribly useful.
				 */
				if (Math.random() <= 0.75) {
					DiningPhilosophers.soMonitor.requestTalk(getTID());
					talk();
					DiningPhilosophers.soMonitor.endTalk(getTID());
				}

				if (Math.random() <= 0.25) {
					DiningPhilosophers.soMonitor.requestSleep(getTID());
					p_sleep();
					DiningPhilosophers.soMonitor.endSleep(getTID());
				}

				yield();
			} catch (InterruptedException e){
				System.err.println("run():");
				DiningPhilosophers.reportException(e);
				System.exit(1);
			}
		}
	} // run()

	/**
	 * Prints out a phrase from the array of phrases at random.
	 * Feel free to add your own phrases.
	 */
	public void saySomething()
	{
		String[] astrPhrases =
		{
			"Eh, it's not easy to be a philosopher: eat, think, talk, eat...",
			"You know, true is false and false is true if you think of it",
			"2 + 2 = 5 for extremely large values of 2...",
			"If thee cannot speak, thee must be silent",
			"My number is " + getTID() + ""
		};
		System.out.println
		(
			"Philosopher " + getTID() + " says: " +
			astrPhrases[(int)(Math.random() * astrPhrases.length)]
		);
	}

}

// EOF
