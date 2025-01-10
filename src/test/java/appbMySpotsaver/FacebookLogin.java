package appbMySpotsaver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.HomePage;

public class FacebookLogin {
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
		
		Thread.sleep(2000);
		WebElement  facebookButton= driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/form/div[3]/div[4]/div/button"));
		facebookButton.click();
		
		//Switch to New Window
        switchToNewWindow(driver);
        
        //Enter facebook id
        WebElement fbId= driver.findElement(By.xpath("//*[@id='email']"));
        fbId.sendKeys("emmaatsociosquares@gmail.com");
        
        //Enter facebook password
        WebElement fbpassword= driver.findElement(By.xpath("//*[@id='pass']"));
        fbpassword.sendKeys("Demo@123");
        
        // Click login button
        WebElement loginFB= driver.findElement(By.xpath("//input[@value='Log in' and @name='login' or @id='u_0_0_4+']"));
        loginFB.click();
        Thread.sleep(2000);
        // Click continue button
        WebElement continueButton= driver.findElement(By.xpath("//div[@class='x1n2onr6 x1ja2u2z x78zum5 x2lah0s xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xn6708d x1ye3gou xtvsq51 x1r1pt67']"));
        continueButton.click();
        
        Thread.sleep(5000);
        
        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(5000);

    	HomePage hp = new HomePage(driver);
    	hp.getSkipNotification();

	}
}
