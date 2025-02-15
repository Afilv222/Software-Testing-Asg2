package org.jfree.data;

import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ConstrainRangeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void whenRangeisNull() throws Exception {

		assertThrows(Exception.class, () -> {
			double actual;

			Range range1 = null;

			actual = range1.constrain(1.9);

		});
	}

	// Test all valid constrains conditions
	// Tests when value is within the Range
	// Tests when value contains decimals if it's within the Range
	// Tests when value is below the lower bound
	// Tests when value is above the upper bound
	// Tests when value is exactly at lower bound
	// Tests when value is exactly at upper bound
	// Tests when value is below a negative boundary
	// Tests when value is above a negative boundary
	// Tests when value is within negative boundary
	// Tests when value is large number
	// Tests when value is large number

	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/constraindata.csv", numLinesToSkip = 1)
	void CSVFileValidTest(double lowerBound, double upperBound, double value, double expected) throws Exception {

		Range range1 = new Range(lowerBound, upperBound);

		double actual = range1.constrain(value);

		Assert.assertEquals(expected, actual, 0.1);
	}

}
