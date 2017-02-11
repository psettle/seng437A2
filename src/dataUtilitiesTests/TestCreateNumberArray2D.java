package dataUtilitiesTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class TestCreateNumberArray2D {

	private static final int DEFAULT_TIMEOUT = 2000;
	
	@Test (expected = InvalidParameterException.class)
	public void testWithArgumentIsNull() {
		
		DataUtilities.createNumberArray(null);
		
	}

}
