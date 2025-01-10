package appbMySpotsaver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import utility.BaseClass;
import pom.PartySizePage;
import pom.ReserveASpotButton;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import pom.SearchStore;

public class TC_021 extends BaseClass{
	
	 
	   @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowser();
	   }
	   
	   @Test
	    public void searchStoreAndReserveSpot() throws InterruptedException {
		     // Initialize the Page Object classes
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        HomePage hp = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        SearchStore searchStore = new SearchStore(driver);
	        PartySizePage ps = new PartySizePage(driver);

	        loginPage.login();
	        hp.getSkipNotification();
	        //Search bar
	        searchStore.clickCancelAddress();
	        searchStore.enterStoreText();	        
	        searchStore.selectYourStore(0);
	        //Zoom out
	        //storeSelectionPage.zoomOutScreen();
	        ps.selectPartySize(2);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    dateSelectionPage.selectFutureDate();
		    dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(10); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(3);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();
	        
	        //Cancel the saved spot
	        cancelSpot.cancelReservation();
	        
	        //Verify spot is canceled
	        cancelSpot.verifyCancellation();			    
	   }
}