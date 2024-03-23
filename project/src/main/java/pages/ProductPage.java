package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{

	
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ClickOnAddToCart()
	{
		By addToCartButton= createByElment(By::id,"add-to-cart-button");
		waitUntilElementVisible(addToCartButton);
		WebElement addToCartButtonElement= createWebElment(addToCartButton);
		addToCartButtonElement.click();
	}
	public void donotAddWarrenty()
	{
		By noThanksButton= createByElment(By::xpath,"//input[@class='a-button-input' and @aria-labelledby='attachSiNoCoverage-announce']");
		
		waitUntilElementVisible(noThanksButton);
		WebElement noThanksButtonElement= createWebElment(noThanksButton);
		
		noThanksButtonElement.click();
	}
	
	public void clickOnGoToBasket()
	{
		By goToBasketButton= createByElment(By::xpath,"(//*[@class='a-button-text' and contains(text(),'Go to basket')])[1]");
		waitUntilElementVisible(goToBasketButton);
		WebElement goToBasketButtonElement= createWebElment(goToBasketButton);
		goToBasketButtonElement.click();
	}
	
	
}
