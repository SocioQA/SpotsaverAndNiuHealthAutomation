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
import pom.SearchStore;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class TC_093 extends BaseClass{
	
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
		   driver = Browser.launchBrowser();
	   }
	   
	   @Test
	    public void save1stSpot() throws InterruptedException {
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
	        //Enter address
	        searchStore.enterStoreText();
	        //Select store
	        searchStore.selectYourStore(0);
	        //Select party size
	        ps.selectPartySize(2);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    dateSelectionPage.selectFutureDate();
		    dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();
	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(9); // Index is 0-based	       
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(7);	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();		    
	   }
	   
	   @Test(dependsOnMethods = "save1stSpot")
	    public void save2ndSpot() throws InterruptedException {
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
	        //Enter address
	        searchStore.enterStoreText();
	        //Select store
	        searchStore.selectYourStore(0);
	        //Select party size
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
	        	    
	   }
	   
	   @Test(dependsOnMethods = "save2ndSpot")
	    public void save3rdSpot() throws InterruptedException {
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
	        //Enter address
	        searchStore.enterStoreText();
	        //Select store
	        searchStore.selectYourStore(0);
	        //Select party size
	        ps.selectPartySize(2);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    dateSelectionPage.selectFutureDate();
		    dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(9); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(3);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();		    
	   }
	   
	   @Test(dependsOnMethods = "save3rdSpot")
	   public void save4thSpot() throws InterruptedException {
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
	        searchStore.selectYourStore(0);
	        Thread.sleep(2000);	       
	        ps.selectPartySize(2);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    dateSelectionPage.selectFutureDate();
		    dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(8); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(1);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();	    
	   }
	   
	   @Test(dependsOnMethods = "save4thSpot")
	    public void save5thSpot() throws InterruptedException {
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
	        searchStore.selectYourStore(0);
	        Thread.sleep(2000);	        
	        ps.selectPartySize(2);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    dateSelectionPage.selectFutureDate();
		    dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(8); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(5);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();	    
	   }
	   
	   @Test(dependsOnMethods = "save5thSpot")
	    public void save6thSpot() throws InterruptedException {
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
	        searchStore.selectYourStore(0);
	        ps.selectPartySize(2);
	        // Scroll to the first date button
	        storeSelectionPage.scrollToFirstDateButton();
	        // Select date
		    dateSelectionPage.selectFutureDate();
		    dateSelectionPage.scrollUpToViewDropdown();
	        // Select the PM time
	        timeSelectionPage.clickOnPm();

	        // Select a specific PM hour (e.g., 9 PM)
	        timeSelectionPage.selectHour(7); // Index is 0-based
	        
	        // Select minutes from the list
	        timeSelectionPage.selectMinutes(9);
	        
	        //Click on reserve a spot button
	        reserveASpot.clickReserveASpotButton();	    
	        
	        //Verify max active spots error message is displayed.
	        reserveASpot.verifyMaxActiveSpotErrorMsg();			    
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
