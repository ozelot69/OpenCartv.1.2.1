package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationConfirmPage extends BasePage {

	public RegistrationConfirmPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgRegConfirm;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnContinue;

	public String getRegConfirmMsg() {
		try {
			return (msgRegConfirm.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}

	public void clickContinue() {
		btnContinue.click();
	}
}
