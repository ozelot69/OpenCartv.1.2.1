package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CamerasPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC014_ProductCompareNameDDT extends BaseClass {

	@Test(dataProvider = "CompareProductName", dataProviderClass = DataProviders.class, groups = "DataDriven")
	public void verifyProductCompareName(String productName) {

		logger.info("***** Starting TC014_ProductCompareNameDDT ***** ");

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

			logger.info("Verify product is added to Compare page");
			ProductComparePage pc = new ProductComparePage(driver);
			String actProdName = pc.productName();
			
			if(actProdName.equalsIgnoreCase(productName)) {
				pc.clickRemove();
				pc.clickLogo();
				Assert.assertTrue(true);				
			}else{
				Assert.assertTrue(false);
			}	

		} catch (Exception e) {
			logger.error("Test failed...");
			Assert.fail();
		} finally {
			logger.info("***** Finished TC014_ProductCompareNameDDT *****");
		}
	}
}
