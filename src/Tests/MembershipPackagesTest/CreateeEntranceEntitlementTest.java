package Tests.MembershipPackagesTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddCategoryDialogBoxInsideEcommerceProductsTabElements;
import ObjectRepository.AddEnteranceEntitlementDialogboxElements;
import ObjectRepository.AddEntranceEntitlementDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.MembershipPackagesPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;


public class CreateeEntranceEntitlementTest {
	 public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String EntranceEntitlement="";

	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }

	  @Test
	  public void CreateEntranceEntitlement()throws Exception
	  {
		  EntranceEntitlement = "Entitlement-"+System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetMembershipPackagesLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetMembershipPackagesLink(driver).click();
		  Thread.sleep(5000);
		  MembershipPackagesPageElements.GetEntranceEntitlementTab(driver).click();
		  Thread.sleep(2000);
		  MembershipPackagesPageElements.GetEntranceEntitlementTab_SelectOption(driver).click();
		  Thread.sleep(2000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Entrance Entitlement").click();
		  Thread.sleep(8000);
		  //driver.switchTo().frame(0);
		  CommonFunctions.SwitchToContentFrame(driver);
		  AddEntranceEntitlementDialogBoxElements.GetEntitlementName(driver).sendKeys(EntranceEntitlement);
		  AddEntranceEntitlementDialogBoxElements.GetLocationDD(driver).click();
		  Thread.sleep(2000);
		  //AddEntranceEntitlementDialogBoxElements.SelectStaticLocation(driver);
		AddEntranceEntitlementDialogBoxElements.SelectDynamicLocation(driver, CreateLocationDepartmentSiteTest.Location);
		  Thread.sleep(2000);
		  
		  AddEntranceEntitlementDialogBoxElements.GetDepartmentDD(driver).click();
		  Thread.sleep(2000);
		  //AddEntranceEntitlementDialogBoxElements.SelectStaticDepartment(driver);
		  AddEntranceEntitlementDialogBoxElements.SelectDynamicDepartment(driver, CreateLocationDepartmentSiteTest.Department);
		  Thread.sleep(2000);

		  AddEntranceEntitlementDialogBoxElements.GetSiteDD(driver).click();
		  Thread.sleep(2000);
		  //AddEntranceEntitlementDialogBoxElements.SelectStaticSite(driver);
		  AddEntranceEntitlementDialogBoxElements.SelectDynamicSite(driver, CreateLocationDepartmentSiteTest.Site);
		  AddEntranceEntitlementDialogBoxElements.GetExternalDescriptionField(driver).sendKeys("External Desc");
		  AddEntranceEntitlementDialogBoxElements.GetNextButton(driver).click();
		  Thread.sleep(5000);
		  AddEntranceEntitlementDialogBoxElements.GetSubmitButton(driver).click();
		  Thread.sleep(10000);
		  driver.switchTo().defaultContent();
		  MembershipPackagesPageElements.GetEntranceEntitlementTab_EntrnaceEntitlementIDColumn(driver).click();
		  Thread.sleep(5000);
		  MembershipPackagesPageElements.GetEntranceEntitlementTab_EntrnaceEntitlementIDColumn(driver).click();
		  Thread.sleep(5000);
		  assertEquals(MembershipPackagesPageElements.GetEntranceEntitlementTab_FirstRowNameColumn(driver).getText().trim(), EntranceEntitlement);
	 
		  CommonFunctions.map.put("Entrance_Entitlement", EntranceEntitlement);
	  
	  }
}
