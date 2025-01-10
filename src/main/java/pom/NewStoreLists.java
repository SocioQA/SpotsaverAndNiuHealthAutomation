package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList; // Import for ArrayList
import utility.BaseClass;

public class NewStoreLists extends BaseClass{
	//   WebDriver driver;
	WebDriverWait wait;
	WebDriverWait waitMore;
	JavascriptExecutor js;
	Actions actions;

	//    private List<WebElement> storeList; // Assume this is initialized correctly
	//    private WebElement detectedLocation; // Assume this is initialized correctly

	// Constructor to initialize WebDriver, WebDriverWait, and PageFactory elements
	public NewStoreLists(WebDriver driver) {
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

	//fetch all the visible stores in a list
	//@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body2 MuiCardHeader-subheader css-3wfnbh']")
	@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body2 MuiCardHeader-subheader css-3wfnbh']")
	List<WebElement> storeList;


	// Method to iterate store list and return the first store text
	public List<String> printStoreLists() {
		List<String> storeTexts = new ArrayList<String>(); // Create a list to store the store texts
		try {
			Thread.sleep(4000); // Sleep for loading time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (WebElement store : storeList) {
			String storeText = store.getText(); // Get the text of the store
			storeTexts.add(storeText); // Add the store text to the list
			//System.out.println(storeText); // Print the store text for debugging
		}

		return storeTexts; // Return the list of store texts
	}


	// Method to extract location after logging in and return the relevant address value
	public String extractLocation() {
		// Fetch the full value of the 'value' attribute
		String fullAddress = detectedLocation.getAttribute("value");

		// Print the full address value
		System.out.println("The detected address is: " + fullAddress);

		// Extract the relevant part ("Bhusawal, Maharashtra")
		String relevantPart = extractRelevantPart(fullAddress);

		return relevantPart; // Return the relevant part
	}
	// Method to compare and assert store location
	public void compareAndAssertStoreLocation() {
	    List<String> storeTexts = printStoreLists(); // Get the list of store texts
	    String firstStoreText = storeTexts.get(0); // Get the first store text
	    String detectedAddressPart = extractLocation(); // Get the relevant address part

	    // Debugging output to see what is being compared
	    System.out.println("First Store Text: " + firstStoreText);
	    System.out.println("Detected Address Part: " + detectedAddressPart);

	    // Normalize and trim both strings before comparison
	    boolean contains = firstStoreText.toLowerCase().contains(detectedAddressPart.toLowerCase().trim());

	    // Assert that the first store text matches the detected address part
	    Assert.assertTrue(contains, 
	        "The first store text does not contain the detected partial address.");
	}
	// Assuming you have this method to extract relevant parts
	private String extractRelevantPart(String fullAddress) {
		// Split the full address into parts and find "Bhusawal" and "Maharashtra"
		String[] parts = fullAddress.split(", ");
		StringBuilder relevantPart = new StringBuilder();

		// Look for specific city and state parts
		for (String part : parts) {
			if (part.equalsIgnoreCase("Bhusawal") || part.equalsIgnoreCase("Maharashtra")) {
				if (relevantPart.length() > 0) {
					relevantPart.append(", "); // Add comma if it's not the first addition
				}
				relevantPart.append(part);
			}
		}

		return relevantPart.toString(); // Return the relevant parts as a string
	}

}
