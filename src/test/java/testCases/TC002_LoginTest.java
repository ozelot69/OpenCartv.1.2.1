package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity", "Master"})
	public void verifyLogin() {
		
		logger.info("*****Starting TC002_LoginTest*****"); 
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.clickLogin();
			logger.info("Clicked in Login link"); 

			logger.info("Providing credentials");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			logger.info("Validating AccountPage displayed"); 
			MyAccountPage macp = new MyAccountPage(driver);			
			boolean targetPage = macp.isMyAccountPageExist();
			
			//version 1
//			if(targetPage==true) {
//				Assert.assertTrue(true);
//				logger.info("Test passed");
//			}else {
//				logger.error("Test failed...");
//				logger.info("AccountPage is not displayed");
//				logger.debug("Debug logs...");
//				Assert.assertTrue(false);
//			}
			
			//version 2
			Assert.assertEquals(targetPage, true, "AccountPage is not displayed"); 
			logger.info("Test passed");
			
			// or Assert.assertTrue(targetPage);	
			
			
		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		}
		finally {
			logger.info("*****Finished TC002_LoginTest*****"); 
		}

	}

}
