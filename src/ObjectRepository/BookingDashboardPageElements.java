package ObjectRepository;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class BookingDashboardPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetCategoryTab(WebDriver driver)
	{
		element =driver.findElement(By.id("tabCategory"));		
		return element;
	}
	public static WebElement GetBookingDetailsTab(WebDriver driver)
	{
		element =driver.findElement(By.id("tabBookDetail"));		
		return element;
	}
	public static WebElement GetBookingDataTab(WebDriver driver)
	{
		element =driver.findElement(By.id("tabBookData"));		
		return element;
	}
	public static WebElement GetCustomizationsTab(WebDriver driver)
	{
		element =driver.findElement(By.id("tabCustomize"));		
		return element;
	}
	public static WebElement GetFinalizeTab(WebDriver driver)
	{
		element =driver.findElement(By.id("tabFinalize"));		
		return element;
	}
	public static WebElement GetPaymentTab(WebDriver driver)
	{
		element =driver.findElement(By.id("tabPayment"));		
		return element;
	}
	public static WebElement GetTicketsTab(WebDriver driver)
	{
		element =driver.findElement(By.id("tabTickets"));		
		return element;
	}
	public static WebElement Get_CategoryTab_CategoryDropdown(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Select Category']"));		
		return element;
	}
	
	
	public static void SelectCategory(WebDriver driver, String Category)
	{
		driver.findElement(By.xpath("//ul[@id='ddlSelCat_listbox']/li[text()='"+Category+"']")).click();		
		
	}
	public static WebElement Get_CategoryTab_Package_SelectButton(WebDriver driver, String Package)
	{
		WebElement ChildElement=driver.findElement(By.xpath("//h3[text()='"+Package+"']/parent::div/parent::div/parent::div"));;
		WebElement ParentElement=ChildElement.findElement(By.tagName("input"));
		String PackageID = ParentElement.getAttribute("value");
		System.out.println("PackageID = " + PackageID);
		element =driver.findElement(By.xpath("//div[@id='tmplPackageRowWrapper']//span[contains(@onclick,'managePackages("+PackageID+",0)]"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_NextWeekButton(WebDriver driver)
	{
		element =driver.findElement(By.id("divCalNextWk"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_PreviousWeekButton(WebDriver driver)
	{
		element =driver.findElement(By.id("divCalPrevWk"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_GetDateField(WebDriver driver, String day)
	{
		element =driver.findElement(By.xpath("//div[contains(text(), '"+day+"') and @class='wkDyTitle']"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_CurrentDay(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='divCalWk']//div[@class='wkDy active']"));		
		return element;
	}
	
	public static WebElement Get_BookingDetailsTab_TimeField(WebDriver driver, String time,String assignment)
	{
		WebElement Assignment = driver.findElement(By.xpath("//h3[text()='"+assignment+"']/parent::div/parent::div//div[4]/p"));
		String AssignmentID = Assignment.getAttribute("id");
		AssignmentID = AssignmentID.replaceAll("AsgnTimeZone", "");
		element =driver.findElement(By.xpath("//ul[contains(@id,'ulAvail"+AssignmentID+"')]//li[text()='"+time+"']"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_TimeFieldByNumber(WebDriver driver, String assignment, int Number)
	{
		WebElement Assignment = driver.findElement(By.xpath("//h3[text()='"+assignment+"']/parent::div/parent::div//div[4]/p"));
		String AssignmentID = Assignment.getAttribute("id");
		AssignmentID = AssignmentID.replaceAll("AsgnTimeZone", "");
		element =driver.findElement(By.xpath("//ul[contains(@id,'ulAvail"+AssignmentID+"')]//li["+Number+"]"));		
		return element;
	}
	public static List<WebElement> Get_BookinDetailsTab_NumberOfTimeSlots(WebDriver driver, String AssignmentNamme)
	{
		WebElement Assignment = driver.findElement(By.xpath("//h3[text()='"+AssignmentNamme+"']/parent::div/parent::div//div[4]/p"));
		String AssignmentID = Assignment.getAttribute("id");
		AssignmentID = AssignmentID.replaceAll("AsgnTimeZone", "");
		List  <WebElement> TimeSlot = driver.findElements(By.xpath("//ul[contains(@id,'ulAvail"+AssignmentID+"')]//li")) ;
		 
		return TimeSlot; 
		
	}
	public static WebElement Get_BookingDetailsTab_TimeFieldAvailalbility(WebDriver driver, String time, String AMPM)
	{
		element =driver.findElement(By.xpath("//ul[contains(@id,'ulAvail1')]//li[contains(@starttime,'"+time+"') and contains(@startampm,'"+AMPM+"')]"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_TicketQtyfield(WebDriver driver)
	{
		element =driver.findElement(By.id("rowVal1"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_TicketQtyfield2(WebDriver driver)
	{
		element =driver.findElement(By.id("rowVal2"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_TicketQtyfield3(WebDriver driver)
	{
		element =driver.findElement(By.id("rowVal3"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_TotalPrice(WebDriver driver)
	{
		element =driver.findElement(By.id("totalPrice"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_SpotsLeftField(WebDriver driver)
	{
		element =driver.findElement(By.id("spotsLeft"));		
		return element;
	}
	public static WebElement Get_BookingDataTab_FirstNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("ff-field-first"));		
		return element;
	}
	public static WebElement Get_BookingDataTab_LastNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("ff-field-last"));		
		return element;
	}
	public static WebElement Get_BookingDataTab_EmailField(WebDriver driver)
	{
		element =driver.findElement(By.id("ff-field-email"));		
		return element;
	}
	public static WebElement Get_BookingDataTab_PhoneField(WebDriver driver)
	{
		element =driver.findElement(By.id("ff-field-phone"));		
		return element;
	}
	public static WebElement Get_BookingDataTab_HeightField(WebDriver driver)
	{
		element =driver.findElement(By.id("ff-field-6"));		
		return element;
	}
	
	public static WebElement Get_BookingDataTab_CreateAccountButton(WebDriver driver)
	{
		element =driver.findElement(By.id("save-finalize"));		
		return element;
	}
	public static WebElement Get_BookingDataTab_CancelBookingButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnCancelBooking"));		
		return element;
	}
	public static WebElement Get_BookingDataTab_ConfirmCancelBookingButton(WebDriver driver)
	{
		element =driver.findElement(By.id("yesCancel"));		
		return element;
	}
	public static WebElement Get_BookingDataTab_WaterfallProductText(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='WFItems']/span[1]"));		
		return element;
	}
	public static WebElement Get_BookingDataTab_WaterfallAssignmentText(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='WFItems']/span[2]"));		
		return element;
	}
	
	public static WebElement Get_FinalizeTab_StatucField(WebDriver driver)
	{
		element =driver.findElement(By.id("pay-status"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_BalanceDueField(WebDriver driver)
	{
		element =driver.findElement(By.id("balance-left"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_SubTotalField(WebDriver driver)
	{
		element =driver.findElement(By.id("bookSubTot"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_TotalDiscountField(WebDriver driver)
	{
		element =driver.findElement(By.id("bookTotDiscAmt"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_BookTaxField(WebDriver driver)
	{
		element =driver.findElement(By.id("bookTax"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_RequireDepositField(WebDriver driver)
	{
		element =driver.findElement(By.id("bookDep"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_DiscountCodeField(WebDriver driver)
	{
		element =driver.findElement(By.id("txtDiscCode"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_ApplyDiscountButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnDiscCode"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_GrandTotal(WebDriver driver)
	{
		element =driver.findElement(By.id("bookGrandTot"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_PayDepositOnly(WebDriver driver)
	{
		element =driver.findElement(By.id("payRequired"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_PayFullAmount(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='PAY FULL AMOUNT']"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_GetPaymentModal_PaymentAmount(WebDriver driver)
	{
		element =driver.findElement(By.id("txtPaymentAmount"));		
		return element;
	}
	public static WebElement Get_FinalizeTab_GetPaymentModal_PayButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='paymentAmtModal']//div[@class='modal-body']/p[3]/span"));
		
		return element;
	}
	
	public static WebElement Get_CustomizationTab(WebDriver driver)
	{
		element =driver.findElement(By.id("tabCustomize"));		
		return element;
	}
	
	public static WebElement addCustomization(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@class='btn btn-aluvii add-product']"));		
		return element;
	}
	
	
	public static WebElement Get_PaymentTab_OrderID(WebDriver driver)
	{
		element =driver.findElement(By.id("#orderId"));		
		return element;
	}
	public static WebElement Get_PaymentTab_BookingTotal(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[contains(@class,'total-to-pay')]"));		
		return element;
	}
	public static WebElement Get_PaymentTab_AmountRemaining(WebDriver driver)
	{
		element =driver.findElement(By.id("#balancetopay"));		
		return element;
	}
	public static WebElement Get_PaymentTab_TotalPaid(WebDriver driver)
	{
		element =driver.findElement(By.id("#paidamt"));		
		return element;
	}
	public static WebElement Get_PaymentTab_Status(WebDriver driver)
	{
		element =driver.findElement(By.id("#status"));		
		return element;
	}
	public static WebElement Get_PaymentTab_Discount(WebDriver driver)
	{
		element =driver.findElement(By.id("#discount"));		
		return element;
	}
	public static WebElement Get_TicketsTab_TicketsTable(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='ticketsGrid']//table/tbody"));		
		return element;
	}
	public static int Get_TicketsTab_TicketsTableRows(WebDriver driver)
	{
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='ticketsGrid']//table/tbody/tr"));
		System.out.println("Ticket Rows = "+rows.size());
		return rows.size();
	}
	
	//Booking Elements
	public static List<WebElement> getFirstBookingDate(WebDriver driver)
	{
		List<WebElement> bookingDates = driver.findElements(By.xpath("((//*[@class='wkDy past'])[last()]/following-sibling::div)[1]"));
		
		return bookingDates;
	}
	public static List<WebElement> getLastBookingDate(WebDriver driver)
	{
		List<WebElement> bookingDates = driver.findElements(By.xpath("//*[@class='wkDy last']"));
		
		return bookingDates;
	}
	public static List<WebElement> getOtherBookingDate(WebDriver driver)
	{
		List<WebElement> bookingDates = driver.findElements(By.xpath("//*[@class='wkDy']"));
		
		return bookingDates;
	}
}
