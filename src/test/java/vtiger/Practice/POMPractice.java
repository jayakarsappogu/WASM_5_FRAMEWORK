package vtiger.Practice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.ObjectRepository.LoginPage;

public class POMPractice {
	
	public static void main(String[] args) {
		
	
	//launch the browser
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	
	// login to app 
/*	LoginPage lp=new LoginPage(driver);
	WebElement username = lp.getUserNameEdt();
	username.sendKeys("admin");
	WebElement password = lp.getPasswordEdt();
	password.sendKeys("manager");
	lp.getLoginBtn().click();*/
		
	//for code optimising we go for business 
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp("admin", "manager");
		
	}
}
