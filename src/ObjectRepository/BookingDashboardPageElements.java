package ObjectRepository;

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
	public static WebElement Get_CategoryTab_Package_SelectButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tmplPackageRowWrapper']//span[contains(@onclick,'managePackages(')]"));
		//element =driver.findElement(By.xpath("//span[ .='Select']"));
		return element;
	}
	public static WebElement Get_BookingDetailsTab_CurrentDay(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='divCalWk']//div[@class='wkDy active']"));		
		return element;
	}
	public static WebElement Get_BookingDetailsTab_TimeField(WebDriver driver, String time)
	{
		element =driver.findElement(By.xpath("//ul[contains(@id,'ulAvail')]//li[text()='"+time+"']"));		
		return element;
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
	public static WebElement Get_BookingDataTab_CreateAccountButton(WebDriver driver)
	{
		element =driver.findElement(By.id("save-finalize"));		
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
		element =driver.findElement(By.xpath("//span[text()=' Pay']"));		
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
		element =driver.findElement(By.xpath("#status"));		
		return element;
	}
	
}
