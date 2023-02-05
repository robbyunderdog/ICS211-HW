package edu.ics211.h03;

public interface Programmer {
	Assignment makeAssignment() throws InvalidStatementException;
	MethodCall makeMethodCall() throws InvalidStatementException;
	WhileLoop makeWhileLoop() throws InvalidStatementException;
	Conditional makeConditional() throws InvalidStatementException;
	Statement makeStatement() throws InvalidStatementException;
}