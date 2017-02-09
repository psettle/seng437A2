import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class TestTest {


	@Test
	public void combineTest() {
		
		Range r = new Range(6, 9);
		
		Range.shift(r, 0);
		
		fail(r.toString());
		
		//assertEquals("Testing " + new Range(4, 6), r);

	}

}
