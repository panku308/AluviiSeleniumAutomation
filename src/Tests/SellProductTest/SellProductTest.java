package Tests.SellProductTest;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductWithTwoTaxRatesTest;
import Tests.RegisterManagementTest.CreateRegisterWithProductTest;
import Tests.RegisterManagementTest.CreateSimpleRegisterTest;
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class SellProductTest extends TestSetup {

	public static String discountCode="";
	public static String discountAmt="";

	@Test
	 public void sellProductWithTwoTaxRates() throws Exception {
		  
		  WebDriver driver=DriverManager.getDriver();
		  DashboardPageElements.GetEmployeeRegistersLink(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, RegisterListPageElements.GetLastPageButton(driver));		  
		  RegisterListPageElements.GetLastPageButton(driver).click();
		  Thread.sleep(5000);
		  RegisterListPageElements.GetRegisterLink(driver, " "+CreateRegisterWithProductTest.RegisterName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryElement(driver, CreateCategoryTest.CategoryName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryProductElement(driver, CreateProductWithTwoTaxRatesTest.ProductName).click();
		  Thread.sleep(2000);
		  
		 //System.out.println(CashierRegisterPageElements.GetSubTotalValue(driver).getText());
		  
		  double subTotalValue=CommonFunctions.getPriceWithoutCurrencyAnnotation((CashierRegisterPageElements.GetSubTotalValue(driver).getText()));
		  String expectedTax="$"+String.valueOf(String.format("%.2f",(subTotalValue*(Double.parseDouble(CommonFunctions.taxRate)
				  + Double.parseDouble(CommonFunctions.taxRate)))));
		 
		  String actualTax=CashierRegisterPageElements.GetTaxValue(driver).getText();
		  
		 // System.out.println(actualTax +"   "+ expectedTax);
		  
		  Assert.assertEquals(actualTax, expectedTax);
		  
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
