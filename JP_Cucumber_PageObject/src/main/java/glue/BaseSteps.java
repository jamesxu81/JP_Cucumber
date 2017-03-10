package glue;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.DriverFactory;
import pageObject.ResultPage;
import pageObject.SearchPage;
import utility.Utility;

public class BaseSteps {
	private WebDriver driver;

	ResultPage re;
	SearchPage se;

	@Before

	public void startUp() {
		System.out.println(System.getProperty("browser"));
		driver = new DriverFactory().getDriver();

	}

	@After()
	public void tearDown(Scenario scenario) {
		System.out.println(scenario.getStatus());
		if (scenario.isFailed()) {
			Utility.captureScreenshot(driver, scenario.getName());
		}

//		driver.close();
	}

	@Given("^I go to JP Home page$")
	public void i_go_to_JP_Home_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		se = new SearchPage(driver);
		se.open();
		se.waitFrom();
	}

	@When("^I fill \"([^\"]*)\", \"([^\"]*)\" and click search button$")
	public void i_fill_and_click_search_button(String from, String to) throws InterruptedException, AWTException {
		// Write code here that turns the phrase above into concrete actions
		re = se.searching(from, to);
		re.waitHop();
	}

	@Then("^I go to the result page with correct \"([^\"]*)\"$")
	public void i_go_to_the_result_page_with_correct(String fare) throws InterruptedException, AWTException {
		// Write code here that turns the phrase above into concrete actions

		re.printInfor();
		re.assertFares(fare);

	}

}
