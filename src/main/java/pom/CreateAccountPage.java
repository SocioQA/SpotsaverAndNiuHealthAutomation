package pom;

import java.time.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import utility.BaseClass;
import utility.JsonDataReader;

public class CreateAccountPage extends BaseClass {
	
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions action;
	
	public CreateAccountPage(WebDriver driver)
	{
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Updated constructor
        this.js = (JavascriptExecutor) driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
	
	// Main button- CREATE ACCOUNT
	@FindBy (xpath= "//*[@id='__next']/div/div[2]/div/form/div[3]/div[2]/button") 
	WebElement CreateAccount;
	@FindBy (xpath= "//*[@id='rgtrFullName']") 
	WebElement FullName;
	@FindBy (xpath= "//*[@id='rgtrEmail']") 
    WebElement emailId;
	@FindBy (xpath= "//*[@id='rgtrPassword']") 
	WebElement password;
	//After inputting all the details click on CREATE ACCOUNT button
	@FindBy (xpath= "//*[@id='mui-2']") 
	WebElement clickCreateAccount;

	
	//Full name is required field
	@FindBy (xpath= "//*[@id='rgtrFullName-helper-text']")
	WebElement fullNameRequired;
	//Email is required field
	@FindBy (xpath= "//*[@id='rgtrEmail-helper-text']")
	WebElement emailRequired;	
	//Password is required field
	@FindBy (xpath= "//*[@id='rgtrPassword-helper-text']")
	WebElement passwordRequired;
	
	//Email id is incorrect text
//	@FindBy (className= "MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained MuiFormHelperText-filled css-16bbdsf")
	@FindBy (xpath= "//*[@id='rgtrEmail-helper-text']")
	WebElement emailIsIncorrect;
	
	// Verify password format
	@FindBy (xpath= "//*[@id='rgtrPassword-helper-text']")
	WebElement passwordFormat;
	
	//Create account with existing email id
	@FindBy (xpath= "//p[@id='rgtrEmail-helper-text' and text()='The email has already been taken.']")
	WebElement emailTaken;
	
	
	//Method to create valid user account
    public void createValidAccount()  {
  	    JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
            String fullName = (String) jsonObject.get("FullName");
            String email = (String) jsonObject.get("newEmail");
            String passWord = (String) jsonObject.get("newPassword");
            
            CreateAccount.click();
            
	        wait.until(ExpectedConditions.visibilityOf(FullName));
            FullName.sendKeys(fullName);
            
	        wait.until(ExpectedConditions.visibilityOf(emailId));
            emailId.sendKeys(email);
            
	        wait.until(ExpectedConditions.visibilityOf(password));
	        password.sendKeys(passWord);
	        
	        wait.until(ExpectedConditions.visibilityOf(clickCreateAccount));
	        js.executeScript("arguments[0].click();", clickCreateAccount);

        } else {
            System.out.println("Failed to load JSON data.");
        }

	}
    
	//Method to create valid user account
    public void createAnotherValidAccount()  {
  	    JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
            String fullName = (String) jsonObject.get("FullName");
            String email = (String) jsonObject.get("newEmailId");
            String passWord = (String) jsonObject.get("newPassword");
            
            CreateAccount.click();
            
	        wait.until(ExpectedConditions.visibilityOf(FullName));
            FullName.sendKeys(fullName);
            
	        wait.until(ExpectedConditions.visibilityOf(emailId));
            emailId.sendKeys(email);
            
	        wait.until(ExpectedConditions.visibilityOf(password));
	        password.sendKeys(passWord);
	        
	        wait.until(ExpectedConditions.visibilityOf(clickCreateAccount));
	        js.executeScript("arguments[0].click();", clickCreateAccount);

        } else {
            System.out.println("Failed to load JSON data.");
        }

	}
    
    public void fullNameRequired(){
    	
    	CreateAccount.click();
        wait.until(ExpectedConditions.visibilityOf(FullName));
        FullName.sendKeys("Roy");
        action.sendKeys(Keys.BACK_SPACE)
        .sendKeys(Keys.BACK_SPACE)
        .sendKeys(Keys.BACK_SPACE).build().perform();       
        // Wait until the text is visible
        wait.until(ExpectedConditions.visibilityOf(fullNameRequired));
        // Get the text and verify
        String fullNameRequiredText = fullNameRequired.getText();
        Assert.assertEquals(fullNameRequiredText, "Full Name is required");
        System.out.println("Tested Successfully");
    }
    
    public void emailRequired(){
    	
    	CreateAccount.click();
        wait.until(ExpectedConditions.visibilityOf(emailId));
        emailId.sendKeys("r");
        action.sendKeys(Keys.BACK_SPACE).build().perform();    
        // Wait until the text is visible
        wait.until(ExpectedConditions.visibilityOf(emailRequired));
        // Get the text and verify
        String emailRequiredText = emailRequired.getText();
        Assert.assertEquals(emailRequiredText, "Email is required");
        System.out.println("Tested Successfully");
    }
    
    public void passwordRequired(){
    	
    	CreateAccount.click();
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("r");
        action.sendKeys(Keys.BACK_SPACE).build().perform();    
        // Wait until the text is visible
        wait.until(ExpectedConditions.visibilityOf(passwordRequired));
        // Get the text and verify
        String passwordRequiredText = passwordRequired.getText();
        Assert.assertEquals(passwordRequiredText, "Password is required");
        System.out.println("Tested Successfully");
    }
    
    public void emailIncorrect(){
    	
    	CreateAccount.click();
        wait.until(ExpectedConditions.visibilityOf(emailId));
        emailId.sendKeys("r");
        //action.sendKeys(Keys.BACK_SPACE).build().perform();    
        // Wait until the text is visible
        wait.until(ExpectedConditions.visibilityOf(emailIsIncorrect));
        // Get the text and verify
        String incorrectEmailText = emailIsIncorrect.getText();
        Assert.assertEquals(incorrectEmailText, "Email is Not Correct");
        System.out.println("Tested Successfully");
    }
    
    public void passWordFormat(){
    	
    	CreateAccount.click();
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("r");
        //action.sendKeys(Keys.BACK_SPACE).build().perform();    
        // Wait until the text is visible
        wait.until(ExpectedConditions.visibilityOf(passwordFormat));
        // Get the text and verify
        String passwordFormatText = passwordFormat.getText();
        Assert.assertEquals(passwordFormatText, "Required Minimum eight characters, at least one letter, one number and one special character");
        System.out.println("Tested Successfully");
    }

	//Method to verify user is not allowed to create the account with existing email id
    public void emailAlreadyTaken()  {
  	    JsonDataReader jsonDataReader = new JsonDataReader();
        JSONObject jsonObject = null; // Initialize jsonObject to null

        try {
            jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            // Extract data from JSON
            String fullName = (String) jsonObject.get("FullName");
            String email = (String) jsonObject.get("userName");
            String passWord = (String) jsonObject.get("newPassword");
            

            CreateAccount.click();
            
	        wait.until(ExpectedConditions.visibilityOf(FullName));
            FullName.sendKeys(fullName);
            
	        wait.until(ExpectedConditions.visibilityOf(emailId));
            emailId.sendKeys(email);
            
	        wait.until(ExpectedConditions.visibilityOf(password));
	        password.sendKeys(passWord);
	        
	        wait.until(ExpectedConditions.visibilityOf(clickCreateAccount));
	        js.executeScript("arguments[0].click();", clickCreateAccount);
	        
	        wait.until(ExpectedConditions.visibilityOf(emailTaken));
	        // Get the text and verify
	        String emailTakenText = emailTaken.getText();
	        Assert.assertEquals(emailTakenText, "The email has already been taken.");
	        System.out.println("User is unable to create an account with an existing account's email id");

        } else {
            System.out.println("Failed to load JSON data.");
        }

	}

}
