package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement txtQuantity;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btnAddToCart;

	@FindBy(xpath = "//div[contains(text(), 'Success: You have added')]")
	WebElement confirmMsg;

	@FindBy(xpath = "//div[@id='cart']")
	WebElement btnCart;
	
	@FindBy(xpath = "//strong[text()='View Cart']")
	WebElement lnkViewCart;

	public void setQuantity(String prodQuantity) {
		txtQuantity.clear();
		txtQuantity.sendKeys(prodQuantity);
	}

	public void clickAddToCart() {
		btnAddToCart.click();
	}

	public boolean isConfirmMsgDisplayed() {
		try {
			return confirmMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void navigateToCart() {
		btnCart.click();
		lnkViewCart.click();
	} 

}
