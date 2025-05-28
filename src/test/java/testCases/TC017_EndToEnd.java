package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductPage;
import pageObjects.RegistrationConfirmPage;
import pageObjects.RegistrationPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC017_EndToEnd extends BaseClass {

	@Test(groups = { "Master" })
	public void endToEndTest() throws InterruptedException {

		logger.info("***** Starting TC017_EndToEnd *****");

		try {
		SoftAssert myAssert = new SoftAssert();

		// Account Registration
		System.out.println("***** Account Registration *****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on Register link");

		RegistrationPage regPage = new RegistrationPage(driver);

		logger.info("Providing customer details");
		String firstName = randomeString().toUpperCase();
		regPage.setFistName(firstName);
		String lastName = randomeString().toUpperCase();
		regPage.setLastName(lastName);
		String email = randomeString() + "@gmail.com"; // randomly generated email
		regPage.setEmail(email);
		regPage.setTelephone(randomeNumber());
		String password = randomeAlphaNumberic(); // randomly generated password
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);

		regPage.setPrivacyPolicy();
		regPage.clickContinue();

		logger.info("Validating expected message...");
		RegistrationConfirmPage regConfPage = new RegistrationConfirmPage(driver);
		String actRegConfirmMsg = regConfPage.getRegConfirmMsg();

		System.out.println("Going to My Account Page? " + actRegConfirmMsg);
		myAssert.assertEquals(actRegConfirmMsg, p.getProperty("expRegConfirmMsg"), "Registration Confirmation message mismatch");
		// logger.info("Test passed");

		MyAccountPage macp = new MyAccountPage(driver);
		macp.clickLogout();

		// Login
		System.out.println("***** Loging to application *****");
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickLogin();
		logger.info("Clicked in Login link");

		logger.info("Providing credentials");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(5000);

		logger.info("Validating AccountPage displayed...");
		boolean targetPage = macp.isMyAccountPageExist();
		System.out.println("Going to My Account Page? " + targetPage);
		myAssert.assertEquals(targetPage, true, "AccountPage is not displayed");
		// logger.info("Test passed");

		// Search & Add product to cart
		System.out.println("***** Search & add product to cart ******");
		String productName = p.getProperty("searchProductName");
		hp.setSearch(productName);
		logger.info("Product name provided");
		hp.clickSearch();
		Thread.sleep(3000);
		logger.info("Search button clicked");

		logger.info("Validating product displayed...");
		SearchPage sp = new SearchPage(driver);
		ProductPage pp = new ProductPage(driver);

		if (sp.isProductDisplayed(productName)) {
			sp.selectProduct(productName);
			logger.info("Product selected");
			pp.setQuantity(p.getProperty("quantity"));
			logger.info("Quantity entered");
			pp.clickAddToCart();
			logger.info("Add to Cart button selected");
		}
		Thread.sleep(3000);

		System.out.println("Added product to cart ? " + pp.isConfirmMsgDisplayed());
		logger.info("Verifying confirmation message displayed");
		myAssert.assertEquals(pp.isConfirmMsgDisplayed(), true, "Added Product Confirmation message is not displayed");
		// logger.info("Test passed");
		pp.navigateToCart(); //navigate to shopping cart

		// Shopping cart
		System.out.println("***** Shopping cart *****");
		ShoppingCartPage sc = new ShoppingCartPage(driver); 		
		String totalPrice = sc.getTotalPrice(); 
		System.out.println("total price is shopping cart: "+ p.getProperty("totalPriceShoppingCart"));
		myAssert.assertEquals(totalPrice, p.getProperty("totalPriceShoppingCart"), "Price is not correct");		
		sc.navigateToCheckout(); //navigate to checkout
		
		//Checkout Product
		System.out.println(" *****Checkout Product *****");
		CheckoutPage ch = new CheckoutPage(driver);
		//ch.selectNewAddress();
		ch.setFirstName(firstName);
		ch.setLastName(lastName);
		ch.setCompany(p.getProperty("company"));
		ch.setAddress1(p.getProperty("address1"));
		ch.setAddress2(p.getProperty("address2"));
		ch.setCity(p.getProperty("city"));
		ch.setPostalCode(p.getProperty("postalCode"));
		ch.setCountry(p.getProperty("country"));
		ch.setState(p.getProperty("state"));
		ch.clickOnContinueAfterBillingAddress();
		ch.clickOnContinueAfterDeliveryAddress();
		ch.setDeliveryMethodComment(p.getProperty("deliveryMsg"));
		ch.clickOnContinueAfterShippingMethod(); 
		ch.selectTermsAndConditions(); 
		ch.clickOnContinueAfterPaymentMethod(); 
		Thread.sleep(3000);
		
		String totalPriceOrderPage = ch.getTotalPriceBeforeConfOrder(); 
		System.out.println("total price in confirmed order page:"+ p.getProperty("totalPriceOrderPage"));
		
		ch.clickOnConfirmOrder(); 
		Thread.sleep(3000);
		
		boolean orderConfirm = ch.isOrderPlaced(p.getProperty("orderConfirmMsg")); 
		System.out.println("Is Order Placed? "+ orderConfirm);
		myAssert.assertEquals(orderConfirm, true, "Order is not placed");
		
		myAssert.assertAll();
		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC017_EndToEnd *****");
		}		

	}

}
