package propertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Simple_Data_Driven_Testing {

	public static void main(String[] args) throws IOException 
	{
      FileInputStream fis=new FileInputStream("C:\\MAVEN PROJECT\\Selenium_CRMGUI_Framework\\src\\test\\resources\\commondata.properties");
      
      Properties pobj=new Properties();
      pobj.load(fis);
      System.out.println(pobj.getProperty("url"));
      
     
		
	}

}
