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
import utility.ListenersClass;
import utility.Screenshot;


//Login and Skip notification

	@Listeners(ListenersClass.class)
	public class TestCase01 {
	    WebDriver driver;

	    @BeforeClass
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.navigate().to("https://appb.myspotsaver.com");
	    }

	    @Test
	    public void searchStore() throws InterruptedException {
	        LoginPage loginPage = new LoginPage(driver);
	        HomePage homePage = new HomePage(driver);
	        loginPage.enterUserName("demou345@gmail.com");
	        loginPage.enterPassword("Demo@123");
	        loginPage.clickSignInButton();

	        Thread.sleep(5000);

	        //This
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	        Actions actions = new Actions(driver);
//	        wait.until(ExpectedConditions.visibilityOf(homePage.getSkipNotification()));
//	        actions.moveToElement(homePage.getSkipNotification()).click().perform();
	        // OR
	        
	        homePage.getSkipNotification();

	        Thread.sleep(7000);

	        homePage.getCancelAddress().click();
	        
	        Thread.sleep(3000);
	        
	       // Screenshot.screenshotMethod(driver, "TCOneImg");
	    }

//	    @AfterClass
//	    public void tearDown() {
//	        driver.quit();
//	    }



}
