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
	
	private static final int DEFAULT_TIMEOUT = 2000;
	
	
	@Before
	public void setup() {
		
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		
	}
	
<<<<<<< HEAD
	@Test
	public void testColumnTotalWithInts() {
=======
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
>>>>>>> 26912cf5dc5241f835fe09239b4bda9f8a287884
		
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
	
<<<<<<< HEAD
	@Test
	public void testColumnTotalWithDoubles() {
=======
	@Test(timeout=DEFAULT_TIMEOUT)
	public void testSummingWithDoubles() {
>>>>>>> 26912cf5dc5241f835fe09239b4bda9f8a287884
		
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
