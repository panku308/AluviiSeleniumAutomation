package Tests.BookingTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
import baseSetup.TestSetup;
import util.DriverManager;
@Listeners (GlobalFiles.ReportCustomization.class)
public class Booking extends TestSetup{
	public static WebDriver driver=null;
	public static boolean actualResult=false;
	public static Double ExpDepositPercentage = 50.00, ExpBasePrice=0.00, ExpVariablePrice=5.00;
	public static Double ExpDepositAmount=0.00;
	public static Double ExpBalanceDue=0.0, ActBalanceDue=0.0;
	public static Double  DepoSitVaue=0.0, GrandTotal=0.0;
	public static Double AmountPaid=0.0; 
	public static int TotalSpots = 40, BookedQuantity=0, ActBookedQuantity=0;
	public static int ExpTotalSpotsLeft=0,ActTotalSpotLeft=0;
	public static String time="";  

	@Test
	public static void CreateMultipleBookings() throws Exception
	{
		WebDriver driver = DriverManager.getDriver();

		CommonFunctions.ScrollUptoElement(driver, DashboardPageElements.GetBookingsLink(driver));
		DashboardPageElements.GetBookingsLink(driver).click();

		gotoBookingPage(driver);

		/*-----------------------------------------------------------------------------------------------------------------------*/
		//TimeZones and TimeSlots Valiations for next 8 days

		int count=0;
		//System.out.println(count);
		//FirstDate Booking
		BookingDashboardPageElements.getFirstBookingDate(driver).get(0).click();
		Thread.sleep(3000);
		Assert.assertEquals(checkAvailableTimeZonesAndSlots(driver), true);
		count++;
		//System.out.println(count);

		//Other dates booking except last date
		for(int i=0;i<BookingDashboardPageElements.getOtherBookingDate(driver).size();i++)
		{
			Thread.sleep(3000);
			BookingDashboardPageElements.getOtherBookingDate(driver).get(i).click();
			Thread.sleep(3000);
			Assert.assertEquals(checkAvailableTimeZonesAndSlots(driver), true);
			count++;
			//System.out.println(count);
		}

		//LastDate Booking
		Thread.sleep(3000);
		BookingDashboardPageElements.getLastBookingDate(driver).get(0).click();
		Thread.sleep(3000);
		Assert.assertEquals(checkAvailableTimeZonesAndSlots(driver), true);
		count++;
		//System.out.println(count);

		if(count!=8)
		{
			int tempCount1=count;

			driver.findElement(By.id("divCalNextWk")).click();
			Thread.sleep(2000);

			/*List<WebElement> element21=driver.findElements(By.xpath("//*[@class='wkDy']"));
			List<WebElement> element31=driver.findElements(By.xpath("//*[@class='wkDy last']"));*/

			//Other dates booking except last date
			for(int i=0;i<8-tempCount1;i++)
			{
				Thread.sleep(2000);
				BookingDashboardPageElements.getOtherBookingDate(driver).get(i).click();
				Thread.sleep(2000);
				Assert.assertEquals(checkAvailableTimeZonesAndSlots(driver), true);
				count++;
				//System.out.println(count);
			}

			//LastDate Booking
			if(count!=8)
			{
				Thread.sleep(2000);
				BookingDashboardPageElements.getLastBookingDate(driver).get(0).click();
				Thread.sleep(2000);
				Assert.assertEquals(checkAvailableTimeZonesAndSlots(driver), true);
				count++;
			//	System.out.println(count);
			}		

		}

		System.out.println("TimeZones and CapacitySlots Validation are successful");
		System.out.println("TimeZones duration <10:00am> to <08:00pm> and the difference between each zones is <02:00hrs>");
		System.out.println("All the timezones slots has a capacity of "+CommonFunctions.createAssignment_capacity+" units");


		/*---------------------------------------------Booking Initiation-----------------------------------------------------------*/
		driver.findElement(By.id("divCalPrevWk")).click();
		Thread.sleep(2000);
		
		int bookingDateCount=0;

		//First Date, Middle Dates, Last Dates
		
		//First Date Booking
		BookingDashboardPageElements.getFirstBookingDate(driver).get(0).click();
		Thread.sleep(2000);

		bookTimeAndSlots(driver, "10:00am", "10", "true", "DepositOnly");
		BookingDashboardPageElements.getFirstBookingDate(driver).get(0).click();
		Thread.sleep(2000);
		Assert.assertFalse(checkTimeSlotsAvailability(driver, "10:00am"));

		bookTimeAndSlots(driver, "12:00pm", "10", "true", "FullAmount");
		BookingDashboardPageElements.getFirstBookingDate(driver).get(0).click();
		Thread.sleep(2000);
		Assert.assertFalse(checkTimeSlotsAvailability(driver, "12:00pm"));

		bookTimeAndSlots(driver, "02:00pm", "10", "true", "DepositOnly");
		BookingDashboardPageElements.getFirstBookingDate(driver).get(0).click();
		Thread.sleep(2000);
		Assert.assertFalse(checkTimeSlotsAvailability(driver, "02:00pm"));

		bookTimeAndSlots(driver, "04:00pm", "10", "true", "FullAmount");
		BookingDashboardPageElements.getFirstBookingDate(driver).get(0).click();
		Thread.sleep(2000);
		Assert.assertFalse(checkTimeSlotsAvailability(driver, "04:00pm"));

		bookTimeAndSlots(driver, "06:00pm", "10", "true", "DepositOnly");
		BookingDashboardPageElements.getFirstBookingDate(driver).get(0).click();
		Thread.sleep(2000);
		Assert.assertFalse(checkTimeSlotsAvailability(driver, "06:00pm"));

		bookTimeAndSlots(driver, "08:00pm", "10", "true", "FullAmount");
		BookingDashboardPageElements.getFirstBookingDate(driver).get(0).click();
		Thread.sleep(2000);
		Assert.assertFalse(checkTimeSlotsAvailability(driver, "08:00pm"));

		bookingDateCount++;
		
		//Other Date Booking	
		for(int i=0;i<BookingDashboardPageElements.getOtherBookingDate(driver).size();i++)
		{
			if(bookingDateCount<4)
			{
			BookingDashboardPageElements.getOtherBookingDate(driver).get(i).click();
			Thread.sleep(2000);

			if(i==0)
			{
				bookTimeAndSlots(driver, "10:00am", "10", "true", "DepositOnly");
				BookingDashboardPageElements.getOtherBookingDate(driver).get(i).click();
				Thread.sleep(2000);
				Assert.assertFalse(checkTimeSlotsAvailability(driver, "10:00am"));
				
				bookTimeAndSlots(driver, "02:00pm", "10", "true", "FullAmount");
				BookingDashboardPageElements.getOtherBookingDate(driver).get(i).click();
				Thread.sleep(2000);
				Assert.assertFalse(checkTimeSlotsAvailability(driver, "02:00pm"));
				
				bookTimeAndSlots(driver, "06:00pm", "10", "true", "DepositOnly");
				BookingDashboardPageElements.getOtherBookingDate(driver).get(i).click();
				Thread.sleep(2000);
				Assert.assertFalse(checkTimeSlotsAvailability(driver, "06:00pm"));				
			}
			
			if(i==1)
			{
				bookTimeAndSlots(driver, "12:00pm", "10", "true", "FullAmount");
				BookingDashboardPageElements.getOtherBookingDate(driver).get(i).click();
				Thread.sleep(2000);
				Assert.assertFalse(checkTimeSlotsAvailability(driver, "12:00pm"));

				bookTimeAndSlots(driver, "04:00pm", "10", "true", "DepositOnly");
				BookingDashboardPageElements.getOtherBookingDate(driver).get(i).click();
				Thread.sleep(2000);
				Assert.assertFalse(checkTimeSlotsAvailability(driver, "04:00pm"));
			}
			
			if(i==2)
			{
				bookTimeAndSlots(driver, "02:00pm", "10", "true", "FullAmount");
				BookingDashboardPageElements.getOtherBookingDate(driver).get(i).click();
				Thread.sleep(2000);
				Assert.assertFalse(checkTimeSlotsAvailability(driver, "02:00pm"));
			}
			

			
			
			}
			bookingDateCount++;
		}
		
		//Last Date Booking
		if(bookingDateCount<4)
		{
			BookingDashboardPageElements.getLastBookingDate(driver).get(0).click();
			Thread.sleep(2000);
			bookTimeAndSlots(driver, "08:00pm", "10", "true", "FullAmount");
			BookingDashboardPageElements.getLastBookingDate(driver).get(0).click();
			Thread.sleep(2000);
			Assert.assertFalse(checkTimeSlotsAvailability(driver, "08:00pm"));
		}

	}

	public static void gotoBookingPage(WebDriver driver) throws InterruptedException
	{
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

		BookingDashboardPageElements.Get_CategoryTab_Package_SelectButton(driver).click();
		Thread.sleep(4000);
	}
	public static boolean checkAvailableTimeZonesAndSlots(WebDriver driver) throws InterruptedException
	{
		List<WebElement> timeZones=driver.findElements(By.xpath("//*[contains(text(),'Timezone')]/..//li"));

		if(timeZones.get(0).getText().contains("10:00am") && timeZones.get(0).getAttribute("slotsavailable").equals(CommonFunctions.createAssignment_capacity))
			if(timeZones.get(1).getText().contains("12:00pm") && timeZones.get(0).getAttribute("slotsavailable").equals(CommonFunctions.createAssignment_capacity))
				if(timeZones.get(2).getText().contains("02:00pm") && timeZones.get(0).getAttribute("slotsavailable").equals(CommonFunctions.createAssignment_capacity))
					if(timeZones.get(3).getText().contains("04:00pm") && timeZones.get(0).getAttribute("slotsavailable").equals(CommonFunctions.createAssignment_capacity))
						if(timeZones.get(4).getText().contains("06:00pm") && timeZones.get(0).getAttribute("slotsavailable").equals(CommonFunctions.createAssignment_capacity))
							if(timeZones.get(5).getText().contains("08:00pm") && timeZones.get(0).getAttribute("slotsavailable").equals(CommonFunctions.createAssignment_capacity))
								return true;

		return false;
	}

	public static boolean checkTimeSlotsAvailability(WebDriver driver, String time) throws Exception
	{
		List<WebElement> timeZones=driver.findElements(By.xpath("//*[contains(text(),'Timezone')]/..//li"));

		for(int i=0;i<timeZones.size();i++)			
			if(timeZones.get(i).getText().contains(time))
				return true;

		return false;
	}

	public static void bookTimeAndSlots(WebDriver driver, String time, String slots, String customize,String paymentType) throws Exception
	{
		Thread.sleep(3000);
		List<WebElement> timeZones=driver.findElements(By.xpath("//*[contains(text(),'Timezone')]/..//li"));

		for(int i=0;i<timeZones.size();i++)			
			if(timeZones.get(i).getText().contains(time))
				timeZones.get(i).click();

		Thread.sleep(3000);

		driver.findElement(By.id("rowVal1")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.id("rowVal1")).sendKeys(slots);
		driver.findElement(By.id("rowVal1")).sendKeys(Keys.ENTER);

		WebElement ele=driver.findElement(By.id("spotsLeft"));
		ExpTotalSpotsLeft=Integer.valueOf(ele.getText());
		BookedQuantity=Integer.valueOf(slots);

		Assert.assertEquals(ele.getText(), String.valueOf(Integer.valueOf(CommonFunctions.createAssignment_capacity) - 
				Integer.valueOf(slots)));

		CommonFunctions.ScrollUptoElement(driver, BookingDashboardPageElements.GetBookingDataTab(driver));
		Thread.sleep(5000);

		BookingDashboardPageElements.GetBookingDataTab(driver).click();
		Thread.sleep(7000);
		BookingDashboardPageElements.Get_BookingDataTab_FirstNameField(driver).sendKeys("fname"+System.currentTimeMillis());
		Thread.sleep(2000);
		BookingDashboardPageElements.Get_BookingDataTab_LastNameField(driver).sendKeys("lname"+System.currentTimeMillis());
		Thread.sleep(2000);
		BookingDashboardPageElements.Get_BookingDataTab_EmailField(driver).sendKeys("email"+System.currentTimeMillis()+"@gmail.com");
		Thread.sleep(2000);
		BookingDashboardPageElements.Get_BookingDataTab_PhoneField(driver).sendKeys("1234567890");
		Thread.sleep(2000);
		BookingDashboardPageElements.Get_BookingDataTab_CreateAccountButton(driver).click();

		Thread.sleep(5000);

		if(customize.equals("true"))
		{
			BookingDashboardPageElements.GetCustomizationsTab(driver).click();
			Thread.sleep(2000);
			BookingDashboardPageElements.addCustomization(driver).click();
			Thread.sleep(2000);
		}

		if(paymentType.equals("DepositOnly"))
			PayDepositOnly(driver);

		if(paymentType.equals("FullAmount"))
			PayFullAmount(driver);

		String OrderID = BookingDashboardPageElements.Get_PaymentTab_OrderID(driver).getText();
		Thread.sleep(3000);				
		BookingEventDashboardPageElements.GetBackToBookingsButton(driver).click();
		Thread.sleep(3000);
		BookingEventDashboardPageElements.GetOrderIDColumnSettingIcon(driver).click();
		filterTable(driver, OrderID);
		Thread.sleep(5000);				
		assertEquals(BookingEventDashboardPageElements.GetOrderNumberOfFirstRow(driver).getText(), OrderID);
		BookingEventDashboardPageElements.GetViewButtonOfFirstRow(driver).click();
		VerifyBookedQty_BasePrice_AndSpotsLeftAfterBooking(driver);
		VerifyBalanceDueOnFinalizeTab(driver);
		VerifyBalanceDueOnPaymentTab(driver);
		Thread.sleep(5000);
		BookingEventDashboardPageElements.GetBackToBookingsButton(driver).click();
		gotoBookingPage(driver);
		Thread.sleep(2000);

	}
	public static void PayDepositOnly(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		BookingDashboardPageElements.GetFinalizeTab(driver).click();
		Thread.sleep(5000);
		String str = BookingDashboardPageElements.Get_FinalizeTab_GrandTotal(driver).getText();
		GrandTotal = Double.valueOf(getElementTextWithout$Sign(str, driver));

		str = BookingDashboardPageElements.Get_FinalizeTab_RequireDepositField(driver).getText();			
		AmountPaid = Double.valueOf(getElementTextWithout$Sign(str, driver));
		/*assertEquals(AmountPaid, ExpDepositAmount);*/

		str=BookingDashboardPageElements.Get_FinalizeTab_BookTaxField(driver).getText();

		/*System.out.println(Double.valueOf(str));
		System.out.println(Double.valueOf(BookingDashboardPageElements.Get_FinalizeTab_SubTotalField(driver).getText()));
		System.out.println(Double.valueOf(CommonFunctions.createTaxOption_TaxRate1));
		System.out.println(Double.valueOf(BookingDashboardPageElements.Get_FinalizeTab_SubTotalField(driver).getText())
				*Double.valueOf(CommonFunctions.createTaxOption_TaxRate1));*/
		Assert.assertEquals(Double.valueOf(str), Double.valueOf(BookingDashboardPageElements.Get_FinalizeTab_SubTotalField(driver).getText())
				*Double.valueOf(CommonFunctions.createTaxOption_TaxRate1));


		BookingDashboardPageElements.Get_FinalizeTab_PayDepositOnly(driver).click();
		Thread.sleep(5000);
		CommonFunctions.SwitchToContentFrame(driver);		
		PaymentTransactionType.PaymentThroughCash(driver);
		CommonFunctions.SwitchToContentFrame(driver);
		ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		assertTrue(true);
		driver.switchTo().defaultContent();
	}
	public static void PayFullAmount(WebDriver driver)throws Exception
	{
		Thread.sleep(5000);
		BookingDashboardPageElements.GetFinalizeTab(driver).click();
		Thread.sleep(5000);
		String str = BookingDashboardPageElements.Get_FinalizeTab_GrandTotal(driver).getText();
		GrandTotal = Double.valueOf(getElementTextWithout$Sign(str, driver));
		str = BookingDashboardPageElements.Get_FinalizeTab_GrandTotal(driver).getText();
		AmountPaid = Double.valueOf(getElementTextWithout$Sign(str, driver));
		BookingDashboardPageElements.Get_FinalizeTab_PayFullAmount(driver).click();
		Thread.sleep(5000);
		BookingDashboardPageElements.Get_FinalizeTab_GetPaymentModal_PaymentAmount(driver).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		BookingDashboardPageElements.Get_FinalizeTab_GetPaymentModal_PaymentAmount(driver).sendKeys(String.valueOf(AmountPaid));
		BookingDashboardPageElements.Get_FinalizeTab_GetPaymentModal_PayButton(driver).click();
		Thread.sleep(5000);
		CommonFunctions.SwitchToContentFrame(driver);		
		PaymentTransactionType.PaymentThroughCash(driver);
		CommonFunctions.SwitchToContentFrame(driver);
		ReceiptSelectionDialogBoxElements.GetNoneButton(driver).click();
		assertTrue(true);
		driver.switchTo().defaultContent();
	}
	public static String getElementTextWithout$Sign(String str, WebDriver driver) throws InterruptedException
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
	public static void VerifyBalanceDueOnFinalizeTab(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		BookingDashboardPageElements.GetFinalizeTab(driver).click();
		Thread.sleep(5000);		
		String str = BookingDashboardPageElements.Get_FinalizeTab_BalanceDueField(driver).getText();
		assertEquals(Double.valueOf(getElementTextWithout$Sign(str, driver)), GrandTotal-AmountPaid);
	}
	public static void VerifyBalanceDueOnPaymentTab(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		BookingDashboardPageElements.GetPaymentTab(driver).click();
		Thread.sleep(5000);
		String str = BookingDashboardPageElements.Get_PaymentTab_BookingTotal(driver).getText();
		assertEquals(Double.valueOf(getElementTextWithout$Sign(str, driver)), GrandTotal);
		str = BookingDashboardPageElements.Get_PaymentTab_TotalPaid(driver).getText();
		assertEquals(Double.valueOf(getElementTextWithout$Sign(str, driver)), AmountPaid);
		str= BookingDashboardPageElements.Get_PaymentTab_AmountRemaining(driver).getText();
		assertEquals(Double.valueOf(getElementTextWithout$Sign(str, driver)), GrandTotal-AmountPaid);

	}
	public static void VerifyBookedQty_BasePrice_AndSpotsLeftAfterBooking(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		String str = BookingDashboardPageElements.Get_BookingDetailsTab_SpotsLeftField(driver).getText();
		assertEquals(Integer.valueOf(getElementTextWithout$Sign(str, driver) ), Integer.valueOf(ExpTotalSpotsLeft));
		str= BookingDashboardPageElements.Get_BookingDetailsTab_TicketQtyfield(driver).getAttribute("value");
		assertEquals(Integer.valueOf(getElementTextWithout$Sign(str, driver) ), Integer.valueOf(BookedQuantity));
		str = BookingDashboardPageElements.Get_BookingDetailsTab_TotalPrice(driver).getText();
		assertEquals(Double.valueOf(getElementTextWithout$Sign(str, driver) ), Double.valueOf(CommonFunctions.createPriceRule_BaseAmount));

	}
}
