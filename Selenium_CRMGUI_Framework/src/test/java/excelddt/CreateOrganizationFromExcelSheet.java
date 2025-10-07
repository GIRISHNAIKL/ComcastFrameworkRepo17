package excelddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationFromExcelSheet {

	public static void main(String[] args) throws IOException 
	{
      
		FileInputStream fis=new FileInputStream("C:\\MAVEN PROJECT\\Selenium_CRMGUI_Framework\\src\\test\\resources\\commondata.properties");
        Properties pobj=new Properties();
       pobj.load(fis);
       
      String BROWSER=pobj.getProperty("browser");
      String URL=pobj.getProperty("url");
      String USERNAME=pobj.getProperty("username");
      //String PASSWORD=pobj.getProperty("password");
      
      //Generate Random Number
      Random random = new Random();
      int randomInt = random.nextInt(1000);
      
      FileInputStream fis1=new FileInputStream("C:\\Users\\Girish Naik L\\Desktop\\DDTpractice.xlsx");
      Workbook wb = WorkbookFactory.create(fis1);
      Sheet sh = wb.getSheet("org");
      Row row = sh.getRow(1);
       String cell = row.getCell(3).toString()+randomInt;
       String password = row.getCell(4).toString();
      
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
      driver.findElement(By.name("user_password")).sendKeys(password);
      driver.findElement(By.xpath("//input[@type='submit']")).click();
      //Step-2:Navigate To Organization Module
      driver.findElement(By.linkText("Organizations")).click();
      //Step-3 Click on Create Organization Button
      driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
      //Enter The Details and create new Organization 
      driver.findElement(By.name("accountname")).sendKeys(cell);
      driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
      //Step-5: Logout
      Actions action=new Actions(driver);
      action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
      driver.findElement(By.linkText("Sign Out")).click();
       
	}

	}


