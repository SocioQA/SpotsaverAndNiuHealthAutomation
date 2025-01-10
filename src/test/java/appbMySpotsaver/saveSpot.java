package appbMySpotsaver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Screenshot;

public class saveSpot {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();
        
        // Add argument to set the zoom level to 75%
        options.addArguments("force-device-scale-factor=0.90");
        
		WebDriver driver= new ChromeDriver(options);
		driver.navigate().to("https://appb.myspotsaver.com");
		driver.manage().window().maximize();
		//Actions act= new Actions(driver);
		Thread.sleep(2000);
		
		//Enter Email
		WebElement email= driver.findElement(By.xpath("//*[@id='lgnEmail']"));
		email.sendKeys("demou34567@gmail.com");
		
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
	    driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div/div[1]/div/div/div/button[1]")).click();
	    
	    Thread.sleep(10000);
	    JavascriptExecutor js= (JavascriptExecutor)driver;
       // js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 75%
        Thread.sleep(5000);
     
	    
	    //new code- Click on Save Spot
	    actions.sendKeys(Keys.TAB);
	    actions.sendKeys(Keys.TAB);
	    actions.sendKeys(Keys.TAB);
	    actions.sendKeys(Keys.TAB);
	    Thread.sleep(5000);
	    actions.sendKeys(Keys.TAB);
	    actions.sendKeys(Keys.ENTER);
	    actions.build().perform();
	    
	    //Take screenshot of saved spot

        Thread.sleep(2000);
        
//        File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String fileName= "saveCurrentSpot";
//		File destinationFile= new File("C:\\.SocioSquares Project\\.Spotsaver Project\\SS" +fileName +"-" +".jpg");
//		try {
//			FileHandler.copy(sourceFile, destinationFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	    
	    Thread.sleep(7000);
	    
	    //Cancel Reservation button
	    WebElement cancelReservation = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/button"));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", cancelReservation);
	    Thread.sleep(5000);
	    //Click on Yes
//	    WebElement yesCancel= driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/button[2]"));
//	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", yesCancel);
	    actions.sendKeys(Keys.TAB).build().perform();
	    Thread.sleep(2000);
	    actions.sendKeys(Keys.TAB).build().perform();
	    Thread.sleep(2000);
	    actions.sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(2000);

//	    
//	    //Cancel Reservation
//	    //Click on Cancel Reservation
//	    actions.sendKeys(Keys.TAB);
//	    actions.sendKeys(Keys.TAB);
//	    Thread.sleep(2000);
//	    actions.sendKeys(Keys.TAB);
//	    actions.sendKeys(Keys.ENTER);
//	    actions.build().perform();
//	    //Click on Yes
//	    Thread.sleep(5000);
//	    actions.sendKeys(Keys.TAB);
//	   // Thread.sleep(2000);
//	    actions.sendKeys(Keys.TAB);
//	    actions.sendKeys(Keys.ENTER);
//	    actions.build().perform();
	    
	    //old code
	/*    // Scroll down for viewing the element
	    WebElement elementText = driver.findElement(By.xpath("/html/body/div/div/div[6]/div[2]/a/button"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", elementText);
	  
/*	    //select party size of 2
		WebElement partySize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next\']/div/div[5]/div/div/div[1]/div/div[2]")));
		Thread.sleep(2000);
		actions.moveToElement(partySize).click().perform();
		//Click on save spot
		//WebElement saveSpot=driver.findElement(By.xpath("//*[@id='mui-4']"));
		//saveSpot.click();
	/*	
		//verify timezone
	    JavascriptExecutor jsNew = (JavascriptExecutor) driver;

		WebElement timeZone= driver.findElement(By.xpath("//*[@id='__next\']/div/ul[2]/li[3]/div[2]"));
		jsNew.executeScript("arguments[0].scrollIntoView();", timeZone);
		String timeZoneText= timeZone.getText();
		if(timeZoneText.equals("Asia/Kolkata"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	*/	

	}
}
