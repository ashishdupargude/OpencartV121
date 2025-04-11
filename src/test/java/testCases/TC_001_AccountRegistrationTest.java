package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	

	@Test(groups={"Regression","Master","All Tests"})
	public void verify_accouunt_registration()
	{
		
		logger.info(" ******Starting TC01_AccountRegistractionTest***** ");
		logger.debug("This is a debug log message");
		
		//
		
		try
		{
		
		
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
	
	
	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	
	
	
	//regpage.setFirstName(randomeString().topUpperCase());
	
	logger.info("Provideing customer details...");
	
	regpage.setFirstName(randomeString().toUpperCase());
	regpage.setLastName(randomeString().toUpperCase());
	regpage.setEmail(randomeString()+"@gmail.com"); //randomly generated the mail
	regpage.setTelephone(randomeNumber());
	
	
	
	
	//String password=randomAlphaNumeric();
	String password=randomeAlphaNumber();
	
	regpage.setPassword(password);
	regpage.setConfirmPassword(password);
	
	regpage.setPrivacyPolicy();
	regpage.clickContinue();
	
	logger.info("Validating expected message");
	String confmsg=regpage.getConfirmtionMeg();
	Assert.assertEquals(confmsg,"Your Account Has Been Created!","Confirmation message mismatch");
	
	logger.info("Test passed");
	
	//Your Account Has Been Created!
	}
		
		catch(Exception e)
		{
			logger.error("Test failed.."+e.getMessage());
			logger.error("Debug logs..."+e.getMessage());
			
			Assert.fail();
	
		}
	
	
		logger.info(" ******Finished TC01_AccountRegistractionTest***** ");
		
	}
	
	
			
}
