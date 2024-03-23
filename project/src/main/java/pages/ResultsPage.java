package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage extends BasePage{

	
	public ResultsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void chooseFirstProduct()
	{
		By firstProduct= createByElment(By::xpath,"//*[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-component-type='s-search-result' and contains(@class,'col')]");
		waitUntilElementVisible(firstProduct);
		WebElement firstProductElement=createWebElment(firstProduct);
		
		firstProductElement.click();
	}
}
