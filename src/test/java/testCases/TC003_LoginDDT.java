package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelUtility;

public class TC003_LoginDDT extends BaseClass  {

	/*
	 * Data is valid - login success - test pass - logout
	 * Data is valid - login failed - test fail
	 * 
	 * Data is invalid - login success - test fail - logout 
	 * Data is invalid - login failed - test pass
	 */
		
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups= "DataDriven")
	public void verifyLoginDDT(String email, String password, String expResult) throws InterruptedException {

		logger.info("***** Starting TC003_LoginDDT ***** ");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();

			MyAccountPage macp = new MyAccountPage(driver);
			boolean targetPage = macp.isMyAccountPageExist();

			if (expResult.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					macp.clickLogout();
					Assert.assertTrue(true);					
				} else {
					Assert.assertTrue(false);
				}
			}

			if (expResult.equalsIgnoreCase("invalid")) {
				if (targetPage == true) {
					macp.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail();
		} finally {
			logger.info("***** Finished TC003_LoginDDT ***** ");
		}

	}

}
