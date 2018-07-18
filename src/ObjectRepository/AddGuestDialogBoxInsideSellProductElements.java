package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddGuestDialogBoxInsideSellProductElements {
private static WebElement element = null;
	
	
	public static WebElement GetScanGuestPassRadioButton(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//input[@id='GuestSearchType' and @value='BarCodeNumber']"));
		return element;
	}
	public static WebElement GetSearchForGuestRadioButton(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//input[@id='GuestSearchType' and @value='GuestName']"));
		return element;
	}
	public static WebElement GetSearchField(WebDriver driver)
	{
		
		element =driver.findElement(By.id("searchbox"));
		return element;
	}
	public static WebElement GetSearchButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnSearchbox"));
		return element;
	}
	public static WebElement GetSearchRecord(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@id='guestGrid']//table/tbody/tr/td[2]/div/a/img"));		
		return element;
	}
	

}
