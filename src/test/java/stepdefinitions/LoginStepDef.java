package stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import hook.Hook;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static hook.Hook.driver;

public class LoginStepDef{
	
//	private WebDriver driver;
//	
//	public LoginStepDef() {
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	}
	
	private LoginPage loginPage;
	
	@Given("User has launched the login URL {string}")
	public void launchURL(String url) {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Launching the URL");
	    driver.get(url);
	}

	@Given("User has entered credentials")
	public void user_has_entered_credentials(DataTable dataTable) {
		List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Entering the credentials");
		loginPage = new LoginPage(driver);
		loginPage.username.sendKeys(credentials.get(0).get("username"));
        loginPage.password.sendKeys(credentials.get(0).get("password"));
	}

	@When("User has clicked login button")
	public void clickLoginButton() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Clicking the login button");
		loginPage.loginButton.click();
	}

	@Then("User lands on {string} page")
	public void pageDisplayed(String page) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Check if Products page is displayed");
		driver.findElement(By.cssSelector("div.product_label")).isDisplayed();
		//Assertion code
	}

	@Then("Error message {string} is displayed")
	public void loginErrorMessaage(String errorMessage) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Check if error message is displayed");
		loginPage.errorMessage.isDisplayed();
		//Assertion code
	}

}
