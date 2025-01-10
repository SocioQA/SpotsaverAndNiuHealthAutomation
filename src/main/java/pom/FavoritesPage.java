package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FavoritesPage {
	    WebDriver driver;
	    WebDriverWait wait;
	    JavascriptExecutor js;
	    Actions action;
	    
	    public FavoritesPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        this.js = (JavascriptExecutor)driver;
	        this.action = new Actions(driver);
	        PageFactory.initElements(driver, this);
	    }
	    
	    //Locate favorite button
	    @FindBy (xpath = "//*[@id='__next']/div/div[2]/div/div/div[1]/div/div/div/button[2]")
	    WebElement favorite;
	    
	    //Locate favorite button
	    @FindBy (xpath = "//*[@id='__next']/div/div[2]/div/div/div[2]/div/div/div/button[2]")
	    WebElement anotherfavorite;
	    
	    //Locate store marked as favorite
	    @FindBy (xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-3ji3x7']")
	    WebElement markedFav;
	    
	    //Locate favorites page
	    @FindBy (xpath = "//*[@id='__next']/div/div[3]/div/button[3]")
	    WebElement favPage;

	    //Locate empty favorites page
	    @FindBy (xpath = "/html/body/div[1]/div/div[2]/div/p")
	    WebElement emptyFav;
	    

	    public void clickOnFavorite() {
	        wait.until(ExpectedConditions.visibilityOfAllElements(favorite));
	        js.executeScript("arguments[0].click();", favorite);
	        System.out.println("Added to favorites");
	    }
	    
	    public void clickOnAnotherFavorite() {
	        wait.until(ExpectedConditions.visibilityOfAllElements(anotherfavorite));
	        js.executeScript("arguments[0].click();", anotherfavorite);
	        System.out.println("Added to favorites");

	    }
	    
	    public void clickToRemoveFavorite() {
	        wait.until(ExpectedConditions.visibilityOfAllElements(markedFav));
	        js.executeScript("arguments[0].click();", markedFav);
	        System.out.println("Removed from favorites");

	    }
	    
	    public void clickOnFavPage() {
	        wait.until(ExpectedConditions.visibilityOfAllElements(favPage));
	        js.executeScript("arguments[0].click();", favPage);
	    }
	    
	    public void emptyFavPage() {
	        wait.until(ExpectedConditions.visibilityOfAllElements(favPage));
	        js.executeScript("arguments[0].click();", favPage);
	        
	       
	        wait.until(ExpectedConditions.visibilityOfAllElements(emptyFav));
			String emptyFavText = emptyFav.getText();
	        Assert.assertEquals(emptyFavText, "Save your favorite places");
			System.out.println("Test passed and no stores is marked as favorite > " +emptyFavText);
	    }
}
