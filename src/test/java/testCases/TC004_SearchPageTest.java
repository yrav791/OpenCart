package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchPageTest extends BaseClass {

	@Test
	public void verify_SearchPage() {
		logger.info("TC004_SearchPageTest Started.....");
		try {
			
		    HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount link");
			hp.clickLogin();
			logger.info("clicked on Login link");
			
		LoginPage lp=new LoginPage(driver);
		logger.info("Enter customer details.....");
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLoginBtn();
		
		
		logger.info("Enter item name for search.....");
		SearchPage sp=new SearchPage(driver);
		sp.setSearchText("imac");
		Thread.sleep(2000);
		sp.clickSearchBtn();
		boolean msg=sp.getConfirmationMsg();
		logger.info("validating search page.....");
		Thread.sleep(2000);
		if(msg==true) {
			Assert.assertTrue(true);
			logger.info("Passed");
			System.out.println("test Passed....");
		}else {
			logger.error("failed");
			logger.debug("debug");
			System.out.println("test failed");
			Assert.fail();
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
		
				
	}
}
