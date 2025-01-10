package appAspotsaver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import utility.BaseClass;

public class loginInClass extends BaseClass{
	
	@BeforeMethod
	public void Test_1()
	{
		driver= Browser.launchCrossBrowserb("Chrome");
	}
	

}
