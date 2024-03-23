package tests;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.testng.annotations.*;

import pages.HomePage;
import pages.ProductPage;
import pages.ResultsPage;
import pages.ShoppingCartPage;
import util.ExtentManager;
import util.JsonDataReader;

public class AmazonTest extends BaseTest {

	HomePage homePage;
	ResultsPage resultsPage;
	ProductPage productPage;
	ShoppingCartPage shopppingCartPage;

	@BeforeMethod(alwaysRun = true)
	public void setup(Method method) {
		startDriver();
		homePage = new HomePage(driver);
		resultsPage = new ResultsPage(driver);
		productPage = new ProductPage(driver);
		shopppingCartPage = new ShoppingCartPage(driver);

	}

	@Test
	public void Validate_Adding_Product_to_Cart(Method method) {
		String methodname = method.getName();
		child = extent.createTest(methodname);
		ExtentManager.logsreportsinfo(child, "Open Amazon Home Page");
		String product = JsonDataReader.getValue("Product");
		homePage.searchForProduct(product);
		ExtentManager.logsreportsinfo(child, "Search for: " + product);
		resultsPage.chooseFirstProduct();
		productPage.ClickOnAddToCart();
		ExtentManager.logsreportsinfo(child, "Add product to the cart");
		productPage.donotAddWarrenty();
		productPage.clickOnGoToBasket();
		String productTitle = shopppingCartPage.getProductTitle();
		boolean flag = productTitle.contains(product);
		ExtentManager.logsreportsinfo(child, "Product added in the shopping cart ",flag);
		assertTrue(flag);
	}

}
