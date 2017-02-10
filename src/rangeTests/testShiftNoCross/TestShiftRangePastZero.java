package rangeTests.testShiftNoCross;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class TestShiftRangePastZero {
	
	private static final int DEFAULT_TIMEOUT = 2000;
	
	private Range range;
	
	@Before
	public void setupRange() {
		this.range = new Range(4, 7);
	}
	
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testPositivehift() {
		assertEquals(new Range(5, 8), Range.shift(this.range, 1));
	}
	
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testNegativeShiftStaysAboveZero() {
		assertEquals(new Range(3, 6), Range.shift(this.range, -1));
	}
	
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testNegativeShiftToZero() {
		assertEquals(new Range(0, 3), Range.shift(this.range, -4));
	}
	
	@Test(timeout=DEFAULT_TIMEOUT) 
	public void testNegativeShiftBlocksAtZero() {
		assertEquals(new Range(0, 3), Range.shift(this.range, -5));
	}
}
