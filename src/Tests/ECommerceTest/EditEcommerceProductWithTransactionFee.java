package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddProduct_Ecommerce_DialogboxElements;
import ObjectRepository.AddWebsiteDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.WebsiteOpenPageElements;

public class EditEcommerceProductWithTransactionFee {
	
	
	
	public static WebDriver driver=null;
	  public static String actualResult="", TransactionFeePercentage="0.10";
	
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void EditProductwithTransactionFee() throws InterruptedException
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
		  Thread.sleep(2000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  AddProduct_Ecommerce_DialogboxElements.GetIncludeTransactionFeeCheckbox(driver).click();
		  Thread.sleep(2000);
		  AddProduct_Ecommerce_DialogboxElements.GetFeeNameDropdown(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, CreateSiteWiseTransactionFees.TransactionFeeName);
		//  CommonFunctions.SelectOptionFromDropdownList(driver, "PL fees");
		  
		  AddProduct_Ecommerce_DialogboxElements.GetFeeAmountField(driver).sendKeys(Keys.chord(TransactionFeePercentage));
		  AddProduct_Ecommerce_DialogboxElements.GetChargeTaxCheckbox(driver).click();
		  AddProduct_Ecommerce_DialogboxElements.GetChargeFeePerProductRadioButton(driver).click();
		  
		  CommonFunctions.ScrollUptoElement(driver, AddProduct_Ecommerce_DialogboxElements.GetSaveButton(driver));
		  Thread.sleep(2000);
		  AddProduct_Ecommerce_DialogboxElements.GetSaveButton(driver).click();
		  Thread.sleep(2000);
		  driver.switchTo().defaultContent();
		  assertEquals(AddProduct_Ecommerce_DialogboxElements.GetProductUpdateMessage(driver).getText(), "Product updated successfully.");
		  VerifyFeeDetailsOnWebsite();
	  }
	  public static void VerifyFeeDetailsOnWebsite() throws InterruptedException
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
		  //WebsiteOpenPageElements.SelectCategory(driver, "Ecom-category-1535605241015");
		  Thread.sleep(5000);
		  WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, CreateEcommereceProductTest.EcommerceProductName).click();
	//	    WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, "EcommerceProduct-1535605387660").click();
		  Thread.sleep(5000);
		  String ExpPrice=CommonFunctions.RemoveCharFromString(WebsiteOpenPageElements.GetProductPriceOnMiniCart(driver, CreateEcommereceProductTest.EcommerceProductName).getText(),"$");
		//  String ExpPrice=CommonFunctions.RemoveCharFromString(WebsiteOpenPageElements.GetProductPriceOnMiniCart(driver, "EcommerceProduct-1535605387660").getText(),"$");
		  String ExpTransFees="";
		  String ActTransFees="";
		  ActTransFees = CommonFunctions.RemoveCharFromString(WebsiteOpenPageElements.GetTransactionFees(driver).getText(), "$");
		  ExpTransFees = CalculatExpectedTransactionFees("1", ExpPrice, TransactionFeePercentage);
		  assertEquals(ActTransFees,ExpTransFees );
		  
		  WebsiteOpenPageElements.GetMiniCartCheckoutButton(driver).click();
		  Thread.sleep(10000);
		  
		  WebsiteOpenPageElements.GetQuantityField(driver).clear();
		  WebsiteOpenPageElements.GetQuantityField(driver).sendKeys(String.valueOf(CommonFunctions.ECommereceProductQuantity));
		  WebsiteOpenPageElements.GetQuantityField(driver).sendKeys(Keys.TAB);
		  Thread.sleep(10000);
		  ActTransFees = CommonFunctions.RemoveCharFromString(WebsiteOpenPageElements.GetTransactionFees(driver).getText(), "$");
		  ExpTransFees = CalculatExpectedTransactionFees(String.valueOf(CommonFunctions.ECommereceProductQuantity), ExpPrice, TransactionFeePercentage);
		  assertEquals(ActTransFees,ExpTransFees );
		  
	  }
	  public static String CalculatExpectedTransactionFees(String Qty, String Price, String TransactionFeesInPercentage)
	  {
		  Double TotalTransactionFees = 0.00;		  
		  TotalTransactionFees = Double.parseDouble(Qty) * Double.parseDouble(CommonFunctions.RemoveCharFromString(Price,"$")) ;
		  System.out.println("= "+TotalTransactionFees);
		  TotalTransactionFees = TotalTransactionFees*Double.parseDouble(TransactionFeesInPercentage);
		  System.out.println("= "+TotalTransactionFees);
		  return CommonFunctions.ConverNumberStringIntoCommaFormat(String.valueOf(TotalTransactionFees));
		  
	  }
	
}
