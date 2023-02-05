package edu.ics211.h03;

public class WhileLoop extends CompoundStatement{
	
	public WhileLoop(String[] tokens) throws InvalidStatementException {
		if (tokens[0].equals("while") && tokens[1].equals("(")) {    //checks parameters
			this.tokens = tokens;
		} else {
			throw new InvalidStatementException();
		}
	}
	
	public WhileLoop(String[] condition, Statement[] loopBody) throws InvalidStatementException{
		String[] tokens = new String[condition.length + loopBody.length + 5];
		tokens[0] = "while";
		tokens[1] = "(";
		for (int i  = 2; i < tokens.length - loopBody.length - 3; i++) {
			tokens[i] = condition[i-2];
		}
		tokens[condition.length + 2] = ")";
		tokens[condition.length + 3] = "{";
		for (int i = condition.length + 4; i < tokens.length - 1; i++) {
			tokens[i] = loopBody[i-condition.length - 4].toString();
		}
		tokens[condition.length + loopBody.length + 4] = "}";
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
