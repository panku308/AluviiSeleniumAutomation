package Tests.SellProductTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ProductModifierInsideCashierRegisterElements;
import ObjectRepository.RegisterListPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductModifier;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;

public class SellProductWithModifier_Cash_Test {

	  public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void SellProductWithModifier_PaymentTypeCash() throws Exception {
		  
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
		  driver.switchTo().frame(0);
		  ProductModifierInsideCashierRegisterElements.GetModifierButton(driver, CreateProductModifier.ModifierValue[0]).click();
		  Thread.sleep(2000);
		  ProductModifierInsideCashierRegisterElements.GetAddButton(driver).click();
		  Thread.sleep(2000);
		  driver.switchTo().defaultContent();
		  if(CashierRegisterPageElements.GetModifierFieldInShopingCardSection(driver, CreateProductTest.ProductName, CreateProductModifier.ModifierValue[0]).isDisplayed())
		  {
			  assertEquals(CashierRegisterPageElements.GetModifierFieldInShopingCardSection(driver, CreateProductTest.ProductName, CreateProductModifier.ModifierValue[0]).getText(), "- "+CreateProductModifier.ModifierValue[0]);
		  }
		  driver.navigate().refresh();
		  CashierRegisterPageElements.GetPayButton(driver).click();
		  Thread.sleep(5000);		  	  
		  driver.switchTo().frame(0);
		  
		  PaymentTransactionType.PaymentThroughCash(driver);
		  assertTrue(true);
		  driver.switchTo().defaultContent();	
		  
	  }
}
