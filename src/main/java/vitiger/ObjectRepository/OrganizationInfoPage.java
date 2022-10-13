package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{

	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	//inisalization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	/*
	 * this method will get header text for organization
	 */
	//business library
	public String getOrgHeader()
	{
		String orgHeader = orgHeaderText.getText();
		return orgHeader;
	}
	
	
	
}
