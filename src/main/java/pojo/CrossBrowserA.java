package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserA {
	
	static WebDriver driver;
	
	public static WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.navigate().to("https://appa.myspotsaver.com");
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver launchCrossBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.navigate().to("https://appa.myspotsaver.com");
		driver.manage().window().maximize();
		return driver;
	}

}
