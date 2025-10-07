package practice.testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.protobuf.Method;

public class HomePageVerificationTest 
{

	@Test
	public void homePageTest(java.lang.reflect.Method mtd)
	{
		System.out.println(mtd.getName()+ " Test Start");
		String expeTitle=" Home Page";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		/*if(actTitle.trim().equals(expeTitle)) {
			System.out.println(expeTitle+"Page is Verified===PASS");
		}else {
			System.out.println(expeTitle+"Page is not Verified===FAIL");
		}*/
		//Hard Assert
		Assert.assertEquals(actTitle, expeTitle);
		
		System.out.println(mtd.getName()+ " Test END");
		
	}
	
	@Test
	public void verifyLogoHomePageTest(java.lang.reflect.Method mtd)
	{
		System.out.println(mtd.getName()+ " Test Start");
		//String expeTitle="Home";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		/*if(status) {
			System.out.println("LOgo is verified");
		}else
		{
			System.out.println("LOgo is not verified");
		}*/
		//Hard Assert
		Assert.assertTrue( status);
		System.out.println(mtd.getName()+ " Test END");
}
}
