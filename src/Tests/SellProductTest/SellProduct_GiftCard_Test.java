package Tests.SellProductTest;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.GiftCardPaymentDialogBoxElements;
import ObjectRepository.PaymentThroughCreditCardDialogBoxElements;
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;

public class SellProduct_GiftCard_Test {
	
	public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	 
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void SellProduct_PaymentTypeCreditcard() throws Exception {
		  
		  DashboardPageElements.GetEmployeeRegistersLink(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, RegisterListPageElements.GetLastPageButton(driver));		  
		  RegisterListPageElements.GetLastPageButton(driver).click();
		  Thread.sleep(5000);
		  RegisterListPageElements.GetRegisterLink(driver, " "+CreateRegisterTest.RegisterName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryElement(driver, CreateCategoryTest.CategoryName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryProductElement(driver, CreateProductTest.ProductName).click();
		  Thread.sleep(2000);
		  CashierRegisterPageElements.GetPayButton(driver).click();
		  Thread.sleep(2000);
		  
		  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));		  
		  System.out.println("iframe length = " + iframeElements.size());		  
		  driver.switchTo().frame(0);		
		  
		  PaymentTransactionDialogBoxElements.GetGiftCardButton(driver).click();
		  Thread.sleep(2000);
		  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));		  
		  System.out.println("iframe length = " + iframeElements.size());		  
		  driver.switchTo().frame(0);
		  
		  GiftCardPaymentDialogBoxElements.GetGiftCardBarcode(driver).sendKeys("123456");
		  GiftCardPaymentDialogBoxElements.GetBalanaceButton(driver).click();
		  Thread.sleep(2000);
		  GiftCardPaymentDialogBoxElements.GetPayWithGiftCardButton(driver).click();		  
		  Thread.sleep(5000);
		  driver.switchTo().parentFrame();
		  PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();
		  Thread.sleep(5000);
		  iframeElements1 = driver.findElements(By.tagName("iframe"));		  
		  System.out.println("iframe length = " + iframeElements.size());		  
		  driver.switchTo().frame(0);		  
		  ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		  assertTrue(true);
		  driver.switchTo().defaultContent();
		  
	  }
	
}
