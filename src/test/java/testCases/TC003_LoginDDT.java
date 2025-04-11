package testCases;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;



public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)//getting data provider from different class
	public void verify_loginDDT(String email,String pwd, String exp)
	{
		
	logger.info("*********Starting TC_003_LoginDDT**********"); 
	
	try
	{
	
	
		//HomePage
		HomePage hp=new HomePage(driver);
				
		hp.clickMyAccount();
		hp.clicklogin();
		
		/*
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("//screenshots");
        
        FileUtils.copyFile(screenshot, destinationFile);
        */
				
		//Login
		LoginPage lp=new LoginPage(driver);
				
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
				
				
		//MyAccouunt
		MyAccountPage macc=new MyAccountPage(driver);
				
		boolean targetPage = macc.isMyAccountPageExists();
		
		/*Data is valid -login success test pass --logout
		 *               login failed -test fail
		 * 
		 * Data is invalid- login success -test fail -logout
		 *                  login failed -test pass
		 */

		
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if (targetPage=true)
			{
				Assert.assertTrue(true);
				macc.clickLogout();
			}
			
			else
			{
				Assert.assertTrue(false);
				
			}

		}
		
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}
			
			else
			{
				Assert.assertTrue(true);
				
			}
			
			
		}
	}
	catch(Exception e)
	{
		Assert.fail("An exception occurred:" +e.getMessage());
		
	}
		logger.info("*********Finished TC_003_LoginDDT**********");
		
	}
	
	
	
	
	
	
	
	
	
}
