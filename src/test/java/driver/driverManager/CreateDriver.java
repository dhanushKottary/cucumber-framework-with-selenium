package driver.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {
	
	//private  WebDriver driver;
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	private static CreateDriver instance;
	
	private CreateDriver() {
		
	}
	
	public static synchronized CreateDriver getInstance() {
		if(instance == null) {
			instance = new CreateDriver();
		}
		return instance;
	}
	
	public void setDriver(String browser) {
		//driver = DriverManager.getBrowserManager(browser).getDriver();
		driver.set(DriverManager.getBrowserManager(browser).getDriver());
	}
	
	public WebDriver getDriver() {
		//return driver;
		return driver.get();
	}

}
