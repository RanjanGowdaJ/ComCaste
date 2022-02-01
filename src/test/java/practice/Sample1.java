package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new FirefoxDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
