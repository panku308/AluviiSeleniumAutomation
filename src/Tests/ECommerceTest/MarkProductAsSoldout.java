package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddProduct_Ecommerce_DialogboxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.WebsiteOpenPageElements;

public class MarkProductAsSoldout {
	
	 public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String EcommerceCategoryName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void MarkProductAsSold() throws InterruptedException
	  {
		  
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetEcommerceLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetEcommerceLink(driver).click();
		  Thread.sleep(5000);		
		  ECommerceDashboardPageElements.GetProductsTab(driver).click();
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetProductsTab_SubTab_Products(driver).click();
		  Thread.sleep(3000);
		  ECommerceDashboardPageElements.GetProductsTab_SubTab_Products_ProductNameColumnSettingsIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver, CreateEcommereceProductTest.EcommerceProductName);
		//  CommonFunctions.filterTable(driver, "EcommerceProduct-1535605387660");
		  Thread.sleep(2000);
		  CommonFunctions.ActionBuilder_PerformDoubleClickEventOnElement(driver, ECommerceDashboardPageElements.GetProductsTab_SubTab_Products_FirstRowProductsNameColumn(driver));
		  Thread.sleep(10000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  
		  AddProduct_Ecommerce_DialogboxElements.GetOutOfStockCheckbox(driver).click();
		  Thread.sleep(3000);
		  CommonFunctions.ScrollUptoElement(driver,  AddProduct_Ecommerce_DialogboxElements.GetSaveButton(driver));
		  Thread.sleep(2000);
		  AddProduct_Ecommerce_DialogboxElements.GetSaveButton(driver).click();
		  Thread.sleep(3000);
		  driver.switchTo().defaultContent();
		  assertEquals(AddProduct_Ecommerce_DialogboxElements.GetProductUpdateMessage(driver).getText(), "Product updated successfully.");
		  VerifyOutofStockInWebsite();
	  }
	  public static void VerifyOutofStockInWebsite() throws InterruptedException
	  {
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetEcommerceLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetEcommerceLink(driver).click();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetWebSiteTab(driver).click();
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetWebsiteTab_WebsiteNameClolumnSettingIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver, CreateWebsiteTest.WebsiteName);
		//  CommonFunctions.filterTable(driver, "website-1535605130198");
		   
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetWebsiteTab_FirstRowWebsiteNameColumn(driver).click();
		  ECommerceDashboardPageElements.GetWebsiteTab_SelectOptionDD(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Open Website").click();
		  Thread.sleep(10000);
		  ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));	  
		  
		  CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, WebsiteOpenPageElements.GetCategoriesDD(driver));
		  Thread.sleep(2000);
		  WebsiteOpenPageElements.SelectCategory(driver, CreateEcommerceCategoryTest.EcommerceCategoryName);
		//  WebsiteOpenPageElements.SelectCategory(driver, "Ecom-category-1535605241015");
		  Thread.sleep(5000);
		  String ActResult="";
		  ActResult =WebsiteOpenPageElements.GetCaetgoryProductOutofStockMessage(driver, CreateEcommereceProductTest.EcommerceProductName).getText();
		  //ActResult =  WebsiteOpenPageElements.GetCaetgoryProductOutofStockMessage(driver, "EcommerceProduct-1535605387660").getText();
		 assertEquals(ActResult.trim(), "OUT OF STOCK");
		  Thread.sleep(5000);
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
	  
	  }
}
