package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

static WebDriver driver;
public static  String mainWindowHandle;  // Store the main window handle globally
	
	public static WebDriver launchBrowserb() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.navigate().to("https://appb.myspotsaver.com");
		driver.manage().window().maximize();
		return driver;
	}
	
    public static WebDriver launchBrowser() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();
        
        // Add argument to set the zoom level to 75%
        options.addArguments("force-device-scale-factor=0.90");
        
        // Launch Chrome with specified options
        driver = new ChromeDriver(options);
        
        // Navigate to the URL
        driver.navigate().to("https://appb.myspotsaver.com");
        
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();
        
        return driver;
    }
	
	public static WebDriver launchHeadlessBrowserb() {
        // Set up the WebDriverManager to manage the ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Create an instance of ChromeOptions to configure Chrome
        ChromeOptions options = new ChromeOptions();

        // Add headless mode to the options
        options.addArguments("--headless=new");

        // Optionally, disable GPU for better performance in headless mode
        options.addArguments("--disable-gpu");
        
        // Add other necessary options
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");  // Useful for low-memory environments
        
        // Enable verbose logging to troubleshoot issues
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        
        // Pass the ChromeOptions to the ChromeDriver
        driver = new ChromeDriver(options);

        // Navigate to the desired URL
        driver.navigate().to("https://appb.myspotsaver.com");
        
        //Maximize the window
		driver.manage().window().maximize();

        return driver;
	}
	
	public static WebDriver launchCrossBrowserb(String browser)
	{
		if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.navigate().to("https://appb.myspotsaver.com");
		driver.manage().window().maximize();
		return driver;
	}
	
	//This method for NIU Health
    public static WebDriver launchBrowserNIUHealth() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();      
        driver= new ChromeDriver();
        // Navigate to the URL
        driver.navigate().to("https://appa.niuhealth.site/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }

    public static WebDriver launchEdgeBrowserNIUHealth() {
        // Setup ChromeDriver using WebDriverManager
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
        // Navigate to the URL
        driver.navigate().to("https://appa.niuhealth.site/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
    
    public static WebDriver launchFirefoxBrowserNIUHealth() {
        // Setup ChromeDriver using WebDriverManager
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
        // Navigate to the URL
        driver.navigate().to("https://appa.niuhealth.site/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
	//This method for NIU Health
    public static WebDriver launchBrowserNIUHealthAppV2() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();      
        driver= new ChromeDriver();
        // Navigate to the URL
        driver.navigate().to("https://appav2.niuhealth.com/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
    public static WebDriver launchEdgeBrowserNIUHealthAppV2() {
        // Setup ChromeDriver using WebDriverManager
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
        // Navigate to the URL
        driver.navigate().to("https://appav2.niuhealth.com/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
    public static WebDriver launchFireFoxBrowserNIUHealthAppV2() {
        // Setup ChromeDriver using WebDriverManager
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
        // Navigate to the URL
        driver.navigate().to("https://appav2.niuhealth.com/login");       
        // Store the main window handle after loading the URL
        mainWindowHandle = driver.getWindowHandle();
        // Maximize the window
        driver.manage().window().maximize();       
        return driver;
    }
}
