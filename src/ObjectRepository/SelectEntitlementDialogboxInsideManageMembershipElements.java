package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectEntitlementDialogboxInsideManageMembershipElements {
	
private static WebElement element = null;
	
	
	public static WebElement GetEntitlementButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='entitlementList']//button"));		
		return element;
	}
	public static WebElement GetYesButton(WebDriver driver)
	{
		element =driver.findElement(By.id("yes"));
		return element;
	}
	public static WebElement GetNoButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("no"));
		return element;
	}
}
