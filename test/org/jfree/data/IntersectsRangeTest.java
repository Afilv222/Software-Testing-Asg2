package org.jfree.data;

import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class IntersectsRangeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void Range_null() {

		Range range = null;

		assertThrows(NullPointerException.class, () -> {
			range.intersects(1.0, 6.0);
		});

	}

	@Test
	void test() {
		Range range1 = new Range(3.0, 5.0);

		System.out.println(range1.intersects(1.0, 6.0));
		// Assert.assertTrue(range1.intersects(3.0, 6.0));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/intersectsdata.csv", numLinesToSkip = 1)
	void IntersectsRangeCSVFileTest(double rlower, double rUpper, double iLower, double iUpper, boolean expectedResult)
			throws Exception {

		Range range = new Range(rlower, rUpper);

		boolean actualResult = range.intersects(iLower, iUpper);

		Assert.assertEquals(expectedResult, actualResult);
	}

}
