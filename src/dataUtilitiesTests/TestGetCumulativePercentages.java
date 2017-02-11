package dataUtilitiesTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class TestGetCumulativePercentages {

	private static final int DEFAULT_TIMEOUT = 2000;
	
	Mockery mockingContext;
	KeyedValues values;
	
	@Before
	public void setup() {
		
		mockingContext = new Mockery();
		values = mockingContext.mock(KeyedValues.class);
		
	}
	
	@Test (expected = InvalidParameterException.class, timeout = DEFAULT_TIMEOUT)
	public void testNullParameter() {
		
		DataUtilities.getCumulativePercentages(null);
		
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void testEmptyKeyedValuesParameter() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getItemCount();
				will(returnValue(0));
			}
		});
		
		
		
	}
	
	

}
