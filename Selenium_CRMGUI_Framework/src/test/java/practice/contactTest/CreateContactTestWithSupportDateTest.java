package practice.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactTestWithSupportDateTest {

	public static void main(String[] args) throws IOException 
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
      Sheet sh = wb.getSheet("contact");
      Row row = sh.getRow(4);
       String lastName = row.getCell(2).toString()+randomInt;
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
      //Step-2:Navigate To Contacts Module
      driver.findElement(By.linkText("Contacts")).click();
      //Step-3 Click on Create Organization Button
      driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
      //Enter The Details and create new Organization
      
      java.util.Date dateobj=new java.util.Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startDate=sim.format(dateobj);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String endDate=sim.format(cal.getTime());
		
      driver.findElement(By.name("lastname")).sendKeys(lastName);
      
      driver.findElement(By.name("support_start_date")).clear();
      driver.findElement(By.name("support_start_date")).sendKeys(startDate);
      driver.findElement(By.name("support_end_date")).clear();
      driver.findElement(By.name("support_end_date")).sendKeys(endDate);
      
      driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
      
      //verify Header msg ExpectedResult
     String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
      if(actLastName.contains(lastName))
      {
    	  System.out.println(lastName+"header verified==PASSED");
      }
      else
      {
    	  System.out.println(lastName+"header is verified==FAIL");  
      }
      
      driver.quit(); 
	}

}
