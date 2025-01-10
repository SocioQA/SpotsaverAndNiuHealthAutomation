package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.PartySizePage;
import pom.ReserveASpotButton;
import pom.SearchStore;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;

public class TC_093_Old extends BaseClass{
	   @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	   
	   @Test
	    public void save1stSpot() throws InterruptedException {
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
	        //searchStore.enterStoreLocation(); //pune location
	        
//	        //Zoom out
//	        storeSelectionPage.zoomOutScreen();
	        searchStore.selectYourStore(0);
	        //Zoom out
	        storeSelectionPage.zoomOutScreen();
	        ps.selectPartySize(2);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    dateSelectionPage.selectFutureDate();
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
	        //cancelSpot.cancelReservation();
	        
	        //Verify spot is canceled
	        //cancelSpot.verifyCancellation();			    
	   }
	   
	   @Test(dependsOnMethods = "save1stSpot")
	    public void save2ndSpot() throws InterruptedException {
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
	        //searchStore.enterStoreLocation(); //pune location
	        
//	        //Zoom out
//	        storeSelectionPage.zoomOutScreen();
	        searchStore.selectYourStore(0);
	        //Zoom out
	        storeSelectionPage.zoomOutScreen();
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
	        //cancelSpot.cancelReservation();
	        
	        //Verify spot is canceled
	        //cancelSpot.verifyCancellation();			    
	   }
	   
	   @Test(dependsOnMethods = "save2ndSpot")
	    public void save3rdSpot() throws InterruptedException {
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

//	        //Zoom out
//	        storeSelectionPage.zoomOutScreen();
	        searchStore.selectYourStore(0);
	        //Zoom out
	        storeSelectionPage.zoomOutScreen();
	        ps.selectPartySize(2);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    dateSelectionPage.selectFutureDate();
		    dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(9); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(3);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();
	        
	        //Cancel the saved spot
	        //cancelSpot.cancelReservation();
	        
	        //Verify spot is canceled
	        //cancelSpot.verifyCancellation();			    
	   }
//	   
//	   @Test(dependsOnMethods = "save3rdSpot")
//	    public void save4thSpot() throws InterruptedException {
//		     // Initialize the Page Object classes
//	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
//	        HomePage hp = new HomePage(driver);
//	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
//	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
//	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
//	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
//	        CancelReservation  cancelSpot = new CancelReservation(driver);
//	        SearchStore searchStore = new SearchStore(driver);
//	        PartySizePage ps = new PartySizePage(driver);
//
//	        loginPage.login();
//	        hp.getSkipNotification();
//	        //Search bar
//	        searchStore.clickCancelAddress();
//	        searchStore.enterStoreText();
//	        //searchStore.enterStoreLocation(); //pune location
//	        
////	        //Zoom out
////	        storeSelectionPage.zoomOutScreen();
//	        searchStore.selectYourStore(0);
//	        Thread.sleep(2000);	       
//	        //Zoom out
//	        storeSelectionPage.zoomOutScreen();
//	        ps.selectPartySize(2);
//	        // Scroll to the first date button
//	        storeSelectionPage.scrollToFirstDateButton();
//	        // Select date
//		    dateSelectionPage.selectFutureDate();
//		    dateSelectionPage.scrollUpToViewDropdown();
//	        // Select the PM time
//	        timeSelectionPage.clickOnPm();
//
//	        // Select a specific PM hour (e.g., 9 PM)
//	        timeSelectionPage.selectHour(8); // Index is 0-based
//	        
//	        // Select minutes from the list
//	        timeSelectionPage.selectMinutes(1);
//	        
//	        //Click on reserve a spot button
//	        reserveASpot.clickReserveASpotButton();
//	        
//	        //Cancel the saved spot
//	        //cancelSpot.cancelReservation();
//	        
//	        //Verify spot is canceled
//	        //cancelSpot.verifyCancellation();			    
//	   }
//	   
//	   @Test(dependsOnMethods = "save4thSpot")
//	    public void save5thSpot() throws InterruptedException {
//		     // Initialize the Page Object classes
//	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
//	        HomePage hp = new HomePage(driver);
//	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
//	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
//	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
//	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
//	        CancelReservation  cancelSpot = new CancelReservation(driver);
//	        SearchStore searchStore = new SearchStore(driver);
//	        PartySizePage ps = new PartySizePage(driver);
//
//	        loginPage.login();
//	        hp.getSkipNotification();
//	        //Search bar
//	        searchStore.clickCancelAddress();
//	        searchStore.enterStoreText();
//	        //searchStore.enterStoreLocation(); //pune location
//	        
////	        //Zoom out
////	        storeSelectionPage.zoomOutScreen();
//	        searchStore.selectYourStore(0);
//	        Thread.sleep(2000);	        //Zoom out
//
//	        //Zoom out
//	        storeSelectionPage.zoomOutScreen();
//	        ps.selectPartySize(2);
//	        // Scroll to the first date button
//	        storeSelectionPage.scrollToFirstDateButton();
//	        // Select date
//		    dateSelectionPage.selectFutureDate();
//		    dateSelectionPage.scrollUpToViewDropdown();
//	        // Select the PM time
//	        timeSelectionPage.clickOnPm();
//
//	        // Select a specific PM hour (e.g., 9 PM)
//	        timeSelectionPage.selectHour(8); // Index is 0-based
//	        
//	        // Select minutes from the list
//	        timeSelectionPage.selectMinutes(5);
//	        
//	        //Click on reserve a spot button
//	        reserveASpot.clickReserveASpotButton();
//	        
//	        //Cancel the saved spot
//	        //cancelSpot.cancelReservation();
//	        
//	        //Verify spot is canceled
//	        //cancelSpot.verifyCancellation();			    
//	   }
//	   
//	   @Test(dependsOnMethods = "save5thSpot")
//	    public void save6thSpot() throws InterruptedException {
//		     // Initialize the Page Object classes
//	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
//	        HomePage hp = new HomePage(driver);
//	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
//	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
//	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
//	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
//	        CancelReservation  cancelSpot = new CancelReservation(driver);
//	        SearchStore searchStore = new SearchStore(driver);
//	        PartySizePage ps = new PartySizePage(driver);
//
//	        loginPage.login();
//	        hp.getSkipNotification();
//	        //Search bar
//	        searchStore.clickCancelAddress();
//	        searchStore.enterStoreText();
//	        //searchStore.enterStoreLocation(); //pune location
//	        
////	        //Zoom out
////	        storeSelectionPage.zoomOutScreen();
//	        searchStore.selectYourStore(0);
//	        //Zoom out
//	        storeSelectionPage.zoomOutScreen();
//	        ps.selectPartySize(2);
//	        // Scroll to the first date button
//	        storeSelectionPage.scrollToFirstDateButton();
//	        // Select date
//		    dateSelectionPage.selectFutureDate();
//		    dateSelectionPage.scrollUpToViewDropdown();
//	        // Select the PM time
//	        timeSelectionPage.clickOnPm();
//
//	        // Select a specific PM hour (e.g., 9 PM)
//	        timeSelectionPage.selectHour(7); // Index is 0-based
//	        
//	        // Select minutes from the list
//	        timeSelectionPage.selectMinutes(9);
//	        
//	        //Click on reserve a spot button
//	        reserveASpot.clickReserveASpotButton();
//	        
//	        //Cancel the saved spot
//	        //cancelSpot.cancelReservation();
//	        
//	        //Verify spot is canceled
//	        //cancelSpot.verifyCancellation();			    
//	   }

}
