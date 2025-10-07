package prsctice.hometest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SimpleTestForScrrenshot 
{
@Test
public void amazonTest() throws IOException
{
	WebDriver driver=new ChromeDriver();
	driver.get("http://amazon.in");
	//Step-1: Create an object to EventFiring WebDriver
    EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
    
    //Step-2: use getscreenshotAs Method to get File type Of Screenshot
    File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
    
    //Step-3: Store screen on locak driver
    FileUtils.copyFile(srcFile, new File("./configAppData/test.png"));
    
}
}
