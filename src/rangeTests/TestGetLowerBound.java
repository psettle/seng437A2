package rangeTests;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class TestGetLowerBound {
	
	private static final int DEFAULT_TIMEOUT = 2000;
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testLowerBoundNegativeInfinity() {
		
		Range range = new Range(Double.NEGATIVE_INFINITY, 5);
		
		assertEquals("Testing getLowerBound with Lower == -infinity", Double.NEGATIVE_INFINITY, range.getLowerBound(), 0);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testUpperBoundPositiveInfinity() {
		
		Range range = new Range(44, Double.POSITIVE_INFINITY);
		
		assertEquals("Testing getLowerBound with Upper == +infinity", 44, range.getLowerBound(), 0);
		
	}
	
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testValidRangeNeitherInfinity() {
		
		Range range = new Range(-1000, -444);
		
		assertEquals("Testing a valid range, (-1000, -444)", -1000, range.getLowerBound(), 0);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testUpperBoundNAN() {
		
		Range range = new Range(0, Double.NaN);
		
		assertEquals("Testing getLowerBound with Upper == NaN", 0, range.getLowerBound(), 0);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testLowerBoundNAN() {
		
		Range range = new Range(Double.NaN, 55);
		
		assertEquals("Testing getLowerBound with Lower == NaN", Double.NaN, range.getLowerBound(), 0);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testLowerEqualsUpper() {
		
		Range range = new Range(0, 0);
		
		assertEquals("Testing getLowerBound with Lower == Upper", 0, range.getLowerBound(), 0);
		
	}
	
	
}
