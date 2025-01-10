package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.ProfilePage;
import utility.BaseClass;

public class TC_035_1 extends BaseClass{
	//Verify that the user can edit their notification preferences in the profile section
	
	   @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowser();
	   }
	   
	   @Test
	    public void toggleSmsNotificationPref() throws InterruptedException {
		     // Initialize the Page Object classes
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        HomePage hp = new HomePage(driver);
			ProfilePage profilePage = new ProfilePage(driver);

	        loginPage.login();
	        hp.getSkipNotification();
	        profilePage.toggleSMSNotification();
	   }



}
