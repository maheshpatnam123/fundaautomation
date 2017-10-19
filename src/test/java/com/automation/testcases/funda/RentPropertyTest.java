package com.automation.testcases.funda;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.pagelibrary.funda.FundaHome;
import com.automation.testutilities.TestBase;

public class RentPropertyTest extends TestBase {
	private static final Logger logger = LoggerFactory.getLogger(RentPropertyTest.class);
	private TestBase tb;
	private WebDriver driver;
	
	FundaHome homepage;
	@BeforeTest
	public void setUp()
	{
		tb= new TestBase();
		driver = tb.setupApplication(); 
		logger.info("Browser launched successfully");
		homepage = new FundaHome(driver);
	
	}
	@Test(enabled=true)
	public void Test_Huur01() 
	{
		homepage.rentProperty("Amsterdam","0","0","100");
		logger.info("rental properties displayed successfully");
	}
	@Test(enabled=true)
	public void Test_Huur02() 
	{
		homepage.rentProperty("Amsterdam","15","6000","6000");
		logger.info("rental properties displayed successfully");
	}
	@Test(enabled=true)
	public void Test_Huur03() 
	{
		homepage.rentProperty("Amsterdam","15","0","6000");
		logger.info("rental properties displayed successfully");
	}
	@AfterTest
	public void tearDown()
	{
		tb.closeApplication();
		logger.info("Browser closed successfully");
	}
	
}
