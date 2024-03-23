package pages;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	 public final WebDriver driver;
	    public final WebDriverWait wait;

		public BasePage(WebDriver driver) {
			 this.driver = driver;
		        wait = new WebDriverWait(driver,Duration.ofSeconds(60));

			
		}
		public  WebElement createWebElment( Function<String, By> locatorStrategy, String locator) {
			return driver.findElement(locatorStrategy.apply(locator));
		}
		public  By createByElment( Function<String, By> locatorStrategy, String locator) {
			return locatorStrategy.apply(locator);
		}
		public  WebElement createWebElment( By element) {
			return driver.findElement(element);
		}
	
		public void waitUntilElementVisible(By by) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    }
}
