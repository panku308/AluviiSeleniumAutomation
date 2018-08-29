package Tests.SellProductTest;

import static org.testng.Assert.assertEquals;
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
import ObjectRepository.GiftCardManagementPageElements;
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
	  public static Double GiftCardAmount=10000.00;
	  public static Double ExpCurrentBalance = 0.00;
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
		  
		  SellGiftCardDialogBoxElements.GetGiftCardAmountField(driver).sendKeys(String.valueOf(GiftCardAmount));
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
		  ExpCurrentBalance = GiftCardAmount;
		  driver.switchTo().defaultContent();
	  }
	  public static void VerifyCurrentAndOriginalBalance(WebDriver driver, String Barcode) throws InterruptedException
	  {
		 CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetGiftCardManagementLink(driver));
		 Thread.sleep(2000);
		 DashboardPageElements.GetGiftCardManagementLink(driver).click();
		 Thread.sleep(5000);
		 GiftCardManagementPageElements.getGiftCardBarCodeColumnSettingsIcon(driver).click();
		 CommonFunctions.filterTable(driver, Barcode);
		 Thread.sleep(5000);
		 String ActcurrentBal = GiftCardManagementPageElements.getCurrentBalanceFieldFirstRow(driver).getText();
		 ActcurrentBal = CommonFunctions.RemoveCharFromString(ActcurrentBal, "$");
		 assertEquals(ActcurrentBal, CommonFunctions.ConverNumberStringIntoCommaFormat(String.valueOf(ExpCurrentBalance)));
		 
		 String ActOriginalCurBal = GiftCardManagementPageElements.getOriginalBalanceFieldFirstRow(driver).getText();
		 ActcurrentBal= CommonFunctions.RemoveCharFromString(ActOriginalCurBal, "$");
		 assertEquals(ActOriginalCurBal, CommonFunctions.ConverNumberStringIntoCommaFormat(String.valueOf(GiftCardAmount)));
		 
		 
	  }	
}
