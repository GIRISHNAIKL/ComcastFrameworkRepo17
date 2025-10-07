package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class CreateOrgTestWithIndustries {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
     
		FileInputStream fis=new FileInputStream("C:\\MAVEN PROJECT\\Selenium_CRMGUI_Framework\\src\\test\\resources\\commondata.properties");
        Properties pobj=new Properties();
       pobj.load(fis);
       
      String BROWSER=pobj.getProperty("browser");
      String URL=pobj.getProperty("url");
      String USERNAME=pobj.getProperty("username");
      String PASSWORD=pobj.getProperty("password");
      
      //Generate Random Number
      Random random = new Random();
      int randomInt = random.nextInt(1000);
      
      FileInputStream fis1=new FileInputStream("C:\\Users\\Girish Naik L\\Desktop\\DDTpractice.xlsx");
      Workbook wb = WorkbookFactory.create(fis1);
      Sheet sh = wb.getSheet("org");
      Row row = sh.getRow(4);
       String orgName = row.getCell(2).toString()+randomInt;
       String industry = row.getCell(3).toString();
       String type = row.getCell(4).toString();
       wb.close();
       
      
      WebDriver driver=null;
      if(BROWSER.equals("chrome"))
      {
   	   driver=new ChromeDriver();
      }
      else if(BROWSER.equals("firefox"))
      {
   	   driver=new FirefoxDriver();
      }
      else if(BROWSER.equals("edge"))
      {
   	   driver=new EdgeDriver();
      }else
      {
   	   driver=new ChromeDriver();
      }
      driver.get(URL);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.findElement(By.name("user_name")).sendKeys(USERNAME);
      driver.findElement(By.name("user_password")).sendKeys(PASSWORD );
      driver.findElement(By.xpath("//input[@type='submit']")).click();
      //Step-2:Navigate To Organization Module
      driver.findElement(By.linkText("Organizations")).click();
      //Step-3 Click on Create Organization Button
      driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
      //Enter The Details and create new Organization 
      driver.findElement(By.name("accountname")).sendKeys(orgName);
      
      WebElement wbsle = driver.findElement(By.name("industry"));
      Select sel=new Select(wbsle);
      sel.selectByVisibleText(industry);
      
      WebElement wbsel2 = driver.findElement(By.name("accounttype"));
      Select sel2=new Select(wbsel2);
      sel2.selectByVisibleText(type);
      
      driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
      
      //verify the inustries and Type info
      String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
      if(actIndustries.equals(industry))
      {
    	  System.out.println(industry+"information is veified==PASSED");
      }
      else
      {
    	  System.out.println(orgName+"information is not veified==FAIL");  
      }
      
      String actType = driver.findElement(By.id("dtlview_Type")).getText();
      if(actType.equals(type))
      {
    	  System.out.println(type+"information is veified==PASSED");
      }
      else
      {
    	  System.out.println(type+"information is not veified==FAIL");  
      }
      driver.quit();
      }

}
