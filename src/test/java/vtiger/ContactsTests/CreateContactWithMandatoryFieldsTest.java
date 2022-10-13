package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtility.BaseClass;
import vitiger.GenericUtility.ExcelFileUtility;
import vitiger.GenericUtility.JavaUtility;
import vitiger.GenericUtility.PropertyFileUtility;
import vitiger.GenericUtility.WebDriverUtility;
import vitiger.ObjectRepository.ContactInfoPage;
import vitiger.ObjectRepository.ContactsPage;
import vitiger.ObjectRepository.CreateNewContactPage;
import vitiger.ObjectRepository.CreateNewOrganizationPage;
import vitiger.ObjectRepository.HomePage;
import vitiger.ObjectRepository.LoginPage;
import vitiger.ObjectRepository.OrganizationInfoPage;
import vitiger.ObjectRepository.OrganizationPage;
@Listeners(vitiger.GenericUtility.ListenerImplementation.class)
public class CreateContactWithMandatoryFieldsTest extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public void createContactWithMandatoryFields() throws IOException, EncryptedDocumentException, InvalidFormatException
	 {
		
		String ORGNAME = eutil.readDataFromExcel("Contact", 4, 3)+jutil.getRandomNumber();
		String LASTNAME = eutil.readDataFromExcel("Contact", 4, 2);
		
		
		//Navigate organization link
		HomePage hp=new HomePage(driver);
		hp.clickOnorglink();
		
		//navigate organization lookup img
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateNeworgImg(driver);
		
		//create new organization with mandatory fields
		CreateNewOrganizationPage nop=new CreateNewOrganizationPage(driver);
		nop.createNewOrg(ORGNAME);
		
		//validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		System.out.println(OrgHeader);
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//navigate contact link
		hp.clickOnContactslink();
		
		//navigate to create contact lookup img
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg(driver);
		
		//create contact with org details
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME, ORGNAME, driver);
		
		//validates
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.getcontactHeader();
		System.out.println(contactHeader);
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
	}
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void demoTest()
	{
		System.out.println("This is demo ");
	}

}
