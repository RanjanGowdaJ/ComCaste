package Vtiger_Organization;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositorylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositorylib.Organizations;

import Generic.BaseClassAnnotations;

public class CreateOrganization extends BaseClassAnnotations {
	
	@Test(groups="smokeTest")
	public void CreateOrganizationTest() throws Throwable  {
	
				int random = jLib.getrandomnumber();
				
				String Orgname = eLib.getDataFromExcel("testdata", 0, 1)+random;
			
				Home hm=new Home(driver);
				hm.getOrganizationlink().click();
				
				Organizations og=new Organizations(driver);
				og.getCreateorgbtn().click();
				
				CreateNewOrganization cno=new CreateNewOrganization(driver);
				cno.CreatOrg(Orgname);
				cno.CreateSavtbtn();
				
				OrganizationInfo oi=new OrganizationInfo(driver);
			  wLib.waitForElementVisibility(driver, oi.getOrgInfo());
			 String actmsg = oi.getOrgInfo().getText();
				if(actmsg.contains(Orgname))
				{
					System.out.println("org created sucessfully");
				}else  
				{
					System.out.println("org not created sucessfully");
				}
	}

	@Test(groups="regressionTest")
	
	public void CreateOragnizationWithIndustry() throws Throwable  {
		
				int random = jLib.getrandomnumber();
				
				String Orgname = eLib.getDataFromExcel("testdata", 0, 1)+random;
			
				Home hm=new Home(driver);
				hm.getOrganizationlink().click();
				
				Organizations og=new Organizations(driver);
				og.getCreateorgbtn().click();
				
				CreateNewOrganization cno=new CreateNewOrganization(driver);
				cno.CreatOrg(Orgname);
				 WebElement ele = cno.getIndusrtylink();
				 ele.click();
				  wLib.select(ele, "Energy");
				  cno.CreateSavtbtn();
				
				OrganizationInfo oi=new OrganizationInfo(driver);
			  wLib.waitForElementVisibility(driver, oi.getOrgInfo());
			 String actmsg = oi.getOrgInfo().getText();
				if(actmsg.contains(Orgname))
				{
					System.out.println("org created sucessfully");
				}else  
				{
					System.out.println("org not created sucessfully");
				}
				
		}
}
	

