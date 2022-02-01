package Vtiger_contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositorylib.ContactInformation;
import com.vtiger.comcast.pomrepositorylib.Contacts;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositorylib.CreatingNewContact;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositorylib.Organizations;

import Generic.BaseClassAnnotations;
import Generic.ExcelUtility;
import Generic.FileUtility;
import Generic.JavaUtility;
import Generic.WebDriverUtility;

public class CreateContact extends BaseClassAnnotations {
	
	@Test(groups="regressionTest")
	public void CreateContactWithOrganizationByPOM() throws Throwable {
	
			
			int random = jLib.getrandomnumber();
			
			String Lastname = eLib.getDataFromExcel("testdata", 5, 2)+random;
			String Orgname = eLib.getDataFromExcel("testdata", 5, 3)+random;
			
			Home hm=new Home(driver);
			hm.getOrganizationlink().click();
			
			Organizations og=new Organizations(driver);
			og.getCreateorgbtn().click();
			
			CreateNewOrganization cno=new CreateNewOrganization(driver);
			cno.getOrgnameEdt().sendKeys(Orgname);
			cno.getSavebtn().click();
			

			OrganizationInfo ogi=new OrganizationInfo(driver);
			wLib.waitForElementVisibility(driver, ogi.getOrgInfo());
			String actulmsg = ogi.getOrgInfo().getText();
			if(actulmsg.contains(Orgname))
			{
				System.out.println(actulmsg);
				System.out.println("org is created sucessfully");
			}
			else
			{
				System.out.println("org is not created Succesfully");
		
			}
		
			hm.getContactlink().click();
			Contacts cn=new Contacts(driver);
			cn.getCreateContactBtn().click();
			
			CreatingNewContact cnc=new CreatingNewContact(driver);
			cnc.getLastnameEdt().sendKeys(Lastname);
			cnc.getOrgnameBtn().click();
			wLib.switchToWindow(driver, "Accounts&action");
			
			og.getSearchetxtEdt().sendKeys(Orgname);
			og.getSercheBtn().click();
			
			driver.findElement(By.xpath("//a[.='"+Orgname+"']")).click();
			
			wLib.switchToWindow(driver, "Contacts&action");
			
			cnc.getSavebtn().click();
			
			ContactInformation cin=new ContactInformation(driver);
			String actumsg = cin.getFinalOrgname().getText();
			if(actumsg.trim().equals(Orgname))
			{
				System.out.println(Orgname+ "contact name is crct");
			}else{
				System.out.println(Orgname+ "Contact name is not crct");
			}	
	}
	
	@Test(groups="smokeTest")
	public void CreateNewContactsByPOM() throws Throwable {
			
		
			
	         int randnumber = jLib.getrandomnumber();
			
			String Lastname = eLib.getDataFromExcel("testdata", 1, 2)+randnumber;
			
			
			
			Home hm=new Home(driver);
			hm.getContactlink().click();
			
			
			Contacts con=new Contacts(driver);
			con.getCreateContactBtn().click();
			
			CreatingNewContact cnc=new CreatingNewContact(driver);
			cnc.getLastnameEdt().sendKeys(Lastname);
			cnc.getSavebtn().click();

			
			ContactInformation ci=new ContactInformation(driver);
			wLib.waitForElementVisibility(driver, ci.getContactInfo());
			String contactmsg = ci.getContactInfo().getText();
			
			if(contactmsg.contains(Lastname))
					{
				System.out.println("yes it is");
					}
			else
			{
				System.out.println("not it is not");
			}
	}
}

