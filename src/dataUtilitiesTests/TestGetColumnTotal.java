package dataUtilitiesTests;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.*;
import org.junit.*;

public class TestGetColumnTotal {

	private Mockery mockingContext;
	private Values2D values;
	
	private static final int DEFAULT_TIMEOUT = 2000;
	
	
	@Before
	public void setup() {
		
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		
	}
	
	@Test(expected=Exception.class,timeout=DEFAULT_TIMEOUT)
	public void testColumnTooLarge() {
		
		mockingContext.checking(new Expectations() {
			{
			atLeast(0).of(values).getRowCount();
			will(returnValue(0));
			atLeast(0).of(values).getColumnCount();
			will(returnValue(0));
			}
		});
		
		DataUtilities.calculateColumnTotal(this.values, 3);
	}
	
	@Test(expected=Exception.class,timeout=DEFAULT_TIMEOUT)
	public void testColumnTooSmall() {
		
		mockingContext.checking(new Expectations() {
			{
			atLeast(0).of(values).getRowCount();
			will(returnValue(0));
			atLeast(0).of(values).getColumnCount();
			will(returnValue(0));
			}
		});
		
		DataUtilities.calculateColumnTotal(this.values, -1);
	}
	
	@Test(timeout=DEFAULT_TIMEOUT)
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
	
	@Test(timeout=DEFAULT_TIMEOUT)
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
