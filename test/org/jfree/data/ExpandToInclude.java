package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ExpandToInclude {
	
	
	// 	test following cases:
	// 	All zeros range expanding zero
	// 	Zero within range
	// 	Positive number within range
	//	Negative number within range
	//	Expanding above all positive range
	//	Expanding below all positive range
	//	Expanding above all negative range
	//	Expanding below all negative range
	//	Expanding above positive and negative range
	//	Expanding below positive and negative range
	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/expandtoincludedata.csv", numLinesToSkip = 1)
	void expandToIncludeCSVFileValidTest(double lowerBound, double upperBound, double eLowerBound, double eUpperBound, double value) throws Exception {

		Range range = new Range(lowerBound, upperBound);
		Range actual = Range.expandToInclude(range, value);
		Range expected = new Range(eLowerBound, eUpperBound);

		assertEquals(expected, actual);
	}
	
	@Test
	void expandToIncludeNullTest() throws Exception {

		Range range = null;
		Range actual = Range.expandToInclude(range, 11);
		Range expected = new Range(11, 11);

		assertEquals(expected, actual);
	}


}
