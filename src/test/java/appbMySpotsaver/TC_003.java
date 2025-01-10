package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CreateAccountPage;
import pom.HomePage;
import utility.BaseClass;

public class TC_003 extends BaseClass{
	
	@BeforeMethod
	public void launchChrome() {
		   driver = Browser.launchBrowserb();
	}
	
	//Verify email id is incorrect
    @Test
    public void verifyEmailIsIncorrect(){
 	
 	CreateAccountPage cA = new CreateAccountPage(driver);
 	HomePage hp = new HomePage(driver);
 	cA.emailIncorrect();	
    }
 
	

}
