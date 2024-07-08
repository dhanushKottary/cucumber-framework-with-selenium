package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dependencyinjection.Context;
import driver.driverManager.CreateDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStepDef {
	
	private WebDriver driver;
	private Context context;
	
	public AddToCartStepDef(Context context) {
		driver = CreateDriver.getInstance().getDriver();
		this.context = context;
	}
	
	@When("User added {string} item to cart")
	public void addToCart(String item) {
	    String addToCartPath = String.format("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='%s']/ancestor::div/following-sibling::div[@class='pricebar']/button", item);
	    WebElement addToCart = driver.findElement(By.xpath(addToCartPath));
	    context.SetContext("itemName", item);
	    addToCart.click();
	    
	}
	
	@Then("Verify the item is removed from the cart")
	public void verifyItemRemoved() {
		String addToCartPath = String.format("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='%s']/ancestor::div/following-sibling::div[@class='pricebar']/button", context.getContext("itemName"));
		WebElement addToCart = driver.findElement(By.xpath(addToCartPath));
		Assert.assertEquals(addToCart.getText(), context.getContext("addToCartText"));
	}

}
