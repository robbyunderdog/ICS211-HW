package edu.ics211.h03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author esb
 *@author Warner, Robert
 */
class BasicStatementTest {
	BasicStatement basic;
	BasicStatement basic2;

	@BeforeEach
	void setUp() throws Exception {
        String[] tokens = { "a", "=", "3", ";" };
		basic = new BasicStatement(tokens);
		basic2 = new BasicStatement(tokens);
	}

	@Test
	void test() {
		assertFalse(basic.isCompound());
		assert(basic.toString().equals("a = 3 ;"));
		assert(basic.equals(basic2));
	}

}