package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void assertPracticeTest()
	{
		System.out.println("===Step-1====");
		System.out.println("===Step-2====");
		System.out.println("===Step-3====");
		System.out.println("===Step-4====");
		System.out.println("===Step-5====");
	}
	@Test
	public void assertPracticeTest2()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("===Test 2 Step-1====");
		Assert.assertTrue(true); //hard assert
		System.out.println("===Test 2 Step-2====");
		sa.assertEquals(0,1); //fails
		System.out.println("===Test 2 Step-3====");
		//sa.assertAll(); no use becuse next step will not execute
		System.out.println("===Test 2 Step-4====");
		System.out.println("===Test 2 Step-5====");
		sa.assertAll();// it should use at the end of the line of code
	}
	

}
