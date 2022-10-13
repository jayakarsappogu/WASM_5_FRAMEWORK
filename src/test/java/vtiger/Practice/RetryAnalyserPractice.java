package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = vitiger.GenericUtility.RetryAnalyserImplementation.class)
	public void retryPractice()
	{
		
		System.out.println("Hi");
		Assert.fail();
	}

}
