package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility
{
    //declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//inisalization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/*
	 *this method will create organization with org name	
	 */
	//business library
	public void createNewOrg(String orgname)
	{
	   OrgNameEdt.sendKeys(orgname); 
	   saveBtn.click();
	}
	/**
	 * this method will create handle the create organition with industry dropdown
	 * @param orgName
	 * @param industrytype
	 */
	public void createNewOrg(String orgName,String industrytype)
	{
		OrgNameEdt.sendKeys(orgName);
		handleDropDown(industrytype, industryDropDown);
		saveBtn.click();
	}
	/*
	 * this method will create handle the create organition type and  industry dropdown
	 */
	public void createNewOrg(String orgName,String industrytype,String type)
	{
		OrgNameEdt.sendKeys(orgName);
		handleDropDown(industrytype, industryDropDown);
		handleDropDown(type, typeDropDown);
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
}

