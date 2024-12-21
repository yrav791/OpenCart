package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups = {"Regression","Master"})
	public void verify_accountRegistration()
	{ 
		logger.info("***** Starting TC_001AccountRegistrationTest .... *****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount link");
		
		hp.clickRegister();
		logger.info("clicked on Register link");
		
		
		RegistrationPage rg=new RegistrationPage(driver);
		logger.info("Providing Customer Details");
		rg.setFirstName(randomString().toUpperCase());
		rg.setLastName(randomString().toUpperCase());
		String email=randomString()+"@gmail.com";
		rg.setEmail(email);
		System.out.println(email);
		rg.setTelephone(randomNumber());
		String pwd=randomAlphaNumeric();
		rg.setPassword(pwd);
		rg.setConfirmPassword(pwd);
		System.out.println(pwd);
		rg.clickNewsLetter();
		rg.clickPolicy();
		rg.clickContinue();
		logger.info("Validating expected Message");
		String confrmMsg=rg.getConfirmationMessage();
		
		if(confrmMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.info("Test info");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Finished TC_001AccountRegistrationTest .... *****");
		
	}
	
}
