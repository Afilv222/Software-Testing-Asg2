package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GetUpperBound {

	@Test
	void getUpperBoundZero() {
		Range range = new Range(0, 0);
		assertEquals(0, range.getUpperBound());
	}

	@Test
	void getUpperBoundPositive() {
		Range range = new Range(9, 15);
		assertEquals(15, range.getUpperBound());
	}

	@Test
	void getUpperBoundPositiveHighValue() {
		Range range = new Range(9, 999999);
		assertEquals(999999, range.getUpperBound());
	}

	@Test
	void getUpperBoundNegitive() {
		Range range = new Range(-15, -5);
		assertEquals(-5, range.getUpperBound());
	}

	@Test
	void getUpperBoundNegitiveHighValue() {
		Range range = new Range(-9999999, -999999);
		assertEquals(-999999, range.getUpperBound());
	}

	@Test
	void getUpperBoundHighValueWithNegitiveLower() {
		Range range = new Range(-99999, 9999999);
		assertEquals(9999999, range.getUpperBound());
	}

}
