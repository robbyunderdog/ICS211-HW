package edu.ics211.h03;

import java.util.Random;

public class RandomProgrammer implements Programmer{
	
	final static String[] variables = { "sushi", "pizza", "poke", "burgers", "rice", "popcorn", "fries", "wings", "sandwiches" };
	final static String[] methods = { "isDumb", "isCringe", "isGamer", "isRich", "isCool", "inspect", "getMethodName", "getVariable", "numOfParts", "isCompound" };
	final static String[] operators = { "+", "-", "*", "/", "%" };
	
	public static void main(String[] args) throws InvalidStatementException {
		RandomProgrammer rp = new RandomProgrammer();
		Statement x = rp.makeStatement();
		
		System.out.println(x.toString());
	}
	
	public Assignment makeAssignment() throws InvalidStatementException {
		String variableName = randomVariable();
		String[] expression = getExpression();
		return new Assignment(variableName, expression);
	}
	
	public MethodCall makeMethodCall() throws InvalidStatementException {
		String methodName = randomMethod();
		
		Random rand = new Random();
		int numOfParameters = rand.nextInt(4);
		String[] parameters = new String[numOfParameters];
		
		for (int i = 0; i < numOfParameters; i ++) {
			parameters = getExpression();
		}
		return new MethodCall(methodName, parameters);
	}
	
	public WhileLoop makeWhileLoop() throws InvalidStatementException {
		String variableName = randomVariable();
		
		Random rand = new Random();		
		String[] condition = new String[3];
		condition[0] = variableName;
		condition[1] = ">";
		condition[2] = Integer.toString(rand.nextInt());
		
		int numOfStatements = rand.nextInt(10) + 1;
		Statement[] statements = new Statement[numOfStatements];
		for (int i = 0; i < statements.length; i++) {
			int x = rand.nextInt(2) + 1;
			if (x == 1) {
				statements[i] = makeAssignment();
			} else {
				statements[i] = makeMethodCall();
			}
		}
		return new WhileLoop(condition, statements);
	}
	
	public Conditional makeConditional() throws InvalidStatementException {
		String variableName = randomVariable();
		
		Random rand = new Random();
				
		String[] condition = new String[3];
		condition[0] = variableName;
		condition[1] = ">";
		condition[2] = Integer.toString(rand.nextInt());
		
		int numOfStatements1 = rand.nextInt(10) + 1;
		Statement[] thenPart = new Statement[numOfStatements1];
		for (int i = 0; i < thenPart.length; i++) {
			int x = rand.nextInt(2) + 1;
			if (x == 1) {
				thenPart[i] = makeAssignment();
			} else {
				thenPart[i] = makeMethodCall();
			}
		}
		
		int numOfStatements2 = rand.nextInt(10) + 1;
		Statement[] elsePart = new Statement[numOfStatements2];
		for (int i = 0; i < elsePart.length; i++) {
			int x = rand.nextInt(2) + 1;
			if (x == 1) {
				elsePart[i] = makeAssignment();
			} else {
				elsePart[i] = makeMethodCall();
			}
		}
		
		return new Conditional(condition, thenPart, elsePart);
	}
	
	public Statement makeStatement() throws InvalidStatementException {
		Random rand = new Random();
		int number = rand.nextInt(4);
		
		switch(number) {
		case(0): return makeAssignment();
		case(1): return makeMethodCall();
		case(2): return makeWhileLoop();
		case(3): return makeConditional();
		default: return null;
		}
	}
	
	private static String randomVariable() {
		Random rand = new Random();
		return variables[rand.nextInt(variables.length)];
	}
	
	private static String randomOperator() {
		Random rand = new Random();
		return operators[rand.nextInt(operators.length)];
	}
	
	private static String randomMethod() {
		Random rand = new Random();
		return methods[rand.nextInt(methods.length)];
	}
	
	private static String[] getExpression() {
		Random rand = new Random();
		int num = rand.nextInt(3);
		if (num == 0) {
			return new String[] { randomVariable() };
		} else if (num == 1) {
			return new String[] { Integer.toString(rand.nextInt()) };
		} else {
			String[] result = new String[3];
			result[0] = randomVariable();
			result[1] = randomOperator();
			result[2] = Integer.toString(rand.nextInt());
			return result;
		}
	}
	
	
}
