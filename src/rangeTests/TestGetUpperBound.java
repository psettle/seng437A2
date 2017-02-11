package rangeTests;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class TestGetUpperBound {

	private static final int DEFAULT_TIMEOUT = 2000;
	
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testLowerBoundNegativeInfinity() {
		
		Range range = new Range(Double.NEGATIVE_INFINITY, 5);
		
		assertEquals("Testing getUpperBound with Lower == -infinity", 5, range.getUpperBound(), 0);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testUpperBoundPositiveInfinity() {
		
		Range range = new Range(44, Double.POSITIVE_INFINITY);
		
		assertEquals("Testing getUpperBound with Upper == +infinity", Double.POSITIVE_INFINITY, range.getUpperBound(), 0);
		
	}
	
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testValidRangeNeitherInfinity() {
		
		Range range = new Range(-1000, -444);
		
		assertEquals("Testing a valid range, (-1000, -444)", -444, range.getUpperBound(), 0);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testLowerEqualsUpper() {
		
		Range range = new Range(0, 0);
		
		assertEquals("Testing getUpperBound with Lower == Upper", 0, range.getUpperBound(), 0);
		
	}
	

}
