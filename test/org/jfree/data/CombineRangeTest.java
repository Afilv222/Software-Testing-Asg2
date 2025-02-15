package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

		Assert.assertNull(actual);

		// Assert.assertEquals(expected, actual);

	}

	@Test
	void combine_WhenFirstRangeIsNull_ReturnsSecondRange() {

		Range range1 = null;
		Range range2 = new Range(3.0, 5.0);

		Range expectedRange = range2;

		Range actualRange = Range.combine(range1, range2);

		Assert.assertEquals(expectedRange, actualRange);

	}

	@Test
	void combine_WhenSecondRangeIsNull_ReturnsFirstRange() {

		Range range1 = new Range(1.0, 5.0);
		Range range2 = null;

		Range expectedRange = range1;

		Range actualRange = Range.combine(range1, range2);

		Assert.assertEquals(expectedRange, actualRange);

	}

	// Test all valid combine ranges
	// Tests When Both Ranges Dont OverLap
	// Tests when both ranges touch at single point
	// Tests when WhenBothRangesOverlap
	// Tests when one range is within the other range
	// Tests again when one range is within the other range but reversed
	// Tests when both ranges are equal to each other

	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/combinedata.csv", numLinesToSkip = 1)
	void CSVFileValidTest(double r1Lower, double r1Upper, double r2Lower, double r2Upper, double eLower, double eUpper)
			throws Exception {

		Range range1 = new Range(r1Lower, r1Upper);
		Range range2 = new Range(r2Lower, r2Upper);

		Range actualRange = Range.combine(range1, range2);

		assertAll(() -> assertEquals(eLower, actualRange.getLowerBound()),
				() -> assertEquals(eUpper, actualRange.getUpperBound()));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
