package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC008_Logout extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verifyLogout() {

		logger.info("*****TC008_Logout*****");

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

			Thread.sleep(3000);

			MyAccountPage macp = new MyAccountPage(driver);
			macp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			macp.clickLogout2();
			logger.info("Clicked in Logout link");

			LogoutPage loutp = new LogoutPage(driver);
			
			//Soft assert 
			SoftAssert sa = new SoftAssert(); 

			logger.info("Validating Logout page displayed");
			boolean targetPage = loutp.isLogoutPageExist();

			// version 1
//			if (targetPage == true) {
//				Assert.assertTrue(true);
//				logger.info("Test passed");
//			} else {
//				logger.error("Test failed...");
//				logger.info("Logout page is not displayed");
//				logger.debug("Debug logs...");
//				Assert.assertTrue(false);
//			}

			// version 2
//			Assert.assertEquals(targetPage, true, "LogoutPage is not displayed"); 
//			logger.info("Test passed");

			//or Assert.assertTrue(targetPage);
			
			//soft assert
			sa.assertEquals(targetPage, true, "LogoutPage is not displayed");
						
			logger.info("Validating page title");
			String actLogoutPageTitle = loutp.getTitle();
			
			//version 1
//			if (pTitle.equals("Account Logout")) {
//				Assert.assertTrue(true);
//				logger.info("Test passed");
//			} else {
//				logger.error("Test failed...");
//				logger.info("Page title is not correct");
//				logger.debug("Debug logs...");
//				Assert.assertTrue(false);
//			}
			
			//version 2
//			Assert.assertEquals(pTitle, "Account Logout", "Page title is not correct");
//			logger.info("Test passed");
			
			//soft assert 
			sa.assertEquals(actLogoutPageTitle, p.getProperty("expLogoutPageTitle"), "Page title is not correct");
						
			logger.info("Validating page URL");
			String actLogoutPageUrl = loutp.getCurrentUrl();
			
			//version 1
//			if (pUrl.equals("https://tutorialsninja.com/demo/index.php?route=account/logout")) {
//				Assert.assertTrue(true);
//				logger.info("Test passed");
//			} else {
//				logger.error("Test failed...");
//				logger.info("Page URL is not correct");
//				logger.debug("Debug logs...");
//				Assert.assertTrue(false);
//			}
			
			//version 2
//			Assert.assertEquals(pUrl, "https://tutorialsninja.com/demo/index.php?route=account/logout", "Page URL is not correct");
//			logger.info("Test passed");
			
			//soft assert 
			sa.assertEquals(actLogoutPageUrl, p.getProperty("expLogoutPageUrl"), "Page URL is not correct"); 
					
			sa.assertAll(); 

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC008_Logout *****");
		}

	}

}
