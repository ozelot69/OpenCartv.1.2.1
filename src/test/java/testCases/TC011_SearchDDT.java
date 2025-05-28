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

public class TC011_SearchDDT extends BaseClass  {

	/*
	 * Data is valid - login success - test pass - logout
	 * Data is valid - login failed - test fail
	 * 
	 * Data is invalid - login success - test fail - logout 
	 * Data is invalid - login failed - test pass
	 */
		
	@Test(dataProvider = "SearchProducts", dataProviderClass = DataProviders.class, groups= "DataDriven")
	public void verifyLoginDDT(String productName, String expResult) throws InterruptedException {

		logger.info("***** Starting TC011_SearchDDT ***** ");

		try {
			HomePage hp = new HomePage(driver);
			hp.setSearch(productName); 
			logger.info("Product name provided");
			hp.clickSearch();
			logger.info("Search button clicked");

			logger.info("Validating product displayed...");
			SearchPage sp = new SearchPage(driver);
			boolean msgDisplayed = sp.isNoProductMsgDisplayed();
			
			if(expResult.equalsIgnoreCase("yes")) {
				if(msgDisplayed==true) {					
					sp.clearSearch();
					Assert.assertTrue(false);
				}else {
					sp.clearSearch();
					Assert.assertTrue(true);					
				}
			}
			
			if(expResult.equalsIgnoreCase("no")) {
				if(msgDisplayed ==true) {					
					sp.clearSearch();
					Assert.assertTrue(true); 
				}else {
					sp.clearSearch();
					Assert.assertTrue(false);					
				}
			}
			//Thread.sleep(3000);
				
			//Assert.assertTrue(msgDisplayed);
//			Assert.assertEquals(msgDisplayed, true, "Product is not displayed");
//			logger.info("Test passed");

		} catch (Exception e) {
			logger.error("Test failed..." + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC011_SearchDDT *****");
		}
	}

}
