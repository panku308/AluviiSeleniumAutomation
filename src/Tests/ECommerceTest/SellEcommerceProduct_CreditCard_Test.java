package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.payment.PaymentRequest;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.WebsiteOpenPageElements;
import Tests.RegisterManagementTest.CreateProductTest;

public class SellEcommerceProduct_CreditCard_Test {
	
	public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String EcommerceCategoryName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void SellEcommerceProductThroughCreditCard()throws Exception
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
		//  CommonFunctions.filterTable(driver, "website-1530796168185");
		   
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
	//	  WebsiteOpenPageElements.SelectCategory(driver, "category-1530931970396");
		  Thread.sleep(2000);
		  WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, CreateEcommereceProductTest.EcommerceProductName).click();
		  //WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, "1531114700645").click();
		  Thread.sleep(2000);
		  WebsiteOpenPageElements.GetMiniCartCheckoutButton(driver).click();
		  Thread.sleep(10000);
		  WebsiteOpenPageElements.GetMiniCartCheckoutButton(driver).click();
		  //driver.switchTo().frame(0);
		  Thread.sleep(2000);
		  WebsiteOpenPageElements.GetGuestCheckOutButton(driver).click();
		  Thread.sleep(10000);
		  driver.switchTo().frame(0);
		  WebsiteOpenPageElements.GetGuestFirstnameField(driver).sendKeys("fname");
		  WebsiteOpenPageElements.GetGuestLastNameField(driver).sendKeys("lname");
		  WebsiteOpenPageElements.GetGuestEmailField(driver).sendKeys("Email"+System.currentTimeMillis()+"@gmail.com");
		  WebsiteOpenPageElements.GetGuestContinueButton(driver).click();
		  Thread.sleep(15000);
		  driver.switchTo().frame(0);
		  PaymentTransactionType.PaymentThroughCreditCard(driver);
		  Thread.sleep(10000);
		 
		  assertEquals(WebsiteOpenPageElements.GetPaymentSuccessMessage(driver).getText().trim(), "Congrats! Your payment has completed successfully.");
		  
		  
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
		  
		  
	  }
}
