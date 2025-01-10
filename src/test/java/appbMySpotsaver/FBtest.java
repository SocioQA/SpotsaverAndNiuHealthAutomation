package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import utility.BaseClass;

public class FBtest extends BaseClass{
	
	@BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	    
	    @Test
	    public void facebookLogin() throws InterruptedException {
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	    	HomePage hp = new HomePage(driver);

	        // Click on the Facebook login button
	        loginPage.clickFacebookLoginButton();

	        // Switch to the new Facebook login window
	        loginPage.switchToNewWindow();
	        
	        // Enter credentials and login with facebook
	        loginPage.loginUsingFacebook();
	        
	      //  Thread.sleep(5000);
	      //  hp.getSkipNotification();

	    }

}
