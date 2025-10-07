package prsctice.hometest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.protobuf.Method;

public class HomeSampleTest {
	@Test
	public void homePageTest(java.lang.reflect.Method mtd) {
		System.out.println(mtd.getName() + " Test Starts");
		SoftAssert  assertobj=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		assertobj.assertEquals("Home", "Home Page");
		System.out.println("Step-3");
		assertobj.assertEquals("Home-CRM", "Home-CRM");
		System.out.println("Step-4");
		assertobj.assertAll();
		System.out.println(mtd.getName() + " Test END");
	}

	@Test
	public void verifyLogoHomePageTest(java.lang.reflect.Method mtd) {
		System.out.println(mtd.getName() + " Test Starts");
		SoftAssert  assertobj=new SoftAssert();
		System.out.println("Step-1");
		System.out.println("Step-2");
		assertobj.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println(mtd.getName() + " Test END");
	}
}
