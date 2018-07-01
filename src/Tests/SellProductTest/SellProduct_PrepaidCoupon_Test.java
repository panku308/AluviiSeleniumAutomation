package Tests.SellProductTest;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.PrePaidCouponDialogBoxElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import ObjectRepository.SimpleCashPaymentDialogBox;
import ObjectRepository.StoredValueDialogBoxElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class SellProduct_PrepaidCoupon_Test {
	

	//fname1530097726899
	public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void SellProduct_PaymentTypeStoredValue() throws Exception {
		 
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
		  PaymentTransactionDialogBoxElements.GetMoreButton(driver).click();
		  Thread.sleep(2000);
		  PaymentTransactionDialogBoxElements.GetMoreOptoin_PrepaidCouopon(driver).click();
		  Thread.sleep(5000);
		  
		  List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));		  
		  System.out.println("iframe length = " + iframeElements.size());		  
		  driver.switchTo().frame(0);
		  
		  PrePaidCouponDialogBoxElements.GetAmountReceivedField(driver).sendKeys(PrePaidCouponDialogBoxElements.GetPaymentAmountField(driver).getAttribute("value"));
		  PrePaidCouponDialogBoxElements.GetSubmitButton(driver).click();		  
		  Thread.sleep(5000);
		  
		  driver.switchTo().parentFrame();
		  
		  PaymentTransactionDialogBoxElements.GetCompletePaymentButton(driver).click();		  
		  Thread.sleep(5000);
		  
		  iframeElements = driver.findElements(By.tagName("iframe"));		  
		  System.out.println("iframe length = " + iframeElements.size());		  
		  driver.switchTo().frame(0);
		  
		  ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		  assertTrue(true);
		  driver.switchTo().defaultContent();
		  
	  }
	
	

}
