package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetLength {

	@Test
	void lengthZero() {
		Range range = new Range(0, 0);
		assertEquals(0, range.getLength());
	}
	
	@Test
	void lengthZeroToPositive() {
		Range range = new Range(0, 10);
		assertEquals(10, range.getLength());
	}
	
	@Test
	void lengthZeroToPositiveHighValue() {
		Range range = new Range(0, 999999999);
		assertEquals(999999999, range.getLength());
	}
	
	@Test
	void lengthZeroToNegitive() {
		Range range = new Range(-10, 0);
		assertEquals(10, range.getLength());
	}
	
	@Test
	void lengthZeroToNegitiveHighValue() {
		Range range = new Range(-999999999, 0);
		assertEquals(999999999, range.getLength());
	}
	
	@Test
	void lengthPositiveToNegitive() {
		Range range = new Range(-10, 10);
		assertEquals(20, range.getLength());
	}
	
	@Test
	void lengthPositiveToNegitiveHighValue() {
		Range range = new Range(-999999999, 999999999);
		assertEquals(1999999998, range.getLength());
	}

}
