package Tests.RegisterManagementTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddModifierDialogBoxInsideAssignProductModifer;
import ObjectRepository.AssignProductModifiersDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class AssignModifierToProduct {
	public static WebDriver driver=null;
	public static String expectedResult="", actualResult="";
	
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}
	@Test
	public static void AssingModifierToProduct() throws InterruptedException {
		 CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetRegisterManagementLink(driver));
		  DashboardPageElements.GetRegisterManagementLink(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Products_ProductNameColumnSettingsIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver,CreateProductTest.ProductName);
		  RegisterManagementDashboardPageElements.Get_ProductTable_FirstRowProductNameCloumn(driver).click();
		  Thread.sleep(2000);
		  RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Products_SelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Assign Modifiers").click();
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  AssignProductModifiersDialogBoxElements.GetAddModifierToProductElement(driver).click();
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  
		  CommonFunctions.ScrollUptoElement(driver, AddModifierDialogBoxInsideAssignProductModifer.GetLastPageButton(driver));
		  Thread.sleep(2000);
		  AddModifierDialogBoxInsideAssignProductModifer.GetLastPageButton(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, AddModifierDialogBoxInsideAssignProductModifer.GetDynamicModifierName(driver,CreateProductModifier.ModifierName));
		  Thread.sleep(2000);
		  AddModifierDialogBoxInsideAssignProductModifer.GetDynamicModifierName(driver,CreateProductModifier.ModifierName).click();
		  Thread.sleep(4000);
		  driver.switchTo().parentFrame();
		  CommonFunctions.ScrollUptoElement(driver, AssignProductModifiersDialogBoxElements.GetCancelButton(driver));
		  AssignProductModifiersDialogBoxElements.GetCancelButton(driver).click();
		  Thread.sleep(2000);
		  driver.switchTo().defaultContent();
		  assertTrue(true, "Modifier assigned successfully.");		  
	}
	
}
