package rangeTests.testShiftNoCross;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class TestShiftRangeSpansZero {

	private Range range;
	
	@Before
	public void setupRange() {
		this.range = new Range(-2, 2);
	}
	
	@Test
	public void testPositivehiftStaysBelowZero() {
		assertEquals(new Range(-1, 3), Range.shift(this.range, 1));
	}
	
	@Test
	public void testNegativeShiftStaysAboveZero() {
		assertEquals(new Range(-4, 0), Range.shift(this.range, -2));
	}
	
	@Test 
	public void testPositiveShiftBlocksAtZero() {
		assertEquals(new Range(0, 4), Range.shift(this.range, 3));
	}
	
	@Test 
	public void testNegativeShiftBlocksAtZero() {
		assertEquals(new Range(-4, 0), Range.shift(this.range, -3));
	}
	
	@Test
	public void testNoShift() {
		assertEquals(new Range(-2, 2), Range.shift(this.range, 0));
	}
}
