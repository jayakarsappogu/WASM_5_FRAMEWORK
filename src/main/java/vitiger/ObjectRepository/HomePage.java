package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{

	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement Organizationslnk;
	
	@FindBy(linkText="Contacts")
	private WebElement Contactslnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement Opportunitieslnk;
	
	@FindBy(linkText="Products")
	private WebElement Productslnk;
	
	@FindBy(linkText="Leads")
	private WebElement Leadslnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;
	
	@FindAll({@FindBy(linkText="Sign Out"),@FindBy(xpath ="//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement Singoutlnk;
	
	

	//Inisalization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//Utilization
	public WebElement getOrganizationslnk() {
		return Organizationslnk;
	}

	public WebElement getContactslnk() {
		return Contactslnk;
	}

	public WebElement getOpportunitieslnk() {
		return Opportunitieslnk;
	}

	public WebElement getProductslnk() {
		return Productslnk;
	}

	public WebElement getLeadslnk() {
		return Leadslnk;
	}
	
	public WebElement getAdministratorimg() {
		return administratorimg;
	}

	public WebElement getSingoutlnk() {
		return Singoutlnk;
	}
	/**
	 * This method will perform signout operation
	 * @param driver
	 */
	//business Library
	public void singOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, administratorimg);
		Singoutlnk.click();
	}
	/**
	 * this method will perfom click on organization link
	 */
	public void clickOnorglink()
	{
		Organizationslnk.click();
	}
	/**
	 * this method will perform click on contacts link
	 */
	public void clickOnContactslink()
	{
		Contactslnk.click();
	}
	
	
	
	
	
	
	
}
