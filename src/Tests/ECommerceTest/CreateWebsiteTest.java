package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddWebsiteDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.WebsiteOpenPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import Tests.CreateEmployeeTest.CreateEmployeeTest;
@Listeners (GlobalFiles.ReportCustomization.class)
public class CreateWebsiteTest {
	
	public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String WebsiteName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void CreateWebsite()throws Exception
	  {
		  WebsiteName = "website-"+System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetEcommerceLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetEcommerceLink(driver).click();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetWebSiteTab(driver).click();
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetWebsiteTab_SelectOptionDD(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Website").click();
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  AddWebsiteDialogBoxElements.GetWebSiteNameField(driver).sendKeys(WebsiteName);
		  AddWebsiteDialogBoxElements.GetShowCategoriesCheckbox(driver).click();
		  AddWebsiteDialogBoxElements.GetSourceWebsiteURLField(driver).sendKeys("https://aluvii.com");
		  
		  AddWebsiteDialogBoxElements.GetLocationDD(driver).click();
		  Thread.sleep(2000);
		 // AddWebsiteDialogBoxElements.SelectFirstOptionFromLocationDD(driver);
		  AddWebsiteDialogBoxElements.SelectDynamicLocation(driver,CreateLocationDepartmentSiteTest.Location);
		  
		  AddWebsiteDialogBoxElements.GetEmailRecTemplateDD(driver).click();
		  Thread.sleep(2000);
		  AddWebsiteDialogBoxElements.SelectOptionFromEmailRecTemplateDD(driver, "Payment Receipt");
		  		  
		  AddWebsiteDialogBoxElements.GetDisplayRecTemplateDD(driver).click();
		  Thread.sleep(2000);
		  AddWebsiteDialogBoxElements.SelectOptionFromDisplayRecTemplateDD(driver, "Payment Receipt");

		  AddWebsiteDialogBoxElements.GetEmailConfigurationDD(driver).click();
		  Thread.sleep(2000);
		  AddWebsiteDialogBoxElements.SelectOptionFromEmailConfigurationDD(driver, "MailGun SMTP");
		  
		  AddWebsiteDialogBoxElements.GetNextButton(driver).click();
		  Thread.sleep(10000);
		  
		  AddWebsiteDialogBoxElements.GetColorDropdown(driver).click();
		  Thread.sleep(2000);
		  AddWebsiteDialogBoxElements.GetColorInputTextBox(driver).clear();
		  AddWebsiteDialogBoxElements.GetColorInputTextBox(driver).sendKeys("#9f60a5");
		  AddWebsiteDialogBoxElements.GetApplyButton(driver).click();
		  Thread.sleep(2000);
		  AddWebsiteDialogBoxElements.GetNext_2_Button(driver).click();
		  Thread.sleep(10000);
		  AddWebsiteDialogBoxElements.GetSubmitButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  ECommerceDashboardPageElements.GetWebsiteTab_WebsiteNameClolumnSettingIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver, WebsiteName);
		  Thread.sleep(2000);
		  actualResult = ECommerceDashboardPageElements.GetWebsiteTab_FirstRowWebsiteNameColumn(driver).getText().toLowerCase().trim().toLowerCase();
		  assertEquals(actualResult, WebsiteName.toLowerCase());
		  OpenWebiste();
	  }
	  public void OpenWebiste() throws InterruptedException
	  {
		  ECommerceDashboardPageElements.GetWebsiteTab_FirstRowWebsiteNameColumn(driver).click();
		  ECommerceDashboardPageElements.GetWebsiteTab_SelectOptionDD(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Open Website").click();
		  Thread.sleep(10000);
		  ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));
		  assertEquals(driver.getTitle(),WebsiteName.toLowerCase().trim());
		  assertEquals(WebsiteOpenPageElements.GetCategoriesField(driver).getText().trim() , "Categories");
		  if(WebsiteOpenPageElements.GetManageMyAccountButton(driver).isEnabled())
		  {
			  assertTrue(true);
		  }
		  else
		  {
			  assertFalse(false, "Manage my account button not found.");
		  }
		  
		  if(WebsiteOpenPageElements.GetReturntToWebsite(driver).isEnabled())
		  {
			  assertTrue(true);
		  }
		  else
		  {
			  assertFalse(false, "Return to Website button not found.");
		  }
		  
		  if(WebsiteOpenPageElements.GetSearchField(driver).isEnabled())
		  {
			  assertTrue(true);
		  }
		  else
		  {
			  assertFalse(false, "Search field not found.");
		  }
		  
		  if(WebsiteOpenPageElements.GetShopAllProductButton(driver).isEnabled())
		  {
			  assertTrue(true);
		  }
		  else
		  {
			  assertFalse(false, "Shop all product button not found.");
		  }
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
		 
	  }
	  
	  
	  
	  
}	
