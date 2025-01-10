package appbMySpotsaver;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import utility.BaseClass;

public class TC_009 extends BaseClass{
// Login Using Json Data	
	
	// WebDriver driver;

	 @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowser();
	   }
	    
	    @Test
	    public void testLogin() throws ParseException {
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	    	HomePage hp = new HomePage(driver);
	        loginPage.login();
	        hp.getSkipNotification();
	    }
	    
//		   @AfterClass
//		    public void tearDown(){
//			    try {
//					Thread.sleep(4000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		        driver.quit();
//		    }

}
