package pom;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pojo.Browser;
import utility.BaseClass;
import utility.JsonDataReader;
import java.time.Duration;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class LoginNewFBAndGoogle extends BaseClass{
	
	// WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
 // Store the main window handle before switching to the Google login window
 //  private  String mainWindowHandle;
    
	public LoginNewFBAndGoogle(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Updated constructor
        this.js = (JavascriptExecutor) driver;
        //mainWindowHandle = driver.getWindowHandle();  // Store the main window handle
        PageFactory.initElements(driver, this);
    }

	   // Locate the elements using PageFactory
		@FindBy (xpath= "//input[@id='lgnEmail']")  
		WebElement userName;
		@FindBy (xpath= "//input[@id='lgnPassword']") 
		WebElement passwordField;
		@FindBy (xpath= "/html/body/div[1]/div/div[2]/div/form/div[3]/div[1]") 
		WebElement signIn;
		@FindBy (xpath= "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-iol86l'])[2]")  
		WebElement createAccount;
		
		//Google button
		@FindBy (xpath= "//*[@id='__next']/div/div[2]/div/form/div[3]/div[3]/button") 
		WebElement signWithGoogle;
	    @FindBy(id = "identifierId")
	    WebElement googleEmail;
		@FindBy (xpath= "//*[@id='identifierNext']/div/button/span") 
		WebElement nextButton1;
	    @FindBy(xpath = "//*[@id='password']/div[1]/div/div[1]/input")
	    WebElement googlePassword;		
		@FindBy (xpath= "//*[@id='passwordNext']/div/button/span") 
		WebElement nextButton2;
	    @FindBy(xpath = "//*[@id='yDmH0d']/c-wiz/div/div[3]/div/div/div[2]/div/div/button")
	    WebElement googleContinueButton;
		

	
		// Method to log in using data from JSON
	    public void login()  {
	    	  JsonDataReader jsonDataReader = new JsonDataReader();
	          JSONObject jsonObject = null; // Initialize jsonObject to null

	          try {
	              jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
	          } catch (ParseException e) {
	              e.printStackTrace();
	          }

	          if (jsonObject != null) {
	              // Extract data from JSON
	              String username = (String) jsonObject.get("userName");
	              String password = (String) jsonObject.get("password");

	              userName.sendKeys(username);
	  	          passwordField.sendKeys(password);
	  	          signIn.click();

	          } else {
	              System.out.println("Failed to load JSON data.");
	          }
//	        JsonDataReader jsonDataReader = new JsonDataReader();
//	        JSONObject jsonObject;
//			try {
//				jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	        // Extract data from JSON
//	        String username = (String) jsonObject.get("userName");
//	        String password = (String) jsonObject.get("password");

	        // Use the extracted data to perform login
//              userName.sendKeys(username);
//  	          passwordField.sendKeys(password);
//  	          signIn.click();
	    }

	 // Method to switch to a new window (Google login)
	    public void switchToNewWindow() {
	        Set<String> windowHandles = driver.getWindowHandles();
	        for (String handle : windowHandles) {
	            if (!handle.equals(Browser.mainWindowHandle)) {  // Use the global mainWindowHandle from launchBrowser
	                try {
	                    driver.switchTo().window(handle);
	                    System.out.println("Switched to Google login window.");
	                } catch (NoSuchWindowException e) {
	                    System.out.println("Failed to switch to Google login window: " + e.getMessage());
	                }
	                break;
	            }
	        }
	    }
	    public void clickGoogleLoginButton() {
            wait.until(ExpectedConditions.visibilityOf(signWithGoogle)).click();

	    }
	    
	    // Method to log in using Google
	    public void loginUsingGoogle() {
	        JsonDataReader jsonDataReader = new JsonDataReader();
	        JSONObject jsonObject = null;

	        try {
	            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        if (jsonObject != null) {
	            String username = (String) jsonObject.get("GoogleId");
	            String password = (String) jsonObject.get("Googlepassword");

	            // Switch to the Google login window (new window)
	            switchToNewWindow();
	            System.out.println("Switched to new window.");

	            // Perform the login in the new window
	            wait.until(ExpectedConditions.visibilityOf(googleEmail)).sendKeys(username);
	            wait.until(ExpectedConditions.visibilityOf(nextButton1)).click();
	            wait.until(ExpectedConditions.visibilityOf(googlePassword)).sendKeys(password);
	            wait.until(ExpectedConditions.visibilityOf(nextButton2)).click();
	            wait.until(ExpectedConditions.visibilityOf(googleContinueButton)).click();

	           
	            // Close the Google login window
	            driver.close();
	            System.out.println("Google login window closed.");

	            // Switch back to the main window after login
	            switchToMainWindow();

	        } else {
	            System.out.println("Failed to load JSON data.");
	        }
	          
	    }
	 // Method to switch back to the main window after completing the Google login
	    public void switchToMainWindow() {
	        Set<String> windowHandles = driver.getWindowHandles();
	        // Verify if the main window is still open
	        if (windowHandles.contains(Browser.mainWindowHandle)) {
	            try {
	                driver.switchTo().window(Browser.mainWindowHandle);  // Switch back to main window using global variable
	                System.out.println("Switched back to main window.");
	            } catch (NoSuchWindowException e) {
	                System.out.println("Failed to switch back to main window: " + e.getMessage());
	            }
	        } else {
	            System.out.println("Main window is not available anymore.");
	        }
	    }
}	    
