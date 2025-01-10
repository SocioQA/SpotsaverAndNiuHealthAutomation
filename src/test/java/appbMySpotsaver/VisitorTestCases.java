package appbMySpotsaver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.PartySizePage;
import pom.ReserveASpotButton;
import pom.SaveSpotButton;
import pom.SearchStore;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class VisitorTestCases extends BaseClass{
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports()
	{
	    // Get the current class name
	    String className = this.getClass().getSimpleName(); 
		reports= Reports.createReport("C:\\Users\\91738\\eclipse-workspace\\Spotsaver\\src\\test\\resources\\TestReports\\" + className +".html");
		
	}
	
	@BeforeMethod
	public void launchChrome() {
		   driver = Browser.launchBrowserb();
	}
	
	//Save Current Spot
	   @Test
	    public void TC_020() throws InterruptedException {
		     // Initialize the Page Object classes
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        HomePage hp = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        SearchStore searchStore = new SearchStore(driver);
	        PartySizePage ps = new PartySizePage(driver);
	        SaveSpotButton saveSpot = new SaveSpotButton(driver);

	        loginPage.login();
	        hp.getSkipNotification();
	        //Search bar
	        searchStore.clickCancelAddress();
	        searchStore.enterStoreText();
	        //searchStore.enterStoreLocation(); //pune location
	        
	        //Zoom out
	        //storeSelectionPage.zoomOutScreen();
	        searchStore.selectYourStore(0);
	        Thread.sleep(4000);
//	        //Zoom out
	        storeSelectionPage.zoomOutScreen();
	        ps.selectPartySize(2);
	        Thread.sleep(4000);
	        saveSpot.saveSpotNew();
//	        saveSpot.verifySavedSpot();
//	        cancelSpot.cancelReservation();  
	        
	   }
	   
	   //Save Future Spot
	   @Test
	    public void TC_021() throws InterruptedException {
		     // Initialize the Page Object classes
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        HomePage hp = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        SearchStore searchStore = new SearchStore(driver);
	        PartySizePage ps = new PartySizePage(driver);

	        loginPage.login();
	        hp.getSkipNotification();
	        //Search bar
	        searchStore.clickCancelAddress();
	        searchStore.enterStoreText();
	        //searchStore.enterStoreLocation(); //pune location
	        
//	        //Zoom out
//	        storeSelectionPage.zoomOutScreen();
	        searchStore.selectYourStore(0);
	        //Zoom out
	        storeSelectionPage.zoomOutScreen();
	        ps.selectPartySize(2);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    dateSelectionPage.selectFutureDate();
		    dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(10); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(3);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();
	        
	        //Cancel the saved spot
	        cancelSpot.cancelReservation();
	        
	        //Verify spot is canceled
	        cancelSpot.verifyCancellation();			    
	   }
	   
	   //Verify date
	   @Test
	    public void TC_021_1() throws InterruptedException {
		     // Initialize the Page Object classes
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	        // LoginPage loginPage = new LoginPage(driver);
	        HomePage homePage = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        ReserveASpotButton reserveASpot = new ReserveASpotButton(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        PartySizePage ps = new PartySizePage(driver);
	        loginPage.login();
	        homePage.getSkipNotification();

	        // Perform store selection
	        storeSelectionPage.selectStore();
	       // Thread.sleep(4000); // Wait for the store selection to process
	        storeSelectionPage.zoomOutScreen();
	        
	        //Select party size
	       // ps.selectPartySize(2);

	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        

	        // Select date
	       // dateSelectionPage.selectCurrentDate();
	        dateSelectionPage.selectFutureDate();
	       // dateSelectionPage.zoomOutScreen();
	        dateSelectionPage.scrollUpToViewDropdown();
	        Thread.sleep(2000);
	        dateSelectionPage.fetchSelectedDate();
	   }
	   
	   //Cancel saved spot
	    @Test
	    public void TC_021_5() throws InterruptedException {
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	    	HomePage hp = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        PartySizePage partySize = new PartySizePage(driver);
	        SaveSpotButton saveSpot = new SaveSpotButton(driver);
	        loginPage.login();
	        hp.getSkipNotification();
	        // Perform store selection
	        storeSelectionPage.selectStore();
	        hp.zoomOutScreen();
	        //partySize.selectPartySize(2);
	        saveSpot.saveSpot();
	        saveSpot.verifySavedSpot();
	        cancelSpot.cancelReservation();   
	    }
	    
	    //Verify cancel spot
	    @Test
	    public void TC_021_6() throws InterruptedException {
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	    	HomePage hp = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        CancelReservation  cancelSpot = new CancelReservation(driver);
	        PartySizePage partySize = new PartySizePage(driver);
	        SaveSpotButton saveSpot = new SaveSpotButton(driver);
	        loginPage.login();
	        hp.getSkipNotification();
	        // Perform store selection
	        storeSelectionPage.selectStore();
	        hp.zoomOutScreen();
	        //partySize.selectPartySize(2);
	        saveSpot.saveSpot();
	        saveSpot.verifySavedSpot();
	        cancelSpot.notCancelReservation();
	        cancelSpot.verifySavedSpot();
	    }
	    
	    @AfterMethod
	    public void publishReports(ITestResult results)
	    {
//	        // Dynamically pass method name to createTest method
	        String methodName = results.getMethod().getMethodName();
	        test = reports.createTest(methodName);
	        String screenshotPath = Screenshot.screenshotMethod(driver, results.getMethod().getMethodName());  // Capture screenshot after each test

	    	if(results.getStatus()== ITestResult.SUCCESS)
	    	{
	    		//test.log(Status.PASS, "<b><i>" +results.getName() +"<b><i>");
	            test.log(Status.PASS, "Test Passed: " + methodName);
	            test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot for passed test to the report

	    	}
	    	else if(results.getStatus()== ITestResult.FAILURE)
	    	{
	    		//test.log(Status.FAIL, "<b><i>" +results.getName() +"<b><i>");
	            test.log(Status.FAIL, "Test Failed: " + methodName);
	            test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot for passed test to the report

	    	}
	    	else
	    	{
	    		//test.log(Status.SKIP, "<b><i>" +results.getName() +"<b><i>");
	            test.log(Status.SKIP, "Test Skipped: " + methodName);
	            test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot for passed test to the report

	    	}
	    }
	    
	    @AfterTest
	    public void createReportAfterTest()
	    {
	    	reports.flush();
	    }

}
