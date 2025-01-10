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
import pom.SaveSpotButton;
import pom.SearchStore;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;

public class TC_020_New extends BaseClass {
	   @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	   
	   @Test
	    public void searchStoreAndSaveSpot() throws InterruptedException {
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
	        SaveSpotButton saveSpot = new SaveSpotButton(driver);

	        loginPage.login();
	        hp.getSkipNotification();
	        //Search bar
	        searchStore.clickCancelAddress();
	        searchStore.enterStoreText();
	        //searchStore.enterStoreLocation(); //pune location
	        
	        //Zoom out
	        //storeSelectionPage.zoomOutScreen();
	        searchStore.selectYourStore(0);
	        Thread.sleep(4000);
//	        //Zoom out
	        storeSelectionPage.zoomOutScreen();
	        ps.selectPartySize(2);
	        Thread.sleep(4000);
	        saveSpot.saveSpotNew();
//	        saveSpot.verifySavedSpot();
//	        cancelSpot.cancelReservation();  
	        
	   }
	   
	   @Test
	    public void searchStoreAndSaveSameSpot() throws InterruptedException {
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
	        SaveSpotButton saveSpot = new SaveSpotButton(driver);

	        loginPage.login();
	        hp.getSkipNotification();
	        //Search bar
	        searchStore.clickCancelAddress();
	        searchStore.enterStoreText();
	        //searchStore.enterStoreLocation(); //pune location
	        
	        //Zoom out
	        //storeSelectionPage.zoomOutScreen();
	        searchStore.selectYourStore(0);
	        Thread.sleep(4000);
//	        //Zoom out
	        storeSelectionPage.zoomOutScreen();
	        ps.selectPartySize(2);
	        Thread.sleep(4000);
	        saveSpot.saveSpot();
	        saveSpot.verifyActiveSpotExist();

	        
	   }
}
