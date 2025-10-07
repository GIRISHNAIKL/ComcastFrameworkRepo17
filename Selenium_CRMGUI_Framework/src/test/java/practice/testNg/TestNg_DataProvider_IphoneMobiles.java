package practice.testNg;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class TestNg_DataProvider_IphoneMobiles 
{
@Test(dataProvider="getData")
 
    public void getProductInfoTest(String BrandName,String ProductName)
    {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in/");

	//Serach Product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName,Keys.ENTER);
	
	//Capture Product Info
	String x="//span[text()='"+ProductName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span[1]/span[2]/span[2]";
	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	
	driver.quit();
	//Apple iPhone 13 (128GB) - Midnight
	}
@DataProvider

public Object[][] getData() throws EncryptedDocumentException, IOException
{
	
	ExcelUtility eLib=new ExcelUtility();
	
	int rowCount=eLib.getRowcount("contact");
	
	Object[][] objArr=new Object[rowCount][2];
			
	for(int i=0;i<rowCount;i++)
	{
		objArr[i][0]=eLib.getDataFromExcel("contact", i+1,0);
	    objArr[i][1]=eLib.getDataFromExcel("contact", i+1,1);
	     }
	
	return objArr;
	
}

}
