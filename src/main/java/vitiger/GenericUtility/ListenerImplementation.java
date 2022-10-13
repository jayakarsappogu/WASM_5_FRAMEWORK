package vitiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class acts like implementation class to override all the methods
 * present in ITest listener interface
 * @author Admin
 *
 */

public class ListenerImplementation implements ITestListener 
{
	ExtentReports reports;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test=reports.createTest(methodName);  //test is created witch will inisalize the induvidual test execution
		//Reporter.log(methodName+"=>test script execution started",true);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"--->passed");
		//Reporter.log(methodName+"=>is passed ",true);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		
		//this will capture exception occured
		result.getThrowable().toString();
		
		//this will capture the current method name
		String methodName = result.getMethod().getMethodName();
		
		//this will append method name with date for screenshot
		String screenShotName = methodName+"-"+jLib.getSystemDateInFormat();
		
		//this will log in reports asnd console
		test.log(Status.FAIL, methodName+"---->failed");
		test.log(Status.FAIL, result.getThrowable());
		//Reporter.log(methodName+"=>is failed because => "+msg,true);
		
		//this will capture the screen shot and provide screen shot name and save it in folder
		try {
			String path = wLib.takeScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"--->skipped");
		test.log(Status.SKIP, result.getThrowable());
		//Reporter.log(methodName+"=>is skiped because => "+msg,true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//start of suite excution
		/*Configure extent reports*/                   //inside ExtentReports Reports-06-sep-2022 10-38-41.html
		ExtentSparkReporter htmlReports=new ExtentSparkReporter(".\\ExtentReports\\Reports-"+new JavaUtility().getSystemDateInFormat()+".html");
	    htmlReports.config().setDocumentTitle("WASM-5-Vtiger Execution Reports");
	    htmlReports.config().setTheme(Theme.DARK);
	    htmlReports.config().setReportName("Vtiger Execution Reports");
	    
	    reports=new ExtentReports();
	    reports.attachReporter(htmlReports);
	    reports.setSystemInfo("Base-Browser", "Chrome");
	    reports.setSystemInfo("Base-Platform", "Windows");
	    reports.setSystemInfo("Base-Url", "https://localhost:8888");
	    reports.setSystemInfo("Reporter Name", "jayakar");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//End of Execution
		reports.flush();  // consolidate all the test scripts execution and dump the status into Reports
		
		
	}
   
}
