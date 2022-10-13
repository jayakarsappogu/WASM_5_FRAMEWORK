package vitiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	
	//declaration
	@FindBy(name="lastname")
	private WebElement ContactNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchBoxEdt;
	
	@FindBy(name="search") 
	private WebElement searchBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//inisalization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLastNameEdt() {
		return ContactNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/*
	 * this methodwill create new contact using mandatory fields and save it
	 */
	//bisuness library
	public void createNewContact(String lastname)
	{
		ContactNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	/*
	 * this method will create contact with contact name and lead source dropdown
	 */
	public void createNewContact(String lastname,String leadSourceType)
	{
		ContactNameEdt.sendKeys(lastname);
		handleDropDown(leadSourceType, leadSourceDropDown);
		saveBtn.click();
	}
	/*
	 * this method will create a contact with lastname and organization name
	 */
	public void createNewContact(String lastname,String orgName,WebDriver driver)
	{
		ContactNameEdt.sendKeys(lastname);
		OrgLookUpImg.click();
		switchToWindow(driver, "Acoounts");
		searchBoxEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();  // orgname always dynamic
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	

}
