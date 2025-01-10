package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.JsonDataReader;
import org.json.simple.JSONObject;

public class LoginPage {
	

    // Locate the elements using PageFactory
	@FindBy (xpath= "//input[@id='lgnEmail']") 
	public WebElement userName;
	@FindBy (xpath= "//input[@id='lgnPassword']") 
	public WebElement password;
	@FindBy (xpath= "/html/body/div[1]/div/div[2]/div/form/div[3]/div[1]") 
	public WebElement signIn;
	@FindBy (xpath= "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-iol86l'])[2]") 
	public WebElement createAccount;
	@FindBy (xpath= "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-15j76c0']") 
	public WebElement signWithGoogle;
	@FindBy (xpath= "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-15j76c0'])[2]") 
	public WebElement signInWithFacebook;
	@FindBy (xpath= "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-15j76c0'])[4]") 
	public WebElement forgotPassword;
	@FindBy (xpath= "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-15j76c0'])[5]") 
	public WebElement googleApple;

	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String name)
	{
		userName.sendKeys(name);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickSignInButton()
	{
		signIn.click();
	}
	
	public void createAccountButton()
	{
		createAccount.click();
	}

	public void forgotPasswordMethod()
	{
		forgotPassword.click();
	}
	

}
