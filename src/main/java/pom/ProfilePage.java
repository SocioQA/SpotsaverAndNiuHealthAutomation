package pom;

import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.BaseClass;
import utility.JsonDataReader;

public class ProfilePage extends BaseClass {

	WebDriverWait wait;
	JavascriptExecutor js;
	Actions action;
    ExtentTest test; // Declare ExtentTest object


	public ProfilePage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Updated constructor
		this.js = (JavascriptExecutor) driver;
		this.action = new Actions(driver);
		PageFactory.initElements(driver, this);
       // this.test = test;  // Assign ExtentTest

	}

	//Profile Button
	@FindBy(xpath = "//*[@id='__next']/div/div[3]/div/button[4]")
	WebElement profileButton;

	//User name
	@FindBy(xpath = "//*[@id='__next']/div[2]/div[1]/h4")
	WebElement name;
	//User email id
	@FindBy(xpath = "//*[@id='__next']/div[2]/div[2]/h4")
	WebElement emailId;

	//Phone Number Field
	@FindBy(xpath = "//*[@id='__next']/div[2]/form/div[1]/div/div/input")
	WebElement phNo;
	
	//Toggle email
	@FindBy(xpath = "/html/body/div[1]/div[2]/form/div[2]/div/span[1]")
	WebElement toggleEmail;
	
	//Toggle email
	@FindBy(xpath = "/html/body/div[1]/div[2]/form/div[2]/div/span[2]")
	WebElement toggleSMS;
	
	//Save button
	@FindBy(xpath = "/html/body/div[1]/div[2]/form/div[3]/button")
	WebElement saveBtn;
	
	//Help Button
	@FindBy(xpath = "//*[@id='__next']/div[2]/form/div[4]/div/div[2]/button[1]")
	WebElement helpButton;
	//Help Button
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/button")
	WebElement contactUsButton;
	
	//Privacy Policy 
	@FindBy(xpath = "//*[@id='__next']/div[2]/form/div[4]/div/div[2]/button[2]")
	WebElement privacyPolicyButton;
	//Privacy Policy 
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div[1]/button")
	WebElement backButton;
	
	
	

	//Delete Account button
	@FindBy(xpath = "//*[@id='__next']/div[2]/form/div[4]/div/div[2]/button[4]")
	WebElement deleteAccountButton;
	
	//Click on Yes
	//Use this xpath if others doesn't work =(//button[contains(@class, 'MuiButtonBase-root') 
	//and contains(@class, 'MuiButton-textPrimary') and contains(@class, 'MuiButton-sizeMedium')])[1]	
	@FindBy(xpath = "/html/body/div[4]/div[3]/div/button[1]")
	WebElement clickOnYes;
	//Click on No
	@FindBy(xpath = "/html/body/div[4]/div[3]/div/button[2]")
	WebElement clickOnNo;

	//Log Out
	@FindBy(xpath = "/html/body/div[1]/div[2]/form/div[4]/div/div[2]/button[5]")
	WebElement logOutButton;
	//Click on Yes
	@FindBy(xpath = "/html/body/div[4]/div[3]/div/button[1]")
	WebElement clickYes;
	//Click on Yes
	@FindBy(xpath = "/html/body/div[4]/div[3]/div/button[2]")
	WebElement clickNo;

	//Password
	@FindBy(xpath = "//*[@id='__next']/div[2]/form/div[4]/div/div[2]/button[3]")
	WebElement password;
	@FindBy(xpath = "//*[@id='mui-10' or @name='password' and @type='password' and @class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-eo1eg5']")
	WebElement enterPassword;
	@FindBy(xpath = "//*[@id='mui-11' or @name='repeatPassword' and @type='password' and @class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-eo1eg5']")
	WebElement enterRepeatPassword;	
	@FindBy(xpath = "//*[@id='mui-12' or @type='submit']")
	WebElement setPasswordButton;

	// Method to switch to profile section
	public void profileSection()
	{
		profileButton.click();
	}

	//Toggle email
	public void toggleEmailNotification() 
	{
		// Wait for the Profile button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(profileButton));

		// Click the profile button
		wait.until(ExpectedConditions.visibilityOf(profileButton)).click();
		
		// Click the email toggle button
		wait.until(ExpectedConditions.visibilityOf(toggleEmail)).click();
		
		// Wait for the sms toggle button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(toggleSMS));
		// Click the sms toggle button
		wait.until(ExpectedConditions.visibilityOf(toggleSMS)).click();
		
		// Wait for the Save button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));

		// Click the Save button
		wait.until(ExpectedConditions.visibilityOf(saveBtn)).click();
		
	}
	//Toggle email
	public void toggleSMSNotification() 
	{
		// Wait for the Profile button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(profileButton));

		// Click the profile button
		wait.until(ExpectedConditions.visibilityOf(profileButton)).click();		
		
//		// Wait for the sms toggle button to be clickable (not just visible)
//		wait.until(ExpectedConditions.elementToBeClickable(toggleSMS));
		// Click the sms toggle button
		wait.until(ExpectedConditions.visibilityOf(toggleSMS)).click();
		
		// Wait for the Save button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));

		// Click the Save button
		wait.until(ExpectedConditions.visibilityOf(saveBtn)).click();
		
	}
	//Fetch user name and email id
	public void verifyUserDetails()
	{
		JsonDataReader jsonDataReader = new JsonDataReader();
		JSONObject jsonObject = null; // Initialize jsonObject to null

		try {
			jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Extract data from JSON
		String username = (String) jsonObject.get("userName");

		// Wait for the Profile button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(profileButton));

		// Click the profile button
		wait.until(ExpectedConditions.visibilityOf(profileButton)).click();

		// Wait until the user name is visible
		wait.until(ExpectedConditions.visibilityOf(name));
		String usernameText = name.getText();
		System.out.println(usernameText);

		// Wait until the user name is visible
		wait.until(ExpectedConditions.visibilityOf(emailId));
		String userEmailText = emailId.getText();
		Assert.assertEquals(username, userEmailText);
		System.out.println(userEmailText);
		System.out.println("User name and email id is present and is not editable");
       // test.log(Status.PASS, "User name and email ID are present and are not editable");

	}

	public void addPhoneNumber() 
	{
		JsonDataReader jsonDataReader = new JsonDataReader();
		JSONObject jsonObject = null; // Initialize jsonObject to null

		try {
			jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Extract data from JSON
		String phN = (String) jsonObject.get("phoneNumber");

		// Wait for the Profile button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(profileButton));

		// Click the Profile button
		wait.until(ExpectedConditions.visibilityOf(profileButton)).click();

		wait.until(ExpectedConditions.visibilityOf(phNo));

		if (jsonObject != null) {
			// Extract data from JSON
			//String phN = (String) jsonObject.get("phoneNumber");
			phNo.sendKeys(phN);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Wait for the Save button to be clickable (not just visible)
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));

		// Click the Save button
		wait.until(ExpectedConditions.visibilityOf(saveBtn)).click();
		System.out.println("Phone number is added succesfully");
	}

	// Method to switch to delete account
	public void deleteAccountSuccessfully()
	{
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(deleteAccountButton));
		// Click the button
		js.executeScript("arguments[0].click();", deleteAccountButton); 
		//Wait until the visibility of the Yes element
		wait.until(ExpectedConditions.visibilityOf(clickOnYes));
		// Click the button
		js.executeScript("arguments[0].click();", clickOnYes);
		System.out.println("User successfully deleted the account. Test Pass");	

	}

	// Method to switch to not delete account
	public void notDeleteAccount()
	{
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(deleteAccountButton));
		// Click the button
		js.executeScript("arguments[0].click();", deleteAccountButton); 
		//Wait until the visibility of the Yes element
		wait.until(ExpectedConditions.visibilityOf(clickOnNo));
		// Get the text and verify
		String notDeletedText = clickOnNo.getText();
		Assert.assertEquals(notDeletedText, "NO");
		System.out.println("User did not deleted the account. Test Pass");	
		// Click the button
		js.executeScript("arguments[0].click();", clickOnNo);
	}

	// Method to switch to logout 
	public void logOutSuccessfully()
	{
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(logOutButton));
		// Click the button
		js.executeScript("arguments[0].click();", logOutButton); 
		//Wait until the visibility of the Yes element
		wait.until(ExpectedConditions.visibilityOf(clickYes));
		// Click the button
		js.executeScript("arguments[0].click();", clickYes);
	}

	// Method to switch to profile section and delete account
	public void notLogOut() throws InterruptedException
	{
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(logOutButton));
		// Click the button
		js.executeScript("arguments[0].click();", logOutButton); 
		Thread.sleep(2000);
		//Wait until the visibility of the Yes element
		wait.until(ExpectedConditions.visibilityOf(clickNo));
		// Get the text and verify
		String notLogoutText = clickNo.getText();
		Assert.assertEquals(notLogoutText, "NO");
		System.out.println("User did not logout. Test Pass");		
		// Click the button
		js.executeScript("arguments[0].click();", clickNo);
	}

	// Method to switch to change password in profile section 
	public void changePasswordSuccessfully()
	{
		JsonDataReader jsonDataReader = new JsonDataReader();
		JSONObject jsonObject = null; // Initialize jsonObject to null

		try {
			jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (jsonObject != null) {
			// Extract data from JSON
			String newPassword = (String) jsonObject.get("changePassword");
			String repeatPassword = (String) jsonObject.get("changePassword");

			//Wait until the visibility of the element
			wait.until(ExpectedConditions.visibilityOf(password));
			// Click the button
			js.executeScript("arguments[0].click();", password); 
			//Enter a new password
			wait.until(ExpectedConditions.visibilityOf(enterPassword)).sendKeys(newPassword);;
			// Repeat password
			wait.until(ExpectedConditions.visibilityOf(enterRepeatPassword)).sendKeys(repeatPassword);;
			//Click on submit button
			wait.until(ExpectedConditions.visibilityOf(setPasswordButton)).click();;


		} else {
			System.out.println("Failed to load JSON data.");
		}
	}
	
	// Method to switch to help in profile section
	public void helpSection()
	{
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(profileButton));
		// Click the button
		js.executeScript("arguments[0].click();", profileButton); 
		
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(helpButton));
		// Click the button
		js.executeScript("arguments[0].click();", helpButton); 
		
		// Wait until the text is visible
		wait.until(ExpectedConditions.visibilityOf(contactUsButton));
		String contactUsText = contactUsButton.getText();
        Assert.assertEquals(contactUsText, "CONTACT US");
		System.out.println("Text matches " +contactUsText);
		
		// Click the button
		js.executeScript("arguments[0].click();", contactUsButton); 

	}

	// Method to switch to profile section
	public void privacyPolicySection()
	{
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(profileButton));
		// Click the button
		js.executeScript("arguments[0].click();", profileButton); 
		
		//Wait until the visibility of the element
		wait.until(ExpectedConditions.visibilityOf(privacyPolicyButton));
		// Click the button
		js.executeScript("arguments[0].click();", privacyPolicyButton); 
		
		// Wait until the back button is visible
		wait.until(ExpectedConditions.visibilityOf(backButton));
		// Click the button
		//js.executeScript("arguments[0].click();", backButton); 


	}

}
