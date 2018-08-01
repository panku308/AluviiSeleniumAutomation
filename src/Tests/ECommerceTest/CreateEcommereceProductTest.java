package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddCategoryDialogBoxInsideEcommerceProductsTabElements;
import ObjectRepository.AddProduct_Ecommerce_DialogboxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.WebsiteOpenPageElements;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.TicketingTest.CreateTicketTypeTest;

public class CreateEcommereceProductTest {
	
	
	public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String EcommerceProductName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void CreateEcommerceProduct()throws Exception
	  {
		  EcommerceProductName = "EcommerceProduct-"+ System.currentTimeMillis();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetEcommerceLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetEcommerceLink(driver).click();
		  Thread.sleep(5000);		
		  ECommerceDashboardPageElements.GetProductsTab(driver).click();
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetProductsTab_SubTab_Products(driver).click();
		  Thread.sleep(3000);
		  ECommerceDashboardPageElements.GetProductsTab_SubTab_Products_SelectOptionDD(driver).click();
		  Thread.sleep(2000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Add Product").click();
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  
		  AddProduct_Ecommerce_DialogboxElements.GetProductName(driver).sendKeys(EcommerceProductName);
		  
		  AddProduct_Ecommerce_DialogboxElements.GetSelectProductTypeDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, "Product");
		  Thread.sleep(2000);
		  
		  AddProduct_Ecommerce_DialogboxElements.GetSelectProductDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, CreateProductTest.ProductName);
		  //CommonFunctions.SelectOptionFromDropdownList(driver, "product1530583344369");
		  Thread.sleep(2000);
		  
		  AddProduct_Ecommerce_DialogboxElements.GetWebsiteDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, CreateWebsiteTest.WebsiteName);
		  //CommonFunctions.SelectOptionFromDropdownList(driver, "website-1530796168185");
		  Thread.sleep(2000);
		  
		  AddProduct_Ecommerce_DialogboxElements.GetCategoryDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, CreateEcommerceCategoryTest.EcommerceCategoryName);
		  //CommonFunctions.SelectOptionFromDropdownList(driver, "category-1530931970396");
		  Thread.sleep(2000);
		  
		  AddProduct_Ecommerce_DialogboxElements.GetPriceField(driver).sendKeys("5");
		  
		  AddProduct_Ecommerce_DialogboxElements.GetDigitalProductTypeDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, "Ticket");
		  Thread.sleep(2000);
		  
		  AddProduct_Ecommerce_DialogboxElements.GetDigitalProductDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, CreateTicketTypeTest.TicketTypeName);
		  //CommonFunctions.SelectOptionFromDropdownList(driver, "TicketType-1530878854683");
		  Thread.sleep(2000);
		  
		  AddProduct_Ecommerce_DialogboxElements.GetEcommerceProductUploadButton(driver).click();		  
		  Thread.sleep(5000);
		  List<WebElement> frametag = driver.findElements(By.tagName("iframe"));
		  System.out.println("frame tag = " + frametag.size());
		  CommonFunctions.SwitchToContentFrame(driver);
		  CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, AddProduct_Ecommerce_DialogboxElements.GetSelectfilesButton(driver));
		  Thread.sleep(3000);
		  CommonFunctions.UploadFile(System.getProperty("user.dir") + "\\resources\\index.jpg");
		  Thread.sleep(10000);
		  driver.switchTo().parentFrame();
		  
		  AddProduct_Ecommerce_DialogboxElements.GetEcommerceProductThumbnailUploadButton(driver).click();		  
		  Thread.sleep(5000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, AddProduct_Ecommerce_DialogboxElements.GetSelectfilesButton(driver));
		  Thread.sleep(5000);
		  CommonFunctions.UploadFile(System.getProperty("user.dir") + "\\resources\\index.jpg");
		  Thread.sleep(10000);
		  driver.switchTo().parentFrame();	
		  CommonFunctions.ScrollUptoElement(driver, AddProduct_Ecommerce_DialogboxElements.GetSaveButton(driver));
		  Thread.sleep(2000);
		  AddProduct_Ecommerce_DialogboxElements.GetSaveButton(driver).click();
		  Thread.sleep(10000);
		  driver.switchTo().defaultContent();
		  ECommerceDashboardPageElements.GetProductsTab_SubTab_Products_ProductNameColumnSettingsIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver, EcommerceProductName);
		  assertEquals(ECommerceDashboardPageElements.GetProductsTab_SubTab_Products_FirstRowProductsNameColumn(driver).getText(),EcommerceProductName);
		  Thread.sleep(2000);
		  VerifyEcommerceProductOnWebsite();
	  }
	  
	  public void VerifyEcommerceProductOnWebsite() throws InterruptedException
	  {
		  driver.navigate().refresh();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetWebSiteTab(driver).click();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetWebsiteTab_WebsiteNameClolumnSettingIcon(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.filterTable(driver, CreateWebsiteTest.WebsiteName);		   
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
		  Thread.sleep(2000);
		  assertEquals(WebsiteOpenPageElements.GetCaetgoryProduct(driver, EcommerceProductName).getText(), EcommerceProductName);
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
	  }
	  
}
