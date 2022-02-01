package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductWithQuick {
	public CreateProductWithQuick(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(xpath="//input[@name='productname']")
	private WebElement ProductnameEdt;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement GroupRadiobtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveproductBtn;

	public WebElement getProductnameEdt() {
		return ProductnameEdt;
	}

	public WebElement getGroupRadiobtn() {
		return GroupRadiobtn;
	}

	public WebElement getSaveproductBtn() {
		return SaveproductBtn;
	}
    
}
