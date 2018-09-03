package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddFeeDialogBoxElements {
private static WebElement element = null;
	
	public static WebElement GetInternalFeeName(WebDriver driver)
	{
		element =driver.findElement(By.id("InternalName"));
		return element;
	}
	public static WebElement GetExternalFeeName(WebDriver driver)
	{
		element =driver.findElement(By.id("ExternalName"));
		return element;
	}
	public static WebElement GetFeeTypeDD(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//span[text()='Select Fee Type']"));
		return element;
	}
	public static WebElement GetDescriptionField(WebDriver driver)
	{
		element =driver.findElement(By.id("Description"));
		return element;
	}
	public static WebElement GetSaveButton(WebDriver driver)
	{
		element =driver.findElement(By.id("Save"));
		return element;
	}
	public static WebElement GetInternalFeeNameColumnsSettingsIcon(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//th[@data-field='InternalName']/a[1]"));
		return element;
	}
	public static WebElement GetFirstRowInternalFeeNameFieldValue(WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@id='gridFeeRule']//div[@class='k-grid-content']//table/tbody/tr[1]/td[2]"));
		return element;
	}
}
