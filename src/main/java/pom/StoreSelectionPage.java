package pom;
import java.time.Duration;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import utility.BaseClass;
import utility.JsonDataReader;

public class StoreSelectionPage extends BaseClass {
	//  WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;
	String storeTexts;

	public StoreSelectionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.js = (JavascriptExecutor) driver;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	//Click on cross button to delete the address from search bar
	@FindBy(css = "button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']")
	WebElement cancelAddress;

	// Locate the search input field by its ID
	@FindBy(id = "mui-2")
	WebElement searchInput;

	//Select a store from the available list
	@FindBy(xpath = "//*[@id='__next']/div/div[2]/div/div/div[1]/div/div/div/button[1]")
	WebElement selectStoreButton;
	//Select a store from the available list
	@FindBy(xpath = "//*[@id='__next']/div/div[2]/div/div/div[1]/div/div/a/div[1]/div[2]/span[2]")
	WebElement selectedStoreText;
	
    // Locate Store details elements after selecting a store- e.g Store address, Time zone, etc
    @FindBy(xpath = "//div[@class='MuiListItemText-root css-567o11']")
    List< WebElement> listItemTexts;
    
    //Fetch phone number from store details
    @FindBy(xpath = "//*[@id='__next']/div/ul[2]/li[2]/div[2]/input")
    WebElement phNum;


	@FindBy(xpath = "/html/body/div[1]/div/div[6]/div[5]/div/div/div[2]/div/div/div[2]/div/div[2]/button[4]")
	WebElement firstDateButton;

	// Method to click on the cancel button
	public void clickCancelAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelAddress));
		cancelAddress.click();
	}

	public void selectStore() {
        String storeText = selectedStoreText.getText();
        System.out.println("Selected Store Details : " + storeText);
		wait.until(ExpectedConditions.visibilityOf(selectStoreButton));
		js.executeScript("arguments[0].click();", selectStoreButton);
		//selectStoreButton.click();

	}

	public void scrollToFirstDateButton() {
		wait.until(ExpectedConditions.visibilityOf(firstDateButton));
		js.executeScript("arguments[0].scrollIntoView();", firstDateButton);
	}
	
    // Method to fetch text from each element
    public void fetchAndPrintStoreTexts() {
        for (WebElement item : listItemTexts) {
            String text = item.getText();
            System.out.println("Store Details : " + text);
        }
        // Fetch the value of the 'value' attribute
        String phNumberValue = phNum.getAttribute("value");

        // Print the value
        System.out.println("The phone number is: " + phNumberValue);
        
//        // Assert that the first store text matches the store text from selectedStoreText
//        String firstStoreText = listItemTexts.get(0).getText();
//        storeTexts = selectedStoreText.getText();
//        Assert.assertEquals(firstStoreText, storeTexts, "The store address does not match");
//        System.out.println("The store address match");
        
    }
        

	public void zoomOutScreen() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Ensure page has fully loaded
		js.executeScript("document.body.style.zoom = '55%'"); // Zoom out to 55%
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Ensure page has fully loaded
	}

	// Method to enter text into the search input field using JSON data
	public void enterStoreText(){
		JsonDataReader jsonDataReader = new JsonDataReader();
		JSONObject jsonObject = null; // Initialize jsonObject to null

		try {
			jsonObject = jsonDataReader.getJsonData("src/test/resources/testData.json");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(searchInput));

		if (jsonObject != null) {
			// Extract data from JSON
			String location = (String) jsonObject.get("searchLocation");
			searchInput.sendKeys(location);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Select first location from the dropdown
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		}
	}



}
