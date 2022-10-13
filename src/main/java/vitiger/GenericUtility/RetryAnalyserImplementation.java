package vitiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class will re try the failed test scripts due synchronisation or network issue
 * @author Admin
 *
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count=0;
	int retryCount=4;// manually try and then specify retry count
	public boolean retry(ITestResult result) {
		
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
