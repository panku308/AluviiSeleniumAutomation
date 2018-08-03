package Tests.SellProductTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.AddGuestDialogBoxInsideSellProductElements;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class SellProductWithDiscount_Cash_Test {
	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public void SellProduct_PaymentTypeCash() throws Exception {
		  
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
		  ApplyAndVerifyDiscount();
		  CashierRegisterPageElements.GetPayButton(driver).click();
		  Thread.sleep(2000);		  	  
		  CommonFunctions.SwitchToContentFrame(driver);
		  PaymentTransactionType.PaymentThroughCash(driver);
		  CommonFunctions.SwitchToContentFrame(driver);
		  ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		  assertTrue(true);
		  driver.switchTo().defaultContent();
		  
	  }
	  public void ApplyAndVerifyDiscount() throws Exception
	  {
		  CashierRegisterPageElements.GetAddGuestButton(driver).click();
		  Thread.sleep(5000);		  	  
		  CommonFunctions.SwitchToContentFrame(driver);
		  AddGuestDialogBoxInsideSellProductElements.GetSearchForGuestRadioButton(driver).click();
		  AddGuestDialogBoxInsideSellProductElements.GetSearchField(driver).sendKeys("Krishna Shankar");
		  AddGuestDialogBoxInsideSellProductElements.GetSearchButton(driver).click();		  
		  Thread.sleep(5000);
		  AddGuestDialogBoxInsideSellProductElements.GetSearchRecord(driver).click();
		  Thread.sleep(5000);
		  driver.switchTo().defaultContent();
		  assertEquals(CashierRegisterPageElements.GetAddGuestButton(driver).getText().trim(), "Krishna Shankar");
		  assertEquals(CashierRegisterPageElements.GetDiscountValue(driver).getText().trim(), "$2.00");		  
		  assertTrue(isDiscountApplied());
	  }
	  public boolean isDiscountApplied()
	  {
		  String SubTotal="", Discount="",Tax="",TotalPaymentDue="",temp="";
		  temp = CashierRegisterPageElements.GetSubTotalValue(driver).getText();
		  SubTotal = temp.substring(temp.indexOf("$")+1, temp.length());
		  System.out.println(SubTotal);
		  temp = CashierRegisterPageElements.GetTaxValue(driver).getText();
		  Tax=temp.substring(temp.indexOf("$")+1, temp.length());
		  System.out.println(Tax);
		  temp = CashierRegisterPageElements.GetDiscountValue(driver).getText();
		  Discount=temp.substring(temp.indexOf("$")+1, temp.length());
		  System.out.println(Discount);
		  temp= CashierRegisterPageElements.GetPayButton(driver).getAttribute("value");
		  TotalPaymentDue= temp.substring(temp.indexOf("$")+1, temp.length());
		  System.out.println(TotalPaymentDue);
		  if((Double.valueOf(SubTotal)-Double.valueOf(Discount))+Double.valueOf(Tax)==Double.valueOf(TotalPaymentDue))
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
		  
	  }
	
}
