package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{
   
	//declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement contactHeaderText;
		
		//inisalization
		public ContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//utilization
		public WebElement getcontactHeaderText() {
			return contactHeaderText;
		}
		/*
		 * this method will get header text for contact
		 */
		//business library
		public String getcontactHeader()
		{
			return contactHeaderText.getText();
			
		}
	
}
