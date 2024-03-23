package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.ExtentManager;
import static util.ConfigReader.*;

public class BaseTest {
	protected static ExtentReports extent;
	
	public ExtentTest child;
	private final static Logger log = LogManager.getLogger();
	protected WebDriver driver;
	// move url to file
	protected static String appURL = getWebsiteConfig("website_url");
	protected static String headless = getWebsiteConfig("headless");
	protected static String browser = getWebsiteConfig("browser");

	@BeforeSuite(alwaysRun = true)
	public void oneTimeSetup() {
		log.info("before suite");
		extent = ExtentManager.createInstance();

	}

	public void startDriver() {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// .clearDriverCache().setup();

			log.info("start the chrome driver ");
			driver = new ChromeDriver(chromeOption());

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOption());

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(appURL);

	}

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.tabs.remote.autostart", false);
		option.addPreference("browser.tabs.remote.autostart.1", false);
		option.addPreference("browser.tabs.remote.autostart.2", false);
		option.addPreference("browser.tabs.remote.force-enable", "false");

		return option;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-features=VizDisplayCompositor");
		// added for netty exception
		options.addArguments("--remote-allow-origins=*");
		LoggingPreferences loggingprefs = new LoggingPreferences();
		loggingprefs.enable(LogType.BROWSER, Level.ALL);
		options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, "accept");

		if (headless.equalsIgnoreCase("true")) {
			options.addArguments("--headless");
			options.addArguments("start-maximized");
			options.addArguments("--window-size=1920,1080");

		} else if (headless.equalsIgnoreCase("false")) {

		}

		return options;

	}

	@AfterMethod(alwaysRun = true)
	public void closeApp(ITestResult res) {

		log.info("get status of test just run");
		if (res.getStatus() == ITestResult.SUCCESS) {
			log.info("test passes");
		} else if (res.getStatus() == ITestResult.FAILURE) {
			log.info("test failed");
			child.log(Status.FAIL, "Test failed ");
		} else if (res.getStatus() == ITestResult.SKIP) {
			log.info("test skipped ");
			child.log(Status.SKIP, "Test skipped");
		} else {
			log.info("test finished with status other than (pass,fail,skip) ");
			child.log(Status.ERROR, "Test skipped");
		}
		log.info("close driver browser in after method");

		driver.quit();
	}

	@AfterClass(alwaysRun = true)
	public void endSuite() throws IOException {
		log.info("end report in after class");
		extent.flush();

	}
}
