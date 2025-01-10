package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.HomePage;
import pom.LoginPage;
import pom.LoginSampleUsingJsonData;
import pom.PartySizePage;
import pom.ReserveASpotButton;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;

public class TC_021_2 extends BaseClass{
	@BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	   
	   @Test
	    public void verifyReserveSpotButton() throws InterruptedException {
		     // Initialize the Page Object classes
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        // LoginPage loginPage = new LoginPage(driver);
	        HomePage homePage = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        PartySizePage ps = new PartySizePage(driver);
	        loginPage.login();
	        homePage.getSkipNotification();

	        // Perform store selection
	        storeSelectionPage.selectStore();
	       // Thread.sleep(4000); // Wait for the store selection to process
	        storeSelectionPage.zoomOutScreen();
	        
	        //Select party size
	       // ps.selectPartySize(2);

	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        

	        // Select date
	       // dateSelectionPage.selectCurrentDate();
	        dateSelectionPage.selectFutureDate();
	       // dateSelectionPage.zoomOutScreen();
	        dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(10); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(7);
	        //Thread.sleep(4000);
	        //reserveASpot.verifyReserveSpotButtonText();

	        
	        //pending for 'reserve a spot button text. it is not present in dom
}
}	   

