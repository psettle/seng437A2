package dataUtilitiesTests;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

public class TestGetColumnTotal {

	private Mockery mockingContext;
	private Values2D values;
	
	
	@Before
	public void setup() {
		
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		
	}
	
	@Test
	public void testSummingWithInts() {
		
		mockingContext.checking(new Expectations() {
			{
			one(values).getRowCount();
			will(returnValue(2));
			one(values).getValue(0, 1);
			will(returnValue(3));
			one(values).getValue(1, 1);
			will(returnValue(4));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 1);
		
		assertEquals(7, result, 0.0000001d);
	}
	
	@Test
	public void testSummingWithDoubles() {
		
		mockingContext.checking(new Expectations() {
			{
			one(values).getRowCount();
			will(returnValue(3));
			one(values).getValue(0, 1);
			will(returnValue(3.3));
			one(values).getValue(1, 1);
			will(returnValue(4.4));
			one(values).getValue(2, 1);
			will(returnValue(5.5));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 1);
		
		assertEquals(13.2, result, 0.0000001d);
	}


}
