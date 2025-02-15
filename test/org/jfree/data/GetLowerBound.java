package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetLowerBound {

	@Test
	void getLowerBoundZero() {
		Range range = new Range(0, 5);
		assertEquals(0, range.getLowerBound());
	}
	
	@Test
	void getLowerBoundPositive() {
		Range range = new Range(5, 15);
		assertEquals(5, range.getLowerBound());
	}
	
	@Test
	void getLowerBoundPositiveHighValue() {
		Range range = new Range(99999, 999999);
		assertEquals(99999, range.getLowerBound());
	}

	@Test
	void getLowerBoundNegitive() {
		Range range = new Range(-5, 15);
		assertEquals(-5, range.getLowerBound());
	}
	
	@Test
	void getLowerBoundNegitiveHighValue() {
		Range range = new Range(-99999, 15);
		assertEquals(-99999, range.getLowerBound());
	}
	
	@Test
	void getLowerBoundNegitiveHighValueWithNegitiveUpper() {
		Range range = new Range(-99999, -15);
		assertEquals(-99999, range.getLowerBound());
	}
}
