package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC004_Registration_VerifyPwdConfirmMsg extends BaseClass {

	@Test(groups = {"Master"})
	public void verifyRegistration_VerifyPwdConfirmMsg() {

		logger.info("*****Starting TC004_AccountRegistration_VerifyPwdConfirmMsg*****");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link");
			hp.clickRegister();
			logger.info("Clicked on Register link");

			RegistrationPage regPage = new RegistrationPage(driver);

			logger.info("Providing customer details");
			regPage.setFistName(randomeString().toUpperCase());
			regPage.setLastName(randomeString().toUpperCase());
			regPage.setEmail(randomeString() + "@gmail.com");
			regPage.setTelephone(randomeNumber());

			String password = randomeAlphaNumberic();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password + randomeNumber());

			regPage.setPrivacyPolicy();
			regPage.clickContinue();

			logger.info("Validating password confimation message...");
			String actPswConfirmMsg = regPage.getPasswordConfirmMsg();

			// v.1
			if (actPswConfirmMsg.equals(p.getProperty("expPswConfirmMsg"))) {
				Assert.assertTrue(true);
				logger.info("Test passed");
			} else {
				logger.error("Test failed...");
				logger.info("Password Confirmation message mismatch");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}

			// v.2
//			Assert.assertEquals(actPswConfirmMsg, p.getProperty("expPswConfirmMsg"), "Password Confirmation message mismatch"); // actual and expected results																								
//			logger.info("Test passed");

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("*****Finished TC004_AccountRegistration_VerifyPwdConfirmMsg*****");
		}
	}
}
