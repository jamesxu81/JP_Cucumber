package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	// WebElement Search
	@FindBy(linkText = "Search")
	private WebElement search;

	// WebElement From
	@FindBy(name = "from")
	public WebElement from;

	// WebElement To
	@FindBy(name = "to")
	private WebElement to;

	// WebElement ArriveBy
	@FindBy(name = "arriveby")
	private WebElement arriveby;

	// WebElement Date
	@FindBy(name = "date")
	private WebElement date;

	// WebElement Time
	@FindBy(name = "ttwelve")
	private WebElement time;

	// WebElement ChangeSearch
	@FindBy(linkText = "Change search")
	private WebElement change_search;

	// WebElement Reset
	@FindBy(linkText = "Reset")
	private WebElement reset;

	
	
	// Open
	public SearchPage open() {
	this.driver.navigate().to("https://at.govt.nz/bus-train-ferry/journey-planner/");
	return new SearchPage(driver);
	}

	// Close
	public SearchPage close() {
	driver.quit();
	return new SearchPage(driver);
	}

	// Search
	public SearchPage searching(String f, String t) throws InterruptedException, AWTException {
		Robot robot_from = new Robot();
		robot_from.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);
		from.sendKeys(f);
		Thread.sleep(5000);
		robot_from.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot_from.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		to.sendKeys(t);
		Thread.sleep(5000);
		Robot robot_to = new Robot();
		robot_to.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot_to.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		search.click();
		return new SearchPage(driver);
	}

	// ArriveBy
	public SearchPage arriveBy(int option) throws InterruptedException, AWTException {
	Select select = new Select(arriveby);
	select.selectByIndex(option);
	return new SearchPage(driver);
	}

	// Data
	public SearchPage date(int option) throws InterruptedException, AWTException {
	Select select = new Select(date);
	select.selectByIndex(option);
	return new SearchPage(driver);
	}

	// Time
	public SearchPage time(String ti) throws InterruptedException, AWTException {
	time.clear();
	time.sendKeys(ti);
	return new SearchPage(driver);
	}

	// ChangeSearch
	public SearchPage changeSearch() {
	change_search.click();
	return new SearchPage(driver);
	}

	// Reset
	public SearchPage reset() {
	reset.click();
	return new SearchPage(driver);
	}

	// Wait
	public SearchPage waitFrom() {
	WebDriverWait wait = new WebDriverWait(driver, 3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("from")));
	return new SearchPage(driver);
	}
	
	public SearchPage waitHop() {
	WebDriverWait wait = new WebDriverWait(driver, 3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Change search")));
	return new SearchPage(driver);
	}

}
