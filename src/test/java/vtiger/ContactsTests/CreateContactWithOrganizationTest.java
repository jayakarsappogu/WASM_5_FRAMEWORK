package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import vitiger.ObjectRepository.HomePage;
@Listeners(vitiger.GenericUtility.ListenerImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void createContactWithOrgTest() throws IOException
	{
		
		String ORGNAME = eutil.readDataFromExcel("Contact", 4, 3)+jutil.getRandomNumber();
		String LASTNAME = eutil.readDataFromExcel("Contact", 4, 2);
		
		//step 5: Navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 6: create organization with mandatory fealds and save
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println("----Organization created------");
		}
		else
		{
			System.out.println("FAIL");
			System.out.println("---Organization not created----");
		}
		
		//step 7: Navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//step 8: Navigate to create contact link
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		//driver.findElement(By.xpath("//input[@name='account_name'"));
		
		//switch the control to child window
		wutil.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		
		//Switch th control back to the parent
		wutil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
			System.out.println("----contact created----");
		}
		else
		{
			System.out.println("FAIL");
			System.out.println("----contact  NOT created----");
		}
		
		
	
		
	}

}

