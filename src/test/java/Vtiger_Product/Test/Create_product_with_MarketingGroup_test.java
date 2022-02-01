package Vtiger_Product.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Create_product_with_MarketingGroup_test {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String bro = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String UNAME = pro.getProperty("username");
		String PASS = pro.getProperty("password");
		WebDriver driver=new FirefoxDriver();
		
		FileInputStream fl=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\nothing.xlsx");
		Workbook book = WorkbookFactory.create(fl);
		Sheet she = book.getSheet("testdata");
		Row grw = she.getRow(0);
		Cell gcll = grw.getCell(0);
		String cellv = gcll.getStringCellValue();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UNAME);
		
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		 WebElement ele = driver.findElement(By.xpath("//select[@style='width:110px']"));
		 
		 ele.click();
		 Select se1=new Select(ele);
		 se1.selectByVisibleText("New Product");
		 
		 driver.findElement(By.xpath("(//input[@name='productname'])[1]")).sendKeys(cellv);
		 driver.findElement(By.xpath("//input[@name='assigntype'and@onclick='toggleAssignType(this.value)'and@value='T']")).click();
		
		 driver.findElement(By.xpath("//input[@name='button'and @type='submit']")).click();
		
		Thread.sleep(5000); 
		WebElement ade = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG'and @style='padding: 0px;padding-left:5px']"));
		Actions act=new Actions(driver);
		 act.moveToElement(ade).perform();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		 
		
		
		
		
		
		
		
	}

}



