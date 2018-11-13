package Tests.BookingTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.BookingDashboardPageElements;
import ObjectRepository.BookingEventDashboardPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import Tests.CreateEventManagementTest.CreateAssignmentTest;
import Tests.CreateEventManagementTest.CreateCategoryTest;
import Tests.CreateEventManagementTest.CreatePackageTest;

public class BookingCancellationAfterPaymentTest {
	

	public static WebDriver driver=null;
	  public static boolean actualResult=false;
	  public static Double ExpDepositPercentage = 50.00, ExpBasePrice=0.00, ExpVariablePrice=5.00;
	  public static Double ExpDepositAmount=0.00;
		public static Double ExpBalanceDue=0.0, ActBalanceDue=0.0;
		public static Double  DepoSitVaue=0.0, GrandTotal=0.0;
		public static Double AmountPaid=0.0; 
		public static int TotalSpots = 25, BookedQuantity=0, ActBookedQuantity=0;
		public static int ExpTotalSpotsLeft=0,ActTotalSpotLeft=0;
		public static String time="02:00pm";  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void BokingCancellationAfterPayment() throws Exception
	  {
		  AddBooking();
		  CancelBookingAfterPayment();
		  AddBooking();
	  }
	  public static void CancelBookingAfterPayment() throws InterruptedException
	  {
		  	BookingDashboardPageElements.Get_BookingDataTab_CancelBookingButton(driver).click();
			Thread.sleep(8000);
			//
			BookingDashboardPageElements.Get_BookingDataTab_ConfirmCancelBookingButton(driver).click();
			Thread.sleep(5000);
			String Exp="https://stagingqa.aluvii.com/employee//Events/DashBoard";
			assertEquals(driver.getCurrentUrl(),Exp);
	  }
	  public static void AddBooking() throws Exception
	  {
		  time="02:00pm";
		  BookedQuantity=5;
		  ExpTotalSpotsLeft = TotalSpots-BookedQuantity;
		  ExpBasePrice=375.00;
		  ExpDepositAmount = (ExpBasePrice/2);
		  
	
	  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetBookingsLink(driver));
	  DashboardPageElements.GetBookingsLink(driver).click();
	  Thread.sleep(5000);
	  CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, BookingEventDashboardPageElements.GetBookingPlusIcon(driver));
		Thread.sleep(2000);
		BookingEventDashboardPageElements.GetAddBookingOption(driver).click();
		Thread.sleep(5000);
		BookingDashboardPageElements.Get_CategoryTab_CategoryDropdown(driver).click();
		Thread.sleep(2000);
	//	BookingDashboardPageElements.SelectCategory(driver, "TestCategory_1536556572448");
		BookingDashboardPageElements.SelectCategory(driver, CreateCategoryTest.CategoryName);
		Thread.sleep(2000);
		try
		{
			BookingDashboardPageElements.Get_CategoryTab_Package_SelectButton(driver,CreatePackageTest.packageName).click();
			Thread.sleep(30000);
		}
		catch(Exception e){
			
		}
		
		BookingDashboardPageElements.Get_BookingDetailsTab_TimeField(driver, time, CreateAssignmentTest.AssignmentName ).click();
		Thread.sleep(20000);
		CommonFunctions.ScrollUptoElement(driver, BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver));
		Thread.sleep(5000);			
		BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(2000);
		
		BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).sendKeys(String.valueOf(BookedQuantity));
		BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).sendKeys(Keys.TAB);
		Thread.sleep(5000);
		CommonFunctions.ScrollUptoElement(driver, BookingDashboardPageElements.GetBookingDataTab(driver));
		Thread.sleep(3000);
		
		BookingDashboardPageElements.GetBookingDataTab(driver).click();
		Thread.sleep(2000);
		BookingDashboardPageElements.Get_BookingDataTab_FirstNameField(driver).sendKeys("fname"+System.currentTimeMillis());
		BookingDashboardPageElements.Get_BookingDataTab_LastNameField(driver).sendKeys("lname"+System.currentTimeMillis());
		BookingDashboardPageElements.Get_BookingDataTab_EmailField(driver).sendKeys("email"+System.currentTimeMillis()+"@gmail.com");
		BookingDashboardPageElements.Get_BookingDataTab_PhoneField(driver).sendKeys("1234567890");
		BookingDashboardPageElements.Get_BookingDataTab_CreateAccountButton(driver).click();
		Thread.sleep(10000);
		PayFullAmount();	
		
		String OrderID = BookingDashboardPageElements.Get_PaymentTab_OrderID(driver).getText();
		Thread.sleep(3000);				
		BookingEventDashboardPageElements.GetBackToBookingsButton(driver).click();
		Thread.sleep(3000);
		BookingEventDashboardPageElements.GetOrderIDColumnSettingIcon(driver).click();
		filterTable(driver, OrderID);
		Thread.sleep(5000);				
		assertEquals(BookingEventDashboardPageElements.GetOrderNumberOfFirstRow(driver).getText(), OrderID);
		BookingEventDashboardPageElements.GetViewButtonOfFirstRow(driver).click();
			
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
			Thread.sleep(5000);
			BookingDashboardPageElements.Get_FinalizeTab_GetPaymentModal_PaymentAmount(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			BookingDashboardPageElements.Get_FinalizeTab_GetPaymentModal_PaymentAmount(driver).sendKeys(String.valueOf(AmountPaid));
			BookingDashboardPageElements.Get_FinalizeTab_GetPaymentModal_PayButton(driver).click();
			Thread.sleep(10000);
			CommonFunctions.SwitchToContentFrame(driver);		
			PaymentTransactionType.PaymentThroughCash(driver);
			CommonFunctions.SwitchToContentFrame(driver);
			ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
			assertTrue(true);
			driver.switchTo().defaultContent();
		}
		
		public static String getElementTextWithout$Sign(String str) throws InterruptedException
		{
			Thread.sleep(5000);
			String strWithout$= str;
		
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
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Filter']")).click();
			Thread.sleep(2000);

		}
		

	
}
