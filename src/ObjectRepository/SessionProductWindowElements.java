package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.RegisterManagementTest.CreateProduct_withSessionTest;

public class SessionProductWindowElements {
private static WebElement element = null;
	
	
	public static WebElement GetFirstTimeSlot(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='dvTimeSlots']/div[1]/div[2]/span"));
		return element;
	}
	public static WebElement GetFirstProductQuantityField(WebDriver driver,String product)
	{
		element =driver.findElement(By.xpath("//input[contains(@id, 'txtProductGroupQuantity') and @data.productname='"+product+"']"));
		return element;
	}
	
	public static WebElement GetAttachWaiverLaterButton(WebDriver driver)
	{
		element =driver.findElement(By.id("btnAttachWaiverLater"));
		return element;
	}
	public static WebElement GetCloseButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[@id='popupChildWindow_wnd_title']/following::div[@class='k-window-actions']/a/span"));
		return element;
	}
}
