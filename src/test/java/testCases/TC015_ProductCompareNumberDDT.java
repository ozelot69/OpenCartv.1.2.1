package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC015_ProductCompareNumberDDT extends BaseClass {

	@Test(dataProvider = "CompareProductNumber", dataProviderClass = DataProviders.class, groups = "DataDriven")

	public void verifyProductCompareNumberDDT(String productName, String number) {

		logger.info("***** Starting TC015_ProductCompareNumberDDT ***** ");

		try {

			HomePage hp = new HomePage(driver);
			hp.setSearch(productName);
			logger.info("Product name provided");
			hp.clickSearch();
			logger.info("Search button clicked");
			Thread.sleep(2000);

			SearchPage sp = new SearchPage(driver);
			sp.clickProdCompare();
			logger.info("Compare Product button clicked");
			Thread.sleep(2000);
			sp.clickProdComparison();
			logger.info("Comparison Product link clicked");

			logger.info("Verify number of products to compare");
			ProductComparePage pc = new ProductComparePage(driver);
			String actNumProdCompare = pc.numberOfProductsCompare();

			Assert.assertEquals(actNumProdCompare, number, "Number of products not correct");
			logger.info("Test passed");
			
		} catch (Exception e) {
			logger.error("Test failed...");
			Assert.fail();
		} finally {
			logger.info("***** Finished TC014_ProductCompareNameDDT *****");
		}
	}

}
