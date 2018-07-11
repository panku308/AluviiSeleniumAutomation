package GlobalFiles;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ObjectRepository.AddModifierDialogBoxElements;
import ObjectRepository.AddModifierDialogBoxInsideAssignProductModifer;
import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.AssignProductModifiersDialogBoxElements;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.ProductModifierInsideCashierRegisterElements;
import ObjectRepository.RegisterListPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductModifier;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;

public class Debug {
	public static WebDriver driver=null;
	public static String ModifierName="";
	public static void main(String[] args) throws Exception {
		PDDocument doc = PDDocument.load(new File("C:\\Users\\DELL\\Downloads\\TicketTransaction-21038_07_11_2018.pdf"));
		int count = doc.getNumberOfPages();
		System.out.println("count = " + count);
		
		System.out.println(CommonFunctions.getCurrentDateInMMddyyyyFormat());
		System.out.println(CommonFunctions.GetCurrentMonth());
		System.out.println(CommonFunctions.GetCurrentYear());
		String str = "/store/shop/productdetails?id=5&productId=16";
		System.out.println("Index of Product id " + str.indexOf("productId"));
		System.out.println("Index of Product id " + str.substring(str.indexOf("productId"),str.length()));
		String str1 = str.substring(str.indexOf("productId"),str.length());
		String str2 = str1.substring(str1.indexOf("=")+1,str1.length());
		System.out.println(str2);
		 driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		 Thread.sleep(5000);
		 CommonFunctions.Login(driver,CommonFunctions.UserName,CommonFunctions.Password);
		 Thread.sleep(5000);
		 try
		 {
			 f();
		 }
		 catch (Exception e)
		 {
			 System.out.println(e);
		 }
		
	}
	public static void f() throws Exception {
		 DashboardPageElements.GetEmployeeRegistersLink(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, RegisterListPageElements.GetLastPageButton(driver));		  
		  RegisterListPageElements.GetLastPageButton(driver).click();
		  Thread.sleep(5000);
		  RegisterListPageElements.GetRegisterLink(driver, " Register_1530706620498").click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryElement(driver, "category_1530706295109").click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryProductElement(driver, "product1530706339812").click();
		  Thread.sleep(2000);
		  driver.switchTo().frame(0);
		  ProductModifierInsideCashierRegisterElements.GetModifierButton(driver, "MV_1530706458170").click();
		  Thread.sleep(2000);
		  ProductModifierInsideCashierRegisterElements.GetAddButton(driver).click();
		  Thread.sleep(2000);
		  driver.switchTo().defaultContent();
		  if(CashierRegisterPageElements.GetModifierFieldInShopingCardSection(driver, "product1530706339812", "MV_1530706458170").isDisplayed())
		  {
			  assertEquals(CashierRegisterPageElements.GetModifierFieldInShopingCardSection(driver, "product1530706339812","MV_1530706458170" ).getText().trim(), "- MV_1530706458170");
		  }
		  driver.navigate().refresh();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetPayButton(driver).click();
		  Thread.sleep(5000);		  	  
		  driver.switchTo().frame(0);
		  
		  PaymentTransactionType.PaymentThroughCash(driver);
		  assertTrue(true);
		  driver.switchTo().defaultContent();	 
	}
	public static void VerifyModifierRecord(WebDriver driver) throws InterruptedException
	{
		RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Modifier_ModifierNameColumnSettingsIcon(driver).click();
		 Thread.sleep(2000);
		 CommonFunctions.filterTable(driver,ModifierName);
		 int i = RegisterManagementDashboardPageElements.GetSearchRecordRowCountOfModifierTable(driver);
		 if(i==1)
		 {
			 assertTrue(true);
			 assertEquals(RegisterManagementDashboardPageElements.Get_ModifierTable_FirstRowModifierNameCloumn(driver).getText().toLowerCase().trim(), ModifierName.toLowerCase().trim());
		 }
		 else
		 {
			 assertFalse(false, "number of record expected =1, actual records found = "+i);
		 }
		 
	}
	
	
	
	
}
