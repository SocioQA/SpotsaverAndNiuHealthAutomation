package appbMySpotsaver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Screenshot;

public class Test0 {

	//public static void main(String[] args) throws InterruptedException {
		
	
	@Test
		public void pract() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	//	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	//	ChromeOptions options= new ChromeOptions();
	//	options.setHeadless(true);
	//	options.addArguments("--disable-notifications");
		
	//	WebDriver driver= new ChromeDriver();
	//	driver.get("https://appb.myspotsaver.com");
	//	driver.manage().window().maximize();
	/*	WebElement userName= driver.findElement(By.xpath("//input[@id='lgnEmail']"));
		userName.sendKeys("demou345@gmail.com");
		WebElement password= driver.findElement(By.xpath("//input[@id='lgnPassword']"));
		password.sendKeys("Demo@123");
		WebElement signInButton= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[3]/div[1]"));
		signInButton.click();
		Thread.sleep(4000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
		WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Skip']")));
		
	//	WebElement skipButton= driver.findElement(By.xpath("//p[text()='Skip']"));
		Actions actions = new Actions(driver);
			Thread.sleep(4000);

		actions.moveToElement(notificationElement).click().perform();
		
		WebElement saveSpotButton= driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[1]/div/div/div/button[1]"));
		saveSpotButton.click();
		WebElement saveSpot= driver.findElement(By.xpath("//*[@id=\"mui-6\"]"));
		
		Thread.sleep(3000);

	//	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", saveSpot);
		
	//	saveSpot.click();
		
	//	WebElement partySize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"__next\\\"]/div/div[5]/div/div/div[1]/div/div[4]")));

	//	WebElement partySize= driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[5]/div/div/div[1]/div/div[1]"));
	//	partySize.click();
		
	*/
		

	}

}
