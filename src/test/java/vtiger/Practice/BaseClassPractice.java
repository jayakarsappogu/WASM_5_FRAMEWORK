package vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	@BeforeSuite
	public void bsConfi()
	{
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void asConfi()
	{
		System.out.println("After Suite");
	}
	@BeforeClass
	public void bcConfi()
	{
		System.out.println("Before Class");
	}
	@AfterClass
	public void acConfi()
	{
		System.out.println("After class");
	}
	@BeforeMethod
	public void bmConfi()
	{
		System.out.println("Before method");
	}
    @AfterMethod()
    public void amConfi()
    {
    	System.out.println("After method");
    }
    @Test
    public void test1()
    {
    	System.out.println("test 1");
    }
    @Test
    public void test2()
    {
    	System.out.println("test 2");
    }
    
}
