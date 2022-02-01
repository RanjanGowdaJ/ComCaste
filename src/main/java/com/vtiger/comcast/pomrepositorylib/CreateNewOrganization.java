package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
   public CreateNewOrganization(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath="//input[@name='accountname']")
   private WebElement OrgnameEdt;
   
   @FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
   private WebElement Savebtn;
     
   @FindBy(xpath="//select[@name='industry']")
   private WebElement industrylink;
   

public WebElement getIndusrtylink() {
	return industrylink;
}

public WebElement getOrgnameEdt() {
	return OrgnameEdt;
}

public WebElement getSavebtn() {
	return Savebtn;
}
   
   public void CreatOrg(String Orgname )
   {
   OrgnameEdt.sendKeys(Orgname);
  
  
   }
  
   public void CreateSavtbtn()
   
   {
	   Savebtn.click();
   }
  
}
