package practice.testNg;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ConfigAnnotationTestNg 
{
	
	@BeforeSuite
	public void configBeforeSuite()
	{
		System.out.println("Executed Before Suite");
	}
	
	@AfterClass
	public void configAfterSuite()
	{
		System.out.println("Executed After Suite");
	}
	
	@BeforeClass
	public void createClassTest()
	{
		System.out.println("Execute Before Class");
	}
	
	 
	@Test
	  public void createContact()
	  {
		  System.out.println("execute createContact");
	  } 
	
	@Test
	public void createContactTest()
	{
		System.out.println("create Contact Test ");
	}
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("execute BM");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("excecute AM");
		
	}
	
	@AfterClass
	public void configAfterClass()
	{
		System.out.println("Execute After Class");
	}
	
  
}
