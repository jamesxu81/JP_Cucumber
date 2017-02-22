package pageObject;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	//Simulate Manual Typing
	public void Typing(WebElement element, String value) throws InterruptedException{
	    String val = value; 
	    element.clear();

	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        Thread.sleep(100);
	        element.sendKeys(s);
	    }       
	}
	
	
	// Search
	public ResultPage searching(String f, String t) throws InterruptedException, AWTException {
		from.click();
		Typing(from, f);
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		to.click();
		Typing(to, t);
		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);
		search.click();
		return new ResultPage(driver);
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

	

}
