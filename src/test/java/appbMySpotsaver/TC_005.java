package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CreateAccountPage;
import pom.HomePage;
import utility.BaseClass;

public class TC_005 extends BaseClass {
	
	@BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	
	
	// Test user is unable to create account with an existing email id
    @Test
    public void emailAlreadyTextTestcase(){
 	
 	CreateAccountPage cA = new CreateAccountPage(driver);
 	HomePage hp = new HomePage(driver);
 	cA.emailAlreadyTaken();
 	
 }

}
