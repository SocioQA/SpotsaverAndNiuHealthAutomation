package test1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class NIUSocial {
	
	
	
	    @Test
	    public void Log() throws InterruptedException {
	    
			WebDriverManager.chromedriver().setup();

	        // Create a new instance of the Chrome driver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the website
	        driver.get("https://appb.niusocial.online/signin");
	    
	        driver.manage().window().maximize();
	        Thread.sleep(3000);
	    
	        // Enter the username and password in the login form
	        
	     WebElement usernameField = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd css-b52kj1'])[1]"));
	     usernameField.sendKeys("cemixo9891@carpetra.com");
	     WebElement passwordField = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd css-b52kj1'])[2]"));
	     passwordField.sendKeys("Demo@123");

	        // Submit the login form
	     WebElement submitButton = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-fullWidth css-13mve93']"));
	     submitButton.click();

	     //Thread.sleep(2000);
	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(10000));
	    
	     WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-1vhx0ju']")));
	     Actions actions = new Actions(driver);
	        Thread.sleep(5000);

	    actions.moveToElement(notificationElement).click().perform();

	    
	     // Locate the close icon element using an appropriate selector
	     //WebElement closeIcon = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M14.59 8 1')]")); // Example XPath selector

	     // Perform a click action on the close icon
	     // closeIcon.click();

	     // Rest of your code
	     // driver.quit();

	    
	     // WebElement button = driver.findElement(By.xpath("//body/div[@role='presentation']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 css-gq38gf']/div[@class='css-sfwh4y']/div[1]//*[name()='svg']"));
	     //button.sendKeys(Keys.RETURN);

	    }
	}


