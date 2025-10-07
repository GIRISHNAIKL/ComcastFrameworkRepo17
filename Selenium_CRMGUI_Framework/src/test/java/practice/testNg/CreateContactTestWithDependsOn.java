package practice.testNg;

import org.testng.annotations.Test;

public class CreateContactTestWithDependsOn 
{
	

	@Test
	public void createContactTest()
	{
		System.out.println("Execeuted createContactTest");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	
	public void modifyContactTest()
	{
		System.out.println("Execeuted modifyContactTest");
	}
	
	@Test(dependsOnMethods ="modifyContactTest" )
	public void deleteContactTest()
	{
		System.out.println("Execeuted deleteContactTest");
	}
	
}
