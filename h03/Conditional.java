package edu.ics211.h03;

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
	
	public Conditional(String[] condition, Statement[] thenPart, Statement[] elsePart) throws InvalidStatementException {
		String[] tokens = new String[condition.length + thenPart.length + elsePart.length + 8];
		tokens[0] = "if";
		tokens[1] = "(";
		for (int i = 2; i < tokens.length - thenPart.length - elsePart.length - 6; i++) {
			tokens[i] = condition[i-2];
		}
		tokens[condition.length + 2] = ")";
		tokens[condition.length + 3] = "{";
		for (int i = condition.length + 4; i < tokens.length - elsePart.length - 4; i++) {
			tokens[i] = thenPart[i-condition.length - 4].toString();
		}
		tokens[condition.length + thenPart.length + 4] = "}";
		tokens[condition.length + thenPart.length + 5] = "else";
		tokens[condition.length + thenPart.length + 6] = "{";
		for (int i = condition.length + thenPart.length + 7; i < tokens.length - 1; i++) {
			tokens[i] = elsePart[i - condition.length - thenPart.length - 7].toString();
		}
		tokens[condition.length + thenPart.length + elsePart.length + 7] = "}";

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
