package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC016_AddToCart extends BaseClass {

	@Test(groups = "Master")
	public void verifyAddToCart() {

		logger.info("***** Starting TC016_AddToCart *****");

		try {
			HomePage hp = new HomePage(driver);
			String productName = p.getProperty("searchProductName");
			hp.setSearch(productName);
			logger.info("Product name provided");
			hp.clickSearch();
			logger.info("Search button clicked");			

			SearchPage sp = new SearchPage(driver);
			ProductPage pp = new ProductPage(driver);
			String prodQuantity = p.getProperty("quantity");
			
			if(sp.isProductDisplayed(productName)) {
				sp.selectProduct(productName);
				logger.info("Product selected");
				pp.setQuantity(prodQuantity);
				logger.info("Quantity entered");
				pp.clickAddToCart();
				logger.info("Add to Cart button selected");
			}
			
			Thread.sleep(3000);

			logger.info("Verifying confirmation message displayed");			
			Assert.assertEquals(pp.isConfirmMsgDisplayed(), true, "Confirmation message is not displayed");
			logger.info("Test passed");

		} catch (Exception e) {
			logger.error("Test failed..." + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC016_AddToCart *****");
		}

	}
}
