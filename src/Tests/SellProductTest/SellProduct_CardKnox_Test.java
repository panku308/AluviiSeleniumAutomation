package Tests.SellProductTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;

public class SellProduct_CardKnox_Test {
	
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
		  
		  CommonFunctions.SwitchToContentFrame(driver);		
		  
		  //PaymentTransactionType.PaymentThroughCreditCard(driver);
		  PaymentTransactionType.PaymentThroughCardKnox(driver);
		  CommonFunctions.SwitchToContentFrame(driver);
		  ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		  
		  assertTrue(true);
		  driver.switchTo().defaultContent();
		  
	  }
	 
}
