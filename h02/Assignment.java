package edu.ics211.h02;

public class Assignment extends BasicStatement{
	
	
	public Assignment(String[] tokens) throws InvalidStatementException {
		if (isJavaIdentifier(tokens[0]) && tokens[1].equals("=") && tokens[tokens.length - 1].equals(";")) {
			
			this.tokens = tokens;
		} else {
			throw new InvalidStatementException();
		}
	}

	
	public String getVariable() {
		return tokens[0];
	}

}
