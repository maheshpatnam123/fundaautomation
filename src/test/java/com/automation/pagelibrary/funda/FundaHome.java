package com.automation.pagelibrary.funda;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FundaHome {
	private static final Logger logger = LoggerFactory.getLogger(FundaHome.class);
	WebDriver driver; 
	public FundaHome(WebDriver ldriver)
	{
	this.driver=ldriver;
	} 
	By koopLink = By.xpath("//a[@href='/koop/']");
	By huurLink = By.xpath("//a[@href='/huur/']");
	By niewbouwLink = By.xpath("//a[@href='/nieuwbouw/']");
	By recreateLink = By.xpath("//a[@href='/recreatie/']");
	By europaLink = By.xpath("//a[@href='/europe/']");
	By location = By.id("autocomplete-input");
	By distance = By.id("Straal");
	By minimumPrice = By.name("filter_KoopprijsVan");
	By maximumPrice = By.name("filter_KoopprijsTot");
	By minimumPropertyPrice = By.name("filter_HuurprijsVan");
	By maximumPropertyPrice = By.name("filter_HuurprijsTot");
	By searchLink = By.xpath("//button[@type='submit']");
	By country = By.id("Land");
	

	/**
	 * Searches for property
	 * @param locationname
	 * @param locationdistance
	 * @param minimum
	 * @param maximum
	 */
	public void searchProperty(String locationname,String locationdistance,String minimum,String maximum)
	{
		waitForElementToDisplay(koopLink);
		find(koopLink).click();
		waitForElementToDisplay(distance);
		WebElement distancevalue = find(distance);
		Select distanceDropdown= new Select(distancevalue);
		distanceDropdown.selectByValue(locationdistance);
		waitForElementToDisplay(minimumPrice);
		WebElement minimumrange = find(minimumPrice);
		Select minimumrangeDropdown= new Select(minimumrange);
		minimumrangeDropdown.selectByValue(minimum);
		waitForElementToDisplay(maximumPrice);
		WebElement maximumrange = find(maximumPrice);
		Select maximumrangedropdown= new Select(maximumrange);
		maximumrangedropdown.selectByValue(maximum);
		waitForElementToDisplay(location);
		find(location).sendKeys(locationname);
		waitForElementToDisplay(searchLink);
		find(searchLink).click();
		try{
			Thread.sleep(3000);
			waitForElementToDisplay(searchLink);
			find(location).sendKeys(Keys.ENTER);
			if(find(searchLink).isDisplayed()){
				find(searchLink).click();	
			}
			
			Thread.sleep(3000);
			List<WebElement> elements = driver.findElements(By.className("search-result-title"));    
	        System.out.println("Test number of properties: " + elements.size());

	        for(WebElement ele : elements){
	        	logger.info("property name:  "+ele.getText());
	        } 
		}catch(Exception e){
			e.printStackTrace();
		}		
		
	}
	
	
	/**
	 * searches for Rental property
	 * @param locationname
	 * @param locationdistance
	 * @param minimum
	 * @param maximum
	 */
	public void rentProperty(String locationname,String locationdistance,String minimum,String maximum)
	{
		waitForElementToDisplay(huurLink);
		find(huurLink).click();
		waitForElementToDisplay(distance);
		WebElement distancevalue = find(distance);
		Select distanceDropdown= new Select(distancevalue);
		distanceDropdown.selectByValue(locationdistance);
		waitForElementToDisplay(minimumPropertyPrice);
		WebElement minimumrange = find(minimumPropertyPrice);
		Select minimumrangeDropdown= new Select(minimumrange);
		minimumrangeDropdown.selectByValue(minimum);
		waitForElementToDisplay(maximumPropertyPrice);
		WebElement maximumrange = find(maximumPropertyPrice);
		Select maximumrangedropdown= new Select(maximumrange);
		maximumrangedropdown.selectByValue(maximum);
		waitForElementToDisplay(location);
		find(location).sendKeys(locationname);
		waitForElementToDisplay(searchLink);
		find(searchLink).click();
		try{
			Thread.sleep(3000);
			find(location).sendKeys(Keys.ENTER);
			if(find(searchLink).isDisplayed()){
				find(searchLink).click();	
			}
			Thread.sleep(3000);
			List<WebElement> elements = driver.findElements(By.className("search-result-title"));    
	        System.out.println("Test number of properties: " + elements.size());

	        for(WebElement ele : elements){
	        	logger.info("property name:  "+ele.getText());
	        } 
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	/**
	 * searches for new construction
	 * @param locationname
	 * @param locationdistance
	 */
	public void findNewConstruction(String locationname,String locationdistance)
	{
		waitForElementToDisplay(niewbouwLink);
		find(niewbouwLink).click();
		waitForElementToDisplay(distance);
		WebElement distancevalue = find(distance);
		Select distanceDropdown= new Select(distancevalue);
		distanceDropdown.selectByValue(locationdistance);
		waitForElementToDisplay(location);
		find(location).sendKeys(locationname);
		waitForElementToDisplay(searchLink);
		find(searchLink).click();
		try{
			Thread.sleep(3000);
			waitForElementToDisplay(searchLink);
			find(location).sendKeys(Keys.ENTER);
			if(find(searchLink).isDisplayed()){
				find(searchLink).click();	
			}
			
			Thread.sleep(3000);
			List<WebElement> elements = driver.findElements(By.className("search-result-title"));    
	        System.out.println("Test number of properties: " + elements.size());

	        for(WebElement ele : elements){
	        	logger.info("property name:  "+ele.getText());
	        } 
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		}
	
	/**
	 * Searches for recreation places.
	 * @param locationname
	 * @param locationdistance
	 */
	public void findRecreation(String locationname,String locationdistance)
	{
		waitForElementToDisplay(recreateLink);
		find(recreateLink).click();
		waitForElementToDisplay(distance);
		WebElement distancevalue = find(distance);
		Select distanceDropdown= new Select(distancevalue);
		distanceDropdown.selectByValue(locationdistance);
		waitForElementToDisplay(location);
		find(location).sendKeys(locationname);
		waitForElementToDisplay(searchLink);
		find(searchLink).click();
		try{
			Thread.sleep(3000);
			waitForElementToDisplay(searchLink);
			if(find(searchLink).isDisplayed()){
				find(location).sendKeys(Keys.ENTER);
				find(searchLink).click();	
			}
			
			Thread.sleep(3000);
			List<WebElement> elements = driver.findElements(By.className("search-result-title"));    
	        System.out.println("Test number of properties: " + elements.size());

	        for(WebElement ele : elements){
	        	logger.info("property name:  "+ele.getText());
	        } 
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		}
	/**
     * Find the {@link WebElement} identified by the given locator.
     *
     * @param locator the locator
     * @return the web element identified by locator
     * @throws org.openqa.selenium.NoSuchElementException if the element does not exist
     */
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }
	
	/**
	 * Clicks on specific element based on locator.
	 * @param locatorname
	 * @param linkname
	 */
	public void clickElement(By locatorname, String linkname){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorname));	
		new Actions(driver).moveToElement(driver.findElement(locatorname)).click().perform();
		WebElement link = driver.findElement(By.linkText(linkname));
		link.click();
	}
	
	/** 
	 * Navigates back to original page.
	 */
	public void navigateBack(){
		driver.navigate().back();
	}
	/**
     * Waits for element to display.
     * @param locator
     */
    public void waitForElementToDisplay(By locator){
        Wait < WebDriver > wait = new FluentWait< >(getWebDriver())
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions
                .presenceOfElementLocated(locator));
    }
    protected WebDriver getWebDriver() {
        return driver;
    }
    
    /**
     *Searches for property in specified country
     * @param countryname
     */
	public void findPropertyinEurope(String countryname)
	{
		waitForElementToDisplay(europaLink);
		find(europaLink).click();
		try{waitForElementToDisplay(country);
		WebElement countrydropdown = find(country);
		Select distanceDropdown= new Select(countrydropdown);
		distanceDropdown.selectByValue(countryname);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		waitForElementToDisplay(searchLink);
		find(searchLink).click();
		displayResults();
		}
	
	/**
	 * displays search results 
	 */
	public void displayResults(){
		try{			
			List<WebElement> elements = driver.findElements(By.className("search-result-title"));    
	        System.out.println("Test number of properties: " + elements.size());

	        for(WebElement ele : elements){
	        	logger.info("property name:  "+ele.getText());
	        } 
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
