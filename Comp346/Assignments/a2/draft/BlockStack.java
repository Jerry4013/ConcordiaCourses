package a2.draft;

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
class BlockStack {
	/**
	 * # of letters in the English alphabet + 2
	 */
	private static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	private static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;

	public int getISize() {
		return iSize;
	}

	public int getITop() {
		return iTop;
	}

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};

	private int stackAccessCounter = 0;

	/**
	 * Default constructor
	 */
	public BlockStack() {
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize) {
		if(piSize != DEFAULT_SIZE) {
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++) {
				this.acStack[i] = (char)('a' + i);
			}

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
			this.iSize = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick() {
		stackAccessCounter++;
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition) {
		stackAccessCounter++;
		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) {
		stackAccessCounter++;
		this.acStack[++this.iTop] = pcBlock;
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop() {
		stackAccessCounter++;
		char cBlock = this.acStack[this.iTop];
		this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
		return cBlock;
	}

	public boolean isEmpty() {
		return (this.iTop == -1);
	}

	public int getAccessCounter() {
		return stackAccessCounter;
	}
}

// EOF
