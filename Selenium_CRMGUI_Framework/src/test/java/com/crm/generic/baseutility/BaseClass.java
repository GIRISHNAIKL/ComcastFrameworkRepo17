package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	@BeforeSuite
	public void configBeforeSuite()
	{
		System.out.println("==== Connect To DB,Report Config ====");
	}
	
	@BeforeClass
	public void createClassTest()
	{
		System.out.println("==Launch the Browser==");
	}
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("==login==");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("==logout==");
		
	}
	
	@AfterClass
	public void configAfterSuite()
	{
		System.out.println("===Close The Browser===");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("==close DB , Report backUP== ");
	}
}
