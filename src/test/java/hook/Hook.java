package hook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	
	
	
   public static WebDriver driver;
	
	@Before
	public void launchDriverInstance(Scenario scenario) throws IOException {
		String browser = getBrowser();
		switch(browser){
		   case "chrome": 
			   driver = new ChromeDriver();
			   break;
		   case "firefox": 
			   driver = new FirefoxDriver();
			   break;	   
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		driver.quit();
	}
	
	
	public String getBrowser() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\test.properties");
		Properties props = new Properties();
		props.load(fis);
		return props.getProperty("browser");
	}

}
