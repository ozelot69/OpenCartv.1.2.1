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
			hp.setSearch(p.getProperty("searchProductName"));
			logger.info("Product name provided");
			hp.clickSearch();
			logger.info("Search button clicked");

			logger.info("Validating product displayed...");
			SearchPage sp = new SearchPage(driver);
			boolean productDisplayed = sp.IsProductDisplayed();

			
			//Assert.assertTrue(productDisplayed);
			Assert.assertEquals(productDisplayed, true, "Product is not displayed");
			logger.info("Test passed");

		} catch (Exception e) {
			logger.error("Test failed...");
			Assert.fail();
		} finally {
			logger.info("***** Finished TC010_Search_ExistingProductName *****");
		}
	}
}
