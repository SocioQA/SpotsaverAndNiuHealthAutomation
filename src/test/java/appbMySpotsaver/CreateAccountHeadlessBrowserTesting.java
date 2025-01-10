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
import pom.CreateAccountPage;
import pom.HomePage;
import utility.BaseClass;
import utility.Reports;
import utility.Screenshot;

public class CreateAccountHeadlessBrowserTesting extends BaseClass{
	
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
		   driver = Browser.launchHeadlessBrowserb();
	}
	
	// Test user is able to create an account successfully with valid credentials
    @Test
    public void TC_001(){
    	
    	CreateAccountPage cA = new CreateAccountPage(driver);
    	HomePage hp = new HomePage(driver);
    	cA.createValidAccount();
    	hp.getSkipNotification();
    	
    }
	
	//Verify full name is required
    @Test
    public void TC_002_1(){
    	
    	CreateAccountPage cA = new CreateAccountPage(driver);
    	HomePage hp = new HomePage(driver);
    	cA.fullNameRequired();  	
    }
    
	//Verify email id is required    
    @Test
    public void TC_002_2(){
    	
    	CreateAccountPage cA = new CreateAccountPage(driver);
    	HomePage hp = new HomePage(driver);
    	cA.emailRequired(); 	
    }
    
	//Verify password is required    
    @Test
    public void TC_002_3(){
    	
    	CreateAccountPage cA = new CreateAccountPage(driver);
    	HomePage hp = new HomePage(driver);
    	cA.passwordRequired();
    }
   
	//Verify email id is incorrect
    @Test
    public void TC_003(){
 	
 	CreateAccountPage cA = new CreateAccountPage(driver);
 	HomePage hp = new HomePage(driver);
 	cA.emailIncorrect();	
    }
    
	//Verify incorrect password format text is displayed
    @Test
       public void TC_004(){
 	
 	  CreateAccountPage cA = new CreateAccountPage(driver);
 	  HomePage hp = new HomePage(driver);
 	  cA.passWordFormat();
      }
	
	// Test user is unable to create account with an existing email id
    @Test
    public void TC_005(){
 	
 	CreateAccountPage cA = new CreateAccountPage(driver);
 	HomePage hp = new HomePage(driver);
 	cA.emailAlreadyTaken();
 	
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
