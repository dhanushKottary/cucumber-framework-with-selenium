package hook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import driver.driverManager.CreateDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	
	
	
   public WebDriver driver;
	
	@Before
	public void launchDriverInstance(Scenario scenario) throws IOException {
//		String browser = getBrowser();
//		switch(browser){
//		   case "chrome": 
//			   driver = new ChromeDriver();
//			   break;
//		   case "firefox": 
//			   driver = new FirefoxDriver();
//			   break;	   
//		}
		String browser = getBrowser();
		CreateDriver.getInstance().setDriver(browser);
		driver = CreateDriver.getInstance().getDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		driver.quit();
	}
	
    @AfterStep
    public void afterStep(Scenario scenario) {
       	 TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
       	 byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
   	    LocalDateTime myDateObj = LocalDateTime.now();
   	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
   	    String imageName = "image-"+myDateObj.format(myFormatObj);
       	scenario.attach(screenshot, "image/png", imageName);

    	 
    }
	
	
	public String getBrowser() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\test.properties");
		Properties props = new Properties();
		props.load(fis);
		return props.getProperty("browser");
	}

}
