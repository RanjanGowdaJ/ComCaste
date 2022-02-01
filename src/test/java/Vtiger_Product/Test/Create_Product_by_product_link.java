package Vtiger_Product.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_Product_by_product_link {
	public static void main(String[] args) throws Throwable{
		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String bro = pro.getProperty("browser");
		String url = pro.getProperty("url");
	    String uname = pro.getProperty("username");
	   String pass = pro.getProperty("password");
	   
	   WebDriver driver=new FirefoxDriver();
	   
	   FileInputStream fl=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\nothing.xlsx");
	 Workbook work = WorkbookFactory.create(fl);
	Sheet test = work.getSheet("testdata");
	Row rw = test.getRow(0);
	Cell cell = rw.getCell(0);
	String sclv = cell.getStringCellValue();
	
	
	
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(url);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(uname);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pass);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.findElement(By.xpath("//a[.='Products']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(sclv);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	Thread.sleep(5000);
	WebElement ade = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG'and @style='padding: 0px;padding-left:5px']"));
	Actions act=new Actions(driver);
	 act.moveToElement(ade).perform();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	 
	}

}
