package GlobalFiles;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
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

import ObjectRepository.AccessControlPageElements;
import ObjectRepository.AddCategoryDialogBoxElements;
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
import ObjectRepository.PaymentTransactionDialogBoxElements;
import ObjectRepository.ProductModifierInsideCashierRegisterElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import ObjectRepository.RegisterListPageElements;
import ObjectRepository.RegisterManagementDashboardPageElements;
import ObjectRepository.SessionProductWindowElements;
import ObjectRepository.SignWaiver2PageElements;
import ObjectRepository.SignWaiverPageElements;
import ObjectRepository.WebsiteOpenPageElements;
import ObjectRepository.WorkflowBuilderPageElements;
import Tests.BookingTest.AddBooking;
import Tests.ECommerceTest.CreateEcommerceCategoryTest;
import Tests.ECommerceTest.CreateEcommereceProductTest;
import Tests.ECommerceTest.CreateWebsiteTest;
import Tests.ManageMembershipsTest.CreateMemberTest;
import Tests.MembershipPackagesTest.CreateeEntranceEntitlementTest;
import Tests.RegisterManagementTest.CreateCategoryTest;
import Tests.RegisterManagementTest.CreateProductModifier;
import Tests.RegisterManagementTest.CreateProductTest;
import Tests.RegisterManagementTest.CreateRegisterTest;
import Tests.WaiverTest.LoadAccoutWaiver_Template2;
import util.DriverManager;

public class Debug {
	public static WebDriver driver=null;
	public static WebDriver driver1=null;
	public static WebDriver driver2=null;
	public static String ModifierName="";
	public static Double ExpBalanceDue=0.0, ActBalanceDue=0.0;
	public static Double  DepoSitVaue=0.0, GrandTotal=0.0;
	public static Double AmountPaid=0.0; 
	public static int TotalSpots = 40, BookedQuantity=10, ActBookedQuantity=0;
	public static int ExpTotalSpotsLeft=10,ActTotalSpotLeft=0;
	public static String ActualCaetgories[]=null;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		
		
		
		
		driver1 = CommonFunctions.SetupEnvironment("https://stagingqa.aluvii.com/employee", "chrome");
		Thread.sleep(5000);
		CommonFunctions.Login(driver1, "pankaj@aluvii.com", "Admin@123");
		Thread.sleep(5000);
		WebElement childElement=null, childElement1=null, childElement2=null;
		try
		{
			//childElement = driver1.findElement(By.xpath("//h3[text()='expsuperscott83018']/parent::*//input"));
			
			childElement = driver1.findElement(By.xpath("//h3[text()='exproom1scott83018']/parent::div/parent::div//div[4]/p"));
	//		childElement1 = driver1.findElement(By.xpath("//h3[text()='expsuperscott83018']/parent::div/parent::div/parent::div/input"));
			System.out.println(childElement.getAttribute("id"));
		childElement2 = childElement.findElement(By.tagName("input"));
			System.out.println(childElement2.getAttribute("value"));
			
			
			
			
			/*childElement = childElement.findElement(By.xpath(".."));
			childElement = childElement.findElement(By.xpath("//input"));*/
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	//	String text = childElement.getAttribute("value");
	//	String text1 = childElement1.getAttribute("value");
		String text2 = childElement2.getAttribute("value");
	//	System.out.println(text);
		GetActualtCategory();
		 ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));
		SignWaiver2PageElements.VerifyDOBDropdownFieldValues(driver, 2);
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetEcommerceLink(driver));
		  Thread.sleep(2000);
		  DashboardPageElements.GetEcommerceLink(driver).click();
		  Thread.sleep(5000);
		  ECommerceDashboardPageElements.GetWebSiteTab(driver).click();
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetWebsiteTab_WebsiteNameClolumnSettingIcon(driver).click();
		  Thread.sleep(2000);
		//  CommonFunctions.filterTable(driver, CreateWebsiteTest.WebsiteName);
		  CommonFunctions.filterTable(driver, "website-1535605130198");
		   
		  Thread.sleep(2000);
		  ECommerceDashboardPageElements.GetWebsiteTab_FirstRowWebsiteNameColumn(driver).click();
		  ECommerceDashboardPageElements.GetWebsiteTab_SelectOptionDD(driver).click();
		  Thread.sleep(3000);
		  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver, "Open Website").click();
		  Thread.sleep(10000);
		  windowHandles = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(windowHandles.get(1));	  
		  
		  CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, WebsiteOpenPageElements.GetCategoriesDD(driver));
		  Thread.sleep(2000);
		 // WebsiteOpenPageElements.SelectCategory(driver, CreateEcommerceCategoryTest.EcommerceCategoryName);
		  WebsiteOpenPageElements.SelectCategory(driver, "Ecom-category-1535605241015");
		  Thread.sleep(5000);
		
		  String ActResult="";
		
		try {
			 //WebsiteOpenPageElements.GetCaetgoryProductOutofStockMessage(driver, CreateEcommereceProductTest.EcommerceProductName).getText();
			ActResult = WebsiteOpenPageElements.GetCaetgoryProductOutofStockMessage(driver, "EcommerceProduct-1535605387660").getText();
			System.out.println(ActResult);
			 assertEquals(ActResult.trim(), "OUT OF STOCK");
			  Thread.sleep(5000);
			
			SignWaiverPageElements.LoadAccountWaiver_Teamplate1(driver,"selenium1535288254935@gmail.com",2); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetRegisterManagementLink(driver));
		  CashierRegisterPageElements.GetCategoryProductElement(driver, "product1534649218071").click();
		  Thread.sleep(15000);
		  driver.switchTo().frame(CashierRegisterPageElements.GetSessionProductWindowFrame(driver));
		  driver.switchTo().defaultContent();
		  SessionProductWindowElements.GetCloseButton(driver).click();
		BookingDashboardPageElements.Get_BookingDetailsTab_GetDateField(driver, "mon").click();
		
		CommonFunctions.SwitchToContentFrame(driver);
		 PaymentTransactionDialogBoxElements.GetSubmitButton_Booking(driver).click();
		AddBooking.PayFullAmount();
		System.out.println(ManageMembershipsPageElements.GetAccountGuest_BarcodeField(driver).getText());
		String time="1:00pm";
		 ManageMembershipsPageElements.GetAccountGuest_BarcodesLink(driver).click();
		  Thread.sleep(2000);
		 String Barcode = ManageMembershipsPageElements.GetAccountGuest_BarcodeField(driver).getText() ;
		  	CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetAccessControlLink(driver));
			Thread.sleep(2000);
			DashboardPageElements.GetAccessControlLink(driver).click();
			Thread.sleep(3000);
			AccessControlPageElements.GetSearchBarcodeField(driver).sendKeys(Barcode);
			AccessControlPageElements.GetScanButton(driver).click();
			Thread.sleep(5000);
			assertEquals(AccessControlPageElements.GetApprovedOrDeniedMessage(driver).getText().trim(), "Approved");
			String	ExpResult = "Welcome to the facility! Hope you enjoy your time";
			 ActResult=AccessControlPageElements.GetBarcodeExpMessage(driver).getText().trim();
			assertEquals(ActResult,ExpResult);
			
		 
			  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetBookingsLink(driver));
				DashboardPageElements.GetBookingsLink(driver).click();
				Thread.sleep(5000);
			
				
			/*	CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, BookingEventDashboardPageElements.GetBookingPlusIcon(driver));
				Thread.sleep(2000);
				BookingEventDashboardPageElements.GetAddBookingOption(driver).click();
				Thread.sleep(5000);
				
				
				BookingDashboardPageElements.Get_CategoryTab_CategoryDropdown(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.SelectCategory(driver, "Brandon Party");
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_CategoryTab_Package_SelectButton(driver).click();
				Thread.sleep(60000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TimeField(driver, time).click();
				Thread.sleep(20000);
				CommonFunctions.ScrollUptoElement(driver, BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver));
				Thread.sleep(5000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).clear();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).sendKeys("10");
				
				Thread.sleep(5000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield2(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield2(driver).clear();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield2(driver).sendKeys("25");
				
				Thread.sleep(5000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield3(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield3(driver).clear();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield3(driver).sendKeys("5");
				
				
				
				
				
				
				
				
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield3(driver).sendKeys(Keys.TAB);
				
				CommonFunctions.ScrollUptoElement(driver, BookingDashboardPageElements.GetBookingDataTab(driver));
				Thread.sleep(3000);*/
				
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
				PayDepoistOnly();
				String OrderID = BookingDashboardPageElements.Get_PaymentTab_OrderID(driver).getText();
				Thread.sleep(3000);				
				BookingEventDashboardPageElements.GetBackToBookingsButton(driver).click();
				Thread.sleep(3000);
				BookingEventDashboardPageElements.GetOrderIDColumnSettingIcon(driver).click();
				filterTable(driver, OrderID);
				Thread.sleep(5000);				
				assertEquals(BookingEventDashboardPageElements.GetOrderNumberOfFirstRow(driver).getText(), OrderID);
				BookingEventDashboardPageElements.GetViewButtonOfFirstRow(driver).click();
				VerifyBookedQtyAndSpotsLeftAfterBooking();
				VerifyBalanceDueOnFinalizeTab();
				VerifyBalanceDueOnPaymentTab();
				Thread.sleep(5000);				
		  	
	}
	public static void PayDepoistOnly() throws Exception
	{
		Thread.sleep(5000);
		BookingDashboardPageElements.GetFinalizeTab(driver).click();
		Thread.sleep(5000);
		String str = BookingDashboardPageElements.Get_FinalizeTab_GrandTotal(driver).getText();
		GrandTotal = Double.valueOf(getElementTextWithout$Sign(str));
		str = BookingDashboardPageElements.Get_FinalizeTab_RequireDepositField(driver).getText();
		AmountPaid = Double.valueOf(getElementTextWithout$Sign(str));
		BookingDashboardPageElements.Get_FinalizeTab_PayDepositOnly(driver).click();
		Thread.sleep(10000);
		CommonFunctions.SwitchToContentFrame(driver);		
		PaymentTransactionType.PaymentThroughCash(driver);
		CommonFunctions.SwitchToContentFrame(driver);
		ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		assertTrue(true);
		driver.switchTo().defaultContent();
	}
	public static void PayFullAmount()throws Exception
	{
		Thread.sleep(5000);
		BookingDashboardPageElements.GetFinalizeTab(driver).click();
		Thread.sleep(5000);
		String str = BookingDashboardPageElements.Get_FinalizeTab_GrandTotal(driver).getText();
		GrandTotal = Double.valueOf(getElementTextWithout$Sign(str));
		str = BookingDashboardPageElements.Get_FinalizeTab_GrandTotal(driver).getText();
		AmountPaid = Double.valueOf(getElementTextWithout$Sign(str));
		BookingDashboardPageElements.Get_FinalizeTab_PayFullAmount(driver).click();
		Thread.sleep(10000);
		CommonFunctions.SwitchToContentFrame(driver);		
		PaymentTransactionType.PaymentThroughCash(driver);
		CommonFunctions.SwitchToContentFrame(driver);
		ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		assertTrue(true);
		driver.switchTo().defaultContent();
	}
	public static void VerifyBalanceDueOnFinalizeTab() throws InterruptedException
	{
		Thread.sleep(5000);
		BookingDashboardPageElements.GetFinalizeTab(driver).click();
		Thread.sleep(5000);		
		String str = BookingDashboardPageElements.Get_FinalizeTab_BalanceDueField(driver).getText();
		assertEquals(Double.valueOf(getElementTextWithout$Sign(str)), GrandTotal-AmountPaid);
	}
	public static void VerifyBalanceDueOnPaymentTab() throws InterruptedException
	{
		Thread.sleep(5000);
		BookingDashboardPageElements.GetPaymentTab(driver).click();
		Thread.sleep(5000);
		String str = BookingDashboardPageElements.Get_PaymentTab_BookingTotal(driver).getText();
		assertEquals(Double.valueOf(getElementTextWithout$Sign(str)), GrandTotal);
		str = BookingDashboardPageElements.Get_PaymentTab_TotalPaid(driver).getText();
		assertEquals(Double.valueOf(getElementTextWithout$Sign(str)), AmountPaid);
		str= BookingDashboardPageElements.Get_PaymentTab_AmountRemaining(driver).getText();
		assertEquals(Double.valueOf(getElementTextWithout$Sign(str)), GrandTotal-AmountPaid);
		
	}
	public static void VerifyBookedQtyAndSpotsLeftAfterBooking() throws InterruptedException
	{
		Thread.sleep(5000);
		String str = BookingDashboardPageElements.Get_BookingDetailsTab_SpotsLeftField(driver).getText();
		assertEquals(Integer.valueOf(getElementTextWithout$Sign(str) ), Integer.valueOf(TotalSpots-BookedQuantity));
		str= BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).getAttribute("value");
		assertEquals(Integer.valueOf(getElementTextWithout$Sign(str) ), Integer.valueOf(BookedQuantity));
		
	}
	public static String getElementTextWithout$Sign(String str) throws InterruptedException
	{
		Thread.sleep(5000);
		String strWithout$= str;
		//strWithout$ = strWithout$.substring(1, strWithout$.length());
		strWithout$ = strWithout$.replace(",", "");
		strWithout$ = strWithout$.replace("$", "");
		
		return strWithout$;
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
	public static void SetWaiverTemplate(WebDriver driver) throws InterruptedException
	{
		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetWorkflowLink(driver));
		Thread.sleep(2000);
		DashboardPageElements.GetWorkflowLink(driver).click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.getWorkflowTypeDD(driver).click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetWorkflowTypeDDOption(driver, "Waiver").click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.getWorkflowOptionDD(driver).click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.getWorkflowOptionDDOption(driver, "Waiver").click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetWaiverTeamplateDD(driver).click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetWaiverTeamplateDDOption(driver, "Aluvii Standard - 1").click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetReqAllGuestOverMinAgeRadioButton(driver).click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetMinAgeOfSignField(driver).sendKeys(Keys.chord(Keys.CONTROL, "a","18"));
		Thread.sleep(2000);
	
		WorkflowBuilderPageElements.GetDisplayEmailOptOutDD(driver).click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetDisplayEmailOptOutDDOption(driver, "Yes").click();
		Thread.sleep(5000);
		WorkflowBuilderPageElements.GetReqSignerDD(driver).click();
		Thread.sleep(2000);
		WorkflowBuilderPageElements.GetReqSignerDDOption(driver, "Yes").click();
	}
	
	public static void AddCategory_Special() throws InterruptedException
	{

		 
		  driver2.navigate().refresh();
		  
		  CommonFunctions.ScrollUptoElement(driver2, DashboardPageElements.GetRegisterManagementLink(driver2));
		  Thread.sleep(3000);
		  DashboardPageElements.GetRegisterManagementLink(driver2).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab(driver2).click();
		  Thread.sleep(5000);
		  for(int i=0;i<ActualCaetgories.length;i++)
		  {
			  RegisterManagementDashboardPageElements.GetProductsTab_subtab_Categories(driver2).click();
			  Thread.sleep(3000);
			  RegisterManagementDashboardPageElements.GetProductsTab_SubTab_Categories_SelectOptionDropdown(driver2).click();
			  Thread.sleep(3000);
			  RegisterManagementDashboardPageElements.SelectOptionFromSelectOptionDD(driver2, "Add Category").click();
			  Thread.sleep(3000);
			  List<WebElement> iframeElements = driver2.findElements(By.tagName("iframe"));
			  System.out.println("iframe length = " + iframeElements.size());
			  CommonFunctions.SwitchToContentFrame(driver2);
			  
			  AddCategoryDialogBoxElements.GetCategoryNameField(driver2).sendKeys(ActualCaetgories[i]);
			  AddCategoryDialogBoxElements.GetCategoryDescField(driver2).sendKeys("categorydescription_"+System.currentTimeMillis());
			  AddCategoryDialogBoxElements.GetAddButton(driver2).click();
			  
			  Thread.sleep(10000);
			  driver.switchTo().defaultContent();
		  }
		  
		
	}
	public static void GetActualtCategory()throws Exception
	{
		 	driver1.navigate().refresh();
		  
		  CommonFunctions.ScrollUptoElement(driver1, DashboardPageElements.GetRegisterManagementLink(driver1));
		  Thread.sleep(3000);
		  DashboardPageElements.GetRegisterManagementLink(driver1).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab(driver1).click();
		  Thread.sleep(5000);
		  RegisterManagementDashboardPageElements.GetProductsTab_subtab_Categories(driver1).click();
		  Thread.sleep(3000);
		 
		
		int CategoryRows=0;
		List<WebElement> categoryList= driver1.findElements(By.xpath("//div[@id='categoryGrid']//div[@class='k-grid-content']//table/tbody/tr"));
		System.out.println("CategoryRows = " + categoryList.size());
		ActualCaetgories = new String [categoryList.size()];
		try
		{
			for(int i=0;i<categoryList.size();i++)
			{
				ActualCaetgories[i] = driver1.findElement(By.xpath("//div[@id='categoryGrid']//div[@class='k-grid-content']//table/tbody/tr["+(i+1)+"]/td[2]")).getText();
				System.out.println(ActualCaetgories[i]);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		
		
	}
	
}
