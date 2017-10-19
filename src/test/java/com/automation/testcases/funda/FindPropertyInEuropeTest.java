package com.automation.testcases.funda;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pagelibrary.funda.FundaHome;
import com.automation.testutilities.ConfigRead;
import com.automation.testutilities.TestBase;

public class FindPropertyInEuropeTest extends TestBase {
	private static final Logger logger = LoggerFactory.getLogger(FindPropertyInEuropeTest.class);
	private TestBase tb;
	private WebDriver driver;
	
	FundaHome homepage;
	@BeforeClass
	public void setUp()
	{
		tb= new TestBase();
		driver = tb.setupApplication(); 
		logger.info("Browser launched successfully");
		homepage = new FundaHome(driver);
	
	}
	@Test(enabled=true)
	public void Test_Europa() 
	{
		homepage.findPropertyinEurope("Alle landen");
		logger.info("properties in Europe displayed successfully");
	}
	
	@AfterClass
	public void tearDown()
	{
		tb.closeApplication();
		logger.info("Browser closed successfully");
	}
	
}
