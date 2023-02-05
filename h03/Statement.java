package edu.ics211.h03;

public abstract class Statement {
	
	protected String[] tokens;
	
	/**
	 * Checks if statement is a compound statement
	 * @return true if it is, false otherwise
	 */
	public abstract boolean isCompound();
	
	@Override
	public String toString() {
		
		//creates new stringbuilder object
		StringBuilder sb = new StringBuilder();
		
		//loop through all tokens and add to stringbuilder
		for (int i = 0; i < this.tokens.length; i++) {
			sb.append(tokens[i]);
			if (i < tokens.length-1) {
				sb.append(" ");
			}
		}
		
		//casts stringbuilder contents to string and returns it
		return sb.toString();
	}
	
	public boolean equals(Object obj) {
		
		//checks for wrong class
		if (obj == null) {
			return false;
		}
		
		//casts the obj to statement type
		Statement st = (Statement) obj;
		
		//compares tokens lengths
		if (this.tokens.length != st.tokens.length) {
			return false;
		}
		
		//compare tokens contents
		for (int i = 0; i < this.tokens.length; i++) {
			if (!this.tokens[i].equals(st.tokens[i])) {
				return false;
			}
		}
		
		//return true if all checks pass
		return true;
	}
	
	protected boolean isJavaIdentifier(String token) {
		//checks if first character is proper java identifier
		if (!Character.isJavaIdentifierStart(token.charAt(0))) {
			return false;
		}
		
		//checks all the other characters
		for (int i = 1; i < token.length(); i++) {
			if (!Character.isJavaIdentifierPart(token.charAt(i))) {
				return false;
			} 
		}
		
		//returns true if all checks pass
		return true;
	}


}
