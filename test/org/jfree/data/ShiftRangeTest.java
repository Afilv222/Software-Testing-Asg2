package org.jfree.data;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ShiftRangeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	// When base is null -> Return InvalidParameterException 
	// Failing due to dependancy on get lower bound???
	@Test
	void Base_null() {

		Range base = null;

		assertThrows(InvalidParameterException.class, () -> {
			Range.shift(base, 6.0);
		});

	}
	
	// proper Functionality
	// Delta = 0
	// Delta < 0
	// Cross zero
		// Zero Crossing
		// cross zero when allowZeroCrossing
		// cross zero when !allowZeroCrossing
	//
	@ParameterizedTest
	@CsvFileSource(resources = "/CSVData/shiftdata.csv", numLinesToSkip = 1)
	void ShiftRangeCSVFileTest(double lowerBound, double upperBound, double delta, double eLower, double eUpper, boolean allowZeroCrossing)
			throws Exception {

		Range base = new Range(lowerBound, upperBound);
		Range expected = new Range(eLower, eUpper);

		//System.out.println(base.getUpperBound());
		Range actual = Range.shift(base, delta, allowZeroCrossing);
		//System.out.println(base.getUpperBound());

		Assert.assertEquals(expected, actual);
	}
	


}
