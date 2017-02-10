package rangeTests;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class TestGetLength {

	@Test
	public void testValidLowerLessThanUpper() {
		
		Range r = new Range(-3.5, 4.7);
		
		assertEquals("Testing a Range that has LowerBound < UpperBound", 8.2, r.getLength(), 0.000001);
		
	}
	
	@Test
	public void testValidLowerEqualsUpper() {
		
		Range r = new Range(3.0, 3.0);
		
		assertEquals("Testing a Range that has LowerBound == UpperBound", 0, r.getLength(), 0.000001);
		
	}
	
	@Test
	public void testUpperBoundNotANumber() {
		
		Range r = new Range(-2.0, Double.NaN);
		
		assertEquals("Testing a Range that has LowerBound == NaN", Double.NaN, r.getLength(), 0);
		
	}
	
	@Test
	public void testLowerBoundNegativeInfinity() {
		
		Range r = new Range(Double.NEGATIVE_INFINITY, 3.0);
		
		assertEquals("Testing a Range that has LowerBound == -Infinity", Double.POSITIVE_INFINITY, r.getLength(), 0);
		
	}
	
	@Test
	public void testUpperBoundPositiveInfinity() {
		
		Range r = new Range(-4.7, Double.POSITIVE_INFINITY);
		
		assertEquals("Testing a Range that has UpperBound == +Infinity", Double.POSITIVE_INFINITY, r.getLength(), 0);
		
	}


}
