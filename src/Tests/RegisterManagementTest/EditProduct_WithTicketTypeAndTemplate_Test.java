package Tests.RegisterManagementTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.TicketingTest.CreateTicketTemplateTest;
import Tests.TicketingTest.CreateTicketTypeTest;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class EditProduct_WithTicketTypeAndTemplate_Test {
	
	 public static WebDriver driver=null;
	  String expectedResult="", actualResult="";
	  public static String ProductName="";
	 
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void EditProductWithTicketTypeAndTemplate() throws InterruptedException
	  {
		  DashboardPageElements.GetRegisterManagementLink(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		  Thread.sleep(5000);
		  
		  RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Products_ProductNameColumnSettingsIcon(driver).click();
		  Thread.sleep(3000);
		  CommonFunctions.filterTable(driver, CreateProductTest.ProductName);
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.Get_ProductTable_FirstRowProductNameCloumn(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Products_SelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Edit Product").click();
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  AddProductDialogBoxElements.GetTicketTab(driver).click();
		  Thread.sleep(2000);
		  AddProductDialogBoxElements.GetTicketTab_IsATicketCheckbox(driver).click();
		  Thread.sleep(2000);
		  AddProductDialogBoxElements.GetTicketTab_TicketTemplateDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, CreateTicketTemplateTest.TicketTemplateName);
		  AddProductDialogBoxElements.GetTicketTab_TicketTypeDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, CreateTicketTypeTest.TicketTypeName);
		  AddProductDialogBoxElements.GetSaveButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
	  }
}
