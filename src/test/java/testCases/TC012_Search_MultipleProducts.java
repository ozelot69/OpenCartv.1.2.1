package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelUtility;

public class TC012_Search_MultipleProducts extends BaseClass  {

	/*
	 * Data is valid - login success - test pass - logout
	 * Data is valid - login failed - test fail
	 * 
	 * Data is invalid - login success - test fail - logout 
	 * Data is invalid - login failed - test pass
	 */
		
	@Test(groups= "Master")
	public void verifySearchMultipleProducts() throws InterruptedException {

		logger.info("***** Starting TC012_Search_MultipleProducts ***** ");

		try {
			HomePage hp = new HomePage(driver);
			hp.setSearch(p.getProperty("searchMultipleProducts")); 
			logger.info("Product name provided");
			hp.clickSearch();
			logger.info("Search button clicked");

			logger.info("Validating multiple products displayed...");
			SearchPage sp = new SearchPage(driver);
			//boolean msgDisplayed = sp.IsNoProductMsgDisplayed();
			String actNumberOfProducts = sp.numberOfProducts();
			String expNumberOfProducts = p.getProperty("searchNumberOfProducts");
			
			Assert.assertEquals(actNumberOfProducts, expNumberOfProducts, "Number of products not correct");
			logger.info("Test passed");			

		} catch (Exception e) {
			logger.error("Test failed...");
			Assert.fail();
		} finally {
			logger.info("***** Finished TC012_Search_MultipleProducts *****");
		}
	}

}
