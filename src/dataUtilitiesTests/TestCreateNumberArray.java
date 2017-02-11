package dataUtilitiesTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class TestCreateNumberArray {

	private static final int DEFAULT_TIMEOUT = 2000;

	
	@Test (expected = InvalidParameterException.class, timeout = DEFAULT_TIMEOUT)
	public void testWithArgumentIsNull() {
		
		DataUtilities.createNumberArray(null);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testEmptyArray() {
		
		double[] testArr = {};
		
		Number[] expected = {};
		
		Number[] actual = DataUtilities.createNumberArray(testArr);
		
		assertArrayEquals("Testing using an empty array argument", expected, actual);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testValidDoubleArrayCreated() {
		
		double[] testArr = {9.9, 8.88, 7.9};
		
		Number[] expected = {9.9, 8.88, 7.9};
		
		Number[] actual = DataUtilities.createNumberArray(testArr);
		
		assertArrayEquals("Testing using a valid double array", expected, actual);
			
	}
	
	

}
