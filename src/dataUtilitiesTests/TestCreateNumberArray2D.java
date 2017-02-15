package dataUtilitiesTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jmock.Mockery;
import org.junit.Test;

public class TestCreateNumberArray2D {

	private static final int DEFAULT_TIMEOUT = 2000;
	
	/**
	 * This test checks for the proper exception being thrown when an invalid parameter is
	 * inputed.
	 */
	@Test (expected = InvalidParameterException.class)
	public void testWithArgumentIsNull() {
		
		DataUtilities.createNumberArray2D(null);
		
	}
	
	
	/**
	 * This test checks for the proper exception being thrown when a row in the matrix is null
	 */
	@Test (expected = InvalidParameterException.class, timeout = DEFAULT_TIMEOUT)
	public void testWith1DArgumentNull() {
		
		double[][] testArr = {null};
		
		Number[][] actual = DataUtilities.createNumberArray2D(testArr);
			
	}
	
	/**
	 * This test checks for the proper output when an empty 2D array is inputed
	 */
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testEmptyArray() {
		
		double[][] testArr = {{}};
		
		Number[][] expected = {{}};
		
		Number[][] actual = DataUtilities.createNumberArray2D(testArr);
		
		assertArrayEquals("Testing using an empty array argument", expected, actual);
		
	}

	
	/**
	 * This test checks for the proper output when a valid 2D array is inputed
	 * Note: all of the numbers have been properly formatted as doubles an not implicit doubles,
	 * as would be the expected input. That is instead of inputting 8, 8.0 is inputed.
	 */
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testValid2DDoubleArrayCreated() {
		
		double[][] testArr = {{-9.9, 8.88, 7.9}, {-5.5, -4.4, 8.0}, {3.3, 23.4, -33.5}};
		
		Number[][] expected = {{-9.9, 8.88, 7.9}, {-5.5, -4.4, 8.0}, {3.3, 23.4, -33.5}};
		
		Number[][] actual = DataUtilities.createNumberArray2D(testArr);
		
		assertArrayEquals(expected, actual);
			
	}

}
