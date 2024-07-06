package runner;



import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = {"src/test/resources"},
	glue = {"stepdefinitions", "hook"},
	tags = "@testNGParallel",
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed.txt"}
)
public class UITestRunnerTestNG extends AbstractTestNGCucumberTests{
	
	
	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before execution of suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("in after suite");
    }


    @BeforeClass
    public void beforeClass(ITestContext context) {
        System.out.println("before class");
        //context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(2);
    }


    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }
    
    @BeforeTest
    public void beforeTest(ITestContext context) {
        System.out.println("before test");
        //context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(2);
    }


    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }
    
    
}
