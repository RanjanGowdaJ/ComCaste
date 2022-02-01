package Vtiger_Product.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.pomrepositorylib.CreateProductInfo;
import com.vtiger.comcast.pomrepositorylib.CreateProductWithQuick;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;

import Generic.ExcelUtility;
import Generic.FileUtility;
import Generic.JavaUtility;
import Generic.WebDriverUtility;

public class CreatingProductWithQuickByPOM {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		String BRO = fLib.getpropertykeyvalue("browser");
		String URL = fLib.getpropertykeyvalue("url");
		String UNAME = fLib.getpropertykeyvalue("username");
		String PASS = fLib.getpropertykeyvalue("password");
		
         
		String productname = eLib.getDataFromExcel("testdata", 1,4);
		if(BRO.equals("chrome"))
		{
		 driver=new ChromeDriver();
		}else if(BRO.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		wLib.waitforpageload(driver);
		driver.get(URL);
		Login lg=new Login(driver);
		lg.loginToApp(UNAME, PASS, URL);
		
		Home hm=new Home(driver);
		WebElement ele = hm.getQuickCreatedropdown();
		ele.click();
		wLib.select(ele, "New Product");
		
		CreateProductWithQuick cpw=new CreateProductWithQuick(driver);
		cpw.getProductnameEdt().sendKeys(productname);
		cpw.getSaveproductBtn().click();
		
		CreateProductInfo cpi=new CreateProductInfo(driver);
		String acut = cpi.getProductInfo().getText();
		if(acut.contains(productname))
		{
			System.out.println(acut +"product name is present");
		}
		else
		{
			System.out.println(acut +"product name is not  present");
		}
		
		hm.logout();
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
