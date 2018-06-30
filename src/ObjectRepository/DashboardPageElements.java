package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageElements {
private static WebElement element = null;
	
	
	public static WebElement GetManageMemberShipLink(WebDriver driver)
	{
		//element =driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[4]/a/span"));
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
	public static void clickOnWaiverManagementlink(WebDriver driver)
	{
		DashboardPageElements.GetWaiverManagementLink(driver).click();	
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
	
	public static WebElement GetCashControlLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Cash Control"));		
		return element;
	}
	
	
	public static WebElement getUserMenu(WebDriver driver)
	{
		element =driver.findElement(By.id("username"));		
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
	
	public static WebElement getCurrentTillStatus(WebDriver driver)
	{
		element =driver.findElement(By.id("current-till-status"));		
		return element;
	}
	
}
