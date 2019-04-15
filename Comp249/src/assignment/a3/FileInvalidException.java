
// -----------------------------------------------------
// Assignment 3
// Question:
// Written by: Jingchao Zhang, 40049474
// -----------------------------------------------------

/**
 * Name(s) and ID(s): Jingchao Zhang 40049474 <br>
 * COMP249 <br>
 * Assignment # 3 <br>
 * Due Date: Mar 16, 2018 <br>
 * Purpose: define a Exception for Invalid Files  
 */
package assignment.a3;

public class FileInvalidException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public FileInvalidException(){
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
	}
	
	public FileInvalidException(String m){
		super(m);
	}
	
	
}
