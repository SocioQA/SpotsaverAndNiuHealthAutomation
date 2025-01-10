package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;

public class MySpotsPage extends BaseClass{

	WebDriverWait wait;
	JavascriptExecutor js;
	Actions action;

	public MySpotsPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated constructor
		this.js = (JavascriptExecutor) driver;
		this.action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//button[@class='MuiButtonBase-root MuiBottomNavigationAction-root bottomNavigation my-spot disabled css-13nq3aa']")
	WebElement MySpots;
	
	@FindBy(xpath ="//span[@class='MuiChip-label MuiChip-labelMedium css-9iedg7' and text()='Completed']")
	WebElement completedSection;
	
	@FindBy(xpath ="//span[@class='MuiChip-label MuiChip-labelMedium css-9iedg7' and text()='Expired']")
	WebElement expiredSection;
	
	@FindBy(xpath ="//span[@class='MuiChip-label MuiChip-labelMedium css-9iedg7' and text()='Canceled']")
	WebElement canceledSection;
	
	//Click on the first saved spot
	@FindBy(xpath ="//*[@id='__next']/div/div[3]/div/div/a/div/div/div[3]")
	WebElement firstSpot;
	
	
	// Method to switch to my spots section
	public void MySpotsSection()
	{
		MySpots.click();
	}
	
	// Method to switch to completed my spots section
	public void CompletedSection()
	{
		MySpots.click();
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(completedSection));
		// Click the button
		js.executeScript("arguments[0].click();", completedSection); 
	}
	
	// Method to switch to expired my spots section
	public void ExpiredSection()
	{
		MySpots.click();
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(expiredSection));
		// Click the button
		js.executeScript("arguments[0].click();", expiredSection); 
	}	
	
	//Select first saved spot
	// Method to switch to expired my spots section
	public void clickOnFirstSavedSpot()
	{
		
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(firstSpot));
		// Click the button
		js.executeScript("arguments[0].click();", firstSpot); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
