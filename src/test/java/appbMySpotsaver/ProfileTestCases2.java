package appbMySpotsaver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import pom.CreateAccountPage;
import pom.HomePage;
import pom.ProfilePage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class ProfileTestCases2  extends BaseClass{

	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports()
	{
	    // Get the current class name
	    String className = this.getClass().getSimpleName(); 
		LocalDateTime dateTime= LocalDateTime.now();
		DateTimeFormatter time= DateTimeFormatter.ofPattern("DD-MM-YY HH_MM_SS");
		String dt= dateTime.format(time);
		reports= Reports.createReport("C:\\Users\\91738\\eclipse-workspace\\Spotsaver\\src\\test\\resources\\TestReports\\" + className + "_" + dt +".html");
		
	}
	@BeforeMethod
	public void launchChrome() {
		driver = Browser.launchBrowser();
	}
	
	@Test
	public void accountDeletedSuccessfully() throws InterruptedException{
		CreateAccountPage cA = new CreateAccountPage(driver);
		HomePage homePage = new HomePage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		//First create a new account
		cA.createAnotherValidAccount();
		homePage.getSkipNotification();
		profilePage.profileSection();
		//Thread.sleep(2000);
		profilePage.deleteAccountSuccessfully();
	}
	
	@Test
	public void notDeleteAccount() throws InterruptedException {
		CreateAccountPage cA = new CreateAccountPage(driver);
		HomePage homePage = new HomePage(driver);
		ProfilePage profilePage = new ProfilePage(driver);
		//First create a new account
		cA.createAnotherValidAccount();
		homePage.getSkipNotification();
		profilePage.profileSection();
		//Thread.sleep(2000);
		profilePage.notDeleteAccount();
		profilePage.deleteAccountSuccessfully();

	}
	
    @AfterMethod
    public void publishReports(ITestResult results)
    {
//        // Dynamically pass method name to createTest method
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
