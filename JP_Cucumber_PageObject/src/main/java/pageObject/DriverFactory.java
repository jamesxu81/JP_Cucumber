package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	private WebDriver driver;

	public DriverFactory() {
		initialize();
	}

	public void initialize() {
		if (driver == null)
			createNewDriverInstance();
	}

	private void createNewDriverInstance() {

		String browser = System.getProperty("browser");

		if (browser == null)
			browser = "chrome";

		switch (browser.toLowerCase()) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "ie":
			// DesiredCapabilities cap = new DesiredCapabilities();
			// cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,
			// true);
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			dc.setCapability("ignoreProtectedModeSettings", true);
			driver = new InternetExplorerDriver(dc);
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void destroyDriver() {
		driver.quit();
		driver = null;
	}

}
