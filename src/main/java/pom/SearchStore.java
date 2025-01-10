package pom;

import java.time.Duration;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;
import utility.JsonDataReader;

public class SearchStore extends BaseClass {
 //   WebDriver driver;
    WebDriverWait wait;
    WebDriverWait waitMore;
    JavascriptExecutor js;
    Actions actions;

    // Constructor to initialize WebDriver, WebDriverWait, and PageFactory elements
    public SearchStore(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.waitMore = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver,this);
    }

    //Detected location address
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[2]/div/div/div/input")
    WebElement detectedLocation;
    
    // Locate the cancel button using @FindBy with CSS Selector
    @FindBy(css = "button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']")
    WebElement cancelAddress;
    
    // Locate the search input field by its ID
    @FindBy(id = "mui-2")
    WebElement searchInput;
    
    //fetch all the visible stores in a list
    //@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body2 MuiCardHeader-subheader css-3wfnbh']")
    @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body2 MuiCardHeader-subheader css-3wfnbh']")
    List<WebElement> storeList;
    
    //To wait after entering location
    @FindBy(xpath = "//input[@id='mui-2' and @value='Mumbai Central']")
    WebElement waitAfterEnteringText;

    // Method to click on the cancel button
    public void clickCancelAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelAddress));
        cancelAddress.click();
    }
    
    // Method to enter text into the search input field //without using json data
    public void enterSearchText(String searchText){
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(searchText);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //   wait.until(ExpectedConditions.visibilityOf(waitAfterEnteringText));
        //  actions.sendKeys(Keys.SPACE).build().perform();
        
        // Use Actions to interact with the dropdown
        //Select first location from the dropdown
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
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
    
    public void enterStoreLocation(){
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
           String location = (String) jsonObject.get("searchAnotherLocation");
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
    
    //After searching for the store location, fetch the stores in a list.
    // Method to select the store from the list dynamically   
	public void selectYourStore(int index) {
		// Wait until the list of party sizes is visible
		// wait.until(ExpectedConditions.visibilityOfAllElements(storeList));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Check if the index is within the bounds of the list
		if (index >= 0 && index < storeList.size()) {
			WebElement element = storeList.get(index);

			// Wait until the element is visible
			wait.until(ExpectedConditions.visibilityOf(element));

			// Click the element using JavaScript Executor
			js.executeScript("arguments[0].click();", element);
		} else {
			System.out.println("Index out of bounds. No element found at index: " + index);
		}
	}
    
    //method to iterate store list
    public void printStoreLists() {
    	try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for (WebElement store : storeList) {
          System.out.println(store.getText());
      }
 	   
    }
    
    //Method to extract location after logging in
    public void extractLocation() {
        // Fetch the value of the 'value' attribute
        String addressValue = detectedLocation.getAttribute("value");

        // Print the value
        System.out.println("The detected address is: " + addressValue);
        
        
    }
}
