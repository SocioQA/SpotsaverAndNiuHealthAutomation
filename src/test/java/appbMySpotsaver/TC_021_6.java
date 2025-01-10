package appbMySpotsaver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
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
import pom.SaveSpotButton;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class TC_021_6 extends BaseClass{
	//Verify the saved spot is not canceled.


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

	@Test
	public void cancelSavedSpot() throws InterruptedException {
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
