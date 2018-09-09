package Tests.RegisterManagementTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ProductModifierInsideCashierRegisterElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import Tests.AdministrationTest.CreateMultipleTaxTest;
import Tests.AdministrationTest.CreateTaxOptionTest;
import baseSetup.TestSetup;
import util.DriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateProductWithTwoTaxRatesTest extends TestSetup{

	  public static WebDriver driver=null;
	  String expectedResult="", actualResult="";
	  public static String ProductName="";
	 
	
	  @Test
	  public void AddProductTest()throws Exception
	  {
		  
		  WebDriver driver=DriverManager.getDriver();
		  ProductName="product" + System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetRegisterManagementLink(driver));
		  DashboardPageElements.GetRegisterManagementLink(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Products_SelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Product").click();
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		
		  AddProductDialogBoxElements.GetProductName(driver).sendKeys(ProductName);
		  
		  AddProductDialogBoxElements.GetCategory(driver).click();		  
		  Thread.sleep(5000);
		  if(CreateCategoryTest.CategoryName!=null && !CreateCategoryTest.CategoryName.equals(""))
		  {
			  CategoryDialogBoxElements.getCategoryNameFilterOption(driver).click();
			  Thread.sleep(2000);
			  CommonFunctions.filterTable(driver, CreateCategoryTest.CategoryName);
			  Thread.sleep(2000);
			  CategoryDialogBoxElements.getCategoryNameFilteredValue(driver).click();
		  }
		  else
		  {
			  CategoryDialogBoxElements.GetStaticCategoryName(driver).click();
			  Thread.sleep(2000);
		  }
		  
		  
		  AddProductDialogBoxElements.GetProductDescription(driver).sendKeys("Product description " + System.currentTimeMillis());
		  AddProductDialogBoxElements.GetPricingTab(driver).click();
		  Thread.sleep(3000);
		  
		  AddProductDialogBoxElements.getUnitPrice(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		  Thread.sleep(2000);
		  AddProductDialogBoxElements.setUnitPrice(driver).sendKeys(CommonFunctions.createProduct_unitPrice);
		  AddProductDialogBoxElements.GetSalesTaxTab(driver).click();
		  Thread.sleep(5000);
		 
		  AddProductDialogBoxElements.GetSalesTax_LocationNameColumnSettingsIcon(driver).click();
		  Thread.sleep(5000);
		  
		  CommonFunctions.filterTable(driver, CreateLocationDepartmentSiteTest.Location);
		  Thread.sleep(2000);
		  AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		  AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		  Thread.sleep(3000);
		  AddProductDialogBoxElements.SelectDynamicTaxOptionFromDD(driver, CreateMultipleTaxTest.TaxOptionName1);
		  Thread.sleep(3000);
		  AddProductDialogBoxElements.SelectDynamicTaxOptionFromDD(driver, CreateMultipleTaxTest.TaxOptionName2);
		  //AddProductDialogBoxElements.SelectfirstOptionFromTaxOptionDropdown(driver);
		  Thread.sleep(2000);
		  AddProductDialogBoxElements.GetAddButton(driver).click();
		  Thread.sleep(10000);
		  driver.switchTo().defaultContent();
		  RegisterManagementDashboardPageElements.Get_ProductTable_IDColumn(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.Get_ProductTable_IDColumn(driver).click();
		  Thread.sleep(5000);
		  actualResult = RegisterManagementDashboardPageElements.Get_ProductTable_FirstRowProductNameCloumn(driver).getText();
		  assertEquals(actualResult, ProductName);
		  
		  
	  }
	  
}
