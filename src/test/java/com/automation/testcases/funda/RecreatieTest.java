package com.automation.testcases.funda;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.pagelibrary.funda.FundaHome;
import com.automation.testutilities.TestBase;

public class RecreatieTest extends TestBase {
	private static final Logger logger = LoggerFactory.getLogger(RecreatieTest.class);
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
	public void Test_Recreatie01() 
	{
		homepage.findRecreation("Bennekom","0");
		logger.info("properties displayed successfully");
	}
	@Test(enabled=false)
	public void Test_Recreatie02() 
	{
		homepage.findRecreation("Bennekom","15");
		logger.info("properties displayed successfully");
	}
	
	@AfterTest
	public void tearDown()
	{
		tb.closeApplication();
		logger.info("Browser closed successfully");
	}
	
}
