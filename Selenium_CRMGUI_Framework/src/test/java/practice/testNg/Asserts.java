package practice.testNg;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sun.org.apache.bcel.internal.classfile.Method;

public class Asserts {
	@Test
	public void assertsTest()
	{
		
		SoftAssert sObj=new SoftAssert();
		Reporter.log("STEP-1",true);
		Reporter.log("STEP-2",true);
		sObj.assertEquals("Home", "Home1");
		Reporter.log("STEP-3",true);
		sObj.assertEquals("login","login1");
		Reporter.log("STEP-4",true);
		sObj.assertEquals("run", "run");
		sObj.assertAll();
		

	}

}
