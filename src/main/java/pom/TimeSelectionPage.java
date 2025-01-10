package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeSelectionPage {
	WebDriver driver;
	JavascriptExecutor js;
    WebDriverWait wait;

	    public TimeSelectionPage(WebDriver driver) {
	        this.driver = driver;
	        this.js = (JavascriptExecutor) driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25)); // Dynamic wait set to 10 seconds
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//li[@aria-label='PM']")
	    WebElement pmElement;
	    
	    @FindBy(xpath = "//li[@aria-label='AM']")
	    WebElement amElement;

	    @FindBy(css = "ul.MuiList-root.MuiList-padding.MuiMultiSectionDigitalClockSection-root.css-107vm94[aria-label='Select hours']")
	    WebElement ulHoursElement;

	    @FindBy(css = "ul.MuiList-root.MuiList-padding.MuiMultiSectionDigitalClockSection-root.css-107vm94[aria-label='Select hours'] li")
	    List<WebElement> liHrsElements;
	    
	    @FindBy(css = "ul.MuiList-root.MuiList-padding.MuiMultiSectionDigitalClockSection-root.css-107vm94[aria-label='Select minutes']")
	    WebElement ulMinElement;
	    
	    @FindBy(css = "ul.MuiList-root.MuiList-padding.MuiMultiSectionDigitalClockSection-root.css-107vm94[aria-label='Select minutes'] li")
	    List<WebElement> liMinElements;
	   

	    public void clickOnPm() {
	        wait.until(ExpectedConditions.visibilityOfAllElements(pmElement));
	        js.executeScript("arguments[0].click();", pmElement);
	    }

	    public void clickOnAm() {
	        js.executeScript("arguments[0].click();", amElement);
	    }

	    public void scrollToHoursList() {
	        js.executeScript("arguments[0].scrollIntoView();", ulHoursElement);
	    }

	    public void selectHour(int indexToSelect) {
	        WebElement liHrElementToSelect = liHrsElements.get(indexToSelect);
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        js.executeScript("arguments[0].click();", liHrElementToSelect);
	    }
	    
	    public void scrollToMinutesList() {
	        js.executeScript("arguments[0].scrollIntoView();", ulMinElement);
	    } 
	    
	    public void selectMinutes(int minutesToSelect){
	        WebElement liMinElementToSelect = liMinElements.get(minutesToSelect);
	        try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        js.executeScript("arguments[0].click();", liMinElementToSelect);
	    }
	    
	    

}
