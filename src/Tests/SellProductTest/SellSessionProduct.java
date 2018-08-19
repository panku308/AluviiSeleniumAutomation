package Tests.SellProductTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import ObjectRepository.SessionProductWindowElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateProduct_withSessionTest;
import Tests.RegisterManagementTest.CreateRegisterTest;
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class SellSessionProduct extends TestSetup{
	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  
	  @Test
	  public void SellProduct_PaymentTypeCash() throws Exception {
		  driver=DriverManager.getDriver();
		  DashboardPageElements.GetEmployeeRegistersLink(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, RegisterListPageElements.GetLastPageButton(driver));		  
		  RegisterListPageElements.GetLastPageButton(driver).click();
		  Thread.sleep(5000);
		  RegisterListPageElements.GetRegisterLink(driver, " "+CreateRegisterTest.RegisterName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryElement(driver, CreateCategoryTest.CategoryName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryProductElement(driver, CreateProduct_withSessionTest.ProductName2).click();
		  Thread.sleep(15000);
		  /*RegisterListPageElements.GetRegisterLink(driver, " "+ "Register_1534649393150").click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryElement(driver, "category_1534649045240").click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryProductElement(driver, "product1534649218071").click();
		  Thread.sleep(15000);
		  */
		  
		  driver.switchTo().frame(CashierRegisterPageElements.GetSessionProductWindowFrame(driver));
		  int BeforeSellSlotAvailableCount= GetAvailabelSlotsCount();
		  SessionProductWindowElements.GetFirstTimeSlot(driver).click();
		  Thread.sleep(2000);
		  
		  /*SessionProductWindowElements.GetFirstProductQuantityField(driver,"product1534649218071").clear();
		  SessionProductWindowElements.GetFirstProductQuantityField(driver,"product1534649218071").sendKeys("3");
		  SessionProductWindowElements.GetFirstProductQuantityField(driver,"product1534649218071").sendKeys(Keys.TAB);
		  */
		  
		  SessionProductWindowElements.GetFirstProductQuantityField(driver,CreateProduct_withSessionTest.ProductName1).clear();
		  SessionProductWindowElements.GetFirstProductQuantityField(driver,CreateProduct_withSessionTest.ProductName1).sendKeys("3");
		  SessionProductWindowElements.GetFirstProductQuantityField(driver,CreateProduct_withSessionTest.ProductName1).sendKeys(Keys.TAB);
		  
		  Thread.sleep(3000);
		  SessionProductWindowElements.GetAttachWaiverLaterButton(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();		  
		  int ExpSlotAvailableCount = BeforeSellSlotAvailableCount-3;
		  
		  CashierRegisterPageElements.GetPayButton(driver).click();
		  Thread.sleep(5000);		  	  
		  driver.switchTo().frame(CashierRegisterPageElements.GetPaymentFrameWindowForSessionProduct(driver));		  
		  PaymentTransactionType.PaymentThroughCash(driver);
		  driver.switchTo().frame(CashierRegisterPageElements.GetPaymentFrameWindowForSessionProduct(driver));
		  ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		  assertTrue(true);
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  CashierRegisterPageElements.GetCategoryProductElement(driver, CreateProduct_withSessionTest.ProductName2).click();
		 // CashierRegisterPageElements.GetCategoryProductElement(driver, "product1534649218071").click();
		  Thread.sleep(15000);
		  driver.switchTo().frame(CashierRegisterPageElements.GetSessionProductWindowFrame(driver));
		  assertEquals(SessionProductWindowElements.GetFirstTimeSlot(driver).getText(), ExpSlotAvailableCount+ " slot available");
		  driver.switchTo().defaultContent();
		  SessionProductWindowElements.GetCloseButton(driver).click();
		  
		  
	  }
	  public static int GetAvailabelSlotsCount()
	  {
		  String AvailabelSlots = SessionProductWindowElements.GetFirstTimeSlot(driver).getText();
		  int count= Integer.valueOf(AvailabelSlots.substring(0, AvailabelSlots.indexOf(" slot")));
		  return count;
	  }
	
}
