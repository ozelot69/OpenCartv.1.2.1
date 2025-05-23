package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName; 
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword; 
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy; 
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue; 	
	
	@FindBy(xpath = "//div[text() = 'Password confirmation does not match password!']")
	WebElement msgPasswordConfirm; 
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement msgEmailWarning; 
	
	@FindBy(xpath = "//label[normalize-space()='No']")
	WebElement radioBtnYes; 	
	
	public void setFistName(String fname) {
		txtFirstName.sendKeys(fname); 		
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname); 		
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}

	public void setPrivacyPolicy() {
		chkdPolicy.click();
	}
	
	public void clickContinue() {
		//sol1 
		btnContinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
	
	public String getPasswordConfirmMsg() {
		try {
			return(msgPasswordConfirm.getText());			
		} catch(Exception e) {
			return(e.getMessage()); 
		}
	}
	
	public String getEmailWarningMessage() {
		try {
			return(msgEmailWarning.getText()); 
		} catch(Exception e) {
			return(e.getMessage()); 
		}
	}
	
	public void clickYesRadioBnt() {
		radioBtnYes.click();
	}
	
}
