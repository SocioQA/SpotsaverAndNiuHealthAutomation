package pom;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CancelReservation {
	    WebDriver driver;
	    JavascriptExecutor js;
	    WebDriverWait wait;
	    WebDriverWait waitMore;

	    public CancelReservation(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        this.waitMore = new WebDriverWait(driver, Duration.ofSeconds(25));
	        this.js = (JavascriptExecutor) driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Locate the Cancel Reservation button
	    @FindBy(xpath = "/html/body/div[1]/div/div[5]/button")
	    WebElement cancelReservationButton;
	    
	    //Use this cancel reservation xpath for 92 no test case
	    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item css-qxa474'] | /html/body/div[1]/div/div[5]/button")
	    WebElement cancelReservationBtn;
	    
	    //Xpath of 'canceled' text
	    @FindBy(xpath = "//*[@id='__next']/div/div[2]/div[2]/h6[2]")
	    WebElement cancelConfirmationElement;

	    // Locate the Yes button in the confirmation dialog
	    @FindBy(xpath = "/html/body/div[4]/div[3]/div/button[2] | //div[@class='MuiBox-root css-ckyhk3']//button[2]")
	    WebElement yesCancelButton;
	    
	    //Locate Cancel button in the confirmation dialog
	    @FindBy(xpath = "/html/body/div[4]/div[3]/div/button[1] | //div[@class='MuiBox-root css-ckyhk3']//button[1]")
	    WebElement cancelCancelButton;
	    
	    //Xpath of 'active' text after successfully saving spot
	    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-subtitle1 css-1bw9ow1']")
	    WebElement savedConfirmationElement;
	    
	    

	    // Method to cancel a reservation
	    public void cancelReservation(){
	        // Wait for the cancel button to be clickable (not just visible)
	        wait.until(ExpectedConditions.elementToBeClickable(cancelReservationButton));

	        // Click the Cancel Reservation button
	    	wait.until(ExpectedConditions.visibilityOf(cancelReservationButton)).click();
	        // Thread.sleep(5000); // Wait for the confirmation dialog to appear

	        // Click the Yes button in the confirmation dialog
	    	waitMore.until(ExpectedConditions.visibilityOf(yesCancelButton)).click();
	    }
	    
	    // Method to cancel a reservation
	    public void cancelRsvtn(){
	        // Click the Cancel Reservation button
	    	wait.until(ExpectedConditions.visibilityOf(cancelReservationBtn)).click();
	        // Thread.sleep(5000); // Wait for the confirmation dialog to appear

	        // Click the Yes button in the confirmation dialog
	    	waitMore.until(ExpectedConditions.visibilityOf(yesCancelButton)).click();
	    } 
	    public void verifyCancellation() {
	        // Wait until the cancellation confirmation is visible
	        wait.until(ExpectedConditions.visibilityOf(cancelConfirmationElement));
	        
	        // Get the text and verify it matches "canceled"
	        String cancelConfirmationText = cancelConfirmationElement.getText();
	        Assert.assertEquals(cancelConfirmationText, "CANCELED", "Spot cancellation verification passed.");
	        System.out.println("Spot Canceled Successfully");
	    }
	    

	    // Method to not cancel a reservation
	    public void notCancelReservation(){
	        // Click the Cancel Reservation button
	    	wait.until(ExpectedConditions.visibilityOf(cancelReservationButton)).click();
	        // Thread.sleep(5000); // Wait for the confirmation dialog to appear

	        // Click the Yes button in the confirmation dialog
	    	waitMore.until(ExpectedConditions.visibilityOf(cancelCancelButton));
	        js.executeScript("arguments[0].click();", cancelCancelButton);
	    }
	    
	    public void verifySavedSpot() {
	        // Wait until the cancellation confirmation is visible
	        wait.until(ExpectedConditions.visibilityOf(savedConfirmationElement));
	     // Get the text and verify it matches "canceled"
	        String savedActiveText = savedConfirmationElement.getText();
	        Assert.assertEquals(savedActiveText, "ACTIVE");
	        System.out.println("Saved Spot Not Canceled");
	    }
		
	    


}
