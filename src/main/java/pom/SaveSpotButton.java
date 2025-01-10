package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SaveSpotButton {
	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait waitMore;
	JavascriptExecutor js;

	public SaveSpotButton(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.waitMore = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	// Locate the "Save Spot" button
	// Locate the element with dynamic id "mui-7" or "mui-4" since the button have dynamic id value.

	//@FindBy(xpath = "//*[@id='mui-6']")
	@FindBy(xpath = "//button[@id='mui-6' or @id='mui-13'  or @id='mui-3' or contains(@class, 'MuiButtonBase-root') and contains(@class, 'MuiButton-containedPrimary')]")
	WebElement saveSpotButton;

	//Another xpath for save spot button
	@FindBy(xpath = "//*[@id='mui-6' or @id='mui-13' or @id='mui-3']")
	WebElement saveSpotBtn;

	//XPATH of 'active' text after successfully saving current spot
	@FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-subtitle1 css-1bw9ow1']")
	WebElement savedConfirmationElement;

	// XPATH for the text of an active reservation already exist for same spot
	@FindBy(xpath = "//*[@id='__next']/div/div[3]/p")
	WebElement alreadySavedSpot;

	// 'Select your party size text
	@FindBy(xpath = "//*[@id='__next']/div/div[4]/p")
	WebElement selectPartyText;

	public void saveSpot() {
		// Wait for the cancel button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(saveSpotButton));
		// Wait until the button is visible
		wait.until(ExpectedConditions.visibilityOf(saveSpotButton));
		// Click the button
		js.executeScript("arguments[0].click();", saveSpotButton); 

	}

	public void saveSpotNew() {
		// Wait for the cancel button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(saveSpotBtn));
		// Wait until the button is visible
		wait.until(ExpectedConditions.visibilityOf(saveSpotBtn));
		// Click the button
		js.executeScript("arguments[0].click();", saveSpotBtn); 

	}

	public void verifySavedSpot() {
		// Wait until the cancellation confirmation is visible
		wait.until(ExpectedConditions.visibilityOf(savedConfirmationElement));
		// Get the text and verify it matches "canceled"
		String savedActiveText = savedConfirmationElement.getText();
		Assert.assertEquals(savedActiveText, "ACTIVE");
		System.out.println("Current Spot Saved Successfully");
	}

	public void verifyActiveSpotExist(){

		// Wait until the cancellation confirmation is visible
		waitMore.until(ExpectedConditions.visibilityOf(alreadySavedSpot));
		// Get the text and verify it matches "canceled"
		String activeSpotText = alreadySavedSpot.getText();
		Assert.assertEquals(activeSpotText, "An active reservation already exists at this location for the given date or time");
		System.out.println("An active reservation already exists");
	}



}
