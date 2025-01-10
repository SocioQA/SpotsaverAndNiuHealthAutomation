package appbMySpotsaver;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.HomePage;

public class AutoGoogleLogin {
	private static void switchToNewWindow(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://appb.myspotsaver.com");
		driver.manage().window().maximize();
		
        // Store the current window handle (main window handle)
        String mainWindowHandle = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Thread.sleep(2000);
		

		WebElement  googleButton= driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/form/div[3]/div[3]/button"));
        wait.until(ExpectedConditions.visibilityOf(googleButton)).click();
//        googleButton.click();
		
		//Switch to New Window
        switchToNewWindow(driver);
        
        //Enter email
        WebElement email= driver.findElement(By.xpath("//*[@id='identifierId']"));
        email.sendKeys("automate637@gmail.com");
        //Click Next
        WebElement next= driver.findElement(By.xpath("//*[@id='identifierNext']/div/button/span"));
        next.click();
        Thread.sleep(4000);
      //Enter Password
        WebElement password= driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
        password.sendKeys("Demo@123");
        //Click Next
        WebElement next1= driver.findElement(By.xpath("//*[@id='passwordNext']/div/button/span"));
        next1.click();
      //  Thread.sleep(6000);
  
        //Click continue button
        WebElement continueButton= driver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[3]/div/div/div[2]/div/div/button"));
        continueButton.click();
       // Thread.sleep(10000);
        
//        // Switch back to the main window
//        driver.switchTo().window(mainWindowHandle);
//        Thread.sleep(5000);
//      //Skip
//      		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
//      		WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Skip']")));
//      		Actions actions = new Actions(driver);
//      		Thread.sleep(4000);
//      	    actions.moveToElement(notificationElement).click().perform();
        
        // Re-fetch available windows and switch back to the main window
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (window.equals(mainWindowHandle)) {
                driver.switchTo().window(mainWindowHandle);
                break;
            }
        }
       // Thread.sleep(4000);
       // HomePage hp = new HomePage(driver);
     //   hp.getSkipNotification();

//        // Wait and click the Skip button
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
//        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Skip']")));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(notificationElement).click().perform();
	}       
}
