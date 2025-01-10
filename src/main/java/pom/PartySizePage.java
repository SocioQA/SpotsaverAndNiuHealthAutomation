package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class PartySizePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    

    // Locate all party size elements with the class 'picker-item'
   // @FindBy(xpath = "//div[@class='picker-item']")
    @FindBy(xpath = "//div[@class='picker-item' or @class='picker-item picker-item-selected']")
    List<WebElement> partySizeElements;

    // Constructor to initialize the driver, wait, and JavaScriptExecutor
    public PartySizePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Dynamic wait set to 10 seconds
        this.js = (JavascriptExecutor) driver; // Initialize JavaScriptExecutor
        PageFactory.initElements(driver, this);
    }

    // Method to select the party size dynamically
    public void selectPartySize(int partySize) {
    	 // Wait until the list of party sizes is visible
        wait.until(ExpectedConditions.visibilityOfAllElements(partySizeElements));

        // Loop through the elements to find and select the desired party size
        for (WebElement element : partySizeElements) {
            if (element.getText().equals(String.valueOf(partySize))) {
                wait.until(ExpectedConditions.visibilityOfAllElements(element));
                js.executeScript("arguments[0].click();", element);
                break; // Break the loop once the desired size is found and clicked
            }
        }
    }
}
