package Tests.RegisterManagementTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;

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
		  CommonFunctions.filterTable(driver, "product1530895499408");
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.Get_ProductTable_FirstRowProductNameCloumn(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Products_SelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Edit Product").click();
		  Thread.sleep(3000);
		  driver.switchTo().frame(0);
		  AddProductDialogBoxElements.GetTicketTab(driver).click();
		  Thread.sleep(2000);
		  AddProductDialogBoxElements.GetTicketTab_IsATicketCheckbox(driver).click();
		  Thread.sleep(2000);
		  AddProductDialogBoxElements.GetTicketTab_TicketTemplateDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, "TicketTemplate-1530920045740");
		  AddProductDialogBoxElements.GetTicketTab_TicketTypeDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, "TicketType-1530879540217");
		  AddProductDialogBoxElements.GetSaveButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
	  }
}
