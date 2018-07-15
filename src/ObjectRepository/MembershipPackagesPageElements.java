package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MembershipPackagesPageElements {
	
private static WebElement element = null;
	
	
	public static WebElement GetPackagesTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Packages"));
		return element;
	}
	public static WebElement GetDiscountEntitlementTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Discount Entitlement"));
		return element;
	}
	public static WebElement GetEntranceEntitlementTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Entrance Entitlements"));
		return element;
	}
	public static WebElement GetPaymentPlansTab(WebDriver driver)
	{
		element =driver.findElement(By.linkText("Payment Plans"));
		return element;
	}
	public static WebElement GetPackageTab_SelectOption(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-1']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetDiscountEntitlementTab_SelectOption(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-2']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetEntranceEntitlementTab_SelectOption(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-3']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetPaymentPlansTab_SelectOption(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='tbsTicket-4']//span[text()='Select Option']"));
		return element;
	}
	public static WebElement GetEntranceEntitlementTab_EntrnaceEntitlementIDColumn(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridEntrances']//a[text()='ID']"));
		return element;
	}
	public static WebElement GetEntranceEntitlementTab_FirstRowNameColumn(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridEntrances']//div[@class='k-grid-content']/table/tbody/tr[1]/td[2]"));		
		return element;
	}

}
