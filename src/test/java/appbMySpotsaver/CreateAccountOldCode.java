package appbMySpotsaver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountOldCode {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://appb.myspotsaver.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Create Account
		WebElement createAccount= driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/form/div[3]/div[2]/button"));
		createAccount.click();
		
		Thread.sleep(2000);
		
		//Enter Full Name
		WebElement fullName= driver.findElement(By.xpath("//*[@id='rgtrFullName']"));
		fullName.sendKeys("Automate User");
		
		//Enter Email
		WebElement email= driver.findElement(By.xpath("//*[@id='rgtrEmail']"));
		email.sendKeys("1a01b365573b15@theeyeoftruth.com");
		
		//Enter Password
		WebElement password= driver.findElement(By.xpath("//*[@id='rgtrPassword']"));
		password.sendKeys("Demo@123");
		Thread.sleep(2000);
		
		//Click on Create account
		WebElement clickCreateAccount= driver.findElement(By.xpath("//*[@id='mui-2']"));
		clickCreateAccount.click();
		
		Thread.sleep(3000);
		
		//Skip Notification
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
		WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Skip']")));
		Actions actions = new Actions(driver);
		//Thread.sleep(4000);
	    actions.moveToElement(notificationElement).click().perform();

}
}
