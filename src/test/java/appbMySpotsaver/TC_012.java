package appbMySpotsaver;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import utility.BaseClass;

public class TC_012 extends BaseClass{
	
	   //Test case for blank login
	
	   @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	    
	    @Test
	    public void testBlankFieldLogin() throws ParseException {
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	    	HomePage hp = new HomePage(driver);
	        loginPage.blankLogin();
	    }

}
