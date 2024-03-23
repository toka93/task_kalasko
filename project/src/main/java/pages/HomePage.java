package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void searchForProduct(String product)
	{
		By searchTextbox= createByElment(By::xpath,"//input[@id='twotabsearchtextbox']");
		waitUntilElementVisible(searchTextbox);
		WebElement searchTextboxElement=createWebElment(searchTextbox);
		searchTextboxElement.sendKeys(product);
		WebElement searchButton=createWebElment(By::xpath,"//input[@id='nav-search-submit-button']");
	
		searchButton.click();
	}
	
	
	
}
