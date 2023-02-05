package edu.ics211.h02;

/**
 * BasicStatement, non-abstract subclass of Statement. Superclass of Methodcall and Assignment
 * @author Warner, Robert
 */

public class BasicStatement extends Statement{
	
	// basic constructor
	public BasicStatement() {}
	
	// constructor that takes string array
	public BasicStatement(String[] tokens) {
		this.tokens = tokens;
	}
	
	/**
	 * Check if statement is a Compound statement
	 * returns true if it is, else false
	 */
	public boolean isCompound() {
		return false;
	}
}
