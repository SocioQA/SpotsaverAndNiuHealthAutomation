package appbMySpotsaver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
import utility.ListenersClass;


@Listeners(utility.ListenersClass.class)

public class TestUsingReports extends BaseClass {
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
    	//String sspath= Screenshot.screenshotMethod(driver,"getMethodName");
    	test= reports.createTest("TC_009");
    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
    	HomePage hp = new HomePage(driver);
        loginPage.login();
        hp.getSkipNotification();
    }
    
    @Test
    public void TC_010() throws ParseException {
    	test= reports.createTest("TC_010");
    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
    	HomePage hp = new HomePage(driver);
        loginPage.invalidEmailLogin();
        loginPage.verifyInvalidEmailLogin();
        //hp.getSkipNotification();
    }
    
    @Test
    public void TC_011() throws ParseException {
    	test= reports.createTest("TC_011");
    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
    	HomePage hp = new HomePage(driver);
        loginPage.invalidPasswordLogin();
        loginPage.verifyInvalidPasswordLogin();
        //hp.getSkipNotification();
    }
    
    @AfterMethod
    public void publishReports(ITestResult results)
    {
        String screenshotPath = Screenshot.screenshotMethod(driver, results.getMethod().getMethodName());  // Capture screenshot after each test

    	if(results.getStatus()== ITestResult.SUCCESS)
    	{
    		test.log(Status.PASS, "<b><i>" +results.getName() +"<b><i>");
            test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot for passed test to the report

    	}
    	else if(results.getStatus()== ITestResult.FAILURE)
    	{
    		test.log(Status.FAIL, "<b><i>" +results.getName() +"<b><i>");
            test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot for passed test to the report

    	}
    	else
    	{
    		test.log(Status.SKIP, "<b><i>" +results.getName() +"<b><i>");
            test.addScreenCaptureFromPath(screenshotPath);  // Add screenshot for passed test to the report

    	}
    }
    
    @AfterTest
    public void createReportAfterTest()
    {
    	reports.flush();
    }
    
//    @AfterClass
//    public void closeAllWindows()
//    {
//    	driver.close();
//    }
	

}
