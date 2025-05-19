package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparePage extends BasePage {

	public ProductComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//table//tbody[1]//tr[1]//td")
	List<WebElement> listProductsCompare;
	
	@FindBy(xpath = "//table//tbody[1]//tr[1]//td[2]")
	WebElement txtProductName;
	
	@FindBy(xpath = "//a[text()='Remove']")
	WebElement btnRemove; 
	
	@FindBy(xpath = "//a[text()='Qafox.com']")
	WebElement lnkLogo; 

	public String numberOfProductsCompare() {
		try {
			int numOfProducts = listProductsCompare.size();
			String strOfProducts = Integer.toString(numOfProducts - 1);
			return (strOfProducts);
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	public String productName() {
		try {
		return txtProductName.getText();
		}catch(Exception e){
			return(e.getMessage());
		}
		
	}
	
	public void clickRemove() {
		btnRemove.click();		
	}
	
	public void clickLogo() {
		lnkLogo.click();		
	}

}
