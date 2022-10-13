package vtiger.ContactsTests;
	import java.io.IOException;
	import java.sql.DriverManager;
	import java.util.Properties;

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

	@Listeners(vitiger.GenericUtility.ListenerImplementation.class)
	public class CreateOrganizationTest extends BaseClass
	{

		@Test
		public void createOrgTest() throws IOException, EncryptedDocumentException, InvalidFormatException
		{

			String LASTNAME = eutil.readDataFromExcel("Organization", 1, 2);
			
			//Step :5 navigates to contacts
			driver.findElement(By.linkText("Organizations")).click();
			
			
			//Step :6 click on create contacts
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//Step :7 create contacts with mandatory fields
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(LASTNAME+jutil.getRandomNumber());
			
			
			//step :8 save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
			
			//validation
			String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(orgHeader.contains(LASTNAME))
			{
				System.out.println("organization valid");
			}
			else
			{
				System.out.println("organization not valid");
			}
		}

	}
	

