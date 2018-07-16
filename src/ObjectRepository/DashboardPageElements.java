package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageElements {
private static WebElement element = null;
	
	public static WebElement GetDashboardLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Dashboard"));
		return element;
	}
	public static WebElement GetClockInOutLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Clock In / Clock Out"));
		return element;
	}
	public static WebElement GetAccessControlLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Access Control"));
		return element;
	}
	public static WebElement GetMembershipPackagesLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Membership Packages"));
		return element;
	}
	public static WebElement GetEmployeeSchedulingLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Employee Scheduling"));
		return element;
	}
	
	public static WebElement GetShiftManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Shift Management"));
		return element;
	}
	public static WebElement GetTimekeepingLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Timekeeping"));
		return element;
	}
	
	public static WebElement GetGiftCardManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Gift Card Management"));
		return element;
	}
	public static WebElement GetKitchenRegisterLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Kitchen Registers"));
		return element;
	}
	public static WebElement GetGuestProtalMangementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Guest Portal Management"));
		return element;
	}
	public static WebElement GetTicketingLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Ticketing"));
		return element;
	}
	public static WebElement GetBookingsLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Bookings"));
		return element;
	}
	public static WebElement GetAdministrationLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Administration"));
		return element;
	}
	public static WebElement GetArcageManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Arcade Management"));
		return element;
	}
	public static WebElement GetAssetManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Asset Management"));
		return element;
	}
	public static WebElement GetEcommerceLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("E-Commerce"));
		return element;
	}
	public static WebElement GetInventoryManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Inventory Management"));
		return element;
	}
	public static WebElement GetTaskManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Task Management"));
		return element;
	}
	public static WebElement GetEventManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Event Management"));
		return element;
	}
	public static WebElement GetWilCallLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Will Call"));
		return element;
	}
	public static WebElement GetWorkflowLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Workflow"));
		return element;
	}
	public static WebElement GetCampaingManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Campaign Management"));
		return element;
	}
	public static WebElement GetHardwareManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Hardware Management"));
		return element;
	}
	public static WebElement GetCallCenterLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Call Center"));
		return element;
	}
	public static WebElement GetReportingManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Reporting"));
		return element;
	}
	public static WebElement GetManageMemberShipLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Manage Memberships"));
		return element;
	}
	public static WebElement GetRegisterManagementLink(WebDriver driver)
	{
		
		element =driver.findElement(By.linkText("Register Management"));
		return element;
	}
	public static WebElement GetWaiverManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Waiver Management"));		
		return element;
	}
	public static WebElement GetEmployeeRegistersLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Employee Registers"));		
		return element;
	}
	
	public static WebElement GetHRManagementLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("HR Management"));		
		return element;
	}
	
	public static WebElement GetAdminstrationLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Administration"));		
		return element;
	}
	
	public static WebElement GetCashControlLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Cash Control"));		
		return element;
	}
	
	
	public static WebElement getUserMenu(WebDriver driver)
	{
		try {
		element =driver.findElement(By.id("username"));		
		}catch(Exception e)
		{
			element =driver.findElement(By.id("name-user"));		
		}
		return element;
	}
	public static WebElement getLogoutButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[@id='user-menu-dropdown']//a[contains(text(),'Logout')]"));		
		return element;
	}
	
	public static WebElement getSidebarMenu(WebDriver driver, String menu)
	{
		element =driver.findElement(By.xpath("//*[@id='sidebar']//li//span[text()='"+menu+"']"));		
		return element;
	}
	
	public static int getAddedActivityMenuSize(WebDriver driver) {

		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[@id='sidebar']//li"));
		return element.size();
	}
	
	public static WebElement getCurrentTillStatus(WebDriver driver)
	{
		element =driver.findElement(By.id("current-till-status"));		
		return element;
	}
	
}
