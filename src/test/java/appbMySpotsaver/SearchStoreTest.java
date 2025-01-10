package appbMySpotsaver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.PartySizePage;
import pom.ReserveASpotButton;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;
import pom.SearchStore;

public class SearchStoreTest extends BaseClass {
    //WebDriver driver;

    // Set up WebDriver before each test
    @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
    
    // Test method to verify the cancel address button functionality and search input
    @Test
    public void testCancelAddressAndSearch() {
        // Initialize the SearchPage object
    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
    	HomePage hp = new HomePage(driver);
        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
        CancelReservation  cancelSpot = new CancelReservation(driver);
        PartySizePage partySize = new PartySizePage(driver);
        SearchStore searchPage = new SearchStore(driver);
        
        //Login and skip notification
        loginPage.login();
        hp.getSkipNotification();
        
        // Click on the cancel button in search bar
        searchPage.clickCancelAddress();

        // Enter text into the search input field and select the first location from dropdown
        searchPage.enterStoreText();

        // Add assertions or further actions as needed
    }

//    // Tear down WebDriver after each test
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
