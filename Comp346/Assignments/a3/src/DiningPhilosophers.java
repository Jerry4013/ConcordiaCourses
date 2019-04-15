import static java.lang.Thread.sleep;

/**
 * Class DiningPhilosophers
 * The main starter.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 * changed by Jingchao Zhang at April 2019
 */
public class DiningPhilosophers
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */

	/**
	 * This default may be overridden from the command line
	 */
	public static final int DEFAULT_NUMBER_OF_PHILOSOPHERS = 4;

	/**
	 * Dining "iterations" per philosopher thread
	 * while they are socializing there
	 */
	public static final int DINING_STEPS = 10;

	/**
	 * Our shared monitor for the philosphers to consult
	 */
	public static Monitor soMonitor = null;

	/*
	 * -------
	 * Methods
	 * -------
	 */

	/**
	 * Main system starts up right here
	 * argv[0] is the number of philosophers, argv[1] is the number of chopsticks (total positions)
	 */
	public static void main(String[] argv)
	{
		try
		{
			/*
			 * TODO:
			 * Should be settable from the command line
			 * or the default if no arguments supplied.
			 */
			int iPhilosophers = DEFAULT_NUMBER_OF_PHILOSOPHERS;
			int ichopsticks = DEFAULT_NUMBER_OF_PHILOSOPHERS;  //task 5

			//Task 4
			if (argv.length > 0){
				try {
					iPhilosophers = Integer.parseInt(argv[0]);
				}
				catch(NumberFormatException n){
					System.err.println(argv[0] + " is not a positive decimal integer");
					System.err.println("Usage: java DiningPhilosophers 4");
					iPhilosophers = DEFAULT_NUMBER_OF_PHILOSOPHERS;
				}
				if (iPhilosophers <= 0){
					System.err.println(iPhilosophers + " is not a positive decimal integer");
					System.err.println("Usage: java DiningPhilosophers 4");
					iPhilosophers = DEFAULT_NUMBER_OF_PHILOSOPHERS;
				}
			}

			// Task 5
			if (argv.length <= 1){
				soMonitor = new Monitor(iPhilosophers);
			} else if (argv.length == 2){
				ichopsticks = Integer.parseInt(argv[1]);
				soMonitor = new Monitor(iPhilosophers, ichopsticks);
			}

			// Space for all the philosophers
			Philosopher aoPhilosophers[] = new Philosopher[iPhilosophers];

			System.out.println(iPhilosophers + " philosopher(s) came in for a dinner.");

			// Let 'em sit down
			for(int j = 0; j < iPhilosophers; j++)
			{
				aoPhilosophers[j] = new Philosopher();
				aoPhilosophers[j].start();
			}

			//task 5
			if (argv.length == 2){
				sleep((long)(Math.random() * Philosopher.TIME_TO_WASTE));
				int numberOfNewPhilosophers = ichopsticks - iPhilosophers;
				Philosopher newPhilosophers[] = new Philosopher[numberOfNewPhilosophers];
				System.out.println(" Some new philosopher(s) came in for a dinner.+++++++++++++++++++");
				for(int j = 0; j < numberOfNewPhilosophers; j++)
				{
					newPhilosophers[j] = new Philosopher();
					DiningPhilosophers.soMonitor.newPhilosopherComeIn();
					newPhilosophers[j].start();
				}
			}

			// Main waits for all its children to die...
			// I mean, philosophers to finish their dinner.
			for(int j = 0; j < iPhilosophers; j++)
				aoPhilosophers[j].join();

			System.out.println("All philosophers have left. System terminates normally.");
		}
		catch(InterruptedException e)
		{
			System.err.println("main():");
			reportException(e);
			System.exit(1);
		}
	} // main()

	/**
	 * Outputs exception information to STDERR
	 * @param poException Exception object to dump to STDERR
	 */
	public static void reportException(Exception poException)
	{
		System.err.println("Caught exception : " + poException.getClass().getName());
		System.err.println("Message          : " + poException.getMessage());
		System.err.println("Stack Trace      : ");
		poException.printStackTrace(System.err);
	}
}

// EOF
