package org.jfree.data;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;;

@RunWith(Suite.class)
@SuiteClasses({CentralValueTest.class,
	CombineRangeTest.class,
	DataUtilitiesTest.class,
	EqualsRangeTest.class,
	ExpandRangeTest.class,
	RangeTest.class})
class TestAll {

}
