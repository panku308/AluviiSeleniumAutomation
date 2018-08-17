package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingEventDashboardPageElements {

private static WebElement element = null;
	
	
	public static WebElement GetBookingPlusIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@class='dropbtn']/i"));		
		return element;
	}
	public static WebElement GetBookingTab(WebDriver driver)
	{
		element =driver.findElement(By.id("booking"));		
		return element;
	}
	public static WebElement GetAvailabitlityTab(WebDriver driver)
	{
		element =driver.findElement(By.id("availability"));		
		return element;
	}
	public static WebElement GetSearchButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("availability"));		
		return element;
	}
	
	public static WebElement GetAddBookingOption(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Add Booking"));		
		return element;
	}
	public static WebElement GetOrderIDColumnSettingIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//th[@data-field='OrderId']/a[1]"));		
		return element;
		//*[@id="BookingGrid"]/div[3]/table/tbody/tr[2]/td[14]/span
	}
	public static WebElement GetBackToBookingsButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnGoToMyBookings"));		
		return element;

	}
	public static WebElement GetTimeOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='BookingGrid']//div[@class='k-grid-content']//table/tbody/tr[2]/td[6]"));
		return element;
	}
	public static WebElement GetAssignmentOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='BookingGrid']//div[@class='k-grid-content']//table/tbody/tr[2]/td[7]"));
		return element;
	}
	public static WebElement GetGuestNameOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='BookingGrid']//div[@class='k-grid-content']//table/tbody/tr[2]/td[8]"));
		return element;
	}
	public static WebElement GetPackageNameOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='BookingGrid']//div[@class='k-grid-content']//table/tbody/tr[2]/td[10]"));
		return element;
	}
	public static WebElement GetSiteOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='BookingGrid']//div[@class='k-grid-content']//table/tbody/tr[2]/td[11]"));
		return element;
	}
	public static WebElement GetCategoryOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='BookingGrid']//div[@class='k-grid-content']//table/tbody/tr[2]/td[12]"));
		return element;
	}
	public static WebElement GetPaymentStatusOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='BookingGrid']//div[@class='k-grid-content']//table/tbody/tr[2]/td[13]"));
		return element;
	}
	public static WebElement GetOrderNumberOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='BookingGrid']//div[@class='k-grid-content']//table/tbody/tr[2]/td[14]"));
		
		return element;
	}
	

	public static WebElement GetViewButtonOfFirstRow(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='BookingGrid']//div[@class='k-grid-content']//table/tbody/tr[2]/td[17]/span"));
		
		return element;
	}
	
}
