package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;

public class BaseClassAnnotations {
	
	public WebDriver driver=null;
	/*Object creation for Lib*/
	
	public WebDriverUtility wLib=new WebDriverUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configuBS()
	{
		System.out.println("***********connect to DB************");
	}
	@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	
	public void ConfigBC() throws Throwable{
		System.out.println("launch the browser");
		String BRO = fLib.getpropertykeyvalue("browser");
		String URL = fLib.getpropertykeyvalue("url");
		
		if(BRO.equals("chrome"))
		{
		 driver=new ChromeDriver();
		}else if(BRO.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		wLib.waitforpageload(driver);
		/* Navigate to app*/
		driver.get(URL);
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void ConfigBM() throws Throwable
	{
		/*common Data*/
		String BRO = fLib.getpropertykeyvalue("browser");
		String URL = fLib.getpropertykeyvalue("url");
		String UNAME = fLib.getpropertykeyvalue("username");
		String PASS = fLib.getpropertykeyvalue("password");
		
		/* step 1 : login */
		Login lg=new Login(driver);
		lg.loginToApp(UNAME, PASS, URL);
			
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void ConfigAM ()
	{
		/*step 6 : logout*/
		Home hm=new Home(driver);
		hm.logout();
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void ConfigAC()
	{
		driver.close();
		System.out.println("close the browser");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void ConfigAS(){
		System.out.println("********close the DB connection");
	}
}
