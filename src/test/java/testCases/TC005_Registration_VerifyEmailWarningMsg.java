package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC005_Registration_VerifyEmailWarningMsg extends BaseClass {

	@Test(groups = { "Master" })
	public void verifyRegistration_VerifyEmailWarningMsg() {

		logger.info("*****Starting TC005_AccountRegistration_VerifyEmailWarningMsg*****");

		try {
			HomePage hp = new HomePage(driver);
			logger.info("Click on MyAccount link");
			hp.clickMyAccount();

			logger.info("Click on Registration link");
			hp.clickRegister();

			logger.info("Provide customer details");
			RegistrationPage regPage = new RegistrationPage(driver);
			regPage.setFistName(randomeString().toUpperCase());
			regPage.setLastName(randomeString().toUpperCase());
			regPage.setEmail(p.getProperty("email"));
			regPage.setTelephone(randomeNumber());

			String password = randomeAlphaNumberic();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);

			regPage.setPrivacyPolicy();
			regPage.clickContinue();

			logger.info("Validating email warning message...");
			String actEmailWarningMsg = regPage.getEmailWarningMessage();

//			if (emailWarningMsg.equals("Warning: E-Mail Address is already registered!")) {
//				Assert.assertTrue(true);
//				logger.info("Test passed");
//			} else {
//				logger.error("Test failed..");
//				logger.info("Email warning message mismatch");
//				logger.debug("Debug logs...");
//				Assert.assertTrue(false);
//			}

			Assert.assertEquals(actEmailWarningMsg, p.getProperty("expEmailWarningMsg"),
					"Email warning message mismatch");
			logger.info("Test passed");

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("*****Finished TC005_AccountRegistration_VerifyEmailWarningMsg*****");
		}
	}
}
