package pom;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.BaseClass;
import utility.JsonDataReader;
import java.time.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class LoginSampleUsingJsonData extends BaseClass{
	
	// WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    String mainWindowHandle;

    
	public LoginSampleUsingJsonData(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Updated constructor
        this.js = (JavascriptExecutor) driver;
        mainWindowHandle = driver.getWindowHandle();  // Store the main window handle
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
		
		
		//Facebook button
		@FindBy (xpath= "//*[@id='__next']/div/div[2]/div/form/div[3]/div[4]/div/button")  
		WebElement signInWithFacebook;
	    // Facebook login window elements
	    @FindBy(id = "email")
	    WebElement fbEmail;
	    @FindBy(id = "pass")
	    WebElement fbPassword;
	    @FindBy(xpath = "//input[@value='Log in' and @name='login']")
	    WebElement fbLoginButton;
	    @FindBy(xpath = "//div[@class='x1n2onr6 x1ja2u2z x78zum5 x2lah0s xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xn6708d x1ye3gou xtvsq51 x1r1pt67']")
	    WebElement fbContinueButton;	    
		@FindBy (xpath= "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-15j76c0'])[4]")  
		WebElement forgotPassword;

		
		//Invalid email id text 
		@FindBy (xpath= "//p[@id='lgnPassword-helper-text']")
		WebElement invalidEmailIdText;		
		//Invalid password login test
		@FindBy (xpath= "//p[@id='lgnPassword-helper-text']")
		WebElement invalidPasswordText;
		//Disabled Sign in button
		@FindBy (xpath= "//button[@class='MuiButtonBase-root MuiButton-root MuiLoadingButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth Mui-disabled MuiButton-root MuiLoadingButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth css-wom08h']")
		WebElement disabledSignInBtn;
		
		
		
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
	    }
		  // Method to log in using invalid email id data from JSON
	    public void invalidEmailLogin()  {
	    	  JsonDataReader jsonDataReader = new JsonDataReader();
	          JSONObject jsonObject = null; // Initialize jsonObject to null

	          try {
	              jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
	          } catch (ParseException e) {
	              e.printStackTrace();
	          }

	          if (jsonObject != null) {
	              // Extract data from JSON
	              String username = (String) jsonObject.get("invalidEmailId");
	              String password = (String) jsonObject.get("password");

	              userName.sendKeys(username);
	  	          passwordField.sendKeys(password);
	  	          signIn.click();

	          } else {
	              System.out.println("Failed to load JSON data.");
	          }
	
	    }
	    
	    //Verify invalid email id text appears while logging in
	    public void verifyInvalidEmailLogin() {
	        // Wait until the text is visible
	        wait.until(ExpectedConditions.visibilityOf(invalidEmailIdText));
	        
	        // Get the text and verify it matches "canceled"
	        String invalidEmailText = invalidEmailIdText.getText();
	        Assert.assertEquals(invalidEmailText, "The selected email is invalid.");
	        System.out.println("User is unable to login with invalid email id");
	    }
	    
		  // Method to log in using invalid password data from JSON
	    public void invalidPasswordLogin()  {
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
	              String password = (String) jsonObject.get("invalidPassword");

	              userName.sendKeys(username);
	  	          passwordField.sendKeys(password);
	  	          signIn.click();

	          } else {
	              System.out.println("Failed to load JSON data.");
	          }
	
	    }
	    
	    //Verify invalid email id text appears while logging in
	    public void verifyInvalidPasswordLogin() {
	        // Wait until the text is visible
	        wait.until(ExpectedConditions.visibilityOf(invalidPasswordText));
	        
	        // Get the text and verify it matches "canceled"
	        String invalidPasswordMsg = invalidPasswordText.getText();
	        Assert.assertEquals(invalidPasswordMsg, "You tried to access an invalid resource or you dont have permission.");
	        System.out.println("User is unable to login with invalid password");
	    }
	    
		// Method to log in using data from JSON
	    public void blankLogin()  {
	        // Wait until the text is visible
	        wait.until(ExpectedConditions.visibilityOf(disabledSignInBtn));
	        
	        // Get the text and verify it matches "canceled"
	        String disabledId = disabledSignInBtn.getText();
	        Assert.assertEquals(disabledId, "SIGN IN");
	        System.out.println("User is unable to login with empty fields and Sign In button remains disabled");	    	
}
	    
	    //Facebook login Process
	    // Method to click the Facebook login button
	    public void clickFacebookLoginButton() {
	    	signInWithFacebook.click();
	    }
	    // Method to switch to the new Facebook login window
	    public void switchToNewWindow() {
	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(mainWindowHandle)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	    }
	    // Method to log in using Facebook
	    public void loginUsingFacebook() {
	    	  JsonDataReader jsonDataReader = new JsonDataReader();
	          JSONObject jsonObject = null; // Initialize jsonObject to null

	          try {
	              jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
	          } catch (ParseException e) {
	              e.printStackTrace();
	          }

	          if (jsonObject != null) {
	              // Extract data from JSON
	              String username = (String) jsonObject.get("facebookId");
	              String password = (String) jsonObject.get("facebookpassword");

	              fbEmail.sendKeys(username);
	              fbPassword.sendKeys(password);
	              fbLoginButton.click();
	              // Click the continue button
	              wait.until(ExpectedConditions.visibilityOf(fbContinueButton)).click();
	              driver.switchTo().window(mainWindowHandle);

	          } else {
	              System.out.println("Failed to load JSON data.");
	          }
	          
	    }
	    
	    public void clickGoogleLoginButton() {
            wait.until(ExpectedConditions.visibilityOf(signWithGoogle)).click();

	    	//signWithGoogle.click();
	    }
	    
	    // Method to log in using Google
	    public void loginUsingGoogle() {
	    	  JsonDataReader jsonDataReader = new JsonDataReader();
	          JSONObject jsonObject = null; // Initialize jsonObject to null

	          try {
	              jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
	          } catch (ParseException e) {
	              e.printStackTrace();
	          }

	          if (jsonObject != null) {
	              // Extract data from JSON
	              String username = (String) jsonObject.get("GoogleId");
	              String password = (String) jsonObject.get("Googlepassword");

	              wait.until(ExpectedConditions.visibilityOf(googleEmail)).sendKeys(username);
	              //googleEmail.sendKeys(username);
	              wait.until(ExpectedConditions.visibilityOf(nextButton1)).click();
	              wait.until(ExpectedConditions.visibilityOf(googlePassword)).sendKeys(password);
	             // googlePassword.sendKeys(password);
	              wait.until(ExpectedConditions.visibilityOf(nextButton2)).click();
	              // Click the continue button
	              wait.until(ExpectedConditions.visibilityOf(googleContinueButton)).click();
	              driver.switchTo().window(mainWindowHandle);

	          } else {
	              System.out.println("Failed to load JSON data.");
	          }
	          
	    }
}	    
