package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail; 
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword; 
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin; 
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement msgWarningCreadentials;
	
	@FindBy(xpath = "//div[@class='form-group']//a[text()='Forgotten Password']")
	WebElement lnkForgotPassword; 
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msgConfirmationEmail; 
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click(); 
	}	
	
	public String getWarningCreadentialsMsg() {
		try{
			return msgWarningCreadentials.getText();		
		}catch(Exception e) {
			return(e.getMessage()); 
		}		
	}
	
	public void clickForgotPassword() {
		lnkForgotPassword.click();
	}
	
	public String getConfirmationEmailMsg() {
		try {
			return msgConfirmationEmail.getText();
		}catch(Exception e) {
			return(e.getMessage()); 
		}
	}

}
