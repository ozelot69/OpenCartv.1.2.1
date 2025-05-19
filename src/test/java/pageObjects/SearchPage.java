package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='iPhone']")
	WebElement lnkProduct;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearch;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement msgNoProduct;
	
	@FindBy(xpath = "//div[@id = 'content']//a//img[contains(@title,'iP')]")
	List <WebElement> listProducts; 
	
	@FindBy(xpath = "//i[@class='fa fa-exchange']")
	WebElement lnkProdCompare; 
	
	@FindBy(xpath = "//a[text()='product comparison']")
	WebElement lnkProdComparison; 

	public boolean IsProductDisplayed() {
		try {
			return (lnkProduct.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public boolean IsNoProductMsgDisplayed() {
		try {
			return(msgNoProduct.isDisplayed());
		}catch(Exception e) {
			return(false);
		}
	}
		
	public void clearSearch() {
		txtSearch.clear();
	}
	
	public String numberOfProducts() {
		try {
		int numOfProducts = listProducts.size(); 
		String strOfProducts = Integer.toString(numOfProducts); 
		return(strOfProducts);	
		}catch(Exception e) {
			return(e.getMessage());
		}		
	}
	
	public void clickProdCompare() {
		lnkProdCompare.click();		
	}
	
	public void clickProdComparison() {
		lnkProdComparison.click();		
	}
}
