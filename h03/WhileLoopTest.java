package edu.ics211.h03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author esb
 * @author Warner, Robert
 *
 */
class WhileLoopTest {

	WhileLoop wl1;
	WhileLoop wl2;

        final static String[] test1 = {
             "while", "(", "x", ">", "0", ")", "{",
                 "x", "=", "x", "-", "1", ";",
              "}" };
        
	@BeforeEach
	void setUp() throws Exception {
		wl1 = new WhileLoop(test1);
		wl2 = new WhileLoop(test1);
	}

	@Test
	void test() {
		assertTrue(wl1.isCompound());
		assertEquals(wl1.numberOfParts(), 1);
		assert(wl1.toString().equals("while ( x > 0 ) { x = x - 1 ; }"));
		assert(wl1.equals(wl2));
	}

}