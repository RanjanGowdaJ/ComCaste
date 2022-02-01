package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	public Organizations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement Createorgbtn;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement SearchetxtEdt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement SercheBtn;
	
	

	public WebElement getSercheBtn() {
		return SercheBtn;
	}


	public WebElement getSearchetxtEdt() {
		return SearchetxtEdt;
	}


	public WebElement getCreateorgbtn() {
		return Createorgbtn;
	}

}
