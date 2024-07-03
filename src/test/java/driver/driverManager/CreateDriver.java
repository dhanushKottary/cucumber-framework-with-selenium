package driver.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {
	
	private WebDriver driver;
	
	private static CreateDriver instance;
	
	private CreateDriver() {
		
	}
	
	public static CreateDriver getInstance() {
		if(instance == null) {
			instance = new CreateDriver();
		}
		return instance;
	}
	
	public void setDriver(String browser) {
		driver = DriverManager.getBrowserManager(browser).getDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
