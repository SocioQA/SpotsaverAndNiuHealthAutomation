package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


public class HomePage {
	  WebDriver driver;
	  WebDriverWait wait;
	  JavascriptExecutor js;
	  Actions action;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        this.js = (JavascriptExecutor)driver;
	        this.action = new Actions(driver);
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//p[text()='Skip']")
	    WebElement skipNotification;

	    @FindBy(css = "button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']")
	    WebElement cancelAddress;
	    

	    public WebElement getSkipNotification() {
	        wait.until(ExpectedConditions.visibilityOf(skipNotification));
	        action.moveToElement(skipNotification).click().perform();
	        return skipNotification;
	    }

	    public WebElement getCancelAddress() {
	        return cancelAddress;
	    }
	    
	    public void zoomOutScreen() {
//	        try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} // Ensure page has fully loaded
	        js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 55%
	        try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Ensure page has fully loaded
	    }
	   

}
