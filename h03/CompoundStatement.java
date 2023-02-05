package edu.ics211.h03;

/**
 * CompoundStatement, abstract subclass of Statement. Superclass of Conditional and WhileLoop
 * @author Warner, Robert
 */

public abstract class CompoundStatement extends Statement{
	
	/**
	 * Find number of parts of compound statement
	 * @return integer of number of parts
	 */
	public abstract int numberOfParts();
	
	/**
	 * Checks if its a compound statement
	 * @return true if it is, else false
	 */
	public boolean isCompound() {
		return true;
	}

}
