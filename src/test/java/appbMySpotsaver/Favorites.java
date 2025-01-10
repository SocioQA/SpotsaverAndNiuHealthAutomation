package appbMySpotsaver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class Favorites {
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
	    Thread.sleep(5000);
	    //Click on favorite button
	    WebElement fav= driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div[1]/div/div/div/button[2]"));
	    JavascriptExecutor js= ((JavascriptExecutor)driver);
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", fav);
	    
	    Thread.sleep(2000);
	    //Switch to Favorites page
	    WebElement favPage= driver.findElement(By.xpath("//*[@id='__next']/div/div[3]/div/button[3]"));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", favPage);

	    

}
}
