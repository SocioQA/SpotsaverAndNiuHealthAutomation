package pom;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateSelectionPage {
	    WebDriver driver;
	    WebDriverWait wait;
	    JavascriptExecutor js;

	    public DateSelectionPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Updated constructor
	        this.js = (JavascriptExecutor) driver;
	        PageFactory.initElements(driver, this);
	    }

	    //Current date
	    @FindBy(xpath = "//*[@id='__next']/div/div[6]/div[5]/div/div/div[2]/div/div/div[2]/div/div[5]/button[4]")
	    WebElement dateElement;
	    
	    //Future date
	    //old xpath- //*[@id='__next']/div/div[6]/div[5]/div/div/div[2]/div/div/div[2]/div/div[5]/button[5]
	    @FindBy(xpath = "//*[@id='__next']/div/div[6]/div[5]/div/div/div[2]/div/div/div[2]/div/div[3]/button[7]") 
	    WebElement futureDateElement;
	    // Using @FindBy to locate the text within the button
	    @FindBy(xpath = "//button[contains(@class, 'MuiPickersDay-root') and contains(@class, 'Mui-selected')]//text()[normalize-space()='27']")
	    WebElement dayTextElement;
	    
	    //View selected year after selecting date from calendar
	    @FindBy(xpath = "//*[@id='__next']/div/div[6]/div[5]/div/div/div[1]/div/div[1]/div[2]/p[1]")
	    WebElement selectedYear;

	    //View selected date  after selecting date from calendar
	    @FindBy(xpath = "//*[@id='__next']/div/div[6]/div[5]/div/div/div[1]/div/div[1]/div[2]/p[2]")
	    WebElement selectedDate;
	    
	    //Scroll up to get page in focus
	    @FindBy(xpath = "/html/body/div[1]/div/div[6]/div[2]/a/button")
	    WebElement scrollUpButton;

	    //Methods
	    public void selectCurrentDate() {
	        wait.until(ExpectedConditions.visibilityOf(dateElement));
	        dateElement.click();
	    }
	    
	    public void selectFutureDate() {
	        wait.until(ExpectedConditions.visibilityOf(futureDateElement));
	        futureDateElement.click();
//	        wait.until(ExpectedConditions.visibilityOf(dayTextElement));
//	        String dayText = dayTextElement.getText();
//	        System.out.println(dayText);
	    }

	    public void zoomOutScreen() {
	        try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Ensure page has fully loaded
	        js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 55%
	        try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Ensure page has fully loaded
	    }

	    public void scrollUpToViewDropdown() {
	        js.executeScript("arguments[0].scrollIntoView(true);", scrollUpButton);
	    }
	    
	    public void fetchSelectedDate() {
	    	String year = selectedYear.getText();
	    	String date = selectedDate.getText();
	    	String completeDate = year.concat(" ").concat(date);
	    	//System.out.println(year +" " + date);
	    	System.out.println(completeDate);
	    }

//	    //Code from chatgpt
//	    public void zoomOutScreen() {
//	        // Wait until the page has fully loaded by checking the document ready state
//	        waitForPageLoad();
//
//	        // Zoom out to 55%
//	        js.executeScript("document.body.style.zoom = '55%'");
//
//	        // Wait until the zoom has been applied
//	        waitUntilZoomApplied("55%");
//	    }
//
//	    private void waitForPageLoad() {
//	        wait.until(new ExpectedCondition<Boolean>() {
//	            public Boolean apply(WebDriver driver) {
//	                return js.executeScript("return document.readyState").equals("complete");
//	            }
//	        });
//	    }
//
//	    private void waitUntilZoomApplied(final String expectedZoomLevel) {
//	        wait.until(new ExpectedCondition<Boolean>() {
//	            public Boolean apply(WebDriver driver) {
//	                return js.executeScript("return document.body.style.zoom").equals(expectedZoomLevel);
//	            }
//	        });
//	    }
//
//	    public void scrollUpToViewDropdown() {
//	        js.executeScript("arguments[0].scrollIntoView(true);", scrollUpButton);
//	    }
	    
}
