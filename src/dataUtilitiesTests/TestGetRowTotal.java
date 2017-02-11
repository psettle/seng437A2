package dataUtilitiesTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class TestGetRowTotal {
	
	private static final int DEFAULT_TIMEOUT = 2000;

	private Mockery mockingContext;
	private Values2D values;
	
	
	@Before
	public void setup() {
		
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		
	}
	
	@Test
	public void testRowTotalWithInts() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(4));
				one(values).getValue(1, 0);
				will(returnValue(3));
				one(values).getValue(1, 1);
				will(returnValue(0));
				one(values).getValue(1, 2);
				will(returnValue(9));
				one(values).getValue(1, 3);
				will(returnValue(4));
			}
		});
		
		double result = DataUtilities.calculateRowTotal(values, 1);
		
		assertEquals("Testing row total with a row on integers", 16, result, 0.0000001d);
	}
	
	@Test
	public void testRowTotalWithDoubles() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(3));
				one(values).getValue(1, 0);
				will(returnValue(3.695));
				one(values).getValue(1, 1);
				will(returnValue(0));
				one(values).getValue(1, 2);
				will(returnValue(8.888));
			}
		});
		
		double result = DataUtilities.calculateRowTotal(values, 1);
		
		assertEquals("Testing row total with row of doubles", 12.583, result, 0.0000001d);
	}
	
	@Test
	public void testRowTotalWithNoColumns() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(0));
			}
		});
		
		double result = DataUtilities.calculateRowTotal(values, 0);
		
		assertEquals("Testing row total with no columns", 0, result, 0.0000001d);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void testRowTotalWithNullArgument() {
		
		DataUtilities.calculateRowTotal(null, 0);
		
	}
	

	
	



}
