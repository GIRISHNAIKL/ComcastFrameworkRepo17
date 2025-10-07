package practice.testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestnNg_DataProvider 
{

	@Test(dataProvider ="getData")
	
	public void createContactTest(String firstName ,String lastName)
	{
		System.out.println("FirstName:"+firstName+" LastName:"+lastName);
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="Girish";
		objArr[0][1]="Naik L";
		
		objArr[1][0]="John";
		objArr[1][1]="Cena";
		
		objArr[2][0]="Under";
		objArr[2][1]="Taker";
		
		return objArr;
		
	}
}
