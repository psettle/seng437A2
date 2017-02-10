package rangeTests;

import org.junit.runner.RunWith;
import rangeTests.testShiftNoCross.TestShiftRangeBelowZero;
import rangeTests.testShiftNoCross.TestShiftRangePastZero;
import rangeTests.testShiftNoCross.TestShiftRangeSpansZero;

import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestContains.class,
	TestGetLength.class,
	TestGetLowerBound.class,
	TestGetUpperBound.class,
	TestShiftRangeBelowZero.class,
	TestShiftRangePastZero.class,
	TestShiftRangeSpansZero.class
})


public class RangeTestSuite {}
