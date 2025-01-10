package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.LoginSampleUsingJsonData;
import pojo.Browser;
import pom.CreateAccountPage;
import pom.HomePage;
import pom.ProfilePage;
import utility.BaseClass;

public class TC_041 extends BaseClass{

	@BeforeMethod
	public void launchChrome() {
		driver = Browser.launchBrowserb();
	}

	@Test
	public void logOutTest() throws InterruptedException {
		LoginSampleUsingJsonData login = new LoginSampleUsingJsonData(driver);
		HomePage homePage = new HomePage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		//First create a new account
		//cA.createValidAccount();
		login.login();
		homePage.getSkipNotification();
		//Thread.sleep(2000);
		profilePage.profileSection();
		homePage.zoomOutScreen();
		profilePage.logOutSuccessfully();
	}
	
	@Test
	public void notLogOutTest() throws InterruptedException {
		LoginSampleUsingJsonData login = new LoginSampleUsingJsonData(driver);
		HomePage homePage = new HomePage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		//First create a new account
		//cA.createValidAccount();
		login.login();
		homePage.getSkipNotification();
		//Thread.sleep(2000);
		profilePage.profileSection();
		homePage.zoomOutScreen();
		profilePage.notLogOut();

	}

}
