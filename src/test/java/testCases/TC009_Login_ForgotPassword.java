package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC009_Login_ForgotPassword extends BaseClass {

	@Test(dataProvider = "ConfirmMsg", dataProviderClass = DataProviders.class, groups = { "DataDriven", "Master" })
	public void verifyLogin_ForgotPassword(String expConfirmEmailMsg) {

		logger.info("***** Starting TC009_Login_ForgotPassword *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.clickLogin();
			logger.info("Clicked Login link");

			LoginPage lp = new LoginPage(driver);
			lp.clickForgotPassword();
			logger.info("Clicked Forgotten Password link");

			ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
			fpp.setEmail(p.getProperty("email"));
			logger.info("Email provided");
			fpp.clickContinue();
			logger.info("Clicked Continue button");

			logger.info("Validating expected message");
			String actualConfirmEmailMsg = lp.getConfirmationEmailMsg();

			Assert.assertEquals(actualConfirmEmailMsg, expConfirmEmailMsg, "Confirmation message mismatch");
			logger.info("Test passed");

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished Starting TC009_Login_ForgotPassword *****");
		}

	}

}
