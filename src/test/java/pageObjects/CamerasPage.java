package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CamerasPage extends BasePage{

	public CamerasPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath = "//div[@id='content']//div[contains(@class,'product-layout')][1]//button[3]")
	WebElement lnkCompareFirst; 
	
	@FindBy(xpath = "//div[@id='content']//div[contains(@class,'product-layout')][2]//button[3]")
	WebElement lnkCompareSecond;
	
	@FindBy(xpath = "//a[text()='product comparison']")
	WebElement lnkProdCompare; 
	
	public void clickCompareCanon() {
		lnkCompareFirst.click();;
	}
	
	public void clickCompareNikon() {
		lnkCompareSecond.click();;
	}
	
	public void clickProdCompare() {
		lnkProdCompare.click();		
	}

}
