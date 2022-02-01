package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.WebDriverUtility;

public class Home extends WebDriverUtility {
	WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[.='Organizations'])[1]")
	private WebElement Organizationlink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement Contactlink;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement Productlink;
	
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement Administratorimg;
    
    @FindBy(xpath="//a[.='Sign Out']")
    private WebElement Signoutlink;
    
   
	@FindBy(xpath="//select[@id='qccombo'] ")
	private WebElement QuickCreatedropdown;
	
	
	public WebElement getQuickCreatedropdown() {
		return QuickCreatedropdown;
	}
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrganizationlink() {
		return Organizationlink;
	}

	public WebElement getContactlink() {
		return Contactlink;
	}

	public WebElement getProductlink() {
		return Productlink;
	}

	public WebElement getAdministratorimg() {
		return Administratorimg;
	}

	public WebElement getSignoutlink() {
		return Signoutlink;
	}
  public void logout()
  {
	  mouseover(driver,Administratorimg );
	  Signoutlink.click();
  }

}
