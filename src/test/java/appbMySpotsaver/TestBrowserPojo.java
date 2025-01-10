package appbMySpotsaver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.HomePage;
import pom.LoginPage;
import pom.LoginSampleUsingJsonData;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;
import pom.DateSelectionPage;
import pom.ReserveASpotButton;
import pom.CancelReservation;

public class TestBrowserPojo extends BaseClass {

	ExtentReports reports;
	ExtentTest test;
	   
	   @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	   
	   @Test
	    public void reserveSpotVerify() throws InterruptedException {
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        HomePage homePage = new HomePage(driver);
	        loginPage.login();
	        homePage.getSkipNotification();
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	        Actions actions = new Actions(driver);
//	        wait.until(ExpectedConditions.visibilityOf(homePage.getSkipNotification()));
//	        actions.moveToElement(homePage.getSkipNotification()).click().perform();
//	        Thread.sleep(3000);
	        
	        // Initialize the Page Object classes
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);

	        // Perform store selection
	        storeSelectionPage.selectStore();
	        Thread.sleep(4000); // Wait for the store selection to process

	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        
	        // Select date
	        dateSelectionPage.selectCurrentDate();
	    //  dateSelectionPage.selectFutureDate();
	        dateSelectionPage.zoomOutScreen();
	        dateSelectionPage.scrollUpToViewDropdown();

	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(9); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(7);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();
	        
	        //Cancel the saved spot
	        cancelSpot.cancelReservation();
	        
	        //Verify spot is canceled successfully by verifying by text 'canceled'
	        cancelSpot.verifyCancellation();
	        
	   }
	   
	   @AfterClass
	    public void tearDown(){
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        driver.quit();
	    }
	        
	    

}
