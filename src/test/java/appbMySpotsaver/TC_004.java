package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.CreateAccountPage;
import pom.HomePage;
import utility.BaseClass;

public class TC_004 extends BaseClass {
	
	@BeforeMethod
	public void launchChrome() {
		   driver = Browser.launchBrowserb();
	}

	//Verify incorrect password format text is displayed
   @Test
      public void verifyIncorrectPasswordFormat(){
	
	  CreateAccountPage cA = new CreateAccountPage(driver);
	  HomePage hp = new HomePage(driver);
	  cA.passWordFormat();
     }

}
