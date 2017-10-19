package com.automation.testcases.funda;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.pagelibrary.funda.FundaHome;
import com.automation.testutilities.TestBase;

public class BuyPropertyTest extends TestBase {
	private static final Logger logger = LoggerFactory.getLogger(BuyPropertyTest.class);
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
	public void Test_Koop01() 
	{
		homepage.searchProperty("Amsterdam","0","0","50000");
		logger.info("properties displayed successfully");
	}
	@Test(enabled=true)
	public void Test_Koop02() 
	{
		homepage.searchProperty("Amsterdam","15","2000000","2000000");
		logger.info("properties displayed successfully");
	}
	@Test(enabled=true)
	public void Test_Koop03() 
	{
		homepage.searchProperty("Amsterdam","15","0","2000000");
		logger.info("properties displayed successfully");
	}
	@AfterTest
	public void tearDown()
	{
		tb.closeApplication();
		logger.info("Browser closed successfully");
	}
	
}
