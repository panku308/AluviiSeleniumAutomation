package Tests.SellProductGroupTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.AddEmployeeDialogBox;
import ObjectRepository.AddLoginActivityDialogBox;
import ObjectRepository.AddDiscountDialogBoxElements;
import ObjectRepository.AddDiscountPackageDialogBoxElements;
import ObjectRepository.AddDiscountRuleDialogBoxElements;
import ObjectRepository.AddScheduleEventManagementDialogBoxElements;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.HRManagementPageElements;
import ObjectRepository.ManageDiscountCodesDialogBoxElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.AdministrationTest.CreateMultipleTaxTest;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductGroupWithTwoTaxRatesTest;
import Tests.RegisterManagementTest.CreateProductWithTwoTaxRatesTest;
import Tests.RegisterManagementTest.CreateRegisterWithProductGroupTest;
import Tests.RegisterManagementTest.CreateSimpleRegisterTest;
import baseSetup.TestSetup;
import util.DriverManager;
import ObjectRepository.EditEmployeeDialogBox;
import ObjectRepository.EditScheduleEventManagementDialogBoxElements;
import ObjectRepository.EventManagementPageElements;
@Listeners (GlobalFiles.ReportCustomization.class) 
public class SellProductGroupTest extends TestSetup {

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
		  RegisterListPageElements.GetRegisterLink(driver, " "+CreateRegisterWithProductGroupTest.RegisterName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryElement(driver, CreateCategoryTest.CategoryName).click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryProductElement(driver, CreateProductGroupWithTwoTaxRatesTest.ProductGroupName).click();
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
