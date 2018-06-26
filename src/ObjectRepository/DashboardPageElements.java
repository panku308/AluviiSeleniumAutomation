package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	

}
