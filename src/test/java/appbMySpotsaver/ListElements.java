package appbMySpotsaver;

import java.io.IOException;
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

public class ListElements {
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
	    
	    Thread.sleep(3000);
	    // Locate the specific Hours list ul element using its class attribute
        WebElement ulHrsElement = driver.findElement(By.cssSelector("ul.MuiList-root.MuiList-padding.MuiMultiSectionDigitalClockSection-root.css-107vm94[aria-label='Select hours']"));
        js.executeScript("arguments[0].scrollIntoView();", ulHrsElement);

        // Fetch all the Hours li elements within the located ul element
        List<WebElement> liHrsElements = ulHrsElement.findElements(By.tagName("li"));
        // Get the total count of li elements
        int totalHoursElements = liHrsElements.size();

//        //Print the total count
        System.out.println("Total number of Hours in dropdown: " + totalHoursElements);
//        Thread.sleep(3000);
//        //Iterate over the list and print each li element's text
//        for (WebElement liElement : liHrsElements) {
//            System.out.println(liElement.getText());
//        }
        
        // Select a specific li element i.e. select any Hour from the list by index (e.g., the second hour element)
        int indexToSelect = 6; // index is 0-based
        WebElement liHrElementToSelect = liHrsElements.get(indexToSelect);
        Thread.sleep(4000);
        // Click the selected li element i.e. select 2pm hour
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", liHrElementToSelect);
	    
	    Thread.sleep(4000);
	    
	    // Locate the specific Minutes list ul element using its class attribute
        WebElement ulMinElement = driver.findElement(By.cssSelector("ul.MuiList-root.MuiList-padding.MuiMultiSectionDigitalClockSection-root.css-107vm94[aria-label='Select minutes']"));
        js.executeScript("arguments[0].scrollIntoView();", ulMinElement);
        // Fetch all the Minutes li elements within the located ul element
        List<WebElement> liMinElements = ulMinElement.findElements(By.tagName("li"));
        // Get the total count of li elements
        int totalMinutesElements = liMinElements.size();
        
//      //Print the total minutes count
        System.out.println("Total number of minutes li elements: " + totalMinutesElements);
//        Thread.sleep(3000);
//        //Iterate over the list and print each li element's text
//        for (WebElement liElement : liMinElements) {
//            System.out.println(liElement.getText());
//        }
       
        // Select a specific li element i.e. select any minutes from the list by index
        int minutesToSelect = 5; // index is 0-based
        WebElement liMinElementToSelect = liMinElements.get(minutesToSelect);
        Thread.sleep(4000);
        // Click the selected li element i.e. select 5minutes hour
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", liMinElementToSelect);

        
        
	    
//	    Thread.sleep(3000);
//	    actions.sendKeys(Keys.TAB).perform();
//	    actions.sendKeys(Keys.TAB).perform();
//	    
//	    // Select hour - working
//        WebElement hourElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@aria-label='9 hours']")));
//        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", hourElement);
//        js.executeScript("arguments[0].click();", hourElement);
//        
//        Thread.sleep(2000);
	}
}
