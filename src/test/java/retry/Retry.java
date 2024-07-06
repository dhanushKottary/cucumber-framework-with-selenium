package retry;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private final int maxRetry = 2;
	private int  retryCount = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess()) {
			if(retryCount< maxRetry) {
				retryCount= retryCount + 1;
				return true;
			}
		}
		return false;
	}
	
	

}
