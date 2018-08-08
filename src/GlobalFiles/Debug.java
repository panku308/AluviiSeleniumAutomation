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
import org.openqa.selenium.remote.server.handler.SendKeys;

import ObjectRepository.AddCategoryDialogBoxInsideEcommerceProductsTabElements;
import ObjectRepository.AddModifierDialogBoxElements;
import ObjectRepository.AddModifierDialogBoxInsideAssignProductModifer;
import ObjectRepository.AddProductDialogBoxElements;
import ObjectRepository.AddProductDialogboxInsideAddRegisterPageElements;
import ObjectRepository.AssignProductModifiersDialogBoxElements;
import ObjectRepository.BookingDashboardPageElements;
import ObjectRepository.BookingEventDashboardPageElements;
import ObjectRepository.CashierRegisterPageElements;
import ObjectRepository.CategoryDialogBoxElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ECommerceDashboardPageElements;
import ObjectRepository.ManageMembershipsPageElements;
import ObjectRepository.ProductModifierInsideCashierRegisterElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductModifier;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;
import util.DriverManager;

public class Debug {
	public static WebDriver driver=null;
	public static String ModifierName="";
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Date dt = new Date();
		System.out.println(dt.getDay());
		driver = CommonFunctions.SetupEnvironment(CommonFunctions.url, "chrome");
		Thread.sleep(5000);
		CommonFunctions.Login(driver, CommonFunctions.UserName, CommonFunctions.Password);
		Thread.sleep(5000);
		String time="1:00pm";  
		  
		  try
		  {
			  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetBookingsLink(driver));
				DashboardPageElements.GetBookingsLink(driver).click();
				Thread.sleep(5000);
				
				BookingEventDashboardPageElements.GetOrderIDColumnSettingIcon(driver).click();
				filterTable(driver, "23060");
				Thread.sleep(5000);
				
				CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, BookingEventDashboardPageElements.GetBookingPlusIcon(driver));
				Thread.sleep(2000);
				BookingEventDashboardPageElements.GetAddBookingOption(driver).click();
				Thread.sleep(5000);
				
				
				BookingDashboardPageElements.Get_CategoryTab_CategoryDropdown(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.SelectCategory(driver, "Brandon Party");
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_CategoryTab_Package_SelectButton(driver).click();
				Thread.sleep(30000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TimeField(driver, time).click();
				Thread.sleep(5000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).clear();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).sendKeys("10");
				
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield2(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield2(driver).clear();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield2(driver).sendKeys("25");
				
				
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield3(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield3(driver).clear();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield3(driver).sendKeys("5");
				
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield3(driver).sendKeys(Keys.TAB);
				
				CommonFunctions.ScrollUptoElement(driver, BookingDashboardPageElements.GetBookingDataTab(driver));
				Thread.sleep(3000);
				BookingDashboardPageElements.GetBookingDataTab(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDataTab_FirstNameField(driver).sendKeys("fname"+System.currentTimeMillis());
				BookingDashboardPageElements.Get_BookingDataTab_LastNameField(driver).sendKeys("lname"+System.currentTimeMillis());
				BookingDashboardPageElements.Get_BookingDataTab_EmailField(driver).sendKeys("email"+System.currentTimeMillis());
				BookingDashboardPageElements.Get_BookingDataTab_PhoneField(driver).sendKeys("1234567890");
				BookingDashboardPageElements.Get_BookingDataTab_CreateAccountButton(driver).click();
				Thread.sleep(5000);
				BookingDashboardPageElements.Get_BookingDataTab_CreateAccountButton(driver).click();
				Thread.sleep(5000);
				BookingDashboardPageElements.GetFinalizeTab(driver).click();
				Thread.sleep(5000);
				BookingDashboardPageElements.Get_FinalizeTab_PayDepositOnly(driver).click();
				Thread.sleep(5000);
				CommonFunctions.SwitchToContentFrame(driver);		
				PaymentTransactionType.PaymentThroughCash(driver);
				CommonFunctions.SwitchToContentFrame(driver);
				ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
				assertTrue(true);
				driver.switchTo().defaultContent();
				String OrderID = BookingDashboardPageElements.Get_PaymentTab_OrderID(driver).getText();
				Thread.sleep(3000);
				BookingEventDashboardPageElements.GetBackToBookingsButton(driver).click();
				Thread.sleep(3000);
				BookingEventDashboardPageElements.GetOrderIDColumnSettingIcon(driver).click();
				filterTable(driver, OrderID);
				Thread.sleep(5000);
				BookingEventDashboardPageElements.GetViewButtonOfFirstRow(driver).click();
				
				
			
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  
			
	
		
	}
	public static void filterTable(WebDriver driver,String input) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Filter']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@title='Operator']/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Is equal to']")).click();
		Thread.sleep(2000);
		CommonFunctions.ActionBuilder_EnterValueInTextbox(driver, driver.findElement(By.xpath("//form[@title ='Show items with value that:']//input[@class='k-formatted-value k-input' and @title='Value']")),input);
		//CommonFunctions.ActionBuilder_EnterValueInTextbox(driver, driver.findElement(By.xpath("//form[@title ='Show items with value that:']//span[@class='k-widget k-numerictextbox']//input[@class='k-formatted-value k-input' and @title='Value']")),input);
		//CommonFunctions.ActionBuilder_EnterValueInTextbox(driver, driver.findElement(By.xpath("/html/body/div[9]/div/ul/li[6]/div/ul/li/div/form/div/span[2]/span/input[1]")),input);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Filter']")).click();
		Thread.sleep(2000);

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
