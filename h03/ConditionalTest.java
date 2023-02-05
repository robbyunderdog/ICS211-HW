package edu.ics211.h03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author esb
 * @author Warner, Robert
 *
 */
class ConditionalTest {

	Conditional if1;
	Conditional if2;
	
	final static String[] test1 = {
             "if", "(", "a", ">", "3", ")", "{",
                 "lifeIsGood", "(", ")", ";",
              "}", "else", "{",
                 "lifeIsVeryGood", "(", "2", ")", ";",
              "}" };

	@BeforeEach
	void setUp() throws Exception {
		if1 = new Conditional(test1);
		if2 = new Conditional(test1);
	}

	@Test
	void test() {
		assertTrue(if1.isCompound());
		assertEquals(if1.numberOfParts(), 2);
		assert(if1.toString().equals("if ( a > 3 ) { lifeIsGood ( ) ; } else { lifeIsVeryGood ( 2 ) ; }"));
		assert(if1.equals(if2));
	}

}