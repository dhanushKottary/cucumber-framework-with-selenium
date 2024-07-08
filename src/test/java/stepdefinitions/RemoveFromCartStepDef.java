package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dependencyinjection.Context;
import driver.driverManager.CreateDriver;
import io.cucumber.java.en.Then;

public class RemoveFromCartStepDef {
	
	private WebDriver driver;
	private Context context;
	
	public RemoveFromCartStepDef(Context context) {
		driver = CreateDriver.getInstance().getDriver();
		this.context = context;
	}
	
	@Then("User removed item from the cart")
	public void removeItemFromCart() {
		String removeFromCartPath = String.format("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='%s']/ancestor::div/following-sibling::div[@class='pricebar']/button", context.getContext("itemName"));
		WebElement removeFromCart = driver.findElement(By.xpath(removeFromCartPath));
		removeFromCart.click();
		String addToCartPath = String.format("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='%s']/ancestor::div/following-sibling::div[@class='pricebar']/button", context.getContext("itemName"));
		WebElement addToCart = driver.findElement(By.xpath(addToCartPath));
		context.SetContext("addToCartText", addToCart.getText());
	}

}
