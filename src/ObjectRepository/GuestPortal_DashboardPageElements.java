package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPortal_DashboardPageElements {
	
	private static WebElement element = null;

	public static WebElement GetMyDigitalPassesLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("My Digital Passes"));
		return element;
	}
	public static WebElement GetMembershipPasses(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Membership Passes"));
		return element;
	}
	public static WebElement GetUsernameMenu(WebDriver driver)
	{
		element =driver.findElement(By.id("username"));
		return element;
	}
	public static WebElement GetHelpLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Help"));
		return element;
	}	
	public static WebElement GetAddOnsLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Add-Ons"));
		return element;
	}
	public static WebElement GetMembershipsLink(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Memberships"));
		return element;
	}
	public static WebElement GetLogoutLink(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='username']//a[contains(text(), 'Logout')]"));
		return element;
	}

}
