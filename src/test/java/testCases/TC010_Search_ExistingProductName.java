package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC010_Search_ExistingProductName extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verifySearchExistingProductName() {

		logger.info("***** Starting TC010_Search_ExistingProductName *****");

		try {
			HomePage hp = new HomePage(driver);
			String productName = p.getProperty("searchProductName");
			hp.setSearch(productName);
			logger.info("Product name provided");
			hp.clickSearch();
			logger.info("Search button clicked");

			logger.info("Validating product displayed...");
			SearchPage sp = new SearchPage(driver);			
			boolean flag = sp.isProductDisplayed(productName);			
			
			Assert.assertEquals(flag, true, "Product is not displayed");
			logger.info("Test passed");
			
			//Assert.assertTrue(actResult);

		} catch (Exception e) {
			logger.error("Test failed..." + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC010_Search_ExistingProductName *****");
		}
	}
}
