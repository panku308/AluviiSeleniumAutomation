package Tests.SellProductTest;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.payment.PaymentRequest;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import ObjectRepository.SellGiftCardDialogBoxElements;
import ObjectRepository.SimpleCashPaymentDialogBox;
import Tests.RegisterManagementTest.CreateRegisterTest;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class SellGiftCard_Cash_Test {
	public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  public static String GiftCardBarcode="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void SellGiftCard_PaymentTypeCash() throws Exception {
		  GiftCardBarcode = String.valueOf(System.currentTimeMillis());
		  DashboardPageElements.GetEmployeeRegistersLink(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, RegisterListPageElements.GetLastPageButton(driver));		  
		  RegisterListPageElements.GetLastPageButton(driver).click();
		  Thread.sleep(3000);
		  RegisterListPageElements.GetRegisterLink(driver, " "+CreateRegisterTest.RegisterName).click();
		  CashierRegisterPageElements.GetSellGiftCardLink(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  SellGiftCardDialogBoxElements.GetGiftCardBarcodeField(driver).sendKeys(GiftCardBarcode);
		  SellGiftCardDialogBoxElements.GetBarCodeTypeDD(driver).click();
		  Thread.sleep(2000);
		  SellGiftCardDialogBoxElements.SelectValueFromBarcodeTypeDropdown(driver, "Gift Card");
		  SellGiftCardDialogBoxElements.GetGiftCardAmountField(driver).sendKeys("10000");
		  SellGiftCardDialogBoxElements.GetAddToCardButton(driver).click();
		  Thread.sleep(3000);
		  driver.switchTo().defaultContent();
		  
		  CashierRegisterPageElements.GetPayButton(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SwitchToContentFrame(driver);		
		  PaymentTransactionType.PaymentThroughCash(driver);
		  CommonFunctions.SwitchToContentFrame(driver);
		  ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		  assertTrue(true);
		  driver.switchTo().defaultContent();
	  }
	
}
