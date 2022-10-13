package vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VTiger_Logout {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver","D:\\Selenium folder\\chromedriver.exe");
		    	ChromeDriver driver = new ChromeDriver();
		    	driver.get("http://localhost:8888");
		    	driver.manage().window().maximize();
		    	
		    	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		    	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		    	driver.findElement(By.xpath("//input[@type='submit']")).click();
		    	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		    	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			}
	}


