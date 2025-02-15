package org.jfree.data;

import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ContainsRangeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void eisNull() throws Exception {

//		Range range69 = new Range(-3.0, 5.0);
//
//		System.out.println(range69);
//		System.out.println(range69.getUpperBound());
//		System.out.println(range69.getLowerBound());

		assertThrows(Exception.class, () -> {

			boolean actual;

			Range range = new Range(15.0, 9.0);

			actual = range.contains(6.0);

		});
	}

	// Test all valid constrains conditions
	// Tests when value is within the Range result will be true
	// Tests when value is zero and still within the Range result will be true
	// Tests when value is exactly at lower bound the result will be true
	// Tests when value is exactly at upper bound the result will be true
	// Tests when value contains decimals if it's within the Range the result will
	// be true

	// Tests when value contains decimals if it's not within the Range the result
	// will be false

	// Tests when both upper and lower bonds are negatives and value is not within
	// the range the result will be false

	//
	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/containsdata.csv", numLinesToSkip = 1)
	void ContainsRangeCSVFileTest(double lowerBound, double upperBound, double value) throws Exception {

		Range range = new Range(lowerBound, upperBound);

		boolean valueWithInRange = range.contains(value);

		if (valueWithInRange) {
			Assert.assertTrue(valueWithInRange);
		} else {
			Assert.assertFalse(valueWithInRange);
		}

	}

}
