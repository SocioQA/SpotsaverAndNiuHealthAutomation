package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.HomePage;
import pom.MySpotsPage;
import pom.LoginSampleUsingJsonData;
import pom.PartySizePage;
import pom.SaveSpotButton;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;

//Verify that the user can view their reserved spots in the My Spots section
public class TC_028 extends BaseClass{
	
	@BeforeMethod
	public void launchChrome() {
		driver = Browser.launchBrowser();
	}

	@Test
	public void testMySpotsPage() throws InterruptedException {
		LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
		HomePage hp = new HomePage(driver);
		MySpotsPage ms = new MySpotsPage(driver);
		StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
		TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
		DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
		CancelReservation  cancelSpot = new CancelReservation(driver);
		PartySizePage partySize = new PartySizePage(driver);
		SaveSpotButton saveSpot = new SaveSpotButton(driver);
		loginPage.login();
		hp.getSkipNotification();
		// Perform store selection
		//storeSelectionPage.selectStore();
		//hp.zoomOutScreen();
		//saveSpot.saveSpot();
		//saveSpot.verifySavedSpot();
		//cancelSpot.cancelReservation();  
		ms.MySpotsSection();
		

	}
	

}
