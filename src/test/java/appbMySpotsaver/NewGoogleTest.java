package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.HomePage;
import pom.LoginNewFBAndGoogle;
import utility.BaseClass;

public class NewGoogleTest extends BaseClass {

	@BeforeMethod
	public void launchChrome() {
		driver = Browser.launchBrowser();
	}

	@Test
	public void googleLogin() throws InterruptedException {
		LoginNewFBAndGoogle loginPage = new LoginNewFBAndGoogle(driver);
		HomePage hp = new HomePage(driver);

		// Click on the google login button
		loginPage.clickGoogleLoginButton();

		// Switch to the new google login window
		//loginPage.switchToNewWindow();

		// Enter credentials and login with google
		loginPage.loginUsingGoogle();

		// Thread.sleep(6000);
		// hp.getSkipNotification();

	}
}
