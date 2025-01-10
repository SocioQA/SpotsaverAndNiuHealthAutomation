package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.HomePage;
import pom.CreateAccountPage;
import pom.LoginSampleUsingJsonData;
import utility.BaseClass;

public class TC_002 extends BaseClass{
	
	@BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	
	//Verify full name is required
    @Test
    public void verifyNameIsRequired(){
    	
    	CreateAccountPage cA = new CreateAccountPage(driver);
    	HomePage hp = new HomePage(driver);
    	cA.fullNameRequired();  	
    }
    
	//Verify email id is required    
    @Test
    public void verifyEmailIsRequired(){
    	
    	CreateAccountPage cA = new CreateAccountPage(driver);
    	HomePage hp = new HomePage(driver);
    	cA.emailRequired(); 	
    }
    
	//Verify password is required    
    @Test
    public void verifyPasswordIsRequired(){
    	
    	CreateAccountPage cA = new CreateAccountPage(driver);
    	HomePage hp = new HomePage(driver);
    	cA.passwordRequired();
    }

}
