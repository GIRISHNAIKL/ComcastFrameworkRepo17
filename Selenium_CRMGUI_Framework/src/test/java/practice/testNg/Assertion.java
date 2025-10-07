package practice.testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
	
	@Test
	public void assertionTest()
	{
		System.out.println("Strp-1");
		System.out.println("Step-2");
		Assert.assertEquals("HOME", "HOME1");
		System.out.println("STPP-3");
		System.out.println("STEP-4");
	}

}
