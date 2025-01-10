package appbMySpotsaver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class SelectDate {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://appb.myspotsaver.com");
		driver.manage().window().maximize();
		//Actions act= new Actions(driver);
		Thread.sleep(2000);
		
		//Enter Email
		WebElement email= driver.findElement(By.xpath("//*[@id='lgnEmail']"));
		email.sendKeys("demou345@gmail.com");
		
		//Enter Password
		WebElement password= driver.findElement(By.xpath("//*[@id='lgnPassword']"));
		password.sendKeys("Demo@123");
		
		//Click Sign In Button
		WebElement signIn= driver.findElement(By.xpath("//*[@id='mui-1']"));
		signIn.click();
		
		Thread.sleep(5000);
		//Skip
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
		WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Skip']")));
		Actions actions = new Actions(driver);
		Thread.sleep(4000);
	    actions.moveToElement(notificationElement).click().perform();
	    
	 // Select a store
	    driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div[1]/div/div/div/button[1]")).click();
	    
	    Thread.sleep(4000);
	    
	    // Scroll down for viewing the element - scroll down till 1st date
	    WebElement elementText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[5]/div/div/div[2]/div/div/div[2]/div/div[2]/button[4]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementText);
	    
	    //Select current date element
		WebDriverWait waitforDate = new WebDriverWait(driver,Duration.ofMillis(10000));
		WebElement DateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div[6]/div[5]/div/div/div[2]/div/div/div[2]/div/div[5]/button[5]")));
      	DateElement.click();
  
      	 // Zoom out of the screen
        Thread.sleep(4000); // Ensure page has fully loaded
        js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 75%
        
        Thread.sleep(7000); // Ensure page has fully loaded

        //Scroll up to view the dropdown
        WebElement scrollUp = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[2]/a/button"));
	    js.executeScript("arguments[0].scrollIntoView(true);", scrollUp);
	    
	    Thread.sleep(5000);
	    // click on PM - working
	    WebElement pmElement = driver.findElement(By.xpath("//li[@aria-label='PM']"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pmElement);
	    
	    Thread.sleep(3000);
	    actions.sendKeys(Keys.TAB).perform();
	    actions.sendKeys(Keys.TAB).perform();
	    
	    // Select hour - working
        WebElement hourElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@aria-label='9 hours']")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", hourElement);
        js.executeScript("arguments[0].click();", hourElement);
        
        Thread.sleep(5000);
        
        //Select Minutes
        WebElement minElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@aria-label='20 minutes']")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", minElement);
        js.executeScript("arguments[0].click();", minElement);
        Thread.sleep(3000);
        // Click on reserve a spot button
        WebElement reserveASpot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id='mui-7']")));
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", reserveASpot);
        js.executeScript("arguments[0].click();", reserveASpot);
 
  
        
//        
//        // Take a screenshot
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File("screenshot29.png");
//        FileHandler.copy(screenshot, destinationFile);


	    
    
		}
}
