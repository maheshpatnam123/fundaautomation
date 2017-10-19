package com.automation.testcases.funda;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.pagelibrary.funda.FundaHome;
import com.automation.testutilities.TestBase;

public class FindNewConstructionTest extends TestBase {
	private static final Logger logger = LoggerFactory.getLogger(FindNewConstructionTest.class);
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
	public void Test_Niewbouw01() 
	{
		homepage.findNewConstruction("Amsterdam","0");
		logger.info("properties displayed successfully");
	}
	@Test(enabled=true)
	public void Test_Niewbouw02() 
	{
		homepage.findNewConstruction("Amsterdam","15");
		logger.info("properties displayed successfully");
	}
	@AfterTest
	public void tearDown()
	{
		tb.closeApplication();
		logger.info("Browser closed successfully");
	}
	
}
