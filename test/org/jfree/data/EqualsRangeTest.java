package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

	// Tests Cases: eqaulsdata.cvs
	// T2 - testing identical ranges (expected: true)
	// T3 - testing identical positive upper (expected: true)
	// T4 - testing different upper bounds (expected: false)
	// T5 - testing identical negative ranges (expected: true)
	// T6 - testing identical zero ranges (expected: true)
	// T7 - testing different negative upper bounds (expected: false)
	// T8 - testing different positive upper bounds (expected: false)
	// T9 - testing negative large range lower bounds & large positive bounds
	// (expected:true)
	// T10 - testing different negative lower bound (expected: false)
	// T11 - testing different ranges (expected: false)
	// T12 - testing different bounds both (expected: false)
	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/equalsdata.csv", numLinesToSkip = 1)
	void testEqualsRange(double lower1, double upper1, double lower2, double upper2, boolean expected) {
		Range range1 = new Range(lower1, upper1);
		Range range2 = new Range(lower2, upper2);

		assertEquals(expected, range1.equals(range2), "Equality test failed.");
	}

}
