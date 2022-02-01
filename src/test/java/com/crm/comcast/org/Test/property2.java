package com.crm.comcast.org.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class property2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		Thread.sleep(1000);
		String brow = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
	
		FileInputStream fl=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\nothing.xlsx");
	Workbook wb = WorkbookFactory.create(fl);
	Sheet sh = wb.getSheet("testdata");
	Row rw = sh.getRow(1);
	Cell cl = rw.getCell(3);
	String cv = cl.getStringCellValue();
	
	
		WebDriver driver=null;
		if(brow.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(brow.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(brow.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("organization");
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("Sample1@gmail.com");
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		
		
		
		
	}

}
