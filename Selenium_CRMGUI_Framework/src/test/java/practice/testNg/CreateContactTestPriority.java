package practice.testNg;

import org.testng.annotations.Test;

public class CreateContactTestPriority 
{
	@Test(priority = 1)
	public void createContactTest()
	{
		System.out.println("Execeuted createContactTest");
	}
	
	@Test(priority = 2)
	public void modifyContactTest()
	{
		System.out.println("Execeuted modifyContactTest");
	}
	
	@Test(priority = 3)
	public void deleteContactTest()
	{
		System.out.println("Execeuted deleteContactTest");
	}
	
}
