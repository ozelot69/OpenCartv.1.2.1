package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[text()='Account Logout']")
	WebElement pageHeading;

	public boolean isLogoutPageExist() {
		try {
			return pageHeading.isDisplayed();
		} catch (Exception e) {
			return (false);
		}
	}	
	
	public String getTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	public String getCurrentUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
