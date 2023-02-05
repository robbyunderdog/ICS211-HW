package edu.ics211.h03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author esb
 * @author Warner, Robert
 *
 */
class MethodCallTest {
	
	MethodCall mc1;
	MethodCall mc2;
	
	@BeforeEach
	void setUp() throws Exception {
                String[] tokens = { "f", "(", "n", ")", ";" };
		mc1 = new MethodCall(tokens);
		mc2 = new MethodCall(tokens);
	}

	@Test
	void test() {
		assertFalse(mc1.isCompound());
		assertEquals(mc1.getMethodName(), "f");
		assert(mc1.toString().equals("f ( n ) ;"));
		assert(mc1.equals(mc2));
	}

}