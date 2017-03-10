package pageObject;

//import static org.testng.AssertJUnit.assertEquals;

import org.junit.Assert;
import java.awt.AWTException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage extends BasePage {
	public ResultPage(WebDriver driver) {
		super(driver);

	}

	// WebElement Price
//	@FindBy(xpath = "//*[contains(@id,'journey')]/a/div[2]/span[3]/b")
	@FindBy(className = "price")
	private WebElement price;

	// WebElement Prices
	@FindBy(className = "price")
	private List<WebElement> prices;

	// WebElement Lines
	@FindBy(xpath = "//*[contains(@id,'journey')]/a/div[2]")
	private List<WebElement> lines;

	// WebElement RouteName
//	@FindBy(xpath = "//div[@class='departArrive']/strong")
	@FindBy(className = "departArrive")
	private WebElement routeName;

	// WebElement Departs
//	@FindBy(xpath = "//*[contains(@id,'journey')]/a/div[1]/span[1]/b")
	@FindBy(className = "nextdeparture")
	private List<WebElement> departs;

	// WebElement Durations
	@FindBy(xpath = "//*[contains(@id,'journey')]/a/div[1]/span[2]")
//	@FindBy(className = "duration")
	private List<WebElement> durations;

	// GetPrice
	public String getPrice() {
		return price.getText();
	}

	// GetRouteName
	public String getRouteName() {
		return routeName.getText();
	}

	// Wait
	public ResultPage waitHop() {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Change search")));
		return new ResultPage(driver);
	}

	// ReplaceBlank
	public String replaceBlank(String s) {
		Pattern p = Pattern.compile("   |\r|\n");
		Matcher m = p.matcher(s);
		String after = m.replaceAll(" ");
		return after;
	}

	// PrintInformation
	public ResultPage printInfor() {
		System.out.println("Route :" + getRouteName());
		for (int i = 0; i < prices.size(); i++)
			System.out.println(departs.get(i).getText() + "   Duration:  " + durations.get(i).getText()
					+ "  Line&Fare:  " + replaceBlank(lines.get(i).getText()));
		return new ResultPage(driver);
	}

	// AssertFare
	public ResultPage assertFares(String fare) throws InterruptedException, AWTException {
		// for (int i = 0; i < prices.size(); i++)
		// Assert.assertEquals(fare, prices.get(i).getText());
		for (WebElement e : prices)
		Assert.assertEquals(fare, e.getText());
		return new ResultPage(driver);
	}

}
