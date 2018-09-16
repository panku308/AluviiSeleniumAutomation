package Tests.EmployeeRegistersTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.AddDiscountDialogBoxElements;
import ObjectRepository.AddGuestDialogBoxInsideSellProductElements;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateDiscountTest;
import Tests.RegisterManagementTest.CreateFixedDiscountOnProductTest;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;
import Tests.RegisterManagementTest.CreateSimpleRegisterTest;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class Register_FixedDiscountOnProductTest {
	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void fixedDiscountOnProductTest() throws Exception {
		  
		  DashboardPageElements.GetEmployeeRegistersLink(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, RegisterListPageElements.GetLastPageButton(driver));		  
		  RegisterListPageElements.GetLastPageButton(driver).click();
		  Thread.sleep(5000);
		  RegisterListPageElements.GetRegisterLink(driver, " "+CreateSimpleRegisterTest.RegisterName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryElement(driver, CreateCategoryTest.CategoryName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryProductElement(driver, CreateProductTest.ProductName).click();
		  Thread.sleep(2000);
		  CashierRegisterPageElements.GetPayButton(driver).click();
		  Thread.sleep(2000);		  	  
		  CommonFunctions.SwitchToContentFrame(driver);
		  Thread.sleep(2000);
		  PaymentTransactionType.getDiscountButton(driver).click();
		  Thread.sleep(2000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  Thread.sleep(2000);
		  AddDiscountDialogBoxElements.getDiscountCodeInputField(driver).sendKeys(CreateFixedDiscountOnProductTest.discountCode);
		  Thread.sleep(2000);
		  AddDiscountDialogBoxElements.getApplyButton(driver).click();
		  Thread.sleep(2000);
		  
		  Assert.assertTrue(AddDiscountDialogBoxElements.getAppliedDiscount(driver).getText().contains(CreateFixedDiscountOnProductTest.discountAmt));
		  Thread.sleep(2000);
		  AddDiscountDialogBoxElements.getCloseButton(driver).click();
		  Thread.sleep(2000);
		  
		  
		  driver.switchTo().defaultContent();
		  CommonFunctions.SwitchToContentFrame(driver);
		  Assert.assertTrue(PaymentTransactionType.getAppliedDiscount(driver).getText().contains(CreateFixedDiscountOnProductTest.discountAmt));
		  
		  PaymentTransactionType.getCloseButton(driver).click();
	  }
	 
}
