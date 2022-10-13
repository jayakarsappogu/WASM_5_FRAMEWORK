package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtility.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility
{
	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNeworgLookUpImg;
    
	//Inisalization
	public OrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateorgLookUpImg() 
	{
		return createNeworgLookUpImg;
	}
	/**
	 * this method will click on create new organization look up image
	 * @param driver
	 */
	//business library
	public void  clickOnCreateNeworgImg(WebDriver driver)
	{
		createNeworgLookUpImg.click();
	}


}
