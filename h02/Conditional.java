package edu.ics211.h02;

/**
 * Conditional, determines if array of strings is indeed a conditional statement, looking for
 * if - else statements with proper syntax. Subclass of CompoundStatement.
 * @author Warner, Robert
 */

public class Conditional extends CompoundStatement{
	
	/**
	 * checks if string array is a conditional statement and if all parameters check out, it sets tokens to the input
	 * else is returns an invalidstatementexception
	 */
	public Conditional(String[] tokens) throws InvalidStatementException {
		boolean containsElse = false;
		for(int i = 2; i < tokens.length-1; i++) {
			if (tokens[i].equals("else")) {
				containsElse = true;
				break;
			}
		}
		if (tokens[0].equals("if") && tokens[1].equals("(") && containsElse && tokens[tokens.length-1].equals("}")) {
			this.tokens = tokens;
		} else {
			throw new InvalidStatementException();
		}
	}
	
	
	// number of parts from compoundstatement, returns default integer of 2
	public int numberOfParts() {
		return 2;
	}

}
