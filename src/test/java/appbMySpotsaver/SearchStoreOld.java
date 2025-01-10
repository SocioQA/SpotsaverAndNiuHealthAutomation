package appbMySpotsaver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchStoreOld {
	
	public static void main(String[] args) throws InterruptedException {
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
	    Thread.sleep(7000);
	    
//	    //Zoom out
//	    JavascriptExecutor js= (JavascriptExecutor)driver;
//        js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 75%
        
	    //Search bar
	    WebElement cancelAddress= driver.findElement(By.cssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']"));
	    cancelAddress.click();
	 
	    // Enter Location
	    Thread.sleep(2000);
	    driver.findElement(By.id("mui-2")).sendKeys("Mumbai Central");
	    Thread.sleep(3000);
	    //Select Mumbai central location from the list using keyboard actions
	    actions.sendKeys(Keys.ARROW_DOWN).build().perform();
	    Thread.sleep(2000);
	    actions.sendKeys(Keys.ENTER).build().perform();
	    //Select your Mumbai central store
	    actions.sendKeys(Keys.TAB).build().perform();
	    Thread.sleep(1000);
	    actions.sendKeys(Keys.TAB).build().perform();
	    Thread.sleep(1000);
	    actions.sendKeys(Keys.TAB).build().perform();
	    Thread.sleep(2000);
	    actions.sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(2000);
	    //Zoom out
	    JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 75%
        Thread.sleep(4000);
          // Party Size
          WebElement partySizes= driver.findElement(By.xpath("//*[@id='__next']/div/div[5]/div/div/div[1]/div/div[3]"));
          //partySizes.click();
          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", partySizes);
          //Save Current Spot
          Thread.sleep(5000);
         WebElement saveSpotButton= driver.findElement(By.xpath("//*[@id='mui-6']"));
         ((JavascriptExecutor)driver).executeScript("arguments[0].click();", saveSpotButton);
         Thread.sleep(6000);
    
       //Cancel Reservation button
 	    WebElement cancelReservation = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/button"));
 	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", cancelReservation);
 	    Thread.sleep(5000);
 	    //Click on Yes
// 	    WebElement yesCancel= driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/button[2]"));
// 	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", yesCancel);
 	    actions.sendKeys(Keys.TAB).build().perform();
 	    Thread.sleep(2000);
 	    actions.sendKeys(Keys.TAB).build().perform();
 	    Thread.sleep(2000);
 	    actions.sendKeys(Keys.ENTER).build().perform();
 	    Thread.sleep(2000);

      
 
	   /*
		    //Click on Search again
		    actions.sendKeys(Keys.TAB);
		    actions.sendKeys(Keys.TAB);
		    actions.sendKeys(Keys.TAB);
		    actions.sendKeys(Keys.TAB);
		    Thread.sleep(2000);
		    actions.sendKeys(Keys.TAB);
		    actions.sendKeys(Keys.ENTER);
		    actions.build().perform();
		 /*   
		    //Search new store
		    Thread.sleep(5000);
		    actions.sendKeys(Keys.TAB);
		    actions.sendKeys(Keys.TAB);
		    actions.sendKeys(Keys.TAB);
		    Thread.sleep(2000);
		    actions.sendKeys(Keys.BACK_SPACE);
		    actions.build().perform();
		 */   

	
	}

}
