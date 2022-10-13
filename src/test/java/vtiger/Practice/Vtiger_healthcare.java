package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vtiger_healthcare {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("QSP");
        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

	}

}
