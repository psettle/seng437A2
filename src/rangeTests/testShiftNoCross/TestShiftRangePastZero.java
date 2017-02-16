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
	
	/*
	 * This tests shifting an above zero range toward pos_inf
	 */
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testPositivehift() {
		assertEquals("Testing positive shift of positive range", new Range(5, 8), Range.shift(this.range, 1));
	}
	
	/**
	 * This tests shift an above zero range towards 0 in a way that should leave it above zero
	 */
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testNegativeShiftStaysAboveZero() {
		assertEquals("Testing negative shift of a positive range", new Range(3, 6), Range.shift(this.range, -1));
	}
	
	/**
	 * This tests a negative shift of an above zero range in a way that brings it right to zero
	 */
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testNegativeShiftToZero() {
		assertEquals("Testing shift to zero of a positive range", new Range(0, 3), Range.shift(this.range, -4));
	}
	
	/**
	 * This tests a negative shift of an above zero range past zero
	 */
	@Test(timeout=DEFAULT_TIMEOUT) 
	public void testNegativeShiftBlocksAtZero() {
		assertEquals("Testing shift past zero of a positive range", new Range(0, 3), Range.shift(this.range, -5));
	}
}
