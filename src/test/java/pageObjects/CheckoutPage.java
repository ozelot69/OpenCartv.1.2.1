package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//form[@class='form-horizontal']//input[@value='new']")
	WebElement radioBtnNewAddress;

	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-payment-company']")
	WebElement txtCompany;

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	WebElement txtAddress1;

	@FindBy(xpath = "//input[@id='input-payment-address-2']")
	WebElement txtAddress2;

	@FindBy(xpath = "//input[@id='input-payment-city']")
	WebElement txtCity;

	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	WebElement txtPostalCode;

	@FindBy(xpath = "//select[@name='country_id']")
	WebElement drpCountry;

	@FindBy(xpath = "//select[@name='zone_id']")
	WebElement drpState;

	@FindBy(xpath = "//input[@id='button-payment-address']")
	WebElement btnContinueBillAddr;

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	WebElement btnContinueDelivAddr;

	@FindBy(xpath = "//textarea[@name='comment']")
	WebElement txtComments;

	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement btnContinueShippingMethod;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkboxAgree;

	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement btnContinuePaymentMethod;

	@FindBy(xpath = "//strong[text()='Total:']/following::td")
	WebElement lblTotalPrice;

	@FindBy(xpath = "//input[@id='button-confirm']")
	WebElement btnConfirm;

	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement lblOderConMsg;

	public void selectNewAddress() {
		radioBtnNewAddress.click();
	}

	public void setFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void setCompany(String company) {
		txtCompany.sendKeys(company);
	}

	public void setAddress1(String address1) {
		txtAddress1.sendKeys(address1);
	}

	public void setAddress2(String address2) {
		txtAddress2.sendKeys(address2);
	}

	public void setCity(String city) {
		txtCity.sendKeys(city);
	}

	public void setPostalCode(String postalCode) {
		txtPostalCode.sendKeys(postalCode);
	}

	public void setCountry(String country) {
		new Select(drpCountry).selectByVisibleText(country);
	}

	public void setState(String state) {
		new Select(drpState).selectByVisibleText(state);
	}

	public void clickOnContinueAfterBillingAddress() {
		btnContinueBillAddr.click();
	}

	public void clickOnContinueAfterDeliveryAddress() {
		btnContinueDelivAddr.click();
	}

	public void setDeliveryMethodComment(String deliveryMsg) {
		txtComments.sendKeys(deliveryMsg);
	}

	public void clickOnContinueAfterShippingMethod() {
		btnContinueShippingMethod.click();
	}

	public void selectTermsAndConditions() {
		chkboxAgree.click();
	}

	public void clickOnContinueAfterPaymentMethod() {
		btnContinuePaymentMethod.click();
	}

	public String getTotalPriceBeforeConfOrder() {
		return lblTotalPrice.getText();
	}

	public void clickOnConfirmOrder() {
		btnConfirm.click();
	}

	public boolean isOrderPlaced(String orderConfirmMsg) {
		try {
			if (lblOderConMsg.getText().equals(orderConfirmMsg)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

}
