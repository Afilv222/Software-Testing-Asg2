package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ExpandRangeTest {

	@Test
	void test() {
		fail("Not yet implemented");
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
	
	// Tests Cases: expandrangedata.cvs
	// T2 - testing expand of different ranges
	// T3 - testing expand of positive equal ranges
	// T4 - testing expand of balanced range with different ranges
	// T5 - testing expand of uneven range with different LE & UE
	// T6 - testing exapnd of range equally
	// T7 - testing expand of negative/zero range with a valid range
	// T8 - testing expand of nagative/positive large ranges
	// T9 - testing expand of a range from negative to positive
	// T10 - testing expand of just a decimal difference
	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/expandrangedata.csv", numLinesToSkip = 1)
	void testExpandRange(double lower, double upper, double lowerExpand, double upperExpand, double expectedLower, double expectedUpper) {
		Range range = new Range(lower, upper);
		Range expanded = Range.expand(range, lowerExpand, upperExpand);
		
		assertEquals(expectedLower, expanded.getLowerBound(), "Expanded Range Lower Bound Mismatch.");
		assertEquals(expectedUpper, expanded.getUpperBound(), "Expanded Range Upper Bound Mismatch.");
    }
}
