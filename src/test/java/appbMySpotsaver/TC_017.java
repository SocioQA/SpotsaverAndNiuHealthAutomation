package appbMySpotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.HomePage;
import pom.LoginSampleUsingJsonData;
import pom.StoreSelectionPage;
import pom.SearchStore;
import pom.NewStoreLists;
import utility.BaseClass;

public class TC_017 extends BaseClass{
   //Verify that the user's location is detected accurately after successful log in

	@BeforeMethod
	public void launchChrome() {
		driver = Browser.launchBrowser();
	}

	@Test
	public void viewStores() throws InterruptedException {
		LoginSampleUsingJsonData loginPage = new LoginSampleUsingJsonData(driver);
		HomePage hp = new HomePage(driver);
		StoreSelectionPage storeSelectionPage = new StoreSelectionPage(driver);
		SearchStore searchStore = new SearchStore(driver);
		NewStoreLists compareStoreAddress = new NewStoreLists(driver);

		loginPage.login();
		hp.getSkipNotification();
		// Perform store selection
		// Here we do not need to select a store, because we need the list of detected stores.
		//storeSelectionPage.selectStore();
		
		searchStore.extractLocation();		
		searchStore.printStoreLists();
		
		//compareStoreAddress.compareAndAssertStoreLocation();

	}	
	
}
