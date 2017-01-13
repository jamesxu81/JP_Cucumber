package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	 protected static WebDriver driver;


	    public DriverFactory() {
	        initialize();
	    }

	    public void initialize() {
	        if (driver == null)
	            createNewDriverInstance();
	    }

	    private void createNewDriverInstance() {
//	        String browser = new PropertyReader().readProperty("browser");
	    	
	    	String browser = System.getProperty("browser");
	    	
//	    	String browser = "chrome";
	    	
	    	if (browser == null)
	    		browser = "firefox";
	    	
	    	
	    	switch (browser.toLowerCase()) {
	    	case "firefox":
	            driver = new FirefoxDriver();
	            break;
	    	case "chrome":
	            driver = new ChromeDriver();
	            break;
	    	case "ie":
	            driver = new InternetExplorerDriver();
	            break;
	    	default:
	    		 driver = new FirefoxDriver();
		            break;}
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }

	    public void destroyDriver() {
	        driver.quit();
	        driver = null;
	    }
	
	
}
