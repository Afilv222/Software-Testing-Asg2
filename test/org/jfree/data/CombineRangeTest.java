package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombineRangeTest {

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void combineRange_whenBothValuesAreNull() {
		Range range1 = null;
		Range range2 = null;

		Range expected = null;

		Range actual = Range.combine(range1, range2);

		Assert.assertEquals(expected, actual);

	}

	@Test
	void combineRange_whenR1Null_returnR2Value() {
		Range range1 = new Range(1.0, 5.0);
		Range range2 = null;

		Range actualRange = Range.combine(range1, range2);

		double higher = actualRange.getUpperBound();
		double lower = actualRange.getLowerBound();

		assertAll(() -> assertEquals(1.0, higher, 0.1), () -> assertEquals(1.0, higher, 0.1));

	}

	@Test
	void combine_WhenSeceondRangeIsNull_ReturnsOtherRange() {

		Range range1 = null;
		Range range2 = new Range(3.0, 5.0);

		Range expectedRange = range2;

		Range actualRange = Range.combine(range1, range2);

		Assert.assertEquals(expectedRange, actualRange);

	}

	@Test
	void combine_WhenFirstRangeIsNull_ReturnsOtherRange() {

		Range range1 = new Range(1.0, 5.0);
		Range range2 = null;

		Range expectedRange = range1;

		Range actualRange = Range.combine(range2, range1);

		Assert.assertEquals(expectedRange, actualRange);

	}

	@Test
	void combine_WhenBothRangesDonOverLap() {
		Range range1 = new Range(1.0, 5.0);
		Range range2 = new Range(7.0, 10.0);

		Range actualRange = Range.combine(range1, range2);

		double expectedRangeSize = actualRange.getLength();
		Assert.assertEquals(10.0, expectedRangeSize);

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

	// ++++++++++++++++++++++ EXPAND TEST ++++++++++++++++++++++

	// when expanding range it should adjust the bounds
	@Test
	void expand_WhenExpandRangeAdjustBounds() {
        	Range range1 = new Range(1.0, 5.0);
		
        	Range actualRange = Range.expand(range1, 0.25, 0.5);

        	double expectedLower = 0.0;
        	double expectedUpper = 7.0;
		
        	assertAll(
			() -> assertEquals(expectedLower, actualRange.getLowerBound(), 0.1),
            		() -> assertEquals(expectedUpper, actualRange.getUpperBound(), 0.1)
		);
	}
	
	// when in-expanding range it should adjust the bounds (reduce)
	@Test
	void expand_WhenExpandingNegativeReduceRange() {
		Range range1 = new Range(1.0, 5.0);
		Range actualRange = Range.expand(range1, -0.1, -0.2);
		
		double expectedLower = 1.4;
		double expectedUpper = 4.2;
		
		assertAll(
			() -> assertEquals(expectedLower, actualRange.getLowerBound(), 0.1),
			() -> assertEquals(expectedUpper, actualRange.getUpperBound(), 0.1)
		);
	}

	// +++++++++++++++++ GET CENTRALVALUE TEST +++++++++++++++++

	// checks getCentralValue method is valid; returns correct median
	@Test
	void getCentralValue_WhenRangeIsValid_ReturnsMedian() {
		Range range1 = new Range(1.0, 5.0);
		
		double actualValue = range1.getCentralValue();
		double expectedValue = (range1.getLowerBound() + range1.getUpperBound()) / 2.0;
		
		assertEquals(expectedValue, actualValue);
	}

	// checks getCentralValue method is valid; returns correct median
	@Test
	void getCentralValue_WhenRangeHasNegative_ReturnsMedian() {
		Range range1 = new Range(-4.0, -2.0);
		
		double actualValue = range1.getCentralValue();
		double expectedValue = (-4.0 + (-2.0)) / 2.0;

		assertEquals(expectedValue, actualValue);
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
