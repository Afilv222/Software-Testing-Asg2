package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ToString {
	
	@Test
	void stringWhenBothZero() {
		Range range = new Range(0, 0);
		assertEquals("Range[0.0,0.0]", range.toString());
	}

	@Test
	void stringWhenBothPositive() {
		Range range = new Range(1, 5);
		assertEquals("Range[1.0,5.0]", range.toString());
	}
	
	@Test
	void stringWhenBothPositiveHighValues() {
		Range range = new Range(2000, 99999);
		assertEquals("Range[2000.0,99999.0]", range.toString());
	}
	
	@Test
	void stringWhenLowerNegitive() {
		Range range = new Range(-3, 5);
		assertEquals("Range[-3.0,5.0]", range.toString());
	}
	
	@Test
	void stringWhenLowerNegitiveHighValues() {
		Range range = new Range(-99999, 99999);
		assertEquals("Range[-99999.0,99999.0]", range.toString());
	}
	
	@Test
	void stringWhenBothNegitive() {
		Range range = new Range(-9, -2);
		assertEquals("Range[-9.0,-2.0]", range.toString());
	}
	
	@Test
	void stringWhenBothNegitiveHighValues() {
		Range range = new Range(-99999, -2000);
		assertEquals("Range[-99999.0,-2000.0]", range.toString());
	}

}
