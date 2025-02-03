package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

}
