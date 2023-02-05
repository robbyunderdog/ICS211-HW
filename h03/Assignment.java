package edu.ics211.h03;

public class Assignment extends BasicStatement{
	
	public Assignment(String variable, String[] expression) throws InvalidStatementException{
		String[] tokens = new String[expression.length + 3];
		tokens[0] = variable;
		tokens[1] = "=";
		for (int i = 2; i < tokens.length - 1; i++) {
			tokens[i] = expression[i-2];
		}
		tokens[tokens.length - 1] = ";";
		if (isJavaIdentifier(tokens[0]) && tokens[1].equals("=") && tokens[tokens.length - 1].equals(";")) {
			this.tokens = tokens;
		} else {
			throw new InvalidStatementException();
		}
	}
	
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
