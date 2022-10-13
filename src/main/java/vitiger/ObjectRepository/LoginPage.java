package vitiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// rule 1: create a class for seperate  every page
	//rule 2: identify all the elements using @findby,@findAll and @findbys and store as private
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
    
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	
	//rule 3: create constructor to inisalize
	//inisalization
    public LoginPage(WebDriver driver)
    {
	  PageFactory.initElements(driver, this);
    }

    //rule 4: provide getters to access elements
    
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * this method will login to application with username and password
	 * @param username
	 * @param password
	 */
	// step 5: business libraury
	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys("admin");
		PasswordEdt.sendKeys("admin");
		loginBtn.click();
	}
    
    
    
}
