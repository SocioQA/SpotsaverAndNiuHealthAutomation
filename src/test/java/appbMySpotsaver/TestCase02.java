package appbMySpotsaver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;
	import pom.HomePage;
	import pom.LoginPage;
import pom.StoreSelectionPage;
import utility.ListenersClass;
    import utility.Screenshot;
    import pojo.Browser;


@Listeners(ListenersClass.class)

public class TestCase02 {
	   WebDriver driver;
	   
	   @BeforeClass
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.navigate().to("https://appb.myspotsaver.com"); 
	    }
	   
	   @Test
	    public void reserveSpot() throws InterruptedException {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.enterUserName("demou345@gmail.com");
	        loginPage.enterPassword("Demo@123");
	        loginPage.clickSignInButton();

	        Thread.sleep(5000);

	        HomePage homePage = new HomePage(driver);
	        StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        Actions actions = new Actions(driver);
	        wait.until(ExpectedConditions.visibilityOf(homePage.getSkipNotification()));
	        actions.moveToElement(homePage.getSkipNotification()).click().perform();
	        Thread.sleep(3000);
	        storeSelectionPage.selectStore();
	        
	        Thread.sleep(4000);
		    
		    // Scroll down for viewing the element - scroll down till 1st date
		    WebElement elementText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[5]/div/div/div[2]/div/div/div[2]/div/div[2]/button[4]")));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", elementText);
		    
		    //Select current date element
			WebDriverWait waitforDate = new WebDriverWait(driver,Duration.ofMillis(10000));
			WebElement DateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div[6]/div[5]/div/div/div[2]/div/div/div[2]/div/div[5]/button[4]")));
	      	DateElement.click();
	  
	      	 // Zoom out of the screen
	        Thread.sleep(10000); // Ensure page has fully loaded
	        js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 75%
	        
	        Thread.sleep(7000); // Ensure page has fully loaded

	        //Scroll up to view the dropdown
	        WebElement scrollUp = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[2]/a/button"));
		    js.executeScript("arguments[0].scrollIntoView(true);", scrollUp);
		    
		    Thread.sleep(5000);
		    // click on PM - working
		    WebElement pmElement = driver.findElement(By.xpath("//li[@aria-label='PM']"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pmElement);
		    
//		    Thread.sleep(3000);
//		    actions.sendKeys(Keys.TAB).perform();
//		    actions.sendKeys(Keys.TAB).perform();
		    
		    // Select hour - working
	        WebElement hourElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@aria-label='9 hours']")));
	        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", hourElement);
	        js.executeScript("arguments[0].click();", hourElement);
	        
	        Thread.sleep(3000);
	        
	        //Select Minutes
	        WebElement minElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@aria-label='30 minutes']")));
	        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", minElement);
	        js.executeScript("arguments[0].click();", minElement);
	        Thread.sleep(3000);
	        // Click on reserve a spot button
	        WebElement reserveASpot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id='mui-7']")));
	        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", reserveASpot);
	        js.executeScript("arguments[0].click();", reserveASpot);

	   
	   
	   }
}
