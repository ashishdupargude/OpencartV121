package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	@Test(groups={"Sanity","Master","All Tests"})
	
	public void verify_login()

	{
		logger.info("******Starting TC_002_LoginTest*********");
		logger.info("capturing application debug logs....");
		
		
		try
		{
		
		//HomePage
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clicklogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		
		//MyAccouunt
		MyAccountPage macc=new MyAccountPage(driver);
		
		 boolean targetPage = macc.isMyAccountPageExists();
		 
		 Assert.assertEquals(targetPage, true);
		 
		// Assert.assertTrue(targetPage);
		}
		
		catch (Exception e)
		{
			Assert.fail();
			
		}
		 logger.info("*******Finished TC_002_LoginTest**********");
		 
		 
		 
		
		
		
		
		
				
	}
	

}
