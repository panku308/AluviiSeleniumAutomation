package Tests.ECommerceTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.AddFeeDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;

public class CreateSiteWiseTransactionFees {

	 public static WebDriver driver=null;
	  public static String actualResult="", TransactionFeeName="";
	  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void CreateTransactionFees() throws Exception
	  {
		  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetEcommerceLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetEcommerceLink(driver).click();
		  Thread.sleep(5000);		
		  ECommerceDashboardPageElements.GetSetupTab(driver).click();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetFeesTab(driver).click();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetSetupTab_SubTab_Fees_SelectOptionDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, "Add Fee");
		  Thread.sleep(5000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  TransactionFeeName = "TransFees-" +System.currentTimeMillis();
		  AddFeeDialogBoxElements.GetInternalFeeName(driver).sendKeys(TransactionFeeName);
		  AddFeeDialogBoxElements.GetExternalFeeName(driver).sendKeys(TransactionFeeName);
		  AddFeeDialogBoxElements.GetFeeTypeDD(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SelectOptionFromDropdownList(driver, "Percentage");
		  AddFeeDialogBoxElements.GetDescriptionField(driver).sendKeys(TransactionFeeName);
		  AddFeeDialogBoxElements.GetSaveButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  VerifyInternalFeeRecord();
		  
	  }
	  public static void VerifyInternalFeeRecord() throws Exception
	  {
		  AddFeeDialogBoxElements.GetInternalFeeNameColumnsSettingsIcon(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.filterTable(driver, TransactionFeeName);
		  Thread.sleep(2000);
		  assertEquals(AddFeeDialogBoxElements.GetFirstRowInternalFeeNameFieldValue(driver).getText(), TransactionFeeName);
	  }

}
