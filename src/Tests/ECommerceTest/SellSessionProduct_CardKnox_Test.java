package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import GlobalFiles.VerifyFileIsDownloaded;
import ObjectRepository.CardKnoxDialogBox_OpenWebsite_Elements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.WebsiteOpenPageElements;
import Tests.RegisterManagementTest.CreateProduct_withSessionTest;
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class SellSessionProduct_CardKnox_Test extends TestSetup {
	
	  public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String EcommerceCategoryName="", TransactionID="";
	  
	  @Test
	  public void SellEcommerceProductThroughCreditCard()throws Exception
	  {
		  String ProductName=CreateEcommereceProductTest.EcommerceProductName;
		  
		  driver=DriverManager.getDriver();
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetEcommerceLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetEcommerceLink(driver).click();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetWebSiteTab(driver).click();
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetWebsiteTab_WebsiteNameClolumnSettingIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver, CreateWebsiteTest.WebsiteName);
		//  CommonFunctions.filterTable(driver, "website-1533960662578");
		   
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
		//  WebsiteOpenPageElements.SelectCategory(driver, "Ecom-category-1533960778127");
		  Thread.sleep(5000);
		  WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, ProductName).click();
		 // WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, "session product").click();
		  Thread.sleep(5000);
		  
		  
		  CommonFunctions.SwitchToContentFrame(driver);
		  WebsiteOpenPageElements.GetProductSessionWindow_FirstTimeSlot(driver).click();
		  Thread.sleep(2000);
		  WebsiteOpenPageElements.GetProductSessionWindow_FirstProductQuantityField(driver, ProductName).clear();
		  WebsiteOpenPageElements.GetProductSessionWindow_FirstProductQuantityField(driver,ProductName).sendKeys("2");
		  WebsiteOpenPageElements.GetProductSessionWindow_FirstProductQuantityField(driver, ProductName).sendKeys(Keys.TAB);
		  Thread.sleep(2000);
		  WebsiteOpenPageElements.GetProductSessionWindow_FirstnameField(driver,ProductName, "1").sendKeys("fname"+System.currentTimeMillis());
		  WebsiteOpenPageElements.GetProductSessionWindow_LastnameField(driver,ProductName, "1").sendKeys("lname"+System.currentTimeMillis());
		  WebsiteOpenPageElements.GetProductSessionWindow_FirstnameField(driver,ProductName, "2").sendKeys("fname"+System.currentTimeMillis());
		  WebsiteOpenPageElements.GetProductSessionWindow_LastnameField(driver, ProductName, "2").sendKeys("lname"+System.currentTimeMillis());
		  WebsiteOpenPageElements.GetProductSessionWindow_AddToCartButton(driver).click();
		  Thread.sleep(10000);
		  driver.switchTo().defaultContent();
		  
		  
		  WebsiteOpenPageElements.GetMiniCartCheckoutButton(driver).click();
		  Thread.sleep(10000);

		  WebsiteOpenPageElements.GetMiniCartCheckoutButton(driver).click();
		  
		  Thread.sleep(5000);
		  WebsiteOpenPageElements.GetGuestCheckOutButton(driver).click();
		  Thread.sleep(10000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  WebsiteOpenPageElements.GetGuestFirstnameField(driver).sendKeys("fname");
		  WebsiteOpenPageElements.GetGuestLastNameField(driver).sendKeys("lname");
		  WebsiteOpenPageElements.GetGuestEmailField(driver).sendKeys("Email"+System.currentTimeMillis()+"@gmail.com");
		  WebsiteOpenPageElements.GetGuestContinueButton(driver).click();
		  Thread.sleep(30000);
		  TransactionID = CardKnoxDialogBox_OpenWebsite_Elements.GetTransactionID(driver);
		  CommonFunctions.SwitchToContentFrame(driver);
		  PaymentTransactionType.PaymentThroughCardKnox(driver);

		  Thread.sleep(10000); 
		 
		  assertEquals(WebsiteOpenPageElements.GetPaymentSuccessMessage(driver).getText().trim(), "Congrats! Your payment has completed successfully.");
		
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
		  // Setting back to 0
		  CreateProduct_withSessionTest.SessionProduct=0;
	  }
	 
	 

}
