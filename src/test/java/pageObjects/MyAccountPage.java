package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class = 'list-group']//a[text() = 'Logout']")
	WebElement lnkLogout; 
	
	@FindBy(xpath = "//a[normalize-space()='Subscribe / unsubscribe to newsletter']")
	WebElement lnkNewsletterSub;
	
	@FindBy(xpath = "//span[normalize-space()='My Account']" )
	WebElement lnkMyAccount; 
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")
	WebElement lnkLogout2; 
	
	public boolean isMyAccountPageExist() {
		try {
			return(msgHeading.isDisplayed());
		}
		catch(Exception e){
			return(false); 			
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
	public void clickNewsletterSub() {
		lnkNewsletterSub.click();
	}	
	
	public void clickMyAccount() {
		lnkMyAccount.click();		
	}
	
	public void clickLogout2() {
		lnkLogout2.click();
	}

}
