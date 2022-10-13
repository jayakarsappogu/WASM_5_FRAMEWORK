package vitiger.GenericUtility;
/**
 * this class contains basic configuration annoutation for common
 *functionalities like connection to DB,lunching browser ect..
 * @author Admin
 *
 */

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.ObjectRepository.HomePage;
import vitiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public DataBaseUtility dutil=new DataBaseUtility();
	public ExcelFileUtility eutil=new ExcelFileUtility();
	public JavaUtility jutil=new JavaUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	
	@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void bsConfig() throws SQLException
	{
		dutil.connectToDB();
		Reporter.log("--Database connected succesufully--",true);
	}
	
	//@Parameter("BROWSER")
	@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("---browser "+BROWSER+" launched succesusfully---",true);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("---browser "+BROWSER+" launched succesusfully---",true);
		}
		else
		{
			System.out.println("----invalid browser----");
		}
		sdriver=driver;
		wutil.maxximiseWindow(driver);
		wutil.waitForElementsToLoadInDom(driver);
		driver.get(URL);
	}	
		@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
		public  void bmConfig() throws IOException
		{
			String USERNAME = putil.readDataFromPropertyFile("username");
			String PASSWORD = putil.readDataFromPropertyFile("password");
		     LoginPage lp=new LoginPage(driver);
		     lp.loginToApp(USERNAME, PASSWORD);
		     Reporter.log("=== login successfully done==",true);
		}
		
		@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
		public void amConfig()
		{
			HomePage hp=new HomePage(driver);
			hp.singOutOfApp(driver);
			Reporter.log("--sign out successfully--",true);
		}
		
		//@AfterTest
		@AfterClass(groups= {"SmokeSuite","RegressionSuite"})
		public void acConfig()
		{
			driver.close();
			Reporter.log("---browser closed successfully---",true);
		}
		@AfterSuite
		public void asConfig() throws SQLException
		{
			 dutil.closeDB();
			 Reporter.log("---database succesufully closed---");
			 
	 
        }
}
