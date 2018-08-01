package Tests.SellProductTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import GlobalFiles.VerifyFileIsDownloaded;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;

public class SellProductWithTicket_Cash {
	 public static WebDriver driver=null;
	  public static String expectedResult="", actualResult="";
	  public static String TransactionID = "";
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  
	  @Test
	  public void SellProductWithTicket_CashTransaction() throws Exception
	  {
		  DashboardPageElements.GetEmployeeRegistersLink(driver).click();
		  Thread.sleep(5000);
		  CommonFunctions.ScrollUptoElement(driver, RegisterListPageElements.GetLastPageButton(driver));		  
		  RegisterListPageElements.GetLastPageButton(driver).click();
		  Thread.sleep(5000);
		  RegisterListPageElements.GetRegisterLink(driver, " "+CreateRegisterTest.RegisterName).click();
		 // RegisterListPageElements.GetRegisterLink(driver, " "+"Register_1532613770670").click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryElement(driver, CreateCategoryTest.CategoryName).click();
		 // CashierRegisterPageElements.GetCategoryElement(driver, "category_1532613595066").click();
		  Thread.sleep(5000);
		  CashierRegisterPageElements.GetCategoryProductElement(driver, CreateProductTest.ProductName).click();
		  //CashierRegisterPageElements.GetCategoryProductElement(driver, "product1532613651249").click();
		  Thread.sleep(2000);
		  CashierRegisterPageElements.GetPayButton(driver).click();
		  Thread.sleep(5000);		  	  		  
		  
		  TransactionID = PaymentTransactionDialogBoxElements.GetTransactionID(driver);
		  CommonFunctions.SwitchToContentFrame(driver);
		  PaymentTransactionType.PaymentThroughCash(driver);
		  Thread.sleep(3000);
		  CommonFunctions.SwitchToContentFrame(driver);
		  ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		  assertTrue(true);
		  driver.switchTo().defaultContent();
		  Thread.sleep(10000);
		  String downloadPath = System.getProperty("user.home")+"\\Downloads";
		  assertEquals(VerifyFileIsDownloaded.isFileDownloaded(downloadPath, GetFileName()),true);
		  
		  
	  }
	 public static String GetFileName()
	 {
		 String FileName = "TicketTransaction-"+TransactionID+"_"+ CommonFunctions.getCurrentDateInMMddyyyyFormat()+".pdf";	
		 System.out.println("Expected File name = "+FileName);
		 return FileName;		 
	 }

}
