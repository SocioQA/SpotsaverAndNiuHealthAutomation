package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PartySize {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    // Locate the Party Size element using @FindBy
    @FindBy(xpath = "//*[@id='__next']/div/div[5]/div/div/div[1]/div/div[3]")
    WebElement partySizes;

    // Constructor to initialize the driver, wait, and JavaScriptExecutor
    public PartySize(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Dynamic wait set to 10 seconds
        this.js = (JavascriptExecutor) driver; // Initialize JavaScriptExecutor
        PageFactory.initElements(driver, this);
    }

    // Method to select the party size
    public void selectPartySize(int partySize) {
        // Wait until the Party Size element is visible
        wait.until(ExpectedConditions.visibilityOf(partySizes));

        // Click the Party Size element using JavaScriptExecutor
        js.executeScript("arguments[0].click();", partySizes);
        
        // Here, you could also add logic to select a specific party size based on the input parameter `partySize`
        // For example, if there are multiple options under `partySizes`, you might want to locate and click the specific one.
    }
}

