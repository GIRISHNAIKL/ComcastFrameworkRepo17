package prsctice.hometest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.protobuf.Method;

public class HomeSampleTest2 {
	@Test
	public void homePageTest(java.lang.reflect.Method mtd) {
		Reporter.log(mtd.getName() + " Test Starts",true);
		
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);

		Reporter.log(mtd.getName() + " Test END",true);
	}

	@Test
	public void verifyLogoHomePageTest(java.lang.reflect.Method mtd) {
		Reporter.log(mtd.getName() + " Test Starts",true);
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		Reporter.log(mtd.getName() + " Test END",true);
	}
}
