package Tests.BookingTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GlobalFiles.CommonFunctions;
import GlobalFiles.PaymentTransactionType;
import ObjectRepository.AddPriceRuleDialogBoxElements;
import ObjectRepository.BookingDashboardPageElements;
import ObjectRepository.BookingEventDashboardPageElements;
import ObjectRepository.DashboardPageElements;
import ObjectRepository.ReceiptSelectionDialogBoxElements;
import Tests.CreateEventManagementTest.CreateCategoryTest;
@Listeners (GlobalFiles.ReportCustomization.class)
public class AddBooking {
	public static WebDriver driver=null;
	  public static boolean actualResult=false;
	  public static Double ExpDepositPercentage = 50.00, ExpBasePrice=0.00, ExpVariablePrice=5.00;
	  public static Double ExpDepositAmount=0.00;
		public static Double ExpBalanceDue=0.0, ActBalanceDue=0.0;
		public static Double  DepoSitVaue=0.0, GrandTotal=0.0;
		public static Double AmountPaid=0.0; 
		public static int TotalSpots = 40, BookedQuantity=0, ActBookedQuantity=0;
		public static int ExpTotalSpotsLeft=0,ActTotalSpotLeft=0;
		public static String time="12:00pm";  
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  driver = CommonFunctions.driver;
	  }
	  @Test
	  public static void CreateMultipleBookings() throws Exception
	  {
		  for (int i=0;i<3;i++)
		  {
			  if(i==0 || i==2)
			  {
				  time="10:00am";
				  BookedQuantity=30;
				  ExpTotalSpotsLeft = TotalSpots-BookedQuantity;
				  ExpBasePrice=375.00;
				  ExpDepositAmount = (ExpBasePrice/2);
				  
			  }
			  else if(i==1)
			  {
				  time="12:00pm";
				  BookedQuantity=31;
				  ExpTotalSpotsLeft = TotalSpots-BookedQuantity;
				  ExpBasePrice=375.00 + ExpVariablePrice;
				  ExpDepositAmount = (ExpBasePrice/2);
			  }

			  CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetBookingsLink(driver));
			  DashboardPageElements.GetBookingsLink(driver).click();
			  Thread.sleep(5000);
			  CommonFunctions.ActionBuilder_PerformMouseHoverEventOnElement(driver, BookingEventDashboardPageElements.GetBookingPlusIcon(driver));
				Thread.sleep(2000);
				BookingEventDashboardPageElements.GetAddBookingOption(driver).click();
				Thread.sleep(5000);
				BookingDashboardPageElements.Get_CategoryTab_CategoryDropdown(driver).click();
				Thread.sleep(2000);
			//	BookingDashboardPageElements.SelectCategory(driver, "TestCategory_1534440606631");
				BookingDashboardPageElements.SelectCategory(driver, CreateCategoryTest.CategoryName);
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_CategoryTab_Package_SelectButton(driver).click();
				Thread.sleep(30000);
				if(i==3)
				{
					if(CommonFunctions.GetDayOfWeekIntFornat()==6)
					{
						BookingDashboardPageElements.Get_BookingDetailsTab_NextWeekButton(driver).click();	
						Thread.sleep(5000);
					}
					BookingDashboardPageElements.Get_BookingDetailsTab_GetDateField(driver, CommonFunctions.GetDayOfWeekStringFormat_FirstThreeLetters()).click();
				}
				BookingDashboardPageElements.Get_BookingDetailsTab_TimeField(driver, time).click();
				Thread.sleep(20000);
				CommonFunctions.ScrollUptoElement(driver, BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver));
				Thread.sleep(5000);			
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				Thread.sleep(2000);
				System.out.println(BookedQuantity);
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).sendKeys(String.valueOf(BookedQuantity));
				BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).sendKeys(Keys.TAB);
				Thread.sleep(5000);
				CommonFunctions.ScrollUptoElement(driver, BookingDashboardPageElements.GetBookingDataTab(driver));
				Thread.sleep(3000);
				
				BookingDashboardPageElements.GetBookingDataTab(driver).click();
				Thread.sleep(2000);
				BookingDashboardPageElements.Get_BookingDataTab_FirstNameField(driver).sendKeys("fname"+System.currentTimeMillis());
				BookingDashboardPageElements.Get_BookingDataTab_LastNameField(driver).sendKeys("lname"+System.currentTimeMillis());
				BookingDashboardPageElements.Get_BookingDataTab_EmailField(driver).sendKeys("email"+System.currentTimeMillis());
				BookingDashboardPageElements.Get_BookingDataTab_PhoneField(driver).sendKeys("1234567890");
				BookingDashboardPageElements.Get_BookingDataTab_CreateAccountButton(driver).click();
				Thread.sleep(10000);
				if(i==0)
				{
					PayDepoistOnly();	
				}
				else if(i>0)
				{
					PayFullAmount();	
				}
				
				
				String OrderID = BookingDashboardPageElements.Get_PaymentTab_OrderID(driver).getText();
				Thread.sleep(3000);				
				BookingEventDashboardPageElements.GetBackToBookingsButton(driver).click();
				Thread.sleep(3000);
				BookingEventDashboardPageElements.GetOrderIDColumnSettingIcon(driver).click();
				filterTable(driver, OrderID);
				Thread.sleep(5000);				
				assertEquals(BookingEventDashboardPageElements.GetOrderNumberOfFirstRow(driver).getText(), OrderID);
				BookingEventDashboardPageElements.GetViewButtonOfFirstRow(driver).click();
				VerifyBookedQty_BasePrice_AndSpotsLeftAfterBooking();
				VerifyBalanceDueOnFinalizeTab();
				VerifyBalanceDueOnPaymentTab();
				Thread.sleep(5000);
		  }
		  				
	  	
		  
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
			assertEquals(AmountPaid, ExpDepositAmount);
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
		public static void VerifyBookedQty_BasePrice_AndSpotsLeftAfterBooking() throws InterruptedException
		{
			Thread.sleep(5000);
			String str = BookingDashboardPageElements.Get_BookingDetailsTab_SpotsLeftField(driver).getText();
			assertEquals(Integer.valueOf(getElementTextWithout$Sign(str) ), Integer.valueOf(ExpTotalSpotsLeft));
			str= BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).getAttribute("value");
			assertEquals(Integer.valueOf(getElementTextWithout$Sign(str) ), Integer.valueOf(BookedQuantity));
			str = BookingDashboardPageElements.Get_BookingDetailsTab_TotalPrice(driver).getText();
			assertEquals(Double.valueOf(getElementTextWithout$Sign(str) ), Double.valueOf(ExpBasePrice));
			
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
		
}
