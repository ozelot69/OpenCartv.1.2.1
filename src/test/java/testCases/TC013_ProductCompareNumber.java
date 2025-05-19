package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CamerasPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import testBase.BaseClass;

public class TC013_ProductCompareNumber extends BaseClass {

	@Test(groups = "Master")
	public void verifyProductCompareNumber() {

		logger.info("***** Starting TC013_ProductCompareNumber ***** ");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickCameras();
		logger.info("Clicked Cameras link");

		CamerasPage cp = new CamerasPage(driver);
		cp.clickCompareCanon();
		logger.info("Clicked compare Canon");
		cp.clickCompareNikon();
		logger.info("Clicked compare Nikon");
		cp.clickProdCompare();
		Thread.sleep(3000);
		logger.info("Clicked product compare");

		logger.info("Verify number of products to compare");
		ProductComparePage pc = new ProductComparePage(driver);
		String actNumProdCompare = pc.numberOfProductsCompare();

		Assert.assertEquals(actNumProdCompare, "2", "Number of products not correct");
		logger.info("Test passed");
		
		}catch(Exception e){
			logger.error("Test failed...");
			Assert.fail();			
		}finally {
			logger.info("***** Finished TC013_ProductCompareNumber *****");		
		}
	}
}
