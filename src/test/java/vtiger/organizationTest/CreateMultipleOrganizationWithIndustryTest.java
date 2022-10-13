package vtiger.organizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtility.BaseClass;
import vitiger.GenericUtility.ExcelFileUtility;
import vitiger.GenericUtility.JavaUtility;
import vitiger.GenericUtility.PropertyFileUtility;
import vitiger.GenericUtility.WebDriverUtility;
import vitiger.ObjectRepository.CreateNewOrganizationPage;
import vitiger.ObjectRepository.HomePage;
import vitiger.ObjectRepository.LoginPage;
import vitiger.ObjectRepository.OrganizationInfoPage;
import vitiger.ObjectRepository.OrganizationPage;
@Listeners(vitiger.GenericUtility.ListenerImplementation.class)
public class CreateMultipleOrganizationWithIndustryTest {
	
	//create object of all required utility
	JavaUtility jutil=new JavaUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	
	WebDriver driver;
	
	@Test(dataProvider =  "OrgData")
	public void createMultipleOrgTest(String OrgName,String IndustryType) throws IOException
	{
		//read all necessary data
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		String Org = OrgName+jutil.getRandomNumber();
		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			System.out.println("chrome browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("firefox browser lanched");
		}
		else
		{
			
			System.out.println("invalid browser");
			driver=new ChromeDriver();
			System.out.println("chromebrowser lanched");
		}
		wutil.maxximiseWindow(driver);
		wutil.waitForElementsToLoadInDom(driver);
		driver.get(URL);
		
		//login to App
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//navigate to organizationlink
		HomePage hp=new HomePage(driver);
		hp.clickOnorglink();
		
		//navigate create organization look up image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateNeworgImg(driver);
		
		//create new organization with industry type
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(Org, IndustryType);
		
		//validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		System.out.println(orgHeader);
		if(orgHeader.contains(Org))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
			
	}
	@DataProvider(name="OrgData")
	public Object [][] getData() throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		return eutil.readMultipleDataFromExcel("MultipleOrg");
		
	}

}
