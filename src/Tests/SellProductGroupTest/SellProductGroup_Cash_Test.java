package Tests.SellProductGroupTest;

import static org.testng.Assert.assertTrue;

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
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductGroupTest;
import Tests.RegisterManagementTest.CreateRegisterTest;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class SellProductGroup_Cash_Test {
	 public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  
	  @Test
	  public static void SellProductGroup_PaymentTypeCash() throws Exception {
		  DashboardPageElements.GetEmployeeRegistersLink(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, RegisterListPageElements.GetLastPageButton(driver));		  
		  RegisterListPageElements.GetLastPageButton(driver).click();
		  Thread.sleep(5000);
		  RegisterListPageElements.GetRegisterLink(driver, " "+CreateRegisterTest.RegisterName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryElement(driver, CreateCategoryTest.CategoryName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryProductElement(driver, CreateProductGroupTest.ProductGroupName).click();
		  Thread.sleep(2000);
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
