package appbMySpotsaver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.HomePage;
import pom.LoginPage;
import pom.PartySizePage;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;
import pom.DateSelectionPage;
import pom.ReserveASpotButton;
import pom.CancelReservation;
public class TC_021_old extends BaseClass{
	//WebDriver driver;
	   
	 @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	   
	   @Test
	    public void reserveSpot() throws InterruptedException {
		     // Initialize the Page Object classes
	        LoginPage loginPage = new LoginPage(driver);
	        HomePage homePage = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        PartySizePage ps = new PartySizePage(driver);
	        loginPage.enterUserName("demou345@gmail.com");
	        loginPage.enterPassword("Demo@123");
	        loginPage.clickSignInButton();
	        homePage.getSkipNotification();

	        // Perform store selection
	        storeSelectionPage.selectStore();
	       // Thread.sleep(4000); // Wait for the store selection to process
	        storeSelectionPage.zoomOutScreen();

	       // Thread.sleep(2000);
	        //Select party size
	       // ps.selectPartySize(2);

	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        
	        // Select date
	       // dateSelectionPage.selectCurrentDate();
	        dateSelectionPage.selectFutureDate();
	        dateSelectionPage.scrollUpToViewDropdown();

	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(10); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(7);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();
	        
	        //Cancel the saved spot
	        cancelSpot.cancelReservation();
	        //Thread.sleep(2000);
	        
	   }
	   
//	   @AfterClass
//	    public void tearDown(){
//		    try {
//				Thread.sleep(4000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        driver.quit();
//	    }

	
	   
}
