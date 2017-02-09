package rangeTests.testShiftNoCross;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class testRangeBelowZero {

	private Range range;
	
	@Before
	public void setupRange() {
		this.range = new Range(-75, -70);
	}
	
	@Test
	public void testNegativeShift() {
		assertEquals(new Range(-76, -71), Range.shift(this.range, -1));
	}
	
	@Test
	public void testPositiveShiftStaysBelowZero() {
		assertEquals(new Range(-5, 0), Range.shift(this.range, 70));
	}
	
	@Test 
	public void testPositiveShiftBlocksAtZero() {
		assertEquals(new Range(-5, 0), Range.shift(this.range, 80000000));
	}
}
