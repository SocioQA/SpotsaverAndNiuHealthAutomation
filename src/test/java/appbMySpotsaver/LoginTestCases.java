package appbMySpotsaver;

import org.json.simple.parser.ParseException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pojo.Browser;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

@Listeners(utility.ListenersClass.class)
public class LoginTestCases extends BaseClass{
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
    public void TC_009() throws ParseException {
    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
    	HomePage hp = new HomePage(driver);
        loginPage.login();
        hp.getSkipNotification();
    }
    
    //Test case for invalid email login
    @Test
    public void TC_010() throws ParseException {
    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
    	HomePage hp = new HomePage(driver);
        loginPage.invalidEmailLogin();
        loginPage.verifyInvalidEmailLogin();
    }
    
    //Test case for invalid password login
    @Test
    public void TC_011() throws ParseException {
    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
    	HomePage hp = new HomePage(driver);
        loginPage.invalidPasswordLogin();
        loginPage.verifyInvalidPasswordLogin();
    }
    
	//Test case for blank login
    @Test
    public void TC_012() throws ParseException {
    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
    	HomePage hp = new HomePage(driver);
        loginPage.blankLogin();
    }
    
    //Test successful facebook login
//    @Test
//    public void TC_014() throws InterruptedException {
//    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
//    	HomePage hp = new HomePage(driver);
//
//        // Click on the Facebook login button
//        loginPage.clickFacebookLoginButton();
//
//        // Switch to the new Facebook login window
//        loginPage.switchToNewWindow();
//        
//        // Enter credentials and login with facebook
//        loginPage.loginUsingFacebook();
//        
//        Thread.sleep(5000);
//        hp.getSkipNotification();
//
//    }
    
    // Test successful google login
//    @Test
//    public void TC_015() throws InterruptedException {
//    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
//    	HomePage hp = new HomePage(driver);
//
//        // Click on the google login button
//        loginPage.clickGoogleLoginButton();
//
//        // Switch to the new google login window
//        loginPage.switchToNewWindow();
//        
//        // Enter credentials and login with google
//        loginPage.loginUsingGoogle();
//        
//       // Thread.sleep(6000);
//        //hp.getSkipNotification();
//
//    }
    
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
