package rangeTests.testShiftNoCross;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class TestShiftRangeBelowZero {

	private static final int DEFAULT_TIMEOUT = 2000;
	
	private Range range;
	
	@Before
	public void setupRange() {
		this.range = new Range(-75, -70);
	}
	
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testNegativeShift() {
		assertEquals(new Range(-76, -71), Range.shift(this.range, -1));
	}
	
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testPositiveShiftStaysBelowZero() {
		assertEquals(new Range(-5, 0), Range.shift(this.range, 70));
	}
	
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testPositiveShiftBlocksAtZero() {
		assertEquals(new Range(-5, 0), Range.shift(this.range, 80000000));
	}
}
