package test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropelPractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://appb.propel.ly/");
		driver.manage().window().maximize();
		//email
		driver.findElement(By.id("email")).sendKeys("tocoper577@marikuza.com");
		//password
		driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd css-qj338w']"))
		.sendKeys("Demo@123");
		//unchecked remember me button
		driver.findElement(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']")).click();
		Thread.sleep(2000);
		//signin
		driver.findElement(By.id(":R5b9l6t6:")).click();
		Thread.sleep(9000);
		WebElement widget= driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/ul/div[2]/div/div/div/i"));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement widgetButton= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div[1]/div/ul/div[2]/div/div/div/i")));
	 	
		widgetButton.click();
		
		WebElement googleId= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='combo-box-demo']")));
		
		googleId.sendKeys("Null Chiropractic, E Chestnut St, Independence, KS, USA");
		
	//	WebElement first= wait.until(ExpectedConditions.attributeContains(googleId, "class", "my-class"));

		WebElement option1= driver.findElement(By.xpath("//*[@id='combo-box-demo']"));
		option1.click();
		Thread.sleep(4000);
		Actions act= new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		WebElement yelpId= driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/div[2]/form/div/div[3]/div/div[4]/div[2]/div/input"));
		yelpId.sendKeys("abcdefgh");
		


		//driver.close();
	}

}
