package appbMySpotsaver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.CancelReservation;
import pom.MySpotsPage;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.SaveSpotButton;
import pom.StoreSelectionPage;
import utility.BaseClass;

public class TC_092_old extends BaseClass {
	
	@BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	    
	    @Test
	    public void testSaveSpot1stTime() throws InterruptedException {
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	    	HomePage hp = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        SaveSpotButton saveSpot = new SaveSpotButton(driver);
	        loginPage.login();
	        hp.getSkipNotification();
	        // Perform store selection
	        storeSelectionPage.selectStore();
	        hp.zoomOutScreen();
	        //partySize.selectPartySize(2);
	        saveSpot.saveSpot();
 
	    }
	    
	    @Test(dependsOnMethods = "testSaveSpot1stTime")
	    public void testSaveSameSpotAgain() throws InterruptedException {
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	    	HomePage hp = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        SaveSpotButton saveSpot = new SaveSpotButton(driver);
	        MySpotsPage ms = new MySpotsPage(driver);
	        loginPage.login();
	        hp.getSkipNotification();
	        // Perform store selection
	        storeSelectionPage.selectStore();
	        hp.zoomOutScreen();
	        saveSpot.saveSpot();
	        Thread.sleep(2000);
	        saveSpot.verifyActiveSpotExist();
	        
	    }
	    
	    //Now, cancel the active spot
	    @Test(dependsOnMethods = "testSaveSameSpotAgain")
	    public void cancelSpotfromAbove() throws InterruptedException {
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	    	HomePage hp = new HomePage(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        MySpotsPage ms = new MySpotsPage(driver);
	        loginPage.login();
	        hp.getSkipNotification();
	        hp.zoomOutScreen();
	        ms.MySpotsSection();
	        ms.clickOnFirstSavedSpot();
	        //Thread.sleep(4000);
	        cancelSpot.cancelReservation();
	    }
}
