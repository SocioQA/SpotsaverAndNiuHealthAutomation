package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.PartySizePage;
import pom.SaveSpotButton;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;

public class TC_022 extends BaseClass{
	//Verify that user can see the Store location, phone number, store's time zone, andOpening/Closing 
	//time for the selected store.
	@BeforeMethod
	public void launchChrome() {
		driver = Browser.launchBrowser();
	}

	@Test
	public void viewStoreDetails() {
		LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
		HomePage hp = new HomePage(driver);
		StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
		loginPage.login();
		hp.getSkipNotification();
		// Perform store selection
		storeSelectionPage.selectStore();
		storeSelectionPage.scrollToFirstDateButton();
		storeSelectionPage.fetchAndPrintStoreTexts();
	}	
	
}
