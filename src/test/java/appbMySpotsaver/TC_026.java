package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CancelReservation;
import pom.DateSelectionPage;
import pom.FavoritesPage;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.PartySizePage;
import pom.SaveSpotButton;
import pom.StoreSelectionPage;
import pom.TimeSelectionPage;
import utility.BaseClass;

public class TC_026 extends BaseClass{
	//Verify that the user can edit the favorites list
	@BeforeMethod
	   public void launchChrome() {
		   driver = Browser.launchBrowser();
	   }
	    
	    @Test
	    public void editFavorites(){
	    	LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
	    	HomePage hp = new HomePage(driver);
	        //StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
	        //TimeSelectionPage timeSelectionPage = new TimeSelectionPage(driver);
	        //DateSelectionPage dateSelectionPage = new DateSelectionPage(driver);
	        //CancelReservation  cancelSpot = new CancelReservation(driver);
	        //PartySizePage partySize = new PartySizePage(driver);
	        //SaveSpotButton saveSpot = new SaveSpotButton(driver);
	        FavoritesPage fav = new FavoritesPage(driver);

	        //Login and skip notification
	        loginPage.login();
	        hp.getSkipNotification();
	        //Mark the first store as favorite
	        fav.clickOnAnotherFavorite();
	        fav.clickOnFavPage();
	        
	
	    }

}
