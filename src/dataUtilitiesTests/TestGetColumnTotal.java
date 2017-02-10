package dataUtilitiesTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

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
	public void testColumnTotalWithInts() {
		
		mockingContext.checking(new Expectations() {
			{
			one(values).getRowCount();
			will(returnValue(4));
			one(values).getValue(0, 1);
			will(returnValue(3));
			one(values).getValue(1, 1);
			will(returnValue(4));
			one(values).getValue(2, 1);
			will(returnValue(0));
			one(values).getValue(3, 1);
			will(returnValue(63));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 1);
		
		assertEquals("Testing a column total with a column of integers", 70, result, 0.0000001d);
	}
	
	@Test
	public void testColumnTotalWithDoubles() {
		
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
		
		assertEquals("Testing a column total with a column of doubles", 13.2, result, 0.0000001d);
	}
	
	@Test
	public void testColumnTotalWithNoRows() {
		
		mockingContext.checking(new Expectations() {
			{
			one(values).getRowCount();
			will(returnValue(0));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 1);
		
		assertEquals("Testing a column total without any rows.", 0, result, 0);
	}
	

	@Test (expected = IndexOutOfBoundsException.class)
	public void testNegativeRowIndex() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, -1);
				will(throwException(new IndexOutOfBoundsException()));
				one(values).getValue(1, -1);
				will(throwException(new IndexOutOfBoundsException()));
				one(values).getValue(2, -1);
				will(throwException(new IndexOutOfBoundsException()));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, -1);
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBounds() {
		
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 5);
				will(throwException(new IndexOutOfBoundsException()));
				one(values).getValue(1, 5);
				will(throwException(new IndexOutOfBoundsException()));
				one(values).getValue(2, 5);
				will(throwException(new IndexOutOfBoundsException()));
			}
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 5);
		
	}
	
	
	


}
