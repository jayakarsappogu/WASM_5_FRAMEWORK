package vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.ObjectRepository.HomePage;
import vitiger.ObjectRepository.LoginPage;

public class Vitger_Login_Logout_Practice {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		HomePage hp=new HomePage(driver);
		hp.mouseHoverOn(driver, element);
		System.out.println("mouse over action performed");
		hp.singOutOfApp(driver);
		driver.findElement(By.linkText("Sign Out")).click();
		
		
	}

}
