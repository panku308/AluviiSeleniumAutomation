package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.WebsiteOpenPageElements;

public class RemovePrdouctFromCart {
 
	
	  public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String EcommerceCategoryName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void RemoveProductTest() throws InterruptedException
	  {

		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetEcommerceLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetEcommerceLink(driver).click();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetWebSiteTab(driver).click();
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetWebsiteTab_WebsiteNameClolumnSettingIcon(driver).click();
		  Thread.sleep(2000);
		 // CommonFunctions.filterTable(driver, CreateWebsiteTest.WebsiteName);
		  CommonFunctions.filterTable(driver, "website-1535605130198");
		   
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
		//  WebsiteOpenPageElements.SelectCategory(driver, CreateEcommerceCategoryTest.EcommerceCategoryName);
		  WebsiteOpenPageElements.SelectCategory(driver, "Ecom-category-1535605241015");
		  Thread.sleep(5000);
		//  WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, CreateEcommereceProductTest.EcommerceProductName).click();
		    WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, "EcommerceProduct-1535605387660").click();
		  Thread.sleep(5000);
		  WebsiteOpenPageElements.GetBtnClearCart(driver).click();
		  Thread.sleep(2000);
		  String ActPrice="", ExpPrice="0.00";
		  ActPrice = CommonFunctions.RemoveCharFromString(WebsiteOpenPageElements.GetCartTotal(driver).getText(),"$");

		  assertEquals(ActPrice, ExpPrice);
//		  WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, CreateEcommereceProductTest.EcommerceProductName).click();
		      WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, "EcommerceProduct-1535605387660").click();
		  Thread.sleep(5000);
		  

		  WebsiteOpenPageElements.GetMiniCartCheckoutButton(driver).click();
		  Thread.sleep(10000);
		  
		  WebsiteOpenPageElements.GetQuantityField(driver).clear();
		  WebsiteOpenPageElements.GetQuantityField(driver).sendKeys(String.valueOf(CommonFunctions.ECommereceProductQuantity));
		  WebsiteOpenPageElements.GetQuantityField(driver).sendKeys(Keys.TAB);
		  Thread.sleep(10000);
		  WebsiteOpenPageElements.GetBtnClearCart(driver).click();
		  Thread.sleep(1000);		  
		  ActPrice = CommonFunctions.RemoveCharFromString(WebsiteOpenPageElements.GetCartTotal(driver).getText(),"$");
		  assertEquals(ActPrice, ExpPrice);
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
	  
	  
	  }
}
