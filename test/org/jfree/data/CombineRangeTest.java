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

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
