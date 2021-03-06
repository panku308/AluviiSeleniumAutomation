package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

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
@Listeners (GlobalFiles.ReportCustomization.class) 
public class SellEcommerceProduct_CardKnox_Test {
	
	public static WebDriver driver=null;
	  public static String actualResult="";
	  public static String EcommerceCategoryName="", TransactionID="";
	  
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
		 // WebsiteOpenPageElements.SelectCategory(driver, "category-1530931970396");
		  Thread.sleep(5000);
		  WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, CreateEcommereceProductTest.EcommerceProductName).click();
		//  WebsiteOpenPageElements.GetCaetgoryProductAddToCartButton(driver, "1531114700645").click();
		  Thread.sleep(5000);
		  WebsiteOpenPageElements.GetMiniCartCheckoutButton(driver).click();
		  Thread.sleep(10000);
		  WebsiteOpenPageElements.GetQuantityField(driver).clear();
		  WebsiteOpenPageElements.GetQuantityField(driver).sendKeys(String.valueOf(CommonFunctions.ECommereceProductQuantity));
		  Thread.sleep(5000);
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
		  String downloadPath = System.getProperty("user.home")+"\\Downloads";
		  assertEquals(VerifyFileIsDownloaded.isFileDownloaded(downloadPath, GetFileName()),true);
		  assertEquals(VerifyFileIsDownloaded.getNumberOfPagesFromPDFFile(downloadPath+"\\"+GetFileName()), CommonFunctions.ECommereceProductQuantity);
		  driver.close();
		  driver.switchTo().window(windowHandles.get(0));
		  
	  }
	  public static String GetFileName()
	  {
			 String FileName = "TicketTransaction-"+TransactionID+"_"+ CommonFunctions.getCurrentDateInMMddyyyyFormat()+".pdf";	
			 System.out.println("Expected File name = "+FileName);
			 return FileName;		 
	  }
	 

}
