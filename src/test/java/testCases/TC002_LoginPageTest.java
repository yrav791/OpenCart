package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginPageTest extends BaseClass{

	@Test(groups = {"Sanity","Master"})
	public void verifyLogin()
	{
		logger.info("*** LoginTestPAge Strated ...****");
		try {
		HomePage hm=new HomePage(driver);
		hm.clickMyAccount();
		hm.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLoginBtn();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountExists();
		//Assert.assertEquals(targetPage, true,"test failed");
		Assert.assertTrue(targetPage);
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***  LoginTestPAge test finished ...****");
		
	}
}
