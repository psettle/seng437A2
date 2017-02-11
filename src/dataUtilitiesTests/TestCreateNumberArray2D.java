package dataUtilitiesTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jmock.Mockery;
import org.junit.Test;

public class TestCreateNumberArray2D {

	private static final int DEFAULT_TIMEOUT = 2000;
	
	
	@Test (expected = InvalidParameterException.class)
	public void testWithArgumentIsNull() {
		
		DataUtilities.createNumberArray2D(null);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testEmptyArray() {
		
		double[][] testArr = {{}};
		
		Number[][] expected = {{}};
		
		Number[][] actual = DataUtilities.createNumberArray2D(testArr);
		
		assertArrayEquals("Testing using an empty array argument", expected, actual);
		
	}

	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testValid2DDoubleArrayCreated() {
		
		double[][] testArr = {{9.9, 8.88, 7.9}, {5.5, 4.4, 8.0}, {3.3, 23.4, 33.5}};
		
		Number[][] expected = {{9.9, 8.88, 7.9}, {5.5, 4.4, 8.0}, {3.3, 23.4, 33.5}};
		
		Number[][] actual = DataUtilities.createNumberArray2D(testArr);
		
		assertArrayEquals(expected, actual);
			
	}

}
