package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.ProfilePage;
import pom.HomePage;
import pom.CreateAccountPage;
import utility.BaseClass;

public class TC_040 extends BaseClass{

	@BeforeMethod
	public void launchChrome() {
		driver = Browser.launchBrowserb();
	}

	@Test
	public void accountDeletedSuccessfully(){
		CreateAccountPage cA = new CreateAccountPage(driver);
		HomePage homePage = new HomePage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		//First create a new account
		cA.createAnotherValidAccount();
		homePage.getSkipNotification();
		profilePage.profileSection();
		homePage.zoomOutScreen();
		profilePage.deleteAccountSuccessfully();
	}
	
	@Test
	public void notDeleteAccount() {
		CreateAccountPage cA = new CreateAccountPage(driver);
		HomePage homePage = new HomePage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		//First create a new account
		cA.createAnotherValidAccount();
		homePage.getSkipNotification();
		profilePage.profileSection();
		homePage.zoomOutScreen();
		profilePage.notDeleteAccount();
		profilePage.deleteAccountSuccessfully();

	}
	
}	   
