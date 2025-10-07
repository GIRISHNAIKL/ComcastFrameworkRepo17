package propertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadComonData {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Girish Naik L\\Desktop\\commondata3.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL=prop.getProperty("Url");
		String USERNAME=prop.getProperty("username");
		String PASSWORD=prop.getProperty("password");
		String BROWSER=prop.getProperty("browser");
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
		driver=new ChromeDriver();	
		}else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}else
		{
			driver=new ChromeDriver();
		}
		driver.get(URL);
	
			
		

	}

}
