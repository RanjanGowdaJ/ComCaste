package Generic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class contain generic methods for all WebDrivers actions
 * @author LENOVO
 *
 */
public class WebDriverUtility {

	/**
	 * 
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * this method wait for 20 sec for page loading
	 * @param driver
	 */
	public void waitforpageload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	/**
	 * * This method wait for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method wait for the element to be clicked , its custom wait created to avoid elemenInterAceptable Exception
	 * @param element
	 * @throws InterruptedException 
	 */
	
	public void waitAndclick(WebElement element) throws InterruptedException
	{
		   int count = 0;
	       while(count<20) {
			   try {
			       element.click();
			       break;
			   }catch(Throwable e){
				   Thread.sleep(1000);
				   count++;
			   }
	       }
	}
	/**
	 * * this methods enables user to handle dropdown using index
	 * @param element
	 * @param index
	 */
    public void select(WebElement element,int index)
     {
	Select sct=new Select(element);
	sct.selectByIndex(index);
    }
    public void select(WebElement element,String name)
    {
	Select sct=new Select(element);
	sct.selectByVisibleText(name);
   }
    /**
     * This method will perform mouse over action
     * @param driver
     * @param element
     */
    public void mouseover(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();
    }
    /**
     * This method performs right click operation 
     * @param driver
     * @param element
     */
    public void rightClick(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();
    }
    /**
     * * This method helps to switch from one window to another
     * @param driver
     * @param partialWinTitle
     */
    public void switchToWindow(WebDriver driver,String partialWinTitle)
    {
    	Set<String> window = driver.getWindowHandles();
    	Iterator<String> it = window.iterator();
    	while(it.hasNext())
    			{
    		   String winId=it.next();
    		   String title=driver.switchTo().window(winId).getTitle();
               if(title.contains(partialWinTitle))
               {
                 break;
    			}
    			}
  
    }
    /**
     * it will accept the alert
     * @param driver
     */
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    }
    /**
     *  Cancel Alert
     * @param driver
     */
    public void cancelAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    /**
     * This method used for scrolling action in a webpage
     * @param driver
     * @param element
     */
    public void scrollToWebelement(WebDriver driver,WebElement element)
    {
    	JavascriptExecutor jsp=(JavascriptExecutor)driver;
    	int y = element.getLocation().getY();
    	   jsp.executeScript("window.scrollBy(0,"+y+")", element);
    }
    
    public void switchFrame(WebDriver driver,int index)
    {
    	driver.switchTo().frame(index);
    
    }
    public void switchFrame(WebDriver driver,WebElement element)
    {
    	driver.switchTo().frame(element);
    
    }
    public void switchFrame(WebDriver driver,String idOrname)
    {
    	driver.switchTo().frame(idOrname);
    
    }
    public void takeScreenshot(WebDriver driver,String screenshotname) throws Throwable
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./screenshot/"+screenshotname+".PNG");
    	Files.copy(src, dest);
    }
    public void passEnterkey(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.sendKeys(Keys.ENTER).perform();
    }
}
