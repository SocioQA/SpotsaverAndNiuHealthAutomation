package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.HomePage;
import pom.CreateAccountPage;
import pom.LoginSampleUsingJsonData;
import utility.BaseClass;

public class TC_001 extends BaseClass{
	
	@BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }

	// Test user is able to create an account successfully with valid credentials
    @Test
    public void createNewUserAccount(){
    	
    	CreateAccountPage cA = new CreateAccountPage(driver);
    	HomePage hp = new HomePage(driver);
    	cA.createValidAccount();
    	hp.getSkipNotification();
    	
    }

}
