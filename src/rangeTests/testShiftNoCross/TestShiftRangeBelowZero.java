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
	
	/**
	 * This tests shifting a range that is below zero towards neg_inf
	 */
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testNegativeShift() {
		assertEquals("Testing negative shift of a sub zero range", new Range(-76, -71), Range.shift(this.range, -1));
	}
	
	/**
	 * This tests shift a range that is below zero towards 0, but no past 0
	 */
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testPositiveShiftStaysBelowZero() {
		assertEquals("Testing positive shift of a sub zero range", new Range(-15, -10), Range.shift(this.range, 60));
	}
	
	/**
	 * This tests shifting a range that is below zero exactly to zero
	 */
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testPositiveShiftToZero() {
		assertEquals("Testing positibve shift past zero of a sub zero range", new Range(-5, 0), Range.shift(this.range, 70));
	}
	
	/**
	 * This tests shifting a range that is below zero towards and past 0
	 */
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testPositiveShiftBlocksAtZero() {
		assertEquals("Testing positibve shift past zero of a sub zero range", new Range(-5, 0), Range.shift(this.range, 80000000));
	}
}
