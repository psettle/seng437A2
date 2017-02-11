package dataUtilitiesTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import javax.xml.crypto.Data;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class TestCreateNumberArray {

	private static final int DEFAULT_TIMEOUT = 2000;

	
	@Test (expected = InvalidParameterException.class, timeout = DEFAULT_TIMEOUT)
	public void testWithArgumentIsNull() {
		
		DataUtilities.createNumberArray(null);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testValidDoubleArrayCreated() {
		
		double[] testArr = {9.9, 8.88, 7, 4.5};
		
		Number[] expected = {9.9, 8.88, 7, 4.5};
		
		Number[] actual = DataUtilities.createNumberArray(testArr);
		
		assertArrayEquals(expected, actual);
		
		
	}
	

}
