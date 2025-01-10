package appbMySpotsaver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import utility.BaseClass;
import pom.PartySizePage;
import pom.ReserveASpotButton;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import pom.SearchStore;

public class PartySizeTestOld extends BaseClass{
	
	 
	   @BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowserb();
	   }
	   
	   @Test
	    public void reserveSpot() throws InterruptedException {
		     // Initialize the Page Object classes
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        HomePage homePage = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        SearchStore searchStore = new SearchStore(driver);
	        PartySizePage ps = new PartySizePage(driver);
		    JavascriptExecutor js= (JavascriptExecutor)driver;

	        loginPage.login();
	        homePage.getSkipNotification();
	        //Search bar
	      
	        
		    WebElement cancelAddress= driver.findElement(By.cssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']"));
		    cancelAddress.click();
		    Actions actions = new Actions(driver);
		    // Enter Location
		    Thread.sleep(2000);
		    driver.findElement(By.id("mui-2")).sendKeys("Mumbai Central");
		    Thread.sleep(3000);
		    //Select Mumbai central location from the list using keyboard actions
		    actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		    Thread.sleep(2000);
		    actions.sendKeys(Keys.ENTER).build().perform();
		    //Select your Mumbai central store
		    actions.sendKeys(Keys.TAB).build().perform();
		    Thread.sleep(1000);
		    actions.sendKeys(Keys.TAB).build().perform();
		    Thread.sleep(1000);
		    actions.sendKeys(Keys.TAB).build().perform();
		    Thread.sleep(2000);
		    actions.sendKeys(Keys.ENTER).build().perform();
		    Thread.sleep(2000);
		    //Zoom out
	        js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 75%
	        Thread.sleep(5000);
	        ps.selectPartySize(2);
	        Thread.sleep(4000);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    // dateSelectionPage.selectCurrentDate();
		    dateSelectionPage.selectFutureDate();
		    dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(10); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(7);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();
	        
	        //Cancel the saved spot
	        cancelSpot.cancelReservation();
	        Thread.sleep(2000);
	
		    
	   }
}

