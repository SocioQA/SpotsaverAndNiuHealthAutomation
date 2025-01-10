package pom;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReserveASpotButton {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public ReserveASpotButton(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	// Locate the "Reserve a Spot" button
	// Locate the element with dynamic id "mui-7" or "mui-4" since the button have dynamic id value.
	@FindBy(xpath = "//*[@id='mui-7' or @id='mui-4']")
	WebElement reserveASpotButton;

	//Xpath of 'active' text after successfully saving spot
	@FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-subtitle1 css-1bw9ow1']")
	WebElement savedConfirmationElement;

	// Locate the "Reserve A Spot" button when it is enabled - xpath not working
	//@FindBy(xpath = "//button[not(@disabled) and @id='mui-7']//span[contains(@class, 'MuiButton-icon') and contains(@class, 'MuiButton-startIcon') and normalize-space()='Reserve A Spot']")
	@FindBy (xpath = "//*[@id='mui-7' or @id='mui-4']/span[2]")
	WebElement reserveSpotEnabledButton;
	
	// Max Active Reservation Text
	@FindBy(xpath = "//*[@id='__next']/div/div[6]/div[6]/p")
	WebElement maxActiveSpotText;

	// Method to fetch and verify the button text
	public void verifyReserveSpotButtonText() {
		wait.until(ExpectedConditions.visibilityOf(reserveSpotEnabledButton));
		wait.until(ExpectedConditions.elementToBeClickable(reserveSpotEnabledButton));

		String expectedText = "Reserve A Spot";
		String actualText = reserveSpotEnabledButton.getText();
		System.out.println("Button Text: " + actualText);
		Assert.assertEquals(actualText, expectedText, "Button text does match!");
	}

	public void clickReserveASpotButton() {
		reserveASpotButton.click();
		//        // Wait until the button is visible
		//        wait.until(ExpectedConditions.visibilityOf(reserveASpotButton));
		//        // Scroll to the button
		//        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", reserveASpotButton);
		//        // Click the button
		//        js.executeScript("arguments[0].click();", reserveASpotButton);
	}

	public void verifySavedSpot() {
		// Wait until the cancellation confirmation is visible
		wait.until(ExpectedConditions.visibilityOf(savedConfirmationElement));
		// Get the text and verify it matches "canceled"
		String savedActiveText = savedConfirmationElement.getText();
		Assert.assertEquals(savedActiveText, "ACTIVE");
		System.out.println("Current Spot Saved Successfully");
	}
	
	public void verifyMaxActiveSpotErrorMsg() {
		// Wait until the cancellation confirmation is visible
		wait.until(ExpectedConditions.visibilityOf(maxActiveSpotText));
		// Get the text and verify it matches "canceled"
		String maxActiveText = maxActiveSpotText.getText();
		Assert.assertEquals(maxActiveText, "Max active reservation per store limit reached.");
		System.out.println("Max active reservation per store limit reached by the user for this location");
	}
	
	


}
