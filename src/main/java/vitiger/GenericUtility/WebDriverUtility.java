package vitiger.GenericUtility;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all methods related to web driver actions
 * @author Admin
 *
 */

public class WebDriverUtility {
	
	/**
	 * This method used to maximize the window
	 * @param driver
	 */
	public void maxximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will wait for 20sec for all entire Dom structure to load
	 * @param driver
	 */
    public void waitForElementsToLoadInDom(WebDriver driver)
    {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    /**
     * This method will for particular element to be visible
     * @param driver
     * @param element
     */
    public void waitForElementToLoad(WebDriver driver,WebElement element)
    {
       WebDriverWait wait =new WebDriverWait(driver,20);
       wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * this method will wait for particular to be clickable
     * @param driver
     * @param element
     */
    public void waitForElementtobeClikable(WebDriver driver, WebElement element)
    {
    	WebDriverWait wait=new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * This method will wait for particular element to perform click operation
     * if the element is not interactive it will wait for 1sec
     * @param element
     * @throws InterruptedException
     */
    public void customWaitAndClickonElement(WebElement element) throws InterruptedException
    {
    	int count =0;
    	while(count<0)
    	{
    		try 
    		{
    			element.clear();
    			break;
    		}
    		catch (Exception e)
    		{
    			Thread.sleep(1000);
    			count++;
    		}
    	}
    }
   /**
    * this methood will handle drop down by select class using index
    * @param value
    * @param Element
    */
   public void handleDropDown(WebElement element,int index)
   {
   	Select s=new Select(element);
   	s.selectByIndex(index);
   }
   /**
    * this method will handle drop down by select class using visibleText
    * @param element
    * @param visibleText
    */
   public void handleDropDown(WebElement element, String visibleText)
   {
	   Select s=new Select(element);
	   s.selectByVisibleText(visibleText);
   }
    /**
     * This method will handle drop down by select class using value
     * @param Element
     * @param index
     */
    public void handleDropDown(String value,WebElement Element)
    {
    	Select s=new Select(Element);
    	s.selectByValue(value);
    }
    /**
     * this method will double click on over a page
     * @param driver
     */
    public void doubleClickOn(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick().perform();
    }
    /**
     * this method will perfom double click on over a perticular element
     * @param driver
     * @param element
     */
    public void doubleClickOn(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick(element);
    }
    /**
     * this method will perform mouse hover action on the particular web element
     * @param driver
     * @param element
     */
    public void mouseHoverOn(WebDriver driver,WebElement element)
    {
    	Actions act =new Actions(driver);
    	act.moveToElement(element).perform();    }
    /**
     * this method will perform mouse hover action over the offset
     * @param driver
     * @param x
     * @param y
     * @throws InterruptedException
     */
    public void mouseHoverOn(WebDriver driver, int x, int y)
    {
    	Actions act=new Actions(driver);
    	act.moveByOffset(x, y).perform();
    }
    /**
     * this method will right click on the page
     * @param driver
     */
    public void rightClickOn(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.contextClick().perform();
    }
    /**
     * this method will right click on the particular element
     * @param driver
     */
    public void rightClickOn(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.contextClick(element).perform();
    }
    /**
     * this method will perform drag and drop action from src element to target element
     * @param driver
     * @param srcElement
     * @param targetElement
     */
    public void dragAndDropOn(WebDriver driver, WebElement srcElement,WebElement targetElement)
    {
    	Actions act =new Actions(driver);
    	act.dragAndDrop(srcElement, targetElement).perform();
    	
    }
    /**
     * This method will accept alert popup
     * @param driver
     */
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    /**
     * This method will dismiss the alert popup
     * @param driver
     */
    public void dissmissAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    /**
     * this method will get text from alert
     * @param driver
     * @return
     */
    public String getTextInAlert(WebDriver driver)
    {
    	String alertText = driver.switchTo().alert().getText();
    	return alertText;
    }
    /**
     * This method will swicth to window with respect to the window title
     * @param driver
     * @param partialTitle
     */
    public void switchToWindow(WebDriver driver,String partialTitle)
    {
    	//step :1 get all windows
    	Set<String> windowids = driver.getWindowHandles();
    	
    	//step :2 iterate  through all the windowids
    	Iterator<String> it = windowids.iterator();
    	
    	// step :3 navigat inside the window
    	while(it.hasNext())
    	{
    		// capture all the window ids
    		String winId = it.next();
    		
    		//swith to the window and capture the title
    		String currentTitle = driver.switchTo().window(winId).getTitle();
    		if(currentTitle.contains(partialTitle))
    		{
    			break;
    		}
    	}
    }
    /**
     * this method swtich to frame based on index
     * @param driver
     * @param index
     */
    public void switchToFrame(WebDriver driver,int index)
    {
    	driver.switchTo().frame(index);
    }
    /**
     * switch to frame based on name or id
     * @param driver
     * @param idOrName
     */
    public void switchToFrame(WebDriver driver,String idOrName)
    {
    	driver.switchTo().frame(idOrName);
    }
    /**
     * switch to frame based on web element
     * @param driver
     * @param element
     */
    public void switchToFrame(WebDriver driver,WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    /**
     * this method will take screenshot
     * @param driver
     * @param screenShotName
     * @return
     * @throws IOException
     */
    public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	java.io.File src = ts.getScreenshotAs(OutputType.FILE);
    	String path = ".\\Screenshots\\"+screenShotName+".png";
    	java.io.File dst=new java.io.File(path);
    	FileUtils.copyFile(src, dst);
    	return dst.getAbsolutePath();
    }
    /**
     * this method will perform random scroll
     * @param driver
     */
    public void scrollAction(WebDriver driver)
    {
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)","");
    }
    /**
     * this methd will scroll untill the particular element
     * @param driver
     * @param element
     */
    public void scrollAction(WebDriver driver,WebElement element)
    {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].scrollIntoView()", element);
    	int y = element.getLocation().getY();
    	js.executeScript("window.scrollBy(0,"+y+")", element);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}










