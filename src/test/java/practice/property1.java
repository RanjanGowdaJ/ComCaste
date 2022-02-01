package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class property1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser");
		String URL = pro.getProperty("url");
	String Uname = pro.getProperty("username");
	String Pass = pro.getProperty("password");
	WebDriver driver=new FirefoxDriver();
	driver.get(URL);
	Thread.sleep(2000);
	driver.findElement(By.name("user_name")).sendKeys(Uname);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Pass);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
	}

}
