package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EqualsRangeTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	// ++++++++++++++++++++++ EQUALS TEST ++++++++++++++++++++++

	// when both ranges are the same return true
	@Test
	void equals_WhenRangesSameReturnTrue() {
		Range range1 = new Range(1.0, 5.0);
		Range range2 = new Range(1.0, 5.0);

		boolean actualRange = range1.equals(range2);

		Assert.assertTrue(actualRange);
	}
	
	// when both ranges are the different return false
	@Test
	void equals_WhenRangesDiffFalse() {
		Range range1 = new Range(1.0, 5.0);
		Range range2 = new Range(2.0, 6.0);

		boolean actualRange = range1.equals(range2);

		Assert.assertFalse(actualRange);
	}

	// when comparing with null value return false
	@Test
	void equals_WhenComparingNullFalse() {
		Range range1 = new Range(1.0, 5.0);
		Range range2 = null;

		boolean actualRange = range1.equals(range2);

		Assert.assertFalse(actualRange);
	}

}
