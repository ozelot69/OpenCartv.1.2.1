package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC007_Login_NoCredentials extends BaseClass {

	@Test(groups = { "Master" })
	public void verifyLogin_NoCredentials() {

		logger.info("*****TC007LoginNoCredentials*****");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.clickLogin();
			logger.info("Clicked in Login link");

			logger.info("No credentials provided");
			LoginPage lp = new LoginPage(driver);
			lp.clickLogin();

			logger.info("Validating credintials warning message displayed");
			String actMsgWarningCreadentials = lp.getWarningCreadentialsMsg();

			// version 1
//			if(msgWarningCreadentials.equals("Warning: No match for E-Mail Address and/or Password.")) {
//				Assert.assertTrue(true);
//				logger.info("Test passed");
//			}else {
//				logger.error("Test failed...");
//				logger.info("Warning message mismatch");
//				logger.debug("Debug logs...");
//				Assert.assertTrue(false);
//			}

			// version 2
			Assert.assertEquals(actMsgWarningCreadentials, p.getProperty("expMsgWarningCreadentials"),
					"Warning message mismatch");
			logger.info("Test passed");

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("*****TC007LoginNoCredentials*****");
		}

	}

}
