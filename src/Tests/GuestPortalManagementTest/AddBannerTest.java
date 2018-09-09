package Tests.GuestPortalManagementTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddProduct_Ecommerce_DialogboxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.GuestPortalManagementPageElements;
import ObjectRepository.GuestPortalManagement_AddNewBannerDialogboxElements;


public class AddBannerTest {
	
	public static WebDriver driver=null;
	 public static String BannerName="";
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
		  Thread.sleep(5000);
	  }
	@Test
	public static void AddBanner() throws Exception
	{
		BannerName = "Banner"+System.currentTimeMillis();
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetGuestProtalMangementLink(driver));
		Thread.sleep(2000);
		DashboardPageElements.GetGuestProtalMangementLink(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetBannersTab(driver).click();
		Thread.sleep(2000);
		GuestPortalManagementPageElements.GetBannerTab_SelectOptionDropdown(driver).click();
		Thread.sleep(2000);
		CommonFunctions.SelectOptionFromDropdownList(driver, "Add New Banner");
		Thread.sleep(2000);
		CommonFunctions.SwitchToContentFrame(driver);
		GuestPortalManagement_AddNewBannerDialogboxElements.GetBannerNameField(driver).sendKeys(BannerName);
		CommonFunctions.ScrollUptoElement(driver, GuestPortalManagement_AddNewBannerDialogboxElements.GetUploadDesktopImageButton(driver));
		Thread.sleep(2000);
		GuestPortalManagement_AddNewBannerDialogboxElements.GetUploadDesktopImageButton(driver).click();
		
		 Thread.sleep(5000);
		  
		  CommonFunctions.SwitchToContentFrame(driver);
		  CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, GuestPortalManagement_AddNewBannerDialogboxElements.GetSelectfilesButton(driver));
		  Thread.sleep(3000);
		  CommonFunctions.UploadFile(System.getProperty("user.dir") + "\\resources\\index.jpg");
		  Thread.sleep(10000);
		  driver.switchTo().parentFrame();
		  
		  GuestPortalManagement_AddNewBannerDialogboxElements.GetUploadMobileImageButton(driver).click();
		  Thread.sleep(5000);
		  
		  CommonFunctions.SwitchToContentFrame(driver);
		  CommonFunctions.ActionBuilder_PerformClickEventOnElement(driver, GuestPortalManagement_AddNewBannerDialogboxElements.GetSelectfilesButton(driver));
		  Thread.sleep(3000);
		  CommonFunctions.UploadFile(System.getProperty("user.dir") + "\\resources\\Bitmapfile.bmp");
		  Thread.sleep(10000);
		  driver.switchTo().parentFrame();
		  
		  GuestPortalManagement_AddNewBannerDialogboxElements.GetAddButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  GuestPortalManagementPageElements.GetBannerTab_BannerNameCoumnSettingIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver, BannerName);
		  assertEquals(GuestPortalManagementPageElements.GetBannerTab_BannerNameFirstRow(driver).getText(), BannerName);
		  
		  
		  
	}
	public static void VerifyBanner()
	{
		
	}
}
