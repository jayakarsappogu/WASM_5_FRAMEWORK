package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
  
	//Declaration
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement createNewcontactLookUpImg;
	    
		//Inisalization
		public ContactsPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		public WebElement getCreateorgLookUpImg() 
		{
			return createNewcontactLookUpImg;
		}
		/**
		 * this method will click on create new organization look up image
		 * @param driver
		 */
		//business library
		public void  clickOnCreateContactImg(WebDriver driver)
		{
			createNewcontactLookUpImg.click();
		}
}
