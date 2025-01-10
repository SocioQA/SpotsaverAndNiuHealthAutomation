package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.ProfilePage;
import utility.BaseClass;

public class TC_038 extends BaseClass{
	//Verify that the user can view the privacy policy

	 @BeforeMethod
	public void launchChrome() {
		driver = Browser.launchBrowser();
	}

	@Test
	public void profilePrivacyPolicySection() throws InterruptedException {
		//Verify that the user can view the privacy policy
		// Initialize the Page Object classes
		LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
		HomePage hp = new HomePage(driver);
		ProfilePage profilePage = new ProfilePage(driver);

		loginPage.login();
		hp.getSkipNotification();
		profilePage.privacyPolicySection();
	}

}
