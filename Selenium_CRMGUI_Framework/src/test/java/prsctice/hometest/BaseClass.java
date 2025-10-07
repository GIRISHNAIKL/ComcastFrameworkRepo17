gpackage prsctice.hometest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtillity;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class BaseClass 
{
	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtillity jLib=new JavaUtillity();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	
		@BeforeSuite
		public void configBeforeSuite()
		{
			System.out.println("==== Connect To DB,Report Config ====");
			dLib.getDbconnection();
		}
		
		@BeforeClass
		public void createClassTest() throws IOException
		{
			System.out.println("==Launch the Browser==");
			//String BROWSER=browser;
			String BROWSER = fLib.getDataFromPropertiesFile("browser");
			
			 
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
			
			
		}
		
		
		@BeforeMethod
		public void configBM() throws IOException
		{
			System.out.println("==login==");
			String URL = fLib.getDataFromPropertiesFile("url");
			String USERNAME = fLib.getDataFromPropertiesFile("username");
			String PASSWORD = fLib.getDataFromPropertiesFile("password");
			LoginPage lp=new LoginPage(driver);
			lp.loginToapp(URL, USERNAME, PASSWORD);
		}
		
		@AfterMethod
		public void configAM() {
			System.out.println("==logout==");
			HomePage hp=new HomePage(driver);
			hp.logout();
		}
		
		@AfterClass
		public void configAfterSuite() throws SQLException
		{
			System.out.println("===Close The Browser===");
			driver.quit();
		}
		
		@AfterSuite
		public void configAS() throws SQLException
		{
			System.out.println("==close DB , Report backUP== ");
			dLib.closeDbconnection();
		}
	}


