package Tests.RegisterManagementTest;

import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class CreateProductTest {

	  public static WebDriver driver=null;
	  String expectedResult="", actualResult="";
	  public static String ProductName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void AddProductTest()throws Exception
	  {
		  ProductName="product" + System.currentTimeMillis();
		  DashboardPageElements.GetRegisterManagementLink(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab(driver).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Products_SelectOptionDropdown(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Product").click();
		  Thread.sleep(3000);
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		  System.out.println("iframe length = " + iframeElements.size());
		  driver.switchTo().frame(0);
		
		  
		  
		  AddProductDialogBoxElements.GetProductName(driver).sendKeys(ProductName);
		  
		  AddProductDialogBoxElements.GetCategory(driver).click();		  
		  Thread.sleep(5000);
		  if(CreateCategoryTest.CategoryName!=null && !CreateCategoryTest.CategoryName.equals("")) {
			  CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetLastPageButton(driver));
			  System.out.println("After category lastpage button");
			  CategoryDialogBoxElements.GetLastPageButton(driver).click();
			  Thread.sleep(5000);
			  CommonFunctions.ScrollUptoElement(driver, CategoryDialogBoxElements.GetDynamicCategoryName(driver,CreateCategoryTest.CategoryName));
			  Thread.sleep(2000);
			  CategoryDialogBoxElements.GetDynamicCategoryName(driver,CreateCategoryTest.CategoryName).click();
			  Thread.sleep(2000);
		  }
		  else
		  {
			  CategoryDialogBoxElements.GetStaticCategoryName(driver).click();
			  Thread.sleep(2000);
		  }
		  
		  
		  AddProductDialogBoxElements.GetProductDescription(driver).sendKeys("Product description " + System.currentTimeMillis());
		  AddProductDialogBoxElements.GetPricingTab(driver).click();
		  Thread.sleep(3000);
		  
		  AddProductDialogBoxElements.SetUnitPrice(driver, CommonFunctions.CreateProduct_unitPrice);
		  AddProductDialogBoxElements.GetSalesTaxTab(driver).click();
		  Thread.sleep(3000);
		  AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		  AddProductDialogBoxElements.GetSalesTax_FirstRowOfTaxOptionNameColumn(driver).click();
		  Thread.sleep(2000);
		  AddProductDialogBoxElements.SelectfirstOptionFromTaxOptionDropdown(driver);
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
