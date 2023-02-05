package edu.ics211.h02;

public class WhileLoop extends CompoundStatement{
	
	public WhileLoop(String[] tokens) throws InvalidStatementException {
		if (tokens[0].equals("while") && tokens[1].equals("(")) {    //checks parameters
			this.tokens = tokens;
		} else {
			throw new InvalidStatementException();
		}
	}
	/**
	 * find number of tokens in the compund statement
	 * @return integer of number of parts to while loop statement
	 */
	@Override
	public int numberOfParts() {
		return 1;
	}
	
}
