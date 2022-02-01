package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	public ContactInformation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactInfo;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
	private WebElement FinalOrgname;


	public WebElement getFinalOrgname() {
		return FinalOrgname;
	}


	public WebElement getContactInfo() {
		return ContactInfo;
	}

}
