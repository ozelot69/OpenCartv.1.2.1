package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(xpath = "//a[normalize-space()='iPhone']")
//	WebElement lnkProduct;

	@FindBy(xpath = "//div[@id = 'content']//div[3]//img")
	List<WebElement> searchProducts;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearch;

	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria')]")
	WebElement msgNoProduct;

	@FindBy(xpath = "//i[@class='fa fa-exchange']")
	WebElement lnkProdCompare;

	@FindBy(xpath = "//a[text()='product comparison']")
	WebElement lnkProdComparison;

//	public boolean IsProductDisplayed() {
//		try {
//			return (lnkProduct.isDisplayed());
//		} catch (Exception e) {
//			return (false);
//		}
//	}

	public boolean isProductDisplayed(String productName) {
		boolean flag = false;
		for (WebElement product : searchProducts) {
			if (product.getDomProperty("title").equalsIgnoreCase(productName)) {
				flag = true;
				break;
			}
		}
		return flag;

	}

	public boolean areMultProdDisplayed(String productName) {
		boolean flag = false;
		for (WebElement product : searchProducts) {
			if (product.getDomProperty("title").contains(productName)) {
				flag = true;
				break;
			}
		}
		return flag;

	}

	public boolean isNoProductMsgDisplayed() {
		try {
			return (msgNoProduct.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clearSearch() {
		txtSearch.clear();
	}

	public boolean numberOfProductsCorrect(int expNumberOfProducts) {
		boolean flag = false;
		if (searchProducts.size() == expNumberOfProducts) {
			flag = true;
		}
		return flag;

	}

	public void clickProdCompare() {
		lnkProdCompare.click();
	}

	public void clickProdComparison() {
		lnkProdComparison.click();
	}

	public void selectProduct(String productName) {
		for (WebElement product : searchProducts) {
			if (product.getDomProperty("title").equals(productName)) {
				product.click();
			}
		}

	}
	
//	public String numberOfProducts() {
//	try {
//		int numOfProducts = listProducts.size();
//		String strOfProducts = Integer.toString(numOfProducts);
//		return (strOfProducts);
//	} catch (Exception e) {
//		return (e.getMessage());
//	}
//}
	
	
}
