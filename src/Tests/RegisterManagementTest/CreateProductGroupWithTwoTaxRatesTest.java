package Tests.RegisterManagementTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.AddProductGroupDialogBoxElements;
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ProductDialogboxInsideAddProductGroupElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.AdministrationTest.CreateLocationDepartmentSiteTest;
import Tests.AdministrationTest.CreateMultipleTaxTest;
import Tests.AdministrationTest.CreateTaxOptionTest;
import Tests.RegisterManagementTest.CreateCategoryTest;
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateProductGroupWithTwoTaxRatesTest extends TestSetup {
	//public static WebDriver driver=null;
	public static String expectedResult="", actualResult="";
	public static String ProductForProductGroup[];
	public static String ProductGroupName="";
	/*@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = CommonFunctions.driver;
	}*/
	@Test
	public void CreateProductGroup () throws Exception {
		
		WebDriver driver = DriverManager.getDriver();
		
		ProductForProductGroup = new String [CommonFunctions.ProductsCountForProductGroup];
		for (int i =0;i<CommonFunctions.ProductsCountForProductGroup;i++)
		{
			ProductForProductGroup[i]="product"+System.currentTimeMillis();
			createProuductForProuductGroup(driver, ProductForProductGroup[i]);
		}
		ProductGroupName = "productgroup_" + System.currentTimeMillis();
		 CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetRegisterManagementLink(driver));
		DashboardPageElements.GetRegisterManagementLink(driver).click();
		Thread.sleep(5000);
		RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		Thread.sleep(5000);
		RegisterManagementDashboardPageElements.GetProductsTab_subtab_ProductGroups(driver).click();
		Thread.sleep(3000);
		RegisterManagementDashboardPageElements.GetProductsTab_SubTab_ProductGroups_SelectOptionDropdown(driver).click();
		Thread.sleep(3000);
		RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Product Group").click();
		Thread.sleep(3000);
		CommonFunctions.SwitchToContentFrame(driver);
		AddProductGroupDialogBoxElements.GetProductGroupNameField(driver).sendKeys(ProductGroupName);
		AddProductGroupDialogBoxElements.GetDescriptionField(driver).sendKeys("Desc_" + System.currentTimeMillis());
		
		AddProductGroupDialogBoxElements.GetUnitPerIssueIncreaseValueIcon(driver).click();
		AddProductGroupDialogBoxElements.GetUniversalPriceCheckbox(driver).click();
		Thread.sleep(3000);
		AddProductGroupDialogBoxElements.SetUnitPriceForGroup(driver, CommonFunctions.CreateProductGroup_UnitPrice);
		Thread.sleep(5000);
		
		AddProductGroupDialogBoxElements.GetPopupCategoryWindowIcon(driver).click();
		Thread.sleep(5000);
	//	CommonFunctions.SwitchToContentFrame(driver);
		CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetLastPageButton(driver));
		System.out.println("After category lastpage button");
		CategoryDialogBoxElements.GetLastPageButton(driver).click();
		Thread.sleep(5000);
		CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetDynamicCategoryName(driver,CreateCategoryTest.CategoryName));
		Thread.sleep(2000);
		CategoryDialogBoxElements.GetDynamicCategoryName(driver,CreateCategoryTest.CategoryName).click();
	    Thread.sleep(2000);
	
	    
		for (int i =0;i<CommonFunctions.ProductsCountForProductGroup;i++)
		{
				AddProductGroupDialogBoxElements.GetAddProductButton(driver).click();
				Thread.sleep(5000);
				
				CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, ProductDialogboxInsideAddProductGroupElements.GetProductNameColumnSettingsIcon(driver));
				
				Thread.sleep(2000);
				CommonFunctions.filterTable(driver,ProductForProductGroup[i]);
				Thread.sleep(5000);
				CommonFunctions.ScrollUptoElement(driver, ProductDialogboxInsideAddProductGroupElements.GetDynamicProductName(driver,ProductForProductGroup[i]));
				Thread.sleep(2000);
				ProductDialogboxInsideAddProductGroupElements.GetDynamicProductName(driver,ProductForProductGroup[i]).click();
				Thread.sleep(2000);
		
				
		}
		AddProductGroupDialogBoxElements.GetSalesTax_LocationNameColumnSettingsIcon(driver).click();
		Thread.sleep(2000);
		CommonFunctions.filterTable(driver, CreateLocationDepartmentSiteTest.Location);
		Thread.sleep(3000);
		AddProductGroupDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		AddProductGroupDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		Thread.sleep(2000);
		//AddProductGroupDialogBoxElements.SelectfirstOptionFromTaxOptionDropdown(driver);
		AddProductGroupDialogBoxElements.SelectDynamicTaxOptionFromDD(driver, CreateMultipleTaxTest.TaxOptionName1);
		Thread.sleep(2000);
		AddProductGroupDialogBoxElements.SelectDynamicTaxOptionFromDD(driver, CreateMultipleTaxTest.TaxOptionName2);
		Thread.sleep(2000);
		AddProductGroupDialogBoxElements.GetAddButton(driver).click();
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		RegisterManagementDashboardPageElements.Get_ProductGroupTable_IDColumn(driver).click();
		Thread.sleep(5000);
		RegisterManagementDashboardPageElements.Get_ProductGroupTable_IDColumn(driver).click();
		Thread.sleep(5000);
		actualResult = RegisterManagementDashboardPageElements.Get_ProductGroupTable_FirstRowProductGroupNameCloumn(driver).getText();
		assertEquals(actualResult, ProductGroupName);
		
		//System.out.println(ProductGroupName);
	  
	}
  public void createProuductForProuductGroup(WebDriver driver, String ProductName) throws Exception
  {
	  
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
		/*  CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetLastPageButton(driver));
		  System.out.println("After category lastpage button");
		  CategoryDialogBoxElements.GetLastPageButton(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetDynamicCategoryName(driver,"category_1535818401325"));
		  Thread.sleep(2000);
		  CategoryDialogBoxElements.GetDynamicCategoryName(driver,"category_1535818401325").click();
		  Thread.sleep(2000);*/
		  
		  
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
	  Thread.sleep(2000);
	  System.out.println("Tax is "+CreateTaxOptionTest.TaxOptionName);
	  AddProductDialogBoxElements.SelectDynamicTaxOptionFromDD(driver, CreateTaxOptionTest.TaxOptionName);
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
  public void SelectProductsForGroup()
  {
	  
  }
  
}
