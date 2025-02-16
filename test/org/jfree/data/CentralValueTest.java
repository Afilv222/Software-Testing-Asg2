package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CentralValueTest {

	@Test
	void test() {
		fail("Not yet implemented");
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

	// Test: for centralvaluedata.csv
	// Testing lower and upper equals the mid value (for all)
	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/centralvaluedata.csv", numLinesToSkip = 1)
	void testCentralValue(double lower, double upper, double expectedCentral) {
		Range range = new Range(lower, upper);
		
		assertEquals(expectedCentral, range.getCentralValue(), "Central Value Wong.");
    }



}
