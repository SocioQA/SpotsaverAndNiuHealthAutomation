package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.PartySizePage;
import pom.ProfilePage;
import pom.ReserveASpotButton;
import pom.SearchStore;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;

public class TC_033 extends BaseClass{
	//Verify that the user's name and email are displayed in the profile section and cannot be edited
	   @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowser();
	   }
	   
	   @Test
	    public void verifyNameAndEmail() throws InterruptedException {
		     // Initialize the Page Object classes
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        HomePage hp = new HomePage(driver);
			ProfilePage profilePage = new ProfilePage(driver);

	        loginPage.login();
	        hp.getSkipNotification();
	        profilePage.verifyUserDetails();	   	        
	   }
}
