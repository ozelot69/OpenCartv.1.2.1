package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver; 
	
	//parent class constructor - will receive driver from child class - HomePage and initiate driver
	public BasePage(WebDriver driver) { 
		this.driver = driver; 
		PageFactory.initElements(driver, this);		
	}

}
