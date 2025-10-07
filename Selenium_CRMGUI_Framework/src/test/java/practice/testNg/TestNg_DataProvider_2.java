package practice.testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNg_DataProvider_2 
{
@Test(dataProvider = "getData")
	 public void getProductInfoTest(String BrandName,String ProductName)
	    {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");

		//Serach Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName,Keys.ENTER);
		
		
		//capture Product Info
		String x="//span[text()='"+ProductName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span[1]/span[2]/span[2]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		//Apple iPhone 13 (128GB) - Midnight
		 }

@DataProvider

public Object[][] getData() 

{

Object[][] objArr=new Object[3][2];
objArr[0][0]="iphone";
objArr[0][1]="Apple iPhone 13 (128GB) - Midnight";

objArr[1][0]="iphone";
objArr[1][1]="iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Black";

objArr[2][0]="iphone";
objArr[2][1]="Apple iPhone 15 (128 GB) - Black";
//return objArr1;

return objArr;

}
}
