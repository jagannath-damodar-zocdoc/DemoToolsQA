package sample;
import org.testng.Assert;
import org.testng.annotations.Test;
import Sample.*;

public class TestNGTest {
	@Test
	public void testNGTest1() {		
		Test1 tst1 = new Test1();
		Assert.assertEquals(tst1.TestMethod(), true);
	}
	
	@Test
	public void testNGTest2() {
		Test1 tst2 = new Test1();
		Assert.assertEquals(tst2.TestMethod(), true);
	}
	
}

