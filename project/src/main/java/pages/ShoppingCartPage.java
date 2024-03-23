package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage{

	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getProductTitle()
	{
		By productTitle= createByElment(By::xpath,"(//*[@class='a-truncate sc-grid-item-product-title a-size-base-plus']/span)[2]");
		waitUntilElementVisible(productTitle);
		WebElement productTitleElement=createWebElment(productTitle);
	return	productTitleElement.getText();
	}
}
