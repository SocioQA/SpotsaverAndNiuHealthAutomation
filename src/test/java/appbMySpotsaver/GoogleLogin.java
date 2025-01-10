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

public class GoogleLogin {
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
		
		Thread.sleep(2000);
		WebElement  googleButton= driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/form/div[3]/div[3]/button"));
		googleButton.click();
		
		//Switch to New Window
        switchToNewWindow(driver);
        
        //Enter email
        WebElement email= driver.findElement(By.xpath("//*[@id='identifierId']"));
        email.sendKeys("shabnama@sociosquares.com");
        
        //Click Next
        WebElement next= driver.findElement(By.xpath("//*[@id='identifierNext']/div/button/span"));
        next.click();
        Thread.sleep(2000);
        //Enter Password
      //*[@id="password"]/div[1]/div/div[1]/input
        WebElement password= driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        password.sendKeys("Demo@123"); //Incorrect password
        
        //Click Next
        WebElement next1= driver.findElement(By.xpath("//*[@id='passwordNext']/div/button/span"));
        next1.click();
        Thread.sleep(5000);
		
	/*	//Skip Notification
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(10000));
		WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Skip']")));
		Actions actions = new Actions(driver);
		//Thread.sleep(4000);
	    actions.moveToElement(notificationElement).click().perform();
    */

        
		
		

}
}