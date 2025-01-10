	package appbMySpotsaver;

	import java.io.IOException;
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;


public class TestClass1 {

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
		    
		    Thread.sleep(2000);
		    
		    // Switch to Profile section
		    WebElement profile= driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/button[4]"));
		    profile.click();
		    Thread.sleep(2000);
		    
		    //Zoom out
		    JavascriptExecutor js= (JavascriptExecutor)driver;
	        js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 75%
	        
	        Thread.sleep(2000);
	        //Select Brand Manager and Add Store button
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.ENTER);
	        actions.sendKeys(Keys.ARROW_UP);
	        Thread.sleep(2000);
	        actions.sendKeys(Keys.ENTER);
	        actions.build().perform();
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.ENTER);
	        actions.sendKeys(Keys.ENTER);
	        actions.build().perform();
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.ENTER);
	        actions.build().perform();
	        Thread.sleep(4000);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.TAB);
	        actions.sendKeys(Keys.ENTER);
	        actions.build().perform();
	        Thread.sleep(2000);
	        actions.sendKeys("Bhusawal").build().perform();
	        Thread.sleep(2000);
	        //Select 1st address from dropdown
	        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
	        Thread.sleep(2000);
	        actions.sendKeys(Keys.ENTER).build().perform();
	        Thread.sleep(4000);
	        //Enter store id
	        actions.sendKeys(Keys.TAB).build().perform();
	        Thread.sleep(2000);
	        actions.sendKeys("Bsl").build().perform();
	        Thread.sleep(2000);
	        //Enter contact number
	        actions.sendKeys(Keys.TAB).build().perform();
	        Thread.sleep(2000);
	        actions.sendKeys("1234567890").build().perform();
	        Thread.sleep(4000);
	        
	        //Add the store
	        WebElement ADDbutton= driver.findElement(By.xpath("//*[@id='mui-8']"));
	        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", ADDbutton);

		      
	}


}
