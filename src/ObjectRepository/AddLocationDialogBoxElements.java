package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddLocationDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetNameField(WebDriver driver)
	{
		element =driver.findElement(By.id("LocationName"));
		return element;
	}
	public static WebElement GetPhoneField(WebDriver driver)
	{
		element =driver.findElement(By.id("LocationPhone"));
		return element;
	}
	public static WebElement GetAddressField(WebDriver driver)
	{
		element =driver.findElement(By.id("LocationAddress"));
		return element;
	}
	public static WebElement GetCityField(WebDriver driver)
	{
		element =driver.findElement(By.id("LocationCity"));
		return element;
	}
	public static WebElement GetZipField(WebDriver driver)
	{
		element =driver.findElement(By.id("LocationZip"));
		return element;
	}
	public static WebElement getSelectTimeZoneButton(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//*[text()='Select Time Zone']"));
		return element;
	}
	public static WebElement setSelectTimeZone(WebDriver driver, String timeZone)
	{
		List<WebElement> element;
		element =driver.findElements(By.xpath("//*[text()='Select Time Zone']/..//*[contains(text(),'"+timeZone+"')]"));
		return element.get(element.size()-1);
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));
		return element;
	}

}
