package edu.ics211.h03;

/**
 * MethodCall, object to represent a statements with a methodcall-type statement in java
 * @author Warner, Robert
 */
public class MethodCall extends BasicStatement{
	public MethodCall(String method, String[] parameters) throws InvalidStatementException {
		String[] tokens = new String[parameters.length + 4];
		tokens[0] = method;
		tokens[1] = "(";
		for (int i = 2; i < tokens.length - 2; i++) {
			tokens[i] = parameters[i-2];
		}
		tokens[tokens.length - 2] = ")";
		tokens[tokens.length - 1] = ";";
		if (isJavaIdentifier(tokens[0]) &&    //checks if first token is a java identifier
				tokens[1].equals("(") &&     //2nd token is a open parenthesis "("
				tokens[tokens.length - 2].equals(")") &&    //2nd to last token is a closed parenthesis ")"
				tokens[tokens.length - 1].equals(";")) {    //last token is semi-colon ";"
			this.tokens = tokens;
		} else {
			throw new InvalidStatementException();
		}
	}
	
	public MethodCall(String[] tokens) throws InvalidStatementException {
		if (isJavaIdentifier(tokens[0]) &&    //checks if first token is a java identifier
				tokens[1].equals("(") &&     //2nd token is a open parenthesis "("
				tokens[tokens.length - 2].equals(")") &&    //2nd to last token is a closed parenthesis ")"
				tokens[tokens.length - 1].equals(";")) {    //last token is semi-colon ";"
			this.tokens = tokens;
		} else {
			throw new InvalidStatementException();
		}
	}
	
	/**
	 * returns the method name, which is the first token of the array
	 * @return tokens[0], corresponding to the first token
	 */
	public String getMethodName() {
		return tokens[0];
	}

}
