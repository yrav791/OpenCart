package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelUtility;

public class TC002_LoginTestDDT extends BaseClass{
	 
	@Test(dataProvider = "LoginData" ,dataProviderClass =DataProviders.class,groups = "dataDriven")
    public void verifyLoginData(String email,String pwd,String exp) throws InterruptedException
    {
		
    	logger.info("**** TC002_LoginTestDDT Started ....****");
    try {	
	HomePage hm=new HomePage(driver);
	hm.clickMyAccount();
	hm.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLoginBtn();
	
	MyAccountPage map=new MyAccountPage(driver);
	boolean targetPage=map.isMyAccountExists();
	if(exp.equalsIgnoreCase("valid"))
	{
		if(targetPage==true)
		{
			map.clickLogout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("invalid"))

		if(targetPage==true)
		{
			map.clickLogout();
			
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
		}
    }catch(Exception e)
    {
    	Assert.fail();
    }
    Thread.sleep(1000);
    
    logger.info("**** TC002_LoginTestDDT finnished....****");


}
}
