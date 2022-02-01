package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContact {
	public CreatingNewContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement LastnameEdt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement Savebtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement OrgnameBtn;

	public WebElement getLastnameEdt() {
		return LastnameEdt;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}

	public WebElement getOrgnameBtn() {
		return OrgnameBtn;
	}
}