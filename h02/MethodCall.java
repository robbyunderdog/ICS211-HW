package edu.ics211.h02;

/**
 * MethodCall, object to represent a statements with a methodcall-type statement in java
 * @author Warner, Robert
 */
public class MethodCall extends BasicStatement{
	
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
