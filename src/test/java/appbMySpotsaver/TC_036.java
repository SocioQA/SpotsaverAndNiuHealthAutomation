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

public class TC_036 extends BaseClass{
	//Verify that the help content is displayed when the user clicks on the Help button.	   
	  @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowser();
	   }
	   
	   @Test
	    public void profileHelpSection() throws InterruptedException {
		     // Initialize the Page Object classes
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        HomePage hp = new HomePage(driver);
			ProfilePage profilePage = new ProfilePage(driver);

	        loginPage.login();
	        hp.getSkipNotification();
	        //profilePage.verifyUserDetails();	
	        profilePage.helpSection();
	   }
}
