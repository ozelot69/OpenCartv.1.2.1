package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationConfirmPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC006_Registration_YesSelected extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verifyRegistration_YesSelected() {

		logger.info("*****Starting TC006_Registration_YesSelected*****");

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
			regPage.setConfirmPassword(password);
			
			regPage.clickYesRadioBnt();
			regPage.setPrivacyPolicy();
			regPage.clickContinue();

			logger.info("Validating expected message...");
			
			RegistrationConfirmPage regConfPage = new RegistrationConfirmPage(driver); 
			String actRegConfirmMsg = regConfPage.getRegConfirmMsg();

			// v.1
//			if (confirmMsg.equals("Your Account Has Been Created!!!")) {
//				Assert.assertTrue(true);
//				logger.info("Test passed");
//			} else {
//				logger.error("Test failed...");
//				logger.info("Confirmation message mismatch");
//				logger.debug("Debug logs...");
//				Assert.assertTrue(false);
//			}

			// v.2
			Assert.assertEquals(actRegConfirmMsg, p.getProperty("expRegConfirmMsg"), "Confirmation message mismatch"); // actual and expected results																								
			logger.info("Test passed");

		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("*****Finished TC001_AccountRegistrationTest*****");
		}
	}
}
