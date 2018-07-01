package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SellGiftCardDialogBoxElements {
private static WebElement element = null;
	
	
	public static WebElement GetGiftCardBarcodeField(WebDriver driver)
	{
		
		element =driver.findElement(By.id("txtBarcode"));
		return element;
	}
	public static WebElement GetGiftCardTypeDD(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//span[text() = 'Gift Card']"));
		return element;
	}
	public static WebElement GetBarCodeTypeDD(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//span[@aria-owns='barcodeTypeDropDownList_listbox']//span[@class='k-input']"));
		return element;
	}
	public static WebElement GetGiftCardAmountField(WebDriver driver)
	{
		
		element =driver.findElement(By.xpath("//div[@class='container-popup']//input[@class='k-formatted-value k-input']"));
		return element;
	}
	public static WebElement GetAddToCardButton(WebDriver driver)
	{
		
		element =driver.findElement(By.id("btnSubmit"));
		return element;
	}
	public static void SelectValueFromBarcodeTypeDropdown(WebDriver driver, String OptionName)
	{
		driver.findElement(By.xpath("//ul[@id='barcodeTypeDropDownList_listbox']//li[text()='"+OptionName+"']")).click();
	}
}
