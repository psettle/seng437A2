package dataUtilitiesTests;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import java.awt.List;
import java.util.Arrays;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class TestGetCumulativePercentages {
	
	private Mockery mockingContext;
	private KeyedValues values;
	
	private static final int DEFAULT_TIMEOUT = 2000;
	
	
	@Before
	public void setup() {
		
		mockingContext = new Mockery();
		values = mockingContext.mock(KeyedValues.class);
		
	}
	
	@Test(expected=Exception.class, timeout=DEFAULT_TIMEOUT)
	public void test_Null_KeyedValuesDataInput() {
		
		DataUtilities.getCumulativePercentages(null);
	}
	
	@Test(expected=Exception.class, timeout=DEFAULT_TIMEOUT)
	public void test_Empty_KeyedValuesDataInput() {
		
		mockingContext.checking(new Expectations() {
			{
			atLeast(0).of(values).getKeys();
			will(returnValue(new List() ));
			atLeast(1).of(values).getItemCount();
			will(returnValue(0));
			}
		});
		
		DataUtilities.getCumulativePercentages(this.values);
	}
	
	//NOTE: THIS COULD BE BROKEN INTO CHECKING FOR SIZE, CHECKING VALUES, AND CHECKING KEYS.
	@Test(timeout=DEFAULT_TIMEOUT)
	public void test_Normal_IntegerValues_KeyedValues() {
		
		mockingContext.checking(new Expectations() {
			{
			atLeast(0).of(values).getKeys();
			will(returnValue(Arrays.asList(0,1,2) ));
			atLeast(1).of(values).getItemCount();
			will(returnValue(3));
			
			atLeast(1).of(values).getValue(0);
			will(returnValue(1));
			atLeast(1).of(values).getValue(1);
			will(returnValue(2));
			atLeast(1).of(values).getValue(2);
			will(returnValue(3));
			
			atLeast(0).of(values).getKey(0);
			will(returnValue(0));
			atLeast(0).of(values).getKey(1);
			will(returnValue(1));
			atLeast(0).of(values).getKey(2);
			will(returnValue(2));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(this.values);
		assertEquals("Testing result size with integer KeyedValues",
				3, result.getItemCount());
		
		assertEquals("Testing returned keys with integer KeyedValues", Arrays.asList(0,1,2),
				result.getKeys());
		
		assertEquals("Testing cumulative percentages with integer KeyedValues",
						Arrays.asList((1.0/6), (3.0/6), (6.0/6)), 
								Arrays.asList(
								result.getValue(result.getKey(0)),
								result.getValue(result.getKey(1)),
								result.getValue(result.getKey(2)) ));

	}
	
	//NOTE: THIS COULD BE BROKEN INTO CHECKING FOR SIZE, CHECKING VALUES, AND CHECKING KEYS.
		@Test(timeout=DEFAULT_TIMEOUT)
		public void test_NegativeKeys_IntegerValues_KeyedValues() {
			//ASSUME it's acceptable for the keys in KeyedValues to be negative numbers.
			mockingContext.checking(new Expectations() {
				{
				atLeast(0).of(values).getKeys();
				will(returnValue(Arrays.asList(-3,-2,-1) ));
				atLeast(1).of(values).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(values).getValue(-3);
				will(returnValue(1));
				atLeast(1).of(values).getValue(-2);
				will(returnValue(2));
				atLeast(1).of(values).getValue(-1);
				will(returnValue(3));
				
				atLeast(0).of(values).getValue(0);
				will(returnValue(null));
				atLeast(0).of(values).getValue(1);
				will(returnValue(null));
				atLeast(0).of(values).getValue(2);
				will(returnValue(null));
				
				atLeast(0).of(values).getKey(0);
				will(returnValue(-3));
				atLeast(0).of(values).getKey(1);
				will(returnValue(-2));
				atLeast(0).of(values).getKey(2);
				will(returnValue(-1));
				}
			});
			
			KeyedValues result = DataUtilities.getCumulativePercentages(this.values);
			assertEquals("Testing result size with integer KeyedValues",
					3, result.getItemCount());
			
			assertEquals("Testing returned keys with integer KeyedValues", Arrays.asList(-3,-2,-1),
					result.getKeys());
			
			assertEquals("Testing cumulative percentages with integer KeyedValues",
							Arrays.asList((1.0/6), (3.0/6), (6.0/6)), 
									Arrays.asList(
									result.getValue(result.getKey(0)),
									result.getValue(result.getKey(1)),
									result.getValue(result.getKey(2)) ));

		}
	
	//NOTE: THIS COULD BE BROKEN INTO CHECKING FOR SIZE, CHECKING VALUES, AND CHECKING KEYS.
	@Test(timeout=DEFAULT_TIMEOUT)
	public void test_Normal_FloatValues_KeyedValues() {
		
		mockingContext.checking(new Expectations() {
			{
			atLeast(0).of(values).getKeys();
			will(returnValue(Arrays.asList(0,1,2) ));
			atLeast(1).of(values).getItemCount();
			will(returnValue(3));
			
			atLeast(1).of(values).getValue(0);
			will(returnValue(1.1));
			atLeast(1).of(values).getValue(1);
			will(returnValue(2.2));
			atLeast(1).of(values).getValue(2);
			will(returnValue(3.3));
			
			atLeast(0).of(values).getKey(0);
			will(returnValue(0));
			atLeast(0).of(values).getKey(1);
			will(returnValue(1));
			atLeast(0).of(values).getKey(2);
			will(returnValue(2));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(this.values);
		assertEquals("Testing result size with integer KeyedValues",
				3, result.getItemCount());
		
		assertEquals("Testing returned keys with integer KeyedValues", Arrays.asList(0,1,2),
				result.getKeys());
		
		assertEquals("Testing cumulative percentages with integer KeyedValues",
						Arrays.asList((1.1/6.6), (3.3/6.6), (6.6/6.6)), 
								Arrays.asList(
								result.getValue(result.getKey(0)),
								result.getValue(result.getKey(1)),
								result.getValue(result.getKey(2)) ));

	}
	//NOTE: THIS COULD BE BROKEN INTO CHECKING FOR SIZE, CHECKING VALUES, AND CHECKING KEYS.
	@Test(timeout=DEFAULT_TIMEOUT)
	public void test_IntegerValues_KeyedValues_KeysDoNotMatchIndices() {
		
		mockingContext.checking(new Expectations() {
			{
			atLeast(0).of(values).getKeys();
			will(returnValue(Arrays.asList(4,5,6) ));
			atLeast(1).of(values).getItemCount();
			will(returnValue(3));
			
			atLeast(0).of(values).getValue(0);
			will(returnValue(null));
			atLeast(0).of(values).getValue(1);
			will(returnValue(null));
			atLeast(0).of(values).getValue(2);
			will(returnValue(null));
			atLeast(0).of(values).getValue(3);
			will(returnValue(null));
			
			atLeast(1).of(values).getValue(4);
			will(returnValue(2));
			atLeast(1).of(values).getValue(5);
			will(returnValue(4));
			atLeast(1).of(values).getValue(6);
			will(returnValue(6));
			
			atLeast(0).of(values).getKey(0);
			will(returnValue(4));
			atLeast(0).of(values).getKey(1);
			will(returnValue(5));
			atLeast(0).of(values).getKey(2);
			will(returnValue(6));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(this.values);
		assertEquals("Testing result size with integer KeyedValues",
				3, result.getItemCount());
		
		//ASSUME that the result generated has the same keys as the input.
		assertEquals("Testing returned keys with integer KeyedValues", Arrays.asList(4,5,6),
				result.getKeys());
		
		assertEquals("Testing cumulative percentages with integer KeyedValues",
						Arrays.asList((2.0/12), (6.0/12), (12.0/12)), 
								Arrays.asList(
								result.getValue(result.getKey(0)),
								result.getValue(result.getKey(1)),
								result.getValue(result.getKey(2)) ));

	}
	
	@Test(expected=Exception.class, timeout=DEFAULT_TIMEOUT)
	public void test_NegativeValue_KeyedValues_exception() {
		
		mockingContext.checking(new Expectations() {
			{
			atLeast(0).of(values).getKeys();
			will(returnValue(Arrays.asList(0,1,2) ));
			atLeast(1).of(values).getItemCount();
			will(returnValue(3));
			
			atLeast(0).of(values).getValue(0);
			will(returnValue(-1));
			atLeast(0).of(values).getValue(1);
			will(returnValue(1));
			atLeast(0).of(values).getValue(2);
			will(returnValue(2));
			
			atLeast(0).of(values).getKey(0);
			will(returnValue(0));
			atLeast(0).of(values).getKey(1);
			will(returnValue(1));
			atLeast(0).of(values).getKey(2);
			will(returnValue(2));
			}
		});

		// delete this comment:
		// ASSUME: This test should throw an exception, but it doesn't. It tries to compute
		// the cumulative percentage anyway, which would result in a percentage value outside of 0.0 and 1.0
		DataUtilities.getCumulativePercentages(this.values);

	}
	
	@Test(expected=Exception.class, timeout=DEFAULT_TIMEOUT)
	public void test_ZeroValue_KeyedValues_exception() {
		
		mockingContext.checking(new Expectations() {
			{
			atLeast(0).of(values).getKeys();
			will(returnValue(Arrays.asList(0,1) ));
			atLeast(1).of(values).getItemCount();
			will(returnValue(2));
			
			atLeast(0).of(values).getValue(0);
			will(returnValue(0));
			atLeast(0).of(values).getValue(1);
			will(returnValue(0));
			
			atLeast(0).of(values).getKey(0);
			will(returnValue(0));
			atLeast(0).of(values).getKey(1);
			will(returnValue(1));
			}
		});

		DataUtilities.getCumulativePercentages(this.values);
		
		// delete these comments:
		// ASSUME: This test should throw an exception, but it doesn't. It tries to compute
		// the cumulative percentage anyway, which would result in a percentage value outside of 0.0 and 1.0 (NaN)
		
		/* THIS ACTUALLY ALL PASSES.

		KeyedValues result = DataUtilities.getCumulativePercentages(this.values);
		assertEquals("Testing result size with integer KeyedValues",
				2, result.getItemCount());
		
		assertEquals("Testing returned keys with integer KeyedValues", Arrays.asList(0,1),
				result.getKeys());
		
		assertEquals("Testing cumulative percentages with integer KeyedValues",
						Arrays.asList((0.0/0.0), (0.0/0.0)), 
								Arrays.asList(
								result.getValue(result.getKey(0)),
								result.getValue(result.getKey(1)) ));
								*/
		

	}
}
