package practice.testNg;

import org.testng.annotations.Test;

public class TestNG_InvocationCount 
{
@Test(invocationCount = 10)

//Invocation means How Many Times Our Test Cases should be executed
    
public void contactTest()
{
	System.out.println("Executed");
}

@Test()
public void createOrg()
{
	System.out.println("Execued1");
}
}
