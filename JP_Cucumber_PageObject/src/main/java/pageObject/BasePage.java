package pageObject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void closeDriver() {
		driver.quit();

	}
	
	 public BasePage navigateTo() {
		    driver.navigate().to("https://at.govt.nz/bus-train-ferry/journey-planner/");
		    driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		    assertThat(driver.getTitle(), containsString("Journey"));
		    return new BasePage(driver);
		  }


}


