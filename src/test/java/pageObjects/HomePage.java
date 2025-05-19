package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//it will receive driver from Test classes 
	//it will pass driver to the Parent class constructor - BasePage
	public HomePage(WebDriver driver) {  
		super(driver);		
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']" )
	WebElement lnkMyAccount; 
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin; 
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearch; 
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch; 
	
	@FindBy(xpath = "//a[text()='Cameras']")
	WebElement lnkCameras;
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void setSearch(String product) {
		txtSearch.sendKeys(product);		
	}
	
	public void clickSearch() {
		btnSearch.click();		
	}
	
	public void clickCameras() {
		lnkCameras.click();
	}

}
