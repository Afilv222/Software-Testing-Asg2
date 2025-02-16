package org.jfree.data;

import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class IntersectsRangeTest {

	@Test
	void Range_null() {

		Range range = null;

		assertThrows(NullPointerException.class, () -> {
			range.intersects(1.0, 6.0);
		});

	}

	@Test
	void testInvalidRangeConstructor_ThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Range(10.0, 0.0);
		});
	}

	// Test all valid Intersects conditions
	// Tests if the Range overlaps with specified range

	// Tests if all the values are negatives and if the Range overlaps with
	// specified range

	// Tests if the specified range is within the Range boundaries
	// Tests the reversed ranges from the above example

	// Tests when the lower bounds for both ranges are overlapping

	// Tests when the Range upper boundary and specified range lower boundary are
	// overlapping

	// Tests when the Range upper boundary and specified range lower boundary are
	// overlapping but also contains negative value

	// Tests when the Ranges lower boundary and specified range upper boundary are
	// overlapping

	// Tests when specified range only overlaps exactly in the middle of the Range
	// boundary

	// Tests when large gap between Range and the specified range should return
	// false as they aren't overlapping

	// Tests when single point gap between Range and the specified range should
	// return false as they aren't overlapping

	// Tests when specified range and Range aren't overlapping

	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/intersectsdata.csv", numLinesToSkip = 1)
	void IntersectsRangeCSVFileTest(double rlower, double rUpper, double iLower, double iUpper, boolean expectedResult)
			throws Exception {

		Range range = new Range(rlower, rUpper);

		boolean actualResult = range.intersects(iLower, iUpper);

		Assert.assertEquals(expectedResult, actualResult);
	}

}
