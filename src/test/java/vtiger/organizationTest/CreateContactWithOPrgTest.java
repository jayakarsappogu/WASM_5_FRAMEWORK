package vtiger.organizationTest;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import vitiger.GenericUtility.BaseClass;
import vitiger.ObjectRepository.ContactInfoPage;
import vitiger.ObjectRepository.ContactsPage;
import vitiger.ObjectRepository.CreateNewContactPage;
import vitiger.ObjectRepository.CreateNewOrganizationPage;
import vitiger.ObjectRepository.HomePage;
import vitiger.ObjectRepository.OrganizationInfoPage;
import vitiger.ObjectRepository.OrganizationPage;


@Listeners(vitiger.GenericUtility.ListenerImplementation.class)
public class CreateContactWithOPrgTest extends BaseClass
{
	@Test
  public void createContactWithOrgTest() throws EncryptedDocumentException, IOException 
  {
	//read all the required data
	  String ORGNAME = eutil.readDataFromExcel("Contact", 4, 3)+jutil.getRandomNumber();
	 String LASTNAME = eutil.readDataFromExcel("Contact", 4, 2);
	 
	 //Navigate to organisation link
	 HomePage hp=new HomePage(driver);
	 hp.clickOnorglink();
	 Reporter.log("orgnisation link cliked ",true);
	 
	 //navigate create org img
	 OrganizationPage op=new OrganizationPage(driver);
	 op.clickOnCreateNeworgImg(driver);
	 Reporter.log("create org look up img clicked ",true);
	 
	 //create organisation with mandatory fields
	 CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
	 cop.createNewOrg(ORGNAME);
	 Reporter.log("new organization created ",true);
	 
	 //validates
	 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String OrgHeader = oip.getOrgHeader();
	System.out.println(OrgHeader);
	Assert.assertTrue(OrgHeader.contains(ORGNAME));
	//Assert.fail();
	
	//navigate to contact link
	hp.clickOnContactslink();
	Reporter.log("contact link clicked ",true);
	
	//navigate create contact look up img
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnCreateContactImg(driver);
	Reporter.log("create contact lookup img cliked",true);
	
	//create new contact with org details
	
	CreateNewContactPage cnp=new CreateNewContactPage(driver);
	cnp.createNewContact(LASTNAME, ORGNAME, driver);
	Reporter.log("new contact with new organization created",true);
	
	//validates
	ContactInfoPage cip=new ContactInfoPage(driver);
	String contactHeader = cip.getcontactHeader();
	System.out.println(contactHeader);
	Assert.assertEquals(contactHeader.contains(LASTNAME),true);
	Reporter.log("validation is successfull",true);
	 
}
}
