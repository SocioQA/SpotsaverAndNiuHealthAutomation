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

public class TC_021_1 extends BaseClass{
	@BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowser();
	   }
	   
	   @Test
	    public void verifyDate() throws InterruptedException {
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
	        Thread.sleep(2000);
	        dateSelectionPage.fetchSelectedDate();

}
}	   
