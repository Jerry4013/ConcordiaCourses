package a2.task3;
import a2.task3.exceptions.EmptyStackException;
import a2.task3.exceptions.FullStackException;
import a2.task3.exceptions.InvalidPositionException;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/02/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;				//task2

	public int getSize() {				//task0
		return iSize;
	}			//task2

	public int getTop() {				//task0
		return iTop;
	}			//task2

	public int getAccessCounter() {		//task0
		return stackAccessCounter;
	}		//task2

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;							//task2

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '*', '*'};  //task1 //task2

	private int stackAccessCounter = 0;       	//task1	//task2

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '*';  //task1

			this.iTop = piSize - 3;
			this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick() throws EmptyStackException
	{
		stackAccessCounter++;             			 //task1
		if (isEmpty()){								//task2
			throw new EmptyStackException();
		}
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition) throws InvalidPositionException
	{
		stackAccessCounter++;                 		  //task1
		if (piPosition >= iSize || piPosition <0){		//task2
			throw new InvalidPositionException();
		}
		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws FullStackException
	{
		stackAccessCounter++;                         //task1

		//task2
		if (iTop >= iSize - 1){
			throw new FullStackException();
		}
		if (isEmpty()){
			this.acStack[++this.iTop] = 'a';
		} else{
			this.acStack[++this.iTop] = pcBlock;
			System.out.println("Successful push!");       //task1
		}
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop() throws EmptyStackException
	{
		stackAccessCounter++;                          //task1
		if (isEmpty()){									//task2
			throw new EmptyStackException();
		}
		char cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '*'; // Leave prev. value undefined   //task1
		System.out.println("Successful pop!");         //task1
		return cBlock;
	}

	public boolean isEmpty() {							//task0
		return (this.iTop == -1);
	}
}

// EOF
